package com.ig.myfinancesbackend;

import com.ig.myfinancesbackend.entities.Transaction;
import com.ig.myfinancesbackend.entities.enums.TypeTransaction;
import com.ig.myfinancesbackend.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class MyFinancesBackendApplication implements CommandLineRunner {

	private final TransactionRepository transactionRepository;

	public MyFinancesBackendApplication(TransactionRepository transactionRepository) {
		this.transactionRepository = transactionRepository;
	}

	public static void main(String[] args) {

		SpringApplication.run(MyFinancesBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Transaction t1 = new Transaction(null, "Salário", 3, 2021, 5000.00, TypeTransaction.INCOME);
		Transaction t2 = new Transaction(null, "Parcela do carro", 3, 2021, 380.00, TypeTransaction.OUTCOME);
		Transaction t3 = new Transaction(null, "Curso de programação", 3, 2021, 150.00, TypeTransaction.OUTCOME);
		Transaction t4 = new Transaction(null, "Aluguel do apartamento", 3, 2021, 850.00, TypeTransaction.OUTCOME);
		Transaction t5 =  new Transaction(null, "Parcela do cartão de crédito", 3, 2021, 550.00, TypeTransaction.OUTCOME);

		transactionRepository.saveAll(Arrays.asList(t1, t2, t3, t4, t5));
	}


}
