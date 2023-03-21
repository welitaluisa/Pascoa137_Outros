// nome do pacote
package apiTest;

// Bibliotecas


// Clasees

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

//@FixMethodOrder(MethodSorters.NAME_ASCENDING)

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestePet {
    // Atributos
    static String ct = "application/json";   // content type
    static String uriPet = "https://petstore.swagger.io/v2/pet/";


    // Funções e Métodos

    // Funçoes de apoio


    public static String lerArquivoJson(String arquivoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(arquivoJson)));
    }
    @Test
    @Order(1)
    public void testarIncluirPet() throws IOException {
        // carregar oa dados do nosso json

        String jsonBody = lerArquivoJson("src/test/resources/json/pet1.json");


        // realizar o teste
        given()
                .contentType(ct)
                .log().all()
                .body(jsonBody)
        .when()
                .post(uriPet) // Endpoint / onde

        .then()
                .log().all()
                .statusCode(200)
                .body("name", is("Nina"))
                .body("status", is("available"))
                .body("category.name", is("Dog"))


        ;


    }// fim do post
    @Test
    @Order(2)

    public void testarConsultarPet() { // inicio do get
        String petId = "9951830645";
        String name = "Nina";
        String status = "available";


        // resultado esperado


        given()
                .contentType(ct)
                .log().all()

        .when()
                .get(uriPet + petId)
        .then()
                .log().all()
                .statusCode(200)
                .body("category.name", is(("Dog")))
                .body("name", is("Nina"))
                .body("status", is("available"))

        ;

    } // fim do get

    @Test
    @Order(3)
    public void testarAlterarPet() throws IOException {
        String jsonBody = lerArquivoJson("src/test/resources/json/pet2.json");

        given()
                .contentType(ct)
                .log().all()
                .body(jsonBody)
        .when()
                .put(uriPet)
        .then()
                .log().all()
                .statusCode(200)
                .body("name", is("Tutuzinho"))
                .body("category.name", is(("Cat")))
                .body("status",is("unavailable"))
        ;
    }

    @Test
    @Order(4)
    public void testarDeletarPet(){
        String petId = "9951830645";

        given()
                .contentType(ct)
                .log().all()
        .when()
        .delete(uriPet +  petId)
                .then()
                .log().all()
                .statusCode(200)
                .body("code", is(200))
                .body("type", is("unknown"))
                .body("message", is(petId))

        ;
    }

}// fim da classe