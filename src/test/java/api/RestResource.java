package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import static api.SpecBuilder.getRequestSpec;
import static api.SpecBuilder.getResponseSpec;
import static io.restassured.RestAssured.given;

public class RestResource {
    public static String token, cookie;

    public static Response post(String path, Object login) {
        return given(getRequestSpec()).body(login).when().post(path).then().spec(getResponseSpec()).extract()
                .response();
    }

    public static Response get(String path, HashMap<String, String> headers, HashMap<String, String> queryParams) {
        return given(getRequestSpec()).queryParams(queryParams).headers(headers).when().get(path).then()
                .spec(getResponseSpec()).extract().response();
    }

    public static Response get(String path, Map<String, String> headers, String pathParam) {
        return given(getRequestSpec()).headers(headers).when().get(path + pathParam).then().spec(getResponseSpec())
                .extract().response();
    }

    public static Response get(String pathParam, HashMap<String, String> headers) {
        return given(getRequestSpec()).headers(headers).when().get(pathParam).then().spec(getResponseSpec()).extract()
                .response();
    }

    public static Response post(String path, Map<String, String> headers, Object data) {
        return given(getRequestSpec()).headers(headers).body(data).when().post(path).then().spec(getResponseSpec())
                .extract().response();
    }

    public String currentLocalTime() {
        LocalTime now = LocalTime.now();

        // Define the formatter for the desired output format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        // Format the current LocalTime to a string
        String formattedTime = now.format(formatter);

        return formattedTime;
    }

    public String dbDateFormatter(String dateValue) {

        // Input date in ISO format
        String isoDate = dateValue;

        // Define the input and output formats
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        // Parse the input date and format it to the desired output format
        LocalDate date = LocalDate.parse(isoDate, inputFormatter);
        String formattedDate = date.format(outputFormatter);

        // Output the result
        System.out.println(formattedDate);
        return formattedDate;

    }

    public static Map<String, String> getCookieAndToken() {
        {
            Map<String, String> data = new HashMap<>();
            String loginId = "cGFydHNhZG1pbg==";
            String password = "S3BhcnRzYWRtaW5AMzIx";
            String code = "MTAwMDAwMDA=";
            String logintype = "RU1QTE9ZRUU=";

            Response response = RestAssured.given()
                    // .baseUri("http://192.168.1.136:5050/ktest-stage/")
                    .baseUri("http://192.168.1.136:7070/ktest/").param("loginId", loginId).param("password", password)
                    .param("companyBranchCode", code).param("loginType", logintype).when().post("onAuthentication")
                    .then().log().all().extract().response();

            // Print response
//            System.out.println("Bearer "+response.header("Authorization"));
//            System.out.println("cookie "+response.header("Set-Cookie"));

            data.put("Token", "Bearer " + response.header("Authorization"));
            data.put("Cookie", "cookie" + response.header("Set-Cookie"));
            token = response.header("Authorization");
            cookie = response.header("Set-Cookie");
            System.out.println(token);
            System.out.println(cookie);
            return data;
        }

    }
}