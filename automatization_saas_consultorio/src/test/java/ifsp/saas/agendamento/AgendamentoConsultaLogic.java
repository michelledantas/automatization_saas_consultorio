package ifsp.saas.agendamento;

//secretaria@exemplo.com
//senha secretaria: 123
import ifsp.saas.DriverManager;
import ifsp.saas.agendamento.AgendamentoConsultaPage;

import org.openqa.selenium.WebDriver;

public class AgendamentoConsultaLogic {

    private final AgendamentoConsultaPage page;

    public AgendamentoConsultaLogic(WebDriver driver) {
        this.page = new AgendamentoConsultaPage(driver);
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