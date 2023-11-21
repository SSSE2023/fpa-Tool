package org.FPAS.springApp.Repository;

import org.FPAS.springApp.model.Client;
import org.FPAS.springApp.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByClient(Client client);
}
