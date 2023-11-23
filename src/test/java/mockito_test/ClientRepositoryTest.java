package mockito_test;

import org.FPAS.springApp.Repository.ClientRepository;
import org.FPAS.springApp.model.Client;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ClientRepositoryTest {

    @Autowired
    ClientRepository clientRepository;

    @Test
    public void testFindByUsernameAndPassword() {
        // Given
        Client client = Client.builder()
                .name("John Doe")
                .username("john.doe")
                .password("password123")
                .email("john.doe@example.com")
                .build();

        clientRepository.save(client);

        // When
        Optional<Client> foundClient = clientRepository.findByUsernameAndPassword("john.doe", "password123");

        // Then
        assertTrue(foundClient.isPresent());
        assertEquals("John Doe", foundClient.get().getName());
        assertEquals("john.doe", foundClient.get().getUsername());
        assertEquals("password123", foundClient.get().getPassword());
        assertEquals("john.doe@example.com", foundClient.get().getEmail());
    }

    // Add more test cases as needed

}
