package com.ig.myfinancesbackend.repositories;

import com.ig.myfinancesbackend.entities.Transaction;
import com.ig.myfinancesbackend.entities.User;
import com.ig.myfinancesbackend.entities.enums.TypeTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    @Query( value =
            " select sum(t.value) from Transaction t join t.user u "
                    + " where u.id = :idUser and t.type =:type group by u " )

    BigDecimal getBalancePerUser(
            @Param("idUser") Integer idUser,
            @Param("type") TypeTransaction type);

    List<Transaction> getTransactionByUserId(Integer user_id);
}

