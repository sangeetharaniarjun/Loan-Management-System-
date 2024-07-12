package kivi.lms.testing;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)

public class CustomerControllerTests
{
    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080; // Assuming your application runs on port 8080
    }

    @Test
    public void testGetAllCustomers() {
        given()
                .when()
                .get("/lms/customer")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("size()", greaterThan(0)); // Assuming there should be at least one customer in the database
    }

    @Test
    public void testGetCustomerById() {
        int customerId = 8; // Change the customer ID as per your database data
        given()
                .pathParam("customerid", customerId)
                .when()
                .get("/lms/customer/{customerid}")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("customerid", equalTo(customerId));
    }

    @Test
    public void testCreateCustomer() {
        // Define the request body for creating a new customer
        String requestBody = "{\"customerid\": 55,\"customername\": \"sangeetha\",\"dob\": \"2003-11-29\",\"address\": \"456 RM Avenue, Coimbatore, Tamil Nadu, India\",\"pan\": \"FGHIJ5678K\",\"aadhar\": \"203874695123\",\"voterid\": \"VTR2345678\",\"rationcard\": \"RC2345678901\",\"gender\": \"Female\",\"maritalstatus\": \"Single\",\"fathername\": \"Vikram\",\"mothername\": \"Ananya\",\"totalloans\": 1,\"activeloans\": 1}";

        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/lms/customer")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("customerid", equalTo(55))
                .body("customername", equalTo("sangeetha"))
                .body("dob", equalTo("2003-11-29"))
                .body("address", equalTo("456 RM Avenue, Coimbatore, Tamil Nadu, India"))
                .body("pan", equalTo("FGHIJ5678K"))
                .body("aadhar", equalTo("203874695123"))
                .body("voterid", equalTo("VTR2345678"))
                .body("rationcard", equalTo("RC2345678901"))
                .body("gender", equalTo("Female"))
                .body("maritalstatus", equalTo("Single"))
                .body("fathername", equalTo("Vikram"))
                .body("mothername", equalTo("Ananya"))
                .body("totalloans", equalTo(1))
                .body("activeloans", equalTo(1));
    }

    @Test
    public void testUpdateCustomer() {
        int customerId=55;
        String requestBody = "{\"customerid\": 55,\"customername\": \"passpass\",\"dob\": \"2003-11-29\",\"address\": \"456 RM Avenue, Coimbatore, Tamil Nadu, India\",\"pan\": \"FGHIJ5678K\",\"aadhar\": \"203874695123\",\"voterid\": \"VTR2345678\",\"rationcard\": \"RC2345678901\",\"gender\": \"Female\",\"maritalstatus\": \"Single\",\"fathername\": \"Vikram\",\"mothername\": \"Ananya\",\"totalloans\": 1,\"activeloans\": 1}";
        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/lms/customer")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("customerid", equalTo(55))
                .body("customername", equalTo("passpass"))
                .body("dob", equalTo("2003-11-29"))
                .body("address", equalTo("456 RM Avenue, Coimbatore, Tamil Nadu, India"))
                .body("pan", equalTo("FGHIJ5678K"))
                .body("aadhar", equalTo("203874695123"))
                .body("voterid", equalTo("VTR2345678"))
                .body("rationcard", equalTo("RC2345678901"))
                .body("gender", equalTo("Female"))
                .body("maritalstatus", equalTo("Single"))
                .body("fathername", equalTo("Vikram"))
                .body("mothername", equalTo("Ananya"))
                .body("totalloans", equalTo(1))
                .body("activeloans", equalTo(1));
    }

    @Test
    public void testDeleteCustomer() {
        int customerId =55; // Change the customer ID as per your database data
        given()
                .pathParam("customerid", customerId)
                .when()
                .delete("/lms/customer/{customerid}")
                .then()
                .statusCode(200); // Assuming successful deletion returns 204 status code
    }
}