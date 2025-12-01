package com.sige;

import com.sige.model.*;
import com.sige.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;


import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootApplication
public class SigeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SigeApplication.class, args);
	}

	@Bean // <- ESSENCIAL para o Spring registrar e executar o CommandLineRunner
	CommandLineRunner setupTestData(EmpresaRepository empresaRepository,
									AlunoRepository alunoRepository,
									OfertaEstagioRepository ofertaRepository,
									CandidaturaRepository candidaturaRepository,
									JdbcTemplate jdbcTemplate) {
		return args -> {

			// Limpar banco de dados
			candidaturaRepository.deleteAll();
			ofertaRepository.deleteAll();
			alunoRepository.deleteAll();
			empresaRepository.deleteAll();

			// Resetar sequences
			jdbcTemplate.execute("ALTER SEQUENCE empresa_id_seq RESTART WITH 1");
			jdbcTemplate.execute("ALTER SEQUENCE aluno_id_seq RESTART WITH 1");
			jdbcTemplate.execute("ALTER SEQUENCE oferta_estagio_id_seq RESTART WITH 1");
			jdbcTemplate.execute("ALTER SEQUENCE candidatura_id_seq RESTART WITH 1");

			// Criar empresa
			Empresa e1 = new Empresa();
			e1.setNome("Empresa Teste");
			e1.setCnpj("12345678000199");
			e1.setEmail("empresa@teste.com");
			e1.setTelefone("11999999999");
			e1.setEndereco("Rua Teste, 123");
			e1.setSenha("senha123");
			empresaRepository.saveAndFlush(e1);

			// Criar oferta
			OfertaEstagio o1 = OfertaEstagio.builder()
					.descricaoVaga("Vaga para desenvolvedor Java")
					.empresa(e1)
					.dataCriacao(LocalDateTime.now())
					.status("ABERTA")
					.build();
			ofertaRepository.save(o1);

			// Criar aluno
			Aluno a1 = new Aluno(
					"Gabriel Bresolin",
					"12345678901",
					LocalDate.of(2003, 1, 15),
					"20231001",
					"11999999999",
					"Rua A, 123",
					"gabriel@teste.com",
					"senha123"
			);
			alunoRepository.save(a1);

			// Criar candidatura
			Candidatura c1 = new Candidatura();
			c1.setAluno(a1);
			c1.setOferta(o1);
			c1.setStatus(StatusCandidatura.INSCRITO);
			candidaturaRepository.save(c1);

			System.out.println("Dados de teste criados com sucesso!");

			// Mostrar ofertas
			ofertaRepository.findAll().forEach(o -> {
				System.out.println("Oferta: " + o.getDescricaoVaga() + " Empresa ID: " + o.getEmpresa().getId());
			});
		};
	}
}
