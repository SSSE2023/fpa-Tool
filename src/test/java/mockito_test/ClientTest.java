package mockito_test;

import org.FPAS.springApp.model.Client;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ClientTest {

    @Test
    void testClientConstructor() {
        Client client = new Client();
        assertNotNull(client);
    }

    @Test
    void testClientFields() {
        Client client = Client.builder()
                .uID(1L)
                .name("John Doe")
                .username("johndoe")
                .password("securePassword")
                .email("john.doe@example.com")
                .build();

        assertEquals(1L, client.getUID());
        assertEquals("John Doe", client.getName());
        assertEquals("johndoe", client.getUsername());
        assertEquals("securePassword", client.getPassword());
        assertEquals("john.doe@example.com", client.getEmail());
    }

    @Test
    void testClientEquality() {
        Client client1 = Client.builder()
                .uID(1L)
                .name("John Doe")
                .username("johndoe")
                .password("securePassword")
                .email("john.doe@example.com")
                .build();

        Client client2 = Client.builder()
                .uID(1L)
                .name("John Doe")
                .username("johndoe")
                .password("securePassword")
                .email("john.doe@example.com")
                .build();

        assertEquals(client1, client2);
    }

    @Test
    void testClientNotEqual() {
        Client client1 = Client.builder()
                .uID(1L)
                .name("John Doe")
                .username("johndoe")
                .password("securePassword")
                .email("john.doe@example.com")
                .build();

        Client client2 = Client.builder()
                .uID(2L)
                .name("Jane Doe")
                .username("janedoe")
                .password("anotherPassword")
                .email("jane.doe@example.com")
                .build();

        assertNotEquals(client1, client2);
    }

    @Test
    void testClientToString() {
        Client client = Client.builder()
                .uID(1L)
                .name("John Doe")
                .username("johndoe")
                .password("securePassword")
                .email("john.doe@example.com")
                .build();

        String expectedToString = "Client(uID=1, name=John Doe, username=johndoe, password=securePassword, email=john.doe@example.com)";
        assertEquals(expectedToString, client.toString());
    }


}
