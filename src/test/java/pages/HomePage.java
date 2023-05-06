package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends Base {

    // Construtor
    public HomePage(WebDriver driver){
        super(driver);
    }

    // Mapeamento dos Elementos
    // Seletor de Local (Origem ou Destino)
    public By byLocal(String local){
        return By.cssSelector("option[value=\"" + local + "\"]");
    }

    // Botão de Procurar Voo
    public By byBtnFindFlights = By.cssSelector("input[value]");

    // Ações
    // Seleção da Origem e do Destino
    public void selecionarOrigemDestino(String byOrigem, String byDestino){
        this.driver.findElement(byLocal(byOrigem)).click();
        this.driver.findElement(byLocal(byDestino)).click();
    }
    // Clicar no botão Find Flights
    public void clicarBtnProcurarVoo(){
        this.driver.findElement(byBtnFindFlights).click();
    }
}