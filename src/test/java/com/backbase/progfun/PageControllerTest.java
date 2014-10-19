package com.backbase.progfun;

import com.jayway.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static com.jayway.restassured.RestAssured.when;
import static com.jayway.restassured.http.ContentType.JSON;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class PageControllerTest {

    @Autowired
    PageRepository pageRepository;

    @Value("${local.server.port}")
    int port;

    @Before
    public void setUp() {
        RestAssured.port = port;
    }

    @Test
    public void links() {
        when().get("/").then()
                .statusCode(HttpStatus.SC_OK)
                .contentType(JSON)
                .body("_links.pages.href", Matchers.is("http://localhost:" + port + "/pages"))
                .body("_links.portals.href", Matchers.is("http://localhost:" + port + "/portals"));
    }

    @Test
    public void findPage( ) {
        when().get("/pages/1").then().statusCode(HttpStatus.SC_OK).body("name", Matchers.is("login"));
    }

    @Test
    public void deleteExistingPage() {
        when().delete("/pages/2").then().statusCode(HttpStatus.SC_NO_CONTENT);
    }

    @Test
    public void deleteNonExistingPage() {
        when().delete("/pages/6").then().statusCode(HttpStatus.SC_NOT_FOUND);
    }


}
