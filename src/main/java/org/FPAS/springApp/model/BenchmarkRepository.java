package org.FPAS.springApp.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BenchmarkRepository extends JpaRepository<Benchmark, Long> {


}
