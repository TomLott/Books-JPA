package ru.tomlott.demo.book;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class BookConfig {


    @Bean
    CommandLineRunner commandLineRunner(BookRepository repository){
        return args -> {
                    Book a = new Book(1L, "Harry Potter", "ss", "sa", 2000 , " dsaf ");
            Book b = new Book( "Harry Potter2", "ss", "sa", 2000, "  asdf");
            repository.saveAll(List.of(a, b));

        };
    }
}
