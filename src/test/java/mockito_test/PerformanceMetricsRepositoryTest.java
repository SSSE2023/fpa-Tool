package mockito_test;
import org.FPAS.springApp.model.Client;
import org.FPAS.springApp.model.PerformanceMetrics;
import org.FPAS.springApp.Repository.PerformanceMetricsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class PerformanceMetricsRepositoryTest {

    @Autowired
    private PerformanceMetricsRepository performanceMetricsRepository;

    @Test
    public void testFindByClientId() {
        Client client = new Client(); // Set up a Client entity
        // Save some performance metrics related to the client
        // ...

        List<PerformanceMetrics> metricsList = performanceMetricsRepository.findByClientId(client.getUID());

        assertNotNull(metricsList, "PerformanceMetrics list should not be null");
        // Add more assertions based on your use case
    }

    @Test
    public void testFindByClient() {
        Client client = new Client(); // Set up a Client entity
        // Save some performance metrics related to the client
        // ...

        List<PerformanceMetrics> metricsList = performanceMetricsRepository.findByClient(client);

        assertNotNull(metricsList, "PerformanceMetrics list should not be null");
        // Add more assertions based on your use case
    }
}
