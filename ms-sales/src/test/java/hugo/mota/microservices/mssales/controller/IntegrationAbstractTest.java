package hugo.mota.microservices.mssales.controller;

import io.restassured.RestAssured;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;


@ActiveProfiles("test")
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public abstract class IntegrationAbstractTest {

    @LocalServerPort
    protected Integer port;

    @Value("${app.baseurl}")
    protected String baseUrl;

    @Value("${server.servlet.context-path}")
    protected String contextPath;

    @PostConstruct
    public void setup() {
        RestAssured.baseURI = baseUrl + ":" + port + "" + contextPath;
    }

}