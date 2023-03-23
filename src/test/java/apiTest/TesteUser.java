// nome do pacote
package apiTest;

// Bibliotecas


// Clasees

import com.google.gson.Gson;
import io.restassured.response.Response;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.UserPrincipal;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

//@FixMethodOrder(MethodSorters.NAME_ASCENDING)

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TesteUser {
    // Atributos
    static String ct = "application/json";   // content type
    static String uriUser = "https://petstore.swagger.io/v2/user/";



    // Funções e Métodos

    // Funçoes de apoio


    public static String lerArquivoJson(String arquivoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(arquivoJson)));
    }
    @Test
    @Order(1)
    public void testarIncluirUser() throws IOException {
        // carregar oa dados do nosso json

        String jsonBody = lerArquivoJson("src/test/resources/json/user1.json");
       String userId = "1370388645";

        // realizar o teste
        given()                                          // Dado que
                .contentType(ct)                         // o tipo de conteudo
                .log().all()                            // mostre tudo
                .body(jsonBody)                         // corpo da requisição
        .when()
                .post(uriUser) // Endpoint / onde

        .then()                                                 // |Então
                .log().all()                                    // mostre tudo na volta
                .statusCode(200)                             // comunicação ida volta ok
                .body("code", is(200))                // tag code é 200
                .body("type", is("unknown"))          // tag type é " unKnown"
                .body("message", is(userId))              // message é o userId
        ;


    }// fim do post

    @Test
    @Order(2)

    public void testarConsultarUser() { // inicio do get
        String username = "Luluzinha";

        // resultado esperado
        int userId = 1370388645; // codigo do usuário
        String email = "lulu_fofa@testegmail.com";
        String senha = "lulu123";
        String telefone = "51999999999";
        given()
                .contentType(ct)
                .log().all()
        .when()
                .get(uriUser + username)
        .then()
                .log().all()
                .statusCode(200)
                .body("id", is(userId))
                .body("email", is(email))
                .body("password", is(senha))
                .body("phone", is(telefone))
        ;

    } // fim do get
 @Test
 @Order(3)
    public  void testarAlterarUser() throws IOException { //Inicio do Put User

     String jsonBody = lerArquivoJson("src/test/resources/json/user2.json");
     String userId = "1370388645";
     String username = "Luluzinha";

     given()
             .contentType(ct)
             .log().all()
             .body(jsonBody)
     .when()
             .put(uriUser + username)
     .then()
             .log().all()
             .statusCode(    200)
             .body("code", is(200))
             .body("type", is("unknown"))
             .body("message", is(userId))
     ;
    } // fim do Put User

    @Test
    @Order(5)
    public void testarDeletarUser(){ // Inicio do delete user

        String username = "Luluzinha";

        // resultado esperado
        int userId = 1370388645; // codigo do usuário


        given()
                .contentType(ct)
                .log().all()
        .when()
                .delete(uriUser + username)
        .then()
                .log().all()
                .statusCode(200)
                .body("code", is(200))                // tag code é 200
                .body("type", is("unknown"))          // tag type é " unKnown"
                .body("message", is(username))              // message é o username
        ;



    } // fim do delete user
    @Test
    @Order(4)
    public void testarLogin() {
        String userName = "Luluzinha";
        String password = "lulu123";

       Response response = (Response) given()
                    .contentType(ct)
                    .log().all()

        .when()
                .get(uriUser + "login?username=" + userName +" &password=" + password)
        .then()
               .log().all()
                    .statusCode(200)
                    .body("code", is(200))
                    .body("type", is("unknown"))
                    .body("message", containsString("logged in user session:"))
                    .body("message", hasLength(36))
        .extract();

       // Extração do token da resposta

        String token = response.jsonPath().getString("message").substring(23);
        System.out.println("Conteudo do token:" + token);

    }

    @Order(6)
    @ParameterizedTest
    @CsvFileSource(resources = "csv/massaUser.csv", numLinesToSkip = 1, delimiter = ',')

    public void testarIncluirUserCSV(
            String id,
            String username,
            String firstName,
            String lastName,
            String email,
            String password,
            String phone,
            String userStatus)
    {

         // carregar oa dados do nosso json

        /*

        StringBuilder jsonBody = new StringBuilder( "{");
        jsonBody.append( "'id':" + id + ", ");
        jsonBody.append( "'username':" + username + ", ");
        jsonBody.append( "'firstName':" + firstName + ", ");
        jsonBody.append( "'lastName':" + lastName + ", ");
        jsonBody.append( "'email':" + email + ", ");
        jsonBody.append( "'password':" + password + ", ");
        jsonBody.append( "'phone':" + phone + ", ");
        jsonBody.append( "'userStatus':" + userStatus);
        jsonBody.append( "}");
        */

       User user =new User(); // instancia a classe User

        user.id = id;
        user.username = username;
        user.firstName = firstName;
        user.lastName = lastName;
        user.email = email;
        user.password = password;
        user.phone = phone;
        user.userStatus = userStatus;

        Gson gson = new Gson(); // Instancia a classe Gson
        String jsonBody = gson.toJson(user);




            // realizar o teste
        given()                                          // Dado que
                    .contentType(ct)                         // o tipo de conteudo
                    .log().all()                            // mostre tudo
                    .body(jsonBody)                         // corpo da requisição
        .when()
                    .post(uriUser) // Endpoint / onde

        .then()                                                 // |Então
                    .log().all()                                    // mostre tudo na volta
                    .statusCode(200)                             // comunicação ida volta ok
                    .body("code", is(200))                // tag code é 200
                    .body("type", is("unknown"))          // tag type é " unKnown"
                    .body("message", is(id))              // message é o userId
        ;


        }// fim incluir csv





}// fim da classe