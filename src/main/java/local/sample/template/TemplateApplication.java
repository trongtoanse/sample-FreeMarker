package local.sample.template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

@SpringBootApplication
public class TemplateApplication implements CommandLineRunner {

    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;

    public static void main(String[] args) {
        SpringApplication.run(TemplateApplication.class, args);
        System.exit(1);
    }

    @Override
    public void run(String... args) {
        FreeMarkerWriter freeMarkerWriter = new FreeMarkerWriter(freeMarkerConfigurer.getConfiguration());
        freeMarkerWriter.run();
    }
}
