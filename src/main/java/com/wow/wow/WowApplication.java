package com.wow.wow;

import java.io.IOException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

import com.wow.wow.model.Product;
import com.wow.wow.model.Role;
import com.wow.wow.model.User;
import com.wow.wow.repository.ProductRepository;
import com.wow.wow.repository.RoleRepository;
import com.wow.wow.repository.UserRepository;

@SpringBootApplication
public class WowApplication {

	public static void main(String[] args) {
		SpringApplication.run(WowApplication.class, args);
	}

	@Bean
	ApplicationRunner init(ProductRepository repository, UserRepository userrepo, RoleRepository rolrrepo) {
		Set<Product> lstProducts = new HashSet<>();
		Set<Role> role = new HashSet<>();
		Random ran = new Random();
		return args -> {
			Stream.of("Ferrari", "Jaguar", "Po rsche", "Lamborghini", "Bugatti", "AMC Gremlin", "Triumph Stag",
					"Ford Pinto", "Yugo GV", "Ferrari", "Jaguar", "Porsche", "Lamborghini", "Bugatti", "AMC Gremlin",
					"Triumph Stag").forEach(name -> {

						Product pro = new Product();
						pro.setName(name);
						pro.setDescription("Default");
						ClassPathResource img = new ClassPathResource("image/bag.png");
						byte[] arrayPic;
						try {
							arrayPic = new byte[(int) img.contentLength()];
							img.getInputStream().read(arrayPic);
							pro.setImage(arrayPic);
						} catch (IOException e) {
							e.printStackTrace();
						}

						pro.setCode("WOW12" + ran.nextInt());
						pro.setPrice(278.90);
						pro.setSize("1'12''");
						pro.setType("Pipping Long Shopping");
						for (int i = 0; i < 3; i++) {
							lstProducts.add(pro);
						}
						repository.save(pro);
					});
			Stream.of("Bugatti", "AMC Gremlin", "Triumph Stag", "Ford Pinto", "Yugo GV").forEach(name -> {

				Product pro = new Product();
				pro.setName(name);
				pro.setDescription("Default");
				ClassPathResource img = new ClassPathResource("image/bag.png");
				byte[] arrayPic;
				try {
					arrayPic = new byte[(int) img.contentLength()];
					img.getInputStream().read(arrayPic);
					pro.setImage(arrayPic);
				} catch (IOException e) {
					e.printStackTrace();
				}

				pro.setCode("WOW12" + ran.nextInt());
				pro.setPrice(278.90);
				pro.setSize("1'12''");
				pro.setType("Long Shopping Bag");
				for (int i = 0; i < 3; i++) {
					lstProducts.add(pro);
				}
				repository.save(pro);
			});
			Stream.of("USER", "ADMIN").forEach(name -> {
				Role pro = new Role();
				pro.setRole(name);
				role.add(pro);
				rolrrepo.save(pro);
			});

			Stream.of("nandha", "Kishore").forEach(name -> {
				// Set<Role> role = new HashSet<>();

				User user = new User();
				user.setFirstname(name);
				user.setLastname(name);
				user.setEmail(user.getFirstname());
				user.setPassword(user.getFirstname());
				user.setPhonenum("9843514822");
				user.setRole(role);
				userrepo.save(user);
			});
			Stream.of("dany").forEach(name -> {
				Set<Role> role1 = new HashSet<>();
				Role pro = new Role();
				pro.setRole("USER1");
				role1.add(pro);
				rolrrepo.save(pro);
				User user = new User();
				user.setFirstname(name);
				user.setLastname(name);
				user.setPhonenum("9843514822");
				user.setEmail(user.getFirstname());
				user.setPassword(user.getFirstname());
				user.setRole(role);
				user.setRole(role1);
				userrepo.save(user);
			});

		};
	}
}
