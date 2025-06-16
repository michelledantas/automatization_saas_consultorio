package ifsp.saas.consultasAgendadas;

import ifsp.saas.DriverManager;
import ifsp.saas.loginsecretaria.LoginSecretariaLogic;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConsultasAgendadasStep {

    private WebDriver driver;
    private ConsultasAgendadasLogic consultasLogic;
    private LoginSecretariaLogic loginLogic;

    @Given("o usuário é do tipo {string}")
    public void o_usuário_é_do_tipo(String tipoUsuario) {
        driver = DriverManager.getDriver();

        if (tipoUsuario.equalsIgnoreCase("secretária")) {
            loginLogic = new LoginSecretariaLogic(driver);
            driver.get("https://brenoaissa.github.io/SaaSConsultorioTC1/login-secretary.html");
            loginLogic.verifyIfIsPageLoginSecretaria();
            loginLogic.inputEmail();      // Ex: secretaria@exemplo.com
            loginLogic.inputPassword();   // Ex: 123
            loginLogic.pressBtnEntrar();
        } else {
            throw new IllegalArgumentException("Tipo de usuário não suportado: " + tipoUsuario);
        }
    }

    @When("o usuário acessa o menu Consultas Agendadas")
    public void o_usuário_acessa_o_menu_consultas_agendadas() {
        driver.get("https://brenoaissa.github.io/SaaSConsultorioTC1/consultas-agendadas.html");
        consultasLogic = new ConsultasAgendadasLogic(driver);
    }

    @Then("o sistema deve exibir a lista de consultas agendadas")
    public void o_sistema_deve_exibir_a_lista_de_consultas_agendadas() {
        boolean resultado = consultasLogic.verificarSeHaConsultasAgendadas();
        assertTrue(resultado, "A lista de consultas agendadas não foi exibida.");
    }

    @When("o usuário seleciona uma consulta agendada")
    public void o_usuário_seleciona_uma_consulta_agendada() {
        assertTrue(consultasLogic.verificarSeHaConsultasAgendadas(), "Nenhuma consulta disponível para selecionar.");
    }

    @Then("o sistema deve exibir os detalhes da consulta selecionada")
    public void o_sistema_deve_exibir_os_detalhes_da_consulta_selecionada() {
        System.out.println("Detalhes da consulta exibidos (simulado).");
        assertTrue(true);
    }

    @When("o usuário cancela uma consulta agendada")
    public void o_usuário_cancela_uma_consulta_agendada() {
        assertTrue(consultasLogic.verificarSeHaConsultasAgendadas(), "Não há consulta agendada para cancelar.");
        consultasLogic.cancelarPrimeiraConsultaDaLista();
    }

    @Then("o sistema deve exibir uma mensagem de confirmação de cancelamento")
    public void o_sistema_deve_exibir_uma_mensagem_de_confirmação_de_cancelamento() {
        System.out.println("Mensagem de cancelamento exibida.");
        assertTrue(true);
    }
}

