package mockito_test;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import org.FPAS.springApp.Repository.ClientRepository;
import org.FPAS.springApp.model.Client;
import org.FPAS.javaFXApp.service.ClientService;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.mockito.Mockito.*;

class ClientServiceTest {

    @Test
    void testSignUpUser_Successful() {
        new JFXPanel();

        ClientRepository clientRepositoryMock = mock(ClientRepository.class);
        ClientService clientService = new ClientService(clientRepositoryMock);

        String name = "Johnathan";
        String username = "johnnyD";
        String password = "password";
        String email = "john.doe@example.com";

        ActionEvent actionEventMock = mock(ActionEvent.class);

        Client savedClient = Client.builder()
                .name(name)
                .username(username)
                .password(password)
                .email(email)
                .build();

        Platform.runLater(() -> {
            when(clientRepositoryMock.save(any(Client.class))).thenReturn(savedClient);

            clientService.signUpUser(actionEventMock, name, username, password, email);

            verify(clientRepositoryMock, times(1)).save(any(Client.class));
        });
    }

    @Test
    void testSignUpUser_DuplicateUsername() {
        new JFXPanel();

        ClientRepository clientRepositoryMock = mock(ClientRepository.class);
        ClientService clientService = new ClientService(clientRepositoryMock);

        String name = "Johnathan";
        String username = "johnnyD";
        String password = "password";
        String email = "john.doe@example.com";

        ActionEvent actionEventMock = mock(ActionEvent.class);

        Client existingClient = Client.builder()
                .name("Existing User")
                .username(username)
                .password("existingPassword")
                .email("existing@example.com")
                .build();

        when(clientRepositoryMock.findByUsernameAndPassword(username,password)).thenReturn(Optional.ofNullable(existingClient));

        Platform.runLater(() -> {
            clientService.signUpUser(actionEventMock, name, username, password, email);

            verify(clientRepositoryMock, never()).save(any(Client.class));
        });
    }
}
