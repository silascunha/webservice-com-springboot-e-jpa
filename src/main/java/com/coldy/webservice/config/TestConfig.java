package com.coldy.webservice.config;

import com.coldy.webservice.entities.Category;
import com.coldy.webservice.entities.Order;
import com.coldy.webservice.entities.User;
import com.coldy.webservice.entities.enums.OrderStatus;
import com.coldy.webservice.repositories.CategoryRepository;
import com.coldy.webservice.repositories.OrderRepository;
import com.coldy.webservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public void run(String... args) throws Exception {

        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        User u1 = new User(null, "Silas Cunha", "silas@gmail.com", "988888888", "12345");
        User u2 = new User(null, "Ana Paula", "anap@gmail.com", "977777777", "123456");

        Order o1 = new Order(null, Instant.parse("2020-06-20T19:53:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2020-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
        Order o3 = new Order(null, Instant.parse("2020-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);

        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
    }
}
