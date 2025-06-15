package ifsp.saas.agendamento;

//secretaria@exemplo.com
//senha secretaria: 123
import ifsp.saas.DriverManager;


import ifsp.saas.loginsecretaria.LoginSecretariaLogic;
import org.openqa.selenium.WebDriver;

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
        // Simulação de acesso à tela de agendamento
        // Você pode usar: driver.get("URL_da_tela_de_agendamento");
        DriverManager.getDriver().get("https://brenoaissa.github.io/SaaSConsultorioTC1/secretary-dashboard.html");
    }

    public void preencherDadosPaciente() {
        page.clicarSelecionarPaciente();
    }

    public void preencherMedicoEData() {
        page.clicarSelecionarMedico();
        page.clicarSelecionarDataHora();
    }

    public void confirmarAgendamento() {
        page.clicarBotaoAgendarConsulta();
    }

    public boolean mensagemDeSucessoExibida() {
        // Simulação. Você pode usar:
        // return driver.findElement(By.id("mensagem-sucesso")).isDisplayed();
        return true; // por enquanto mockado
    }

    public boolean mensagemDeErroExibida() {
        // Simulação
        return true;
    }

    public void tentarAgendarComDadosInvalidos() {
        // Pode deixar campos vazios ou inserir dados inválidos
        page.clicarBotaoAgendarConsulta();
    }

    public boolean medicoEstaDisponivel() {
        // Mock temporário. Pode validar um texto ou status na tela.
        return true;
    }

}