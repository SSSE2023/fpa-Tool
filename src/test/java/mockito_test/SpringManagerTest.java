package mockito_test;
import org.FPAS.springApp.SpringManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SpringManagerTest {

    @BeforeEach
    public void setUp() {

    }

    @AfterEach
    public void tearDown() {

    }

    @Test
    public void testStartAndStopSpringApp() {
        SpringManager.startSpringApp();
        assertNotNull(SpringManager.getSpringApp());

        SpringManager.stopSpringApp();
    }
}
