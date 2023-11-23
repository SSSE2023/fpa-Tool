package mockito_test;

import org.FPAS.springApp.model.Benchmark;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BenchmarkTest {

    @Test
    void testBenchmarkConstructor() {
        Benchmark benchmark = new Benchmark();
        assertNotNull(benchmark);
    }

    @Test
    void testBenchmarkFields() {
        Benchmark benchmark = Benchmark.builder()
                .benchmarkID(1L)
                .name("S&P 500")
                .benchmarkReturn(0.1)
                .annum(2022)
                .build();

        assertEquals(1L, benchmark.getBenchmarkID());
        assertEquals("S&P 500", benchmark.getName());
        assertEquals(0.1, benchmark.getBenchmarkReturn());
        assertEquals(2022, benchmark.getAnnum());
    }

    // Add more test cases as needed

}
