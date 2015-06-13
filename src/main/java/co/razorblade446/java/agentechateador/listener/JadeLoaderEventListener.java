package co.razorblade446.java.agentechateador.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.ArrayList;
import java.util.List;

public class JadeLoaderEventListener implements ApplicationListener {

    private static int counter = 0;

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        if(applicationEvent instanceof ContextRefreshedEvent){
            if(counter == 0) {
                System.out.println("========== INICIALIZACIÓN DE JADE ==========");

                ArrayList<String> parametros = new ArrayList<String>();

                parametros.add("-conf");

                parametros.add("src/main/resources/jade-container.properties");

                jade.Boot.main(parametros.toArray(new String[parametros.size()]));

                counter++;
            }
        }

    }
}
