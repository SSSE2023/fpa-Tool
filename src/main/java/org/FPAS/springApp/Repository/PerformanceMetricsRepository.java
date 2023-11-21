package org.FPAS.springApp.Repository;

import org.FPAS.springApp.model.Client;
import org.FPAS.springApp.model.PerformanceMetrics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PerformanceMetricsRepository extends JpaRepository<PerformanceMetrics, Long> {
    @Query("SELECT p FROM PerformanceMetrics p WHERE p.client_id = :clientId")
    List<PerformanceMetrics> findByClientId(@Param("clientId") long clientId);

    List<PerformanceMetrics> findByClient(Client client);
}


