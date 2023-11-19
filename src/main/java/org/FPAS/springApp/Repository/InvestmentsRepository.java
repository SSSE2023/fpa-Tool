package org.FPAS.springApp.Repository;

import org.FPAS.springApp.model.Investments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvestmentsRepository extends JpaRepository<Investments, String> {
}
