package com.wow.wow;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.wow.wow.model.Product;
import com.wow.wow.model.User;
import com.wow.wow.repository.ProductRepository;
import com.wow.wow.repository.UserRepository;
@SpringBootApplication
public class WowApplication {

	public static void main(String[] args) {
		SpringApplication.run(WowApplication.class, args);
	}
	
	@Bean
    ApplicationRunner init(ProductRepository repository, UserRepository userrepo) {
		Set<Product> lstProducts = new HashSet<>();
        return args -> {
            Stream.of("Ferrari", "Jaguar", "Porsche", "Lamborghini", "Bugatti",
                      "AMC Gremlin", "Triumph Stag", "Ford Pinto", "Yugo GV", "Ferrari", "Jaguar", "Porsche", "Lamborghini", "Bugatti",
                      "AMC Gremlin", "Triumph Stag", "Ford Pinto", "Yugo GV").forEach(name -> {
                Product pro = new Product();
                pro.setName(name);
                pro.setDescription("Default");
                pro.setCode("WOW12");
                pro.setPrice(278.90);
                pro.setSize("1'12''");
                for(int i=0; i<3;i++) {
                	lstProducts.add(pro);
                }
                repository.save(pro);
            });

            Stream.of("Nandha", "Dany", "Kishore").forEach(name -> {
                User user = new User();
                user.setFirstname(name);
                user.setLastname(name);
                user.setEmail("defaultnmail@gmail.com");
                userrepo.save(user);
            });
        
        };
    }
}
   
