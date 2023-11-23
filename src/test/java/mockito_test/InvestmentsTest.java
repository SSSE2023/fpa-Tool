package mockito_test;

import org.FPAS.springApp.model.Investments;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InvestmentsTest {

    @Test
    public void testInvestments() {
        Investments investment = Investments.builder()
                .symbol("AAPL")
                .name("Apple Inc.")
                .investmentType("Stock")
                .price_2022(150)
                .price_2021(130)
                .price_2020(110)
                .price_2023_Q1(160)
                .price_2023_Q2(170)
                .price_2023_Q3(180)
                .risk_rating(3)
                .build();

        assertEquals("AAPL", investment.getSymbol());
        assertEquals("Apple Inc.", investment.getName());
        assertEquals("Stock", investment.getInvestmentType());
        assertEquals(150, investment.getPrice_2022());
        assertEquals(130, investment.getPrice_2021());
        assertEquals(110, investment.getPrice_2020());
        assertEquals(160, investment.getPrice_2023_Q1());
        assertEquals(170, investment.getPrice_2023_Q2());
        assertEquals(180, investment.getPrice_2023_Q3());
        assertEquals(3, investment.getRisk_rating());
    }
}
