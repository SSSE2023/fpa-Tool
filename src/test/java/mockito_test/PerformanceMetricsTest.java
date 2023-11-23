package mockito_test;

import org.FPAS.springApp.model.Client;
import org.FPAS.springApp.model.PerformanceMetrics;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PerformanceMetricsTest {

    @Test
    void testPerformanceMetricsConstructor() {
        PerformanceMetrics metrics = new PerformanceMetrics();
        assertNotNull(metrics);
    }

    @Test
    void testPerformanceMetricsFields() {
        Client client = Client.builder()
                .uID(1L)
                .name("John Doe")
                .username("johndoe")
                .password("securePassword")
                .email("john.doe@example.com")
                .build();

        PerformanceMetrics metrics = PerformanceMetrics.builder()
                .metricsid(1L)
                .client_id(1L)
                .return_2020(0.1)
                .return_2021(0.15)
                .return_2022(0.12)
                .return_2023(0.2)
                .standard_deviation(0.05)
                .client(client)
                .build();

        assertEquals(1L, metrics.getMetricsid());
        assertEquals(1L, metrics.getClient_id());
        assertEquals(0.1, metrics.getReturn_2020());
        assertEquals(0.15, metrics.getReturn_2021());
        assertEquals(0.12, metrics.getReturn_2022());
        assertEquals(0.2, metrics.getReturn_2023());
        assertEquals(0.05, metrics.getStandard_deviation());
        assertEquals(client, metrics.getClient());
    }

    // Add more test cases as needed

}
