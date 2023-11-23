package mockito_test;

import org.FPAS.springApp.SpringJavaFxApplication;
import org.FPAS.springApp.SpringManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SpringManagerTest {

    @BeforeEach
    public void setUp() {
        SpringManager.startSpringApp();
    }

    @AfterEach
    public void tearDown() {
        SpringManager.stopSpringApp();
    }

    @Test
    public void testSpringManager() {
        SpringJavaFxApplication springApp = SpringManager.getSpringApp();
        assertNotNull(springApp, "Spring application should not be null");
    }
}
