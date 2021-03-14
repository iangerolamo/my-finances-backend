package com.ig.myfinancesbackend;

import com.ig.myfinancesbackend.models.Transaction;
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

		Transaction transactionOne = new Transaction(null, "Salário", 5000.00, "income");
		Transaction transactionTwo = new Transaction(null, "Parcela do carro", 380.00, "outcome");
		Transaction transactionThree = new Transaction(null, "Curso de programação", 150.00, "outcome");
		Transaction transactionFour = new Transaction(null, "Conta de luz", 39.00, "income");

		transactionRepository.saveAll(Arrays.asList(transactionOne, transactionTwo, transactionThree, transactionFour));
	}

}
