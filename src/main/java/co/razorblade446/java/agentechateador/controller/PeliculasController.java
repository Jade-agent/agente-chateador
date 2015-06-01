package co.razorblade446.java.agentechateador.controller;

import co.razorblade446.java.agentechateador.message.*;
import co.razorblade446.java.agentechateador.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.persistence.*;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Collection;
import java.util.List;

/**
 * Clase Controlador para la gestión de las películas.
 */

@Controller
public class PeliculasController {

    private String generosUrl = "http://api.themoviedb.org/3/genre/movie/list?api_key=cc6b2fd800ed2be1daff415461202d8e&language=es";
    private String peliculasDeAccionUrl = "http://api.themoviedb.org/3/genre/28/movies?api_key=cc6b2fd800ed2be1daff415461202d8e&language=es";
    private String creditosDePeliculaUrl = "http://api.themoviedb.org/3/movie/%d/credits?api_key=cc6b2fd800ed2be1daff415461202d8e&language=es";
    private String personaUrl = "http://api.themoviedb.org/3/person/%d?api_key=cc6b2fd800ed2be1daff415461202d8e&language=es";

    private EntityManager entityManager;

    @Autowired
    private PeliculaRepository peliculaRepository;

    /**
     * Método de Controlador que lista las películas registradas.
     * @param model
     * @return
     */
    @RequestMapping(value = "/peliculas", method = RequestMethod.GET)
    public String getListaPeliculas(ModelMap model){
        initializeEntityManager();

        Query queryPeliculas = entityManager.createNamedQuery("Pelicula.findAllWithCast");
        queryPeliculas.setMaxResults(200);

        List<Pelicula> pelis = queryPeliculas.getResultList();

        model.addAttribute("peliculas", pelis);
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
    //@Transactional
    @RequestMapping(value = "/peliculas/importar", method = RequestMethod.POST)
    @ResponseBody
    public PeliculaImportarMessage importarPeliculas(){
        initializeEntityManager();
        PeliculaImportarMessage response = new PeliculaImportarMessage();
        response.setCantidad(0);

        int pagina=1;
        int total_paginas = 1;
        int cantidad = 0;

        System.out.println("EM 2: " + entityManager);

        Query queryGenero = entityManager.createNamedQuery("Genero.findOne");
        Query queryPelicula = entityManager.createNamedQuery("Pelicula.findOne");
        Query queryPersona = entityManager.createNamedQuery("Persona.findOne");
        Query queryPersonaje = entityManager.createNamedQuery("Personaje.findOne");
        queryGenero.setParameter("generoId", (short) 28);
        Genero generoAccion = (Genero) queryGenero.getSingleResult();

        Proxy proxy= new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.10.10.11", 8080));
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setProxy(proxy);

        RestTemplate restTemplate = new RestTemplate(requestFactory);

        Pelicula miPelicula;
        Boolean presente;

        try {

            while(pagina <= total_paginas) {

                GenreMoviesMessage message = restTemplate.getForObject(peliculasDeAccionUrl + "&page=" + pagina, GenreMoviesMessage.class);
                System.out.println("Películas para importar: " + message.getTotal_pages());

                Collection<MoviesMessage> movies = message.getResults();

                for (MoviesMessage movie : movies) {

                    entityManager.getTransaction().begin();

                    queryPelicula.setParameter("peliculaId", movie.getId());
                    try {
                        miPelicula = (Pelicula) queryPelicula.getSingleResult();
                        presente = true;
                    }catch (NoResultException nrex){
                        miPelicula = new Pelicula();
                        miPelicula.setPeliculaId(movie.getId());
                        presente = false;
                    }

                    miPelicula.setNombre(movie.getTitle());
                    miPelicula.setGenero(generoAccion);
                    miPelicula.setTrama(movie.getOverview());
                    miPelicula.setFecha(new java.sql.Date(movie.getRelease_date().getTime()));
                    cantidad++;

                    System.out.println("\rItem [" + movie.getId() + "][" + (presente ? "Existente" : "Nuevo") + "]: " + cantidad);

                    // Lectura de Actores

                    Thread.sleep(150);
                    MovieCreditsMessage messageCredits = restTemplate.getForObject(String.format(creditosDePeliculaUrl, movie.getId()), MovieCreditsMessage.class);
                    System.out.println("Creditos de la película '" + miPelicula.getNombre() + "'");

                    Collection<CastMessage> castList = messageCredits.getCast();

                    for(CastMessage cast: castList){

                        System.out.println("Personaje: " + cast.getCharacter());

                        Thread.sleep(150);
                        PersonMessage messagePerson = restTemplate.getForObject(String.format(personaUrl, cast.getId()), PersonMessage.class);

                        System.out.println("Persona: " + messagePerson.getName());

                        queryPersona.setParameter("personaId", cast.getId());

                        Persona persona;

                        try{
                            persona = (Persona) queryPersona.getSingleResult();
                            // No hacemos nada, la persona ya está relacionada...
                        }catch(NoResultException nrex2){
                            persona = new Persona();
                            persona.setPersonaId(cast.getId());
                            persona.setNombre(messagePerson.getName());
                            persona.setFechaNacimiento(messagePerson.getBirthday());
                            entityManager.merge(persona);
                        }

                        queryPersonaje.setParameter("personajeId", cast.getCast_id());

                        Personaje personaje;

                        try {
                            personaje = (Personaje) queryPersonaje.getSingleResult();
                            // No se hace nada con el personaje, ya existe
                        }catch (NoResultException nrex3){
                            personaje = new Personaje();
                            personaje.setPersonajeId(cast.getCast_id());
                            personaje.setPelicula(miPelicula);
                            personaje.setNombre(cast.getCharacter());
                            personaje.setPersona(persona);
                            entityManager.persist(personaje);
                        }

                        if(!miPelicula.getPersonajes().contains(personaje)){
                            miPelicula.getPersonajes().add(personaje);
                        }

                    }

                    if(presente) {
                        entityManager.persist(miPelicula);
                    }else{
                        entityManager.merge(miPelicula);
                    }

                    entityManager.getTransaction().commit();

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

    protected void initializeEntityManager(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("defaultPersistenceUnit");

        System.out.println("EMF;" + entityManagerFactory);

        entityManager = entityManagerFactory.createEntityManager();

        System.out.println("EM: " + entityManager);
    }

}