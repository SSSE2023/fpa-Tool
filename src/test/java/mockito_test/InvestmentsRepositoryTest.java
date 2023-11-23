package mockito_test;

import org.FPAS.springApp.model.Investments;
import org.FPAS.springApp.Repository.InvestmentsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class InvestmentsRepositoryTest {

    @Autowired
    private InvestmentsRepository investmentsRepository;

    @Test
    public void testFindBySymbol() {
        String symbol = "AAPL"; // Set up a symbol
        // Save some investments related to the symbol
        // ...

        List<Investments> investmentsList = investmentsRepository.findBySymbol(symbol);

        assertNotNull(investmentsList, "Investments list should not be null");
        // Add more assertions based on your use case
    }
}
