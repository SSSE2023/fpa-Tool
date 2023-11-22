package mockito_test;

import org.FPAS.javaFXApp.SharedData;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SharedDataTest {

    @Test
    void testSetCredentials() {
        String testUsername = "testUser";
        String testPassword = "testPassword";

        SharedData.setCredentials(testUsername, testPassword);

        assertEquals(testUsername, SharedData.getUsername());
        assertEquals(testPassword, SharedData.getPassword());
    }
}
