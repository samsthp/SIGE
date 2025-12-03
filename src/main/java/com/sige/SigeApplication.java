package com.sige;

import com.sige.model.Empresa;
import com.sige.repository.EmpresaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SigeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SigeApplication.class, args);
    }

}
