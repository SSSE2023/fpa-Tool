package mockito_test;

import org.FPAS.springApp.model.Client;
import org.FPAS.springApp.model.Transaction;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {

    @Test
    void testTransactionConstructor() {
        Transaction transaction = new Transaction();
        assertNotNull(transaction);
    }

    @Test
    void testTransactionFields() {
        Client client = Client.builder()
                .uID(1L)
                .name("John Doe")
                .username("johndoe")
                .password("securePassword")
                .email("john.doe@example.com")
                .build();

        Transaction transaction = Transaction.builder()
                .transactionID(1L)
                .client(client)
                .transaction_year("2022")
                .transaction_type("Purchase")
                .transaction_amount(1000.0)
                .build();

        assertEquals(1L, transaction.getTransactionID());
        assertEquals(client, transaction.getClient());
        assertEquals("2022", transaction.getTransaction_year());
        assertEquals("Purchase", transaction.getTransaction_type());
        assertEquals(1000.0, transaction.getTransaction_amount());
    }


}
