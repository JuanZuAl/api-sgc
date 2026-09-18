package co.github.JuanZuAl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
// Spring Data JPA toma por defecto las clases "<Repositorio>Impl" como fragmentos del repositorio.
// Se cambia el sufijo para que las clases repository.impl.*RepositoryImpl sean beans normales.
@EnableJpaRepositories(repositoryImplementationPostfix = "CustomImpl")
public class BootApplication {

    public static void main(String[] args) {

        SpringApplication.run(BootApplication.class, args);
    }
}
