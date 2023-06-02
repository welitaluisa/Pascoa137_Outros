package webTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EveclassLogin {
    // Atributos
    private WebDriver driver;
    WebDriverWait wait;

    // Antes do Teste
    @BeforeEach
    public void setup(){
        // WebDriverManager.chromedriver().setup();
        // Declarar o gerenciador para baixar o chrome driver

        WebDriverManager.chromedriver().setup();
        // Configuração especifica a partir do Selenium Webdriver 4.8.1
        ChromeOptions options = new ChromeOptions(); // instancia o chromeoption
        // Add ao chromeOption a permissão de aceitar qualquer origem de acesso remoto
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options); // Instancia o Chrome driver com as opções ( Options)
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofMillis(60000));

        //Declara o Objeto de  espera explicita
        wait = new WebDriverWait(driver, Duration.ofMillis(5000));

    }
    // Depois do Teste
    @AfterEach
    public void tearDown(){
       // driver.quit();
    }

    // Testes
    @Test
    public void testeLogin(){
        driver.get("https://testando.eveclass.com");
        driver.findElement(By.id("support-action")).click();

        // Este é um caso de "Programação Exótica"
        driver.navigate().refresh(); //atualizar a página

        // Mudança de Página - Carregar uma nova página
        // É como um alfinete - ajuda, mas deve ser removido
        // Thread.sleep(5000); // Espere por 5 segundos

        // No lugar do Thread.sleep, devemos usar uma espera explicita
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".auth-header h1")));

        // Preencher os dados de e-mail e senha
        driver.findElement(By.cssSelector("input[type=\"email\"]")).sendKeys(Keys.chord("correia@iterasys.com.br"));
        driver.findElement(By.cssSelector("input[type=\"password\"]")).sendKeys("Teste123");

        // Clicar no botão Entrar
        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();

        // Transição de Tela, pode precisar de um novo wait
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1.overview-group-title overview-group-title_primary")));

        // Clicar nas iniciais do usuário para abrir o menu
        driver.findElement(By.cssSelector("div.user-avatar avatar-initials")).click();
        assertEquals("José Antonio Fernandes Correia", driver.findElement(By.cssSelector("p.infos-text")).getText());
//*[@id="scroll-container"]/div/div/div/div[2]/div[1]/div[1]/h1
    }




}



