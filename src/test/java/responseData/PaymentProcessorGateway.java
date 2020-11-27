package responseData;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.google.common.net.MediaType;
import wiremock.com.fasterxml.jackson.databind.ObjectMapper;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class PaymentProcessorGateway {

    public PaymentProcessorGateway(PaymentProcessorResponseRequest jsonObject) throws wiremock.com.fasterxml.jackson.core.JsonProcessingException {
        stubFor(WireMock.get("/user/1")
                .willReturn(aResponse()
                        .withStatus(200)
                        .withBody(new ObjectMapper().writeValueAsString(jsonObject)).withHeader("Content-Type", "application/json")));
    }
}
