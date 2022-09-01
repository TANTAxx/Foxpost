package com.foxpost;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;

@SpringBootApplication
@Import(SpringDataRestConfiguration.class)
public class Demo1Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
    }

//    @Bean
//    CommandLineRunner commandLineRunner(ClientRepository clientRepository, ParcelsRepository parcelsRepository) {
//        return args -> {
//            Clients newClientOne = new Clients("Nagy Ernő", "Ady Endre utca 10", "9700"
//                    , "Szombathely", "06203698337", "ernonagy10@freemail.hu");
//            clientRepository.save(newClientOne);
//            Parcels parcels = new Parcels(newClientOne.getId(), newClientOne.getId(), "XPS125044224");
//            parcelsRepository.save(parcels);
//        };
//    }
}
