package api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import utilities.ConfigLoader;

public class SpecBuilder {

    public static RequestSpecification getRequestSpec() {
        ConfigLoader configLoader = new ConfigLoader();
        return new RequestSpecBuilder().setBaseUri(configLoader.getProperty("Baseurl")).setContentType(ContentType.JSON)
                .log(LogDetail.ALL).build();
    }

    public static ResponseSpecification getResponseSpec() {
        return new ResponseSpecBuilder().log(LogDetail.ALL).build();
    }
}
