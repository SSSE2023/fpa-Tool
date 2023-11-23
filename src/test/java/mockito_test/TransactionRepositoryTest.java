package mockito_test;

import org.FPAS.springApp.model.Client;
import org.FPAS.springApp.model.Transaction;
import org.FPAS.springApp.Repository.TransactionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class TransactionRepositoryTest {

    @Autowired
    private TransactionRepository transactionRepository;

    @Test
    public void testFindByClient() {
        Client client = new Client(); // Set up a Client entity
        // Save some transactions related to the client
        // ...

        List<Transaction> transactions = transactionRepository.findByClient(client);

        assertNotNull(transactions, "Transaction list should not be null");
        // Add more assertions based on your use case
    }
}
