package mockito_test;

import org.FPAS.springApp.model.Benchmark;
import org.FPAS.springApp.Repository.BenchmarkRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class BenchmarkRepositoryTest {

    @Autowired
    private BenchmarkRepository benchmarkRepository;

    @Test
    public void testFindAll() {
        // Save some benchmarks
        // ...

        List<Benchmark> benchmarkList = benchmarkRepository.findAll();

        assertNotNull(benchmarkList, "Benchmark list should not be null");
        // Add more assertions based on your use case
    }
}
