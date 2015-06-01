package co.razorblade446.java.agentechateador.controller;

import co.razorblade446.java.agentechateador.message.GenreMoviesMessage;
import co.razorblade446.java.agentechateador.message.MoviesMessage;
import co.razorblade446.java.agentechateador.message.PeliculaImportarMessage;
import co.razorblade446.java.agentechateador.model.Pelicula;
import co.razorblade446.java.agentechateador.model.PeliculaRepository;
import jade.wrapper.gateway.JadeGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

/**
 * Clase Controlador para la gestión de las películas.
 */

@Controller
public class PeliculasController {

    private String generosUrl = "http://api.themoviedb.org/3/genre/movie/list?api_key=cc6b2fd800ed2be1daff415461202d8e&language=es";
    private String peliculasDeAccionUrl = "http://api.themoviedb.org/3/genre/28/movies?api_key=cc6b2fd800ed2be1daff415461202d8e&language=es";


    @Autowired
    private PeliculaRepository peliculaRepository;

    /**
     * Método de Controlador que lista las películas registradas.
     * @param model
     * @return
     */
    @RequestMapping(value = "/peliculas", method = RequestMethod.GET)
    public String getListaPeliculas(ModelMap model){
        model.addAttribute("pelicula", new Pelicula());
        model.addAttribute("peliculas", peliculaRepository.findAll());
        return "peliculas_lista";
    }

    /**
     * Método de Controlador que habilita la edición de las peliculas
     * @param model
     * @param peliculaId
     * @return MapModel
     */
    @RequestMapping(value = "/peliculas/editar/{peliculaId}", method = RequestMethod.GET)
    public String editarPeliculas(ModelMap model, @PathVariable("peliculaId") int peliculaId){
        Pelicula miPelicula = peliculaRepository.findOne((long) peliculaId);

        model.addAttribute("pelicula", miPelicula);
        return "peliculas_editar";
    }

    /**
     * Método de Controlador que realiza la importación de las películas desde TMDB.org
     * @param model
     * @return MapModel
     */
    @RequestMapping(value = "/peliculas/importar", method = RequestMethod.GET)
    public String importarPeliculas(ModelMap model){
        return "peliculas_importar";
    }

    /**
     * Método de Controlador que realiza la importación de las películas desde TMDB.org
     * @return Json
     */
    @RequestMapping(value = "/peliculas/importar", method = RequestMethod.POST)
    @ResponseBody
    public PeliculaImportarMessage importarPeliculas(){
        PeliculaImportarMessage response = new PeliculaImportarMessage();
        response.setCantidad(0);

        int pagina=1;
        int total_paginas = 1;
        int cantidad = 0;

        try {

            RestTemplate restTemplate = new RestTemplate();

            while(pagina <= total_paginas) {

                GenreMoviesMessage message = restTemplate.getForObject(peliculasDeAccionUrl + "&page=" + pagina, GenreMoviesMessage.class);
                System.out.println("Películas para importar: " + message.getTotal_pages());

                Collection<MoviesMessage> movies = message.getResults();

                for (MoviesMessage movie : movies) {

                        Pelicula miPelicula = new Pelicula();
                        miPelicula.setPeliculaId(movie.getId());
                        miPelicula.setNombre(movie.getTitle());
                        miPelicula.setGeneroId((short)28);
                        miPelicula.setTrama(movie.getOverview());
                        miPelicula.setFecha(new java.sql.Date(movie.getRelease_date().getTime()));
                        peliculaRepository.saveAndFlush(miPelicula);
                        cantidad ++;

                    System.out.println("\rItem [" + movie.getId() + "]: " + cantidad);

                }

                total_paginas = message.getTotal_pages();
                pagina++;

                Thread.sleep(150);

            }

        }catch (Exception ex){
            System.out.println("Error de consulta: " + ex.getMessage());
            ex.printStackTrace();
        }
        response.setCantidad(cantidad);

        return response;
    }

}