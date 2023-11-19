package org.FPAS.springApp.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvestmentsRepository extends JpaRepository<Investments, String> {
    @Query("SELECT p FROM Investments p WHERE p.symbol = :symbol")
    List<Investments> findBySymbol(String symbol);
}
