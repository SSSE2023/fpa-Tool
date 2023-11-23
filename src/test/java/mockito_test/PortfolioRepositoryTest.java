package mockito_test;

import org.FPAS.springApp.model.Client;
import org.FPAS.springApp.model.Portfolio;
import org.FPAS.springApp.Repository.PortfolioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class PortfolioRepositoryTest {

    @Autowired
    private PortfolioRepository portfolioRepository;

    @Test
    public void testFindByClient() {
        Client client = new Client(); // Set up a Client entity
        // Save some portfolios related to the client
        // ...

        List<Portfolio> portfolios = portfolioRepository.findByClient(client);

        assertNotNull(portfolios, "Portfolio list should not be null");
        // Add more assertions based on your use case
    }
}
