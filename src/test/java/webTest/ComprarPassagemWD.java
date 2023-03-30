//0 - Pacote
package webTest;

//1 - Bibliotecs

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Classes
public class ComprarPassagemWD { // Inicio da Classe

    // 2.1 Atributos
    private WebDriver driver; // Declaramos o objeto do Selenium WebDriver


    // 2.2 Funções e Metodos

    // Antes do teste
    @BeforeEach
    public void setUp() { // inicio do before

        // Declarar o gerenciador para baixar o chrome driver

        WebDriverManager.chromedriver().setup();
        // Configuração especifica a partir do Selenium Webdriver 4.8.1
        ChromeOptions options = new ChromeOptions(); // instancia o chromeoption
        // Add ao chromeOption a permissão de aceitar qualquer origem de acesso remoto
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options); // Instancia o Chrome driver com as opções ( Options)
        driver.manage().window().maximize();



    } // fim do before

    // Depois do Teste

    @AfterEach
    public void tearDown() { // Inicio do After
        driver.quit(); // Destroi a instancia do Selenium WebDriver

    }// fim do driver

    // o teste
    @Test
    public void comprarPassagemWD(){ // Inicio da classe do teste
        driver.get("https://blazedemo.com/"); // Abre o endereço alvo
        driver.findElement(By.name("fromPort")).click(); // Selecionar a lista de cidade de origem
        // Selecionar a cidade na lista
        { // Inicio da seleção dentro da lista
            WebElement lista = driver.findElement(By.name("fromPort"));
            lista.findElement(By.xpath("//option[@value='São Paolo']")).click();

        } // Fim da seleção dentro da lista

        driver.findElement(By.name("toPort")).click(); // Selecionar a lista de cidade de origem
        // Selecionar a cidade na lista
        { // Inicio da seleção dentro da lista
            WebElement lista = driver.findElement(By.name("toPort"));
            lista.findElement(By.xpath("//option[@value='Berlin']")).click();

        } // Fim da seleção dentro da lista

        // Apertar o botão Find Flights

        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();

        // validar a frase que indica que o vôo é de São Paolo para Berlin
        assertEquals("Flights from São Paolo to Berlin:",driver.findElement(By.cssSelector("h3")).getText());

    } // Fim da classe teste

    // fim do teste




} // fim da classe
