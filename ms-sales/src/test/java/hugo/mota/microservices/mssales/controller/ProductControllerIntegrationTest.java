package hugo.mota.microservices.mssales.controller;


import hugo.mota.microservices.mssales.entity.ProductEntity;
import hugo.mota.microservices.mssales.repository.ProductRepository;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import lombok.SneakyThrows;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.util.UUID;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class ProductControllerIntegrationTest extends IntegrationAbstractTest {

    //@MockBean
    @Autowired
    private ProductRepository repository;

    @Test
    @SneakyThrows
    public void createAProduct() {

        ProductEntity productEntity = new ProductEntity();
        UUID productId = UUID.randomUUID();
        productEntity.setId(productId);
        productEntity.setName("test1");
        productEntity.setDescription("test1");
        productEntity.setPrice(BigDecimal.valueOf(10.6));

        //doReturn(productEntity).when(repository).save(productEntity);

        JSONObject requestParams = new JSONObject();
        requestParams.put("id", "");
        requestParams.put("name", "test1");
        requestParams.put("description", "test1");
        requestParams.put("price", BigDecimal.valueOf(10.6));


        Response response = given()
                .contentType(ContentType.JSON)
                .and().body(requestParams.toString())
                .when()
                .post("/products")
                .then()
                .extract().response();

        JsonPath jsonPath = response.jsonPath();

        assertEquals(201, response.statusCode());
        assertNotNull(jsonPath.getString("id"));
        assertEquals("test1", jsonPath.getString("name"));
        assertEquals("test1", jsonPath.getString("description"));
    }

}