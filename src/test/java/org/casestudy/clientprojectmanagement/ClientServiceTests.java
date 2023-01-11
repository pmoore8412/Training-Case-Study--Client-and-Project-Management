package org.casestudy.clientprojectmanagement;

import org.casestudy.clientprojectmanagement.Entities.Client;
import org.casestudy.clientprojectmanagement.Repositories.ClientRepository;
import org.casestudy.clientprojectmanagement.Services.ClientService;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;



@ExtendWith(MockitoExtension.class)
public class ClientServiceTests {

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientService clientService;

    private Client client;

    @BeforeEach
    public void setUp() {
        client = Client.builder()
                .id(675)
                .clientName("Jimmy Johns")
                .clientDescription("It's Freaky Fast")
                .build();
    }

    @Test
    @DisplayName("Test should pass when a new client is successfully added")
    public void shouldAddANewClient() {

        given(clientRepository.findByName(client.getClientName())).willReturn(null);
        given(clientRepository.save(client)).willReturn(client);

        Client testClient = clientService.addNewClient(client);

        assertThat(testClient).isNotNull();

    }

    @Test
    @DisplayName("Should Throw an exception when trying to add the same client")
    public void shouldThrowExceptionWhenTryingToAddSameClient() {

        given(clientRepository.findByName(client.getClientName())).willReturn(client);

        Assertions.assertThrows(ResponseStatusException.class ,() -> {
            clientService.addNewClient(client);
        });

        verify(clientRepository, never()).save(any(Client.class));
    }

    @Test
    @DisplayName("test should pass when the list of clients is returned")
    public void shouldGetListOfClients() {

        Client client2 = Client.builder()
                .id(679)
                .clientName("Wendy's")
                .clientDescription("Mom")
                .build();

        given(clientRepository.findAll()).willReturn(List.of(client, client2));

        List<Client> testClient = clientService.getAllClients();

        assertThat(testClient).isNotNull();
        assertThat(testClient.size()).isEqualTo(2);

    }

}
