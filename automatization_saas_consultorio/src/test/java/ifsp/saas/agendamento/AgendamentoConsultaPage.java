package ifsp.saas.agendamento;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDateTime;

public class AgendamentoConsultaPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public AgendamentoConsultaPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @FindBy(id = "consulta-paciente")
    private WebElement clicarDropDownPaciente;

    @FindBy(id = "consulta-medico")
    private WebElement clicarDropDownMedico;

    @FindBy(id = "consulta-data-hora")
    private WebElement selecionarDataHora;

    @FindBy(xpath = "//button[contains(text(), 'Agendar Consulta')]")
    private WebElement btnAgendarConsulta;

    public void clicarSelecionarPaciente() {
        wait.until(ExpectedConditions.elementToBeClickable(clicarDropDownPaciente));
        clicarDropDownPaciente.click();
    }

    public void clicarSelecionarMedico() {
        wait.until(ExpectedConditions.elementToBeClickable(clicarDropDownMedico));
        clicarDropDownMedico.click();
    }

    public void clicarSelecionarDataHora(LocalDateTime dataHora) {
        // Formata a data e hora para o formato esperado pelo campo
        String formattedDateTime = dataHora.toLocalDate() + "T" + dataHora.toLocalTime().toString();
        selecionarDataHora.clear();
        selecionarDataHora.sendKeys(formattedDateTime);
        // Clica no campo para aplicar a data e hora selecionadas
        wait.until(ExpectedConditions.elementToBeClickable(selecionarDataHora));
        selecionarDataHora.click();
    }

    public void clicarBotaoAgendarConsulta() {
        wait.until(ExpectedConditions.elementToBeClickable(btnAgendarConsulta));
        btnAgendarConsulta.click();
    }
}
