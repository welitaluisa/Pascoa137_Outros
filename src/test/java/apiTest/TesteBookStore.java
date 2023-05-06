//Pacote
package apiTest;

// Biblioteca

import com.google.gson.Gson;
import io.restassured.response.Response;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.sql.SQLOutput;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.is;

// Classe
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TesteBookStore {
    //Atributos
    // Uso comun

    Gson gson = new Gson(); // Instancia o Gson - mantem o json

    static String ct = "application/json";
    static String jsonBody;

    // Endpoints
    static String uriAccount = "https://bookstore.toolsqa.com/Account/v1/";

    // Dados da conta / Account
    static String userName = "Luisa1Mendes1";
    static String password = "Senha@93";
    static String userId;
    static String token;

    @Test
    @Order(1)

    public void testeCriarUsuario () {
        //configura

        Account account = new Account(); // Instancia a classe account
        account.userName = userName;
        account.password = password;
        jsonBody = gson.toJson(account);

        // Executa
        Response resp = ( Response)

        given()
                .contentType(ct)
                .log().all()
                .body(jsonBody)
        .when()
                .post(uriAccount + "User")
        .then()
                .log().all()
                .statusCode(201)
               .body("username", is(userName))
                .extract()
        ;
         userId = resp.jsonPath().getString("userID");
        System.out.println("UserID" + userId);
    }

    @Test
    @Order(2)
    public void testarTokenUser() {
        Response resp = (Response) given()
                .contentType(ct)
                .log().all()
                .body(jsonBody)
        .when()
                .post(uriAccount + "GenerateToken")
        .then()
                .log().all()
                .statusCode(200)
              //  .body("username", is(userName))
                .extract()
        ;
        token = resp.jsonPath().getString("token");
        System.out.println("token:" + token);

    }

    @Test
    @Order(66)
    public void testeExcluirUsuario(){ // exclui o usuário e desloga do sistema
        given()
                .contentType(ct)
                .log().all()
                .header("Authorization", "Bearer " + token) // todas as requisiçoes precisa passar esse header
                .when()
                .delete(uriAccount + "user/" + userId)
                .then()
                .statusCode(204)
        ;
    }


    }




