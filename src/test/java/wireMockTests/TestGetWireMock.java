package wireMockTests;


import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.github.tomakehurst.wiremock.http.ResponseDefinition;
import com.github.tomakehurst.wiremock.stubbing.StubMapping;
import io.restassured.RestAssured;
import org.apache.http.impl.conn.Wire;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.net.URI;
import java.net.URISyntaxException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class TestGetWireMock {

    private static final int PORT = 8086;
    private static final String HOST = "localhost";

    @Before
    public void beforeTest()
    {
        WireMock.configureFor(HOST, PORT);
    }

    @Test
    public void test1() throws URISyntaxException, Exception {
        StubMapping responce = stubFor(WireMock.get("/my/tests")
                .willReturn(aResponse()));

     
        editStub(get(urlEqualTo("/my/tests"))
            .withId(responce.getId())
            .willReturn(aResponse()
                .withBody("Modified")));

        
    }
}
