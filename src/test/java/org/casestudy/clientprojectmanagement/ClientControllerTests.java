package org.casestudy.clientprojectmanagement;

import org.casestudy.clientprojectmanagement.Controllers.ClientController;
import org.casestudy.clientprojectmanagement.Entities.Client;
import org.casestudy.clientprojectmanagement.Services.ClientService;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.mockito.BDDMockito.given;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ClientControllerTests {

    @Mock
    private ClientService clientService;

    @InjectMocks
    private ClientController clientController;

    private Client client;

    @BeforeEach
    public void setUp() {
        client = Client.builder()
                .id("59dcfd0f-59e4-4101-be3c-4fe6791cf52e")
                .clientName("Jimmy Johns")
                .clientPOC("Jimmy John")
                .clientPOCEmail("jimjohn@jimmyjohns.com")
                .clientDescription("It's Freaky Fast")
                .build();
    }

    @Test
    @DisplayName("Test should pass when a new client is successfully added")
    public void shouldAddNewClient() {

        given(clientService.addNewClient(client)).willReturn(client);

        Client testClient = clientController.addNewClient(client);

        assertThat(testClient).isNotNull();

    }

    @Test
    @DisplayName("Test should pass if client is found by id")
    public void shouldGetClientDetails() {
        given(clientService.getClient(client.getId())).willReturn(client);

        Client testClient = clientController.getClient(client.getId());

        assertThat(testClient).isNotNull();
    }

    @Test
    @DisplayName("test should pass when the list of clients is returned")
    public void shouldGetListOfClients() {

        Client client2 = Client.builder()
                .id("22a484e4-2ca1-4e6f-a68c-801231657d5c")
                .clientName("Wendy's")
                .clientDescription("Mom")
                .clientPOC("John Doe")
                .clientDescription("Mom")
                .build();

        given(clientService.getAllClients()).willReturn(List.of(client, client2));

        List<Client> testClient = clientController.getAllClients();

        assertThat(testClient).isNotNull();
        assertThat(testClient.size()).isEqualTo(2);

    }

    @Test
    @DisplayName("Test should pass if client is updated successfully")
    public void shouldUpdateClient() {

        given(clientService.updateClientDetails(client.getId(), client)).willReturn(client);

        client.setClientPOC("Mr Sub");
        client.setClientPOCEmail("mrsub@quiznos.com");

        Client updateClient = clientController.updateClientDetails(client.getId(), client);

        assertThat(updateClient.getClientPOC()).isEqualTo("Mr Sub");
        assertThat(updateClient.getClientPOCEmail()).isEqualTo("mrsub@quiznos.com");

    }

}
