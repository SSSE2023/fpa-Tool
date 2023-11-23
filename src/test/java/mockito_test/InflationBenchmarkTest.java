package mockito_test;

import org.FPAS.springApp.model.InflationBenchmark;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InflationBenchmarkTest {

    @Test
    public void testGetAdjustedReturn() {
        InflationBenchmark inflationBenchmark = InflationBenchmark.builder()
                .inflationID(1L)
                .name("Test Inflation")
                .return_2020(0.1)
                .return_2021(0.2)
                .return_2022(0.3)
                .return_2023(0.4)
                .build();

        assertEquals(0.13, inflationBenchmark.getAdjustedReturn("2020"), 0.0001);
        assertEquals(0.24, inflationBenchmark.getAdjustedReturn("2021"), 0.0001);
        assertEquals(0.35, inflationBenchmark.getAdjustedReturn("2022"), 0.0001);
        assertEquals(0.46, inflationBenchmark.getAdjustedReturn("2023"), 0.0001);

        // Test case for default year
        assertEquals(0.0, inflationBenchmark.getAdjustedReturn("2024"), 0.0001);

        // Test case with a negative return
        inflationBenchmark.setReturn_2020(-0.1);
        assertEquals(-0.07, inflationBenchmark.getAdjustedReturn("2020"), 0.0001);

        // Add more test cases as needed
    }

    @Test
    public void testSetterAndGetterMethods() {
        InflationBenchmark inflationBenchmark = new InflationBenchmark();

        inflationBenchmark.setInflationID(2L);
        assertEquals(2L, inflationBenchmark.getInflationID());

        inflationBenchmark.setName("New Inflation");
        assertEquals("New Inflation", inflationBenchmark.getName());

        inflationBenchmark.setReturn_2020(0.5);
        assertEquals(0.5, inflationBenchmark.getReturn_2020(), 0.0001);

        inflationBenchmark.setReturn_2021(0.6);
        assertEquals(0.6, inflationBenchmark.getReturn_2021(), 0.0001);

        inflationBenchmark.setReturn_2022(0.7);
        assertEquals(0.7, inflationBenchmark.getReturn_2022(), 0.0001);

        inflationBenchmark.setReturn_2023(0.8);
        assertEquals(0.8, inflationBenchmark.getReturn_2023(), 0.0001);
    }

    // Add more test methods as needed for other functionalities of your InflationBenchmark class
}
