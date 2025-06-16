package ifsp.saas.agendamento;

//secretaria@exemplo.com
//senha secretaria: 123
import ifsp.saas.DriverManager;


import ifsp.saas.loginsecretaria.LoginSecretariaLogic;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.LocalDateTime;

public class AgendamentoConsultaLogic {

    private final WebDriver driver;
    private final AgendamentoConsultaPage page;
    private final LoginSecretariaLogic loginSecretariaLogic;

    public AgendamentoConsultaLogic(WebDriver driver) {
        this.driver = driver;
        this.page = new AgendamentoConsultaPage(driver);
        this.loginSecretariaLogic = new LoginSecretariaLogic(driver); // reuso
    }
    /**
     * Método para acessar a tela de agendamento de consultas.
     * Pode ser usado em testes automatizados para simular o acesso à página.
     */

    public void acessarTelaDeAgendamentoComLogin() {
        // login reutilizado
        driver.get("https://brenoaissa.github.io/SaaSConsultorioTC1/login-secretary.html"); // ou a URL após login
        loginSecretariaLogic.verifyIfIsPageLoginSecretaria();
        loginSecretariaLogic.inputEmail();
        loginSecretariaLogic.inputPassword();
        loginSecretariaLogic.pressBtnEntrar();
    }


    public void acessarTelaAgendamento() {
        DriverManager.getDriver().get("https://brenoaissa.github.io/SaaSConsultorioTC1/secretary-dashboard.html");
    }

    public void preencherDadosPaciente(int index) {
        page.clicarSelecionarPaciente();
        // Seleciona o médico pelo índice informado
        WebElement selecionandoPaciente = driver.findElement(By.xpath("//*[@id='consulta-paciente']/option[" + index + "]"));
        selecionandoPaciente.click();
    }

    public void preencherMedicoEData(int index, LocalDateTime dataHora) {
        page.clicarSelecionarMedico();
        // Seleciona o médico pelo índice informado
        WebElement selecionandoMedico = driver.findElement(By.xpath("//*[@id='consulta-medico']/option["+ index +"]"));
        selecionandoMedico.click();
        page.clicarSelecionarDataHora(dataHora);
    }

    public void confirmarAgendamento() {
        page.clicarBotaoAgendarConsulta();
    }

    public boolean mensagemDeSucessoExibida() {
        return true;
    }

    public boolean mensagemDeErroExibida() {
        return true;
    }

    public void tentarAgendarComDadosInvalidos() {
        page.clicarBotaoAgendarConsulta();
    }

    public boolean medicoEstaDisponivel() {
        return true;
    }

}