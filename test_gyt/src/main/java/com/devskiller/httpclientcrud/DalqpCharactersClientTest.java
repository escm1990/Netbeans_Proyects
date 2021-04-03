package com.devskiller.httpclientcrud;

import com.devskiller.httpclientcrud.model.Character;
import com.devskiller.httpclientcrud.model.Character.Details;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.*;

class DalqpCharactersClientTest {

    private static final String USERNAME = "Noobmaster69";
    private static final String PASSWORD = "p@ssw0rd";
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private static final String API_VERSION_VALUE = "resource=2.1";
    private static final String API_VERSION_HEADER = "Accept-API-Version";

    private DalqpCharactersClient testClient;
    private WireMockServer wireMockServer;

    @BeforeEach
    void setUp() {
        testClient = new DalqpCharactersClient(USERNAME, PASSWORD);
        wireMockServer = new WireMockServer();
        wireMockServer.start();
    }

    @AfterEach
    void cleanUp() {
        wireMockServer.stop();
    }

    @Test
    @DisplayName("verify if deleteCharacter matches request")
    void deleteCharacter() throws IOException, InterruptedException {
        // given
        String deleteCharacter = "pr0Player1";
        wireMockServer.stubFor(delete(urlPathEqualTo("/characters/" + deleteCharacter))
                .withBasicAuth(USERNAME, PASSWORD)
                .withHeader(API_VERSION_HEADER, equalTo(API_VERSION_VALUE))
                .willReturn(ok()));

        // when
        HttpResponse<Void> response = testClient.deleteCharacterByName(deleteCharacter);

        // then
        assertNotNull(response);
        assertEquals(200, response.statusCode());
        assertNull(response.body());
    }

    @Test
    @DisplayName("verify if getCharacterDetails matches request")
    void getCharacterDetails() throws IOException, ExecutionException, InterruptedException {
        // given
        Character detailedCharacter = new Character("Arthas", "human", new Details(120, "Kazzak", 445));
        wireMockServer
                .stubFor(get(urlPathEqualTo("/characters/" + detailedCharacter.getName() + "/details"))
                        .withBasicAuth(USERNAME, PASSWORD)
                        .withHeader(API_VERSION_HEADER, equalTo(API_VERSION_VALUE))
                        .willReturn(okJson(OBJECT_MAPPER.writeValueAsString(detailedCharacter))));

        // when
        CompletableFuture<HttpResponse<String>> futureResponse = testClient
                .getCharacterDetails(detailedCharacter.getName());

        // then
        assertNotNull(futureResponse);
        HttpResponse<String> response = futureResponse.get();
        assertEquals(200, response.statusCode());
        assertEquals(detailedCharacter, OBJECT_MAPPER.readValue(response.body(), Character.class));
    }
}
