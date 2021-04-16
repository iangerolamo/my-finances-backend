package com.ig.myfinancesbackend;

import com.ig.myfinancesbackend.entities.Transaction;
import com.ig.myfinancesbackend.entities.User;
import com.ig.myfinancesbackend.entities.enums.TypeTransaction;
import com.ig.myfinancesbackend.repositories.TransactionRepository;
import com.ig.myfinancesbackend.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.Arrays;

@SpringBootApplication
public class MyFinancesBackendApplication implements CommandLineRunner {

	private final TransactionRepository transactionRepository;
	private final UserRepository userRepository;

	public MyFinancesBackendApplication(TransactionRepository transactionRepository, UserRepository userRepository) {
		this.transactionRepository = transactionRepository;
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {

		SpringApplication.run(MyFinancesBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		User u1 = new User(null, "Ian", "iangerolamo@gmail.com", "123456");
		User u2 = new User(null, "Jessica", "jessica@gmail.com", "654321");

		BigDecimal big1 = new BigDecimal("5000");
		BigDecimal big2 = new BigDecimal("380");
		BigDecimal big3 = new BigDecimal("150");
		BigDecimal big4 = new BigDecimal("850");
		BigDecimal big5 = new BigDecimal("550");
		BigDecimal big6 = new BigDecimal("1800");


		Transaction t1 = new Transaction(null, "Salário", 3, 2021, u1, big1, TypeTransaction.INCOME);
		Transaction t2 = new Transaction(null, "Parcela do carro", 3, 2021, u1, big2, TypeTransaction.OUTCOME);
		Transaction t3 = new Transaction(null, "Curso de programação", 3, 2021, u1,big3, TypeTransaction.OUTCOME);
		Transaction t4 = new Transaction(null, "Aluguel do apartamento", 3, 2021, u1, big4, TypeTransaction.OUTCOME);
		Transaction t5 = new Transaction(null, "Parcela do cartão de crédito", 3, 2021, u1, big5, TypeTransaction.OUTCOME);
		Transaction t6 = new Transaction(null, "Salário", 3, 2021, u2, big6, TypeTransaction.INCOME);

		userRepository.saveAll(Arrays.asList(u1, u2));
		transactionRepository.saveAll(Arrays.asList(t1, t2, t3, t4, t5, t6));
	}


}
