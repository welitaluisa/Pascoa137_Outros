package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class selecionarPassagem {
    @Given("que acesso o site Blazedemo")
    public void que_acesso_o_site_blazedemo() {
        System.out.println(" Passo 1");

    }
    @When("seleciono a origem como {string} e destino {string}")
    public void seleciono_a_origem_como_e_destino(String string, String string2) {
        System.out.println(" Passo 2");

    }
    @And("clico em Procurar Voo")
    public void clico_em_procurar_voo() {
        System.out.println(" Passo 3");

    }
    @Then("exibe a frase indicando voo entre {string} Berlin\"")
    public void exibe_a_frase_indicando_voo_entre_berlin(String string) {
        System.out.println(" Passo 4");

    }
}
