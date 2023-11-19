package org.FPAS.springApp.Repository;

import org.FPAS.springApp.model.Benchmark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BenchmarkRepository extends JpaRepository<Benchmark, Long> {


}
