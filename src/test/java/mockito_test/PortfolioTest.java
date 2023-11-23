package mockito_test;

import org.FPAS.springApp.model.Client;
import org.FPAS.springApp.model.Portfolio;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PortfolioTest {

    @Test
    void testPortfolioConstructor() {
        Portfolio portfolio = new Portfolio();
        assertNotNull(portfolio);
        assertNull(portfolio.getName());
    }

    @Test
    void testPortfolioFields() {
        Client client = Client.builder()
                .uID(1L)
                .name("John Doe")
                .username("johndoe")
                .password("securePassword")
                .email("john.doe@example.com")
                .build();

        Portfolio portfolio = Portfolio.builder()
                .investmentID(1L)
                .name("Tech Stocks")
                .symbol("AAPL")
                .quantity(50)
                .purchasePrice(150.0)
                .purchaseYear("2022")
                .investmentType("Stock")
                .client(client)
                .build();

        assertEquals(1L, portfolio.getInvestmentID());
        assertEquals("Tech Stocks", portfolio.getName());
        assertEquals("AAPL", portfolio.getSymbol());
        assertEquals(50, portfolio.getQuantity());
        assertEquals(150.0, portfolio.getPurchasePrice());
        assertEquals("2022", portfolio.getPurchaseYear());
        assertEquals("Stock", portfolio.getInvestmentType());
        assertEquals(client, portfolio.getClient());

        assertNotNull(portfolio.getClient());
        assertEquals(1L, portfolio.getClient().getUID());
        assertEquals("John Doe", portfolio.getClient().getName());
        assertEquals("johndoe", portfolio.getClient().getUsername());
        assertEquals("securePassword", portfolio.getClient().getPassword());
        assertEquals("john.doe@example.com", portfolio.getClient().getEmail());
    }

    @Test
    void testSetterMethods() {
        Portfolio portfolio = new Portfolio();

        portfolio.setInvestmentID(2L);
        assertEquals(2L, portfolio.getInvestmentID());

        portfolio.setName("New Portfolio");
        assertEquals("New Portfolio", portfolio.getName());
    }

    @Test
    void testEqualsAndHashCodeMethods() {
        Client client1 = Client.builder()
                .uID(1L)
                .name("John Doe")
                .username("johndoe")
                .password("securePassword")
                .email("john.doe@example.com")
                .build();

        Portfolio portfolio1 = Portfolio.builder()
                .investmentID(1L)
                .name("Tech Stocks")
                .symbol("AAPL")
                .quantity(50)
                .purchasePrice(150.0)
                .purchaseYear("2022")
                .investmentType("Stock")
                .client(client1)
                .build();

        Portfolio portfolio2 = Portfolio.builder()
                .investmentID(1L)
                .name("Tech Stocks")
                .symbol("AAPL")
                .quantity(50)
                .purchasePrice(150.0)
                .purchaseYear("2022")
                .investmentType("Stock")
                .client(client1)
                .build();

        Client client2 = Client.builder()
                .uID(2L)
                .name("Jane Doe")
                .username("janedoe")
                .password("anotherPassword")
                .email("jane.doe@example.com")
                .build();

        Portfolio portfolio3 = Portfolio.builder()
                .investmentID(2L)
                .name("Real Estate")
                .symbol("RE")
                .quantity(20)
                .purchasePrice(200.0)
                .purchaseYear("2021")
                .investmentType("Real Estate")
                .client(client2)
                .build();

        assertEquals(portfolio1, portfolio2);
        assertNotEquals(portfolio1, portfolio3);
        assertEquals(portfolio1.hashCode(), portfolio2.hashCode());
        assertNotEquals(portfolio1.hashCode(), portfolio3.hashCode());
    }
}
