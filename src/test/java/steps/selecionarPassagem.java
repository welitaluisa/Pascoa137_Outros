package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class selecionarPassagem {
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
       // driver.manage().timeouts().implicitlyWait(Duration.ofMillis(60000));
        driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);

        synchronized (driver) {
            try {
                driver.wait(5000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }



    @After
    public void tearDown(){
      driver.quit();
    }

    @Given("que acesso o site Blazedemo")
    public void que_acesso_o_site_blazedemo() {
        System.out.println("Passo 1");
        driver.get("https://www.blazedemo.com");
    }
    @When("seleciono a origem como {string} e destino {string}")
    public void seleciono_a_origem_como_e_destino(String origem, String destino) {
        System.out.println("Passo 2");
        driver.findElement(By.name("fromPort")).click();
        // selecionar a cidade na lista
        { //inicio da seleção dentro da lista
            WebElement lista = driver.findElement(By.name("fromPort"));
            lista.findElement(By.xpath("//option[. = '" + origem + "']")).click();
        } //fim da seleção dentro da lista

        driver.findElement(By.name("toPort")).click();
        // selecionar a cidade na lista
        { //inicio da seleção dentro da lista
            WebElement lista = driver.findElement(By.name("toPort"));
            lista.findElement(By.xpath("//option[. = '" + destino + "']")).click();
        } //fim da seleção dentro da lista
    }
    @And("clico em Procurar Voo")
    public void clico_em_procurar_voo() {
        System.out.println("Passo 3");
        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
    }
    @Then("exibe a frase indicando voo entre {string} e {string}")
    public void exibe_a_frase_indicando_voo_entre_e(String string, String string2) {
        System.out.println("Passo 4");
        assertEquals("Flights from São Paolo to Berlin:",driver.findElement(By.cssSelector("h3")).getText());
    }
}
