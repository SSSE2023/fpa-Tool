package org.FPAS.springApp.Repository;

import org.FPAS.springApp.model.Benchmark;
import org.FPAS.springApp.model.InflationBenchmark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InflationBenchmarkRepository extends JpaRepository<InflationBenchmark, Long> {
}
