package ifsp.saas.agendamento;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AgendamentoConsultaPage {

    public AgendamentoConsultaPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "consulta-paciente")
    private WebElement selecionarPaciente;

    @FindBy(id = "consulta-medico")
    private WebElement selecionarMedico;

    @FindBy(id = "consulta-data-hora")
    private WebElement selecionarDataHora;

    @FindBy(xpath = "//button[contains(text(), 'Agendar Consulta')]")
    private WebElement btnAgendarConsulta;

    // Métodos públicos para interação

    public void clicarSelecionarPaciente() {
        selecionarPaciente.click();
    }

    public void clicarSelecionarMedico() {
        selecionarMedico.click();
    }

    public void clicarSelecionarDataHora() {
        selecionarDataHora.click();
    }

    public void clicarBotaoAgendarConsulta() {
        btnAgendarConsulta.click();
    }
}
