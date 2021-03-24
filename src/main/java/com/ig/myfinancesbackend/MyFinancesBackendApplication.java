package com.ig.myfinancesbackend;

import com.ig.myfinancesbackend.entities.Transaction;
import com.ig.myfinancesbackend.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class MyFinancesBackendApplication implements CommandLineRunner {

	@Autowired
	private TransactionRepository transactionRepository;

	public static void main(String[] args) {

		SpringApplication.run(MyFinancesBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Transaction transactionOne = new Transaction(1, "Salário", 5000.00, "entrada");
		Transaction transactionTwo = new Transaction(2, "Parcela do carro", -380.00, "saída");
		Transaction transactionThree = new Transaction(3, "Curso de programação", -150.00, "saída");

		transactionRepository.saveAll(Arrays.asList(transactionOne, transactionTwo, transactionThree));
	}


}
