package ifsp.saas.consultasAgendadas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ConsultasAgendadasPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public ConsultasAgendadasPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @FindBy(id = "lista-consultas")
    private WebElement listaConsultas;

    @FindBy(id = "consultas-agendadas-lista")
    private WebElement historicoConsultasPaciente;

    @FindBy(xpath = "//*[@id='consultas-agendadas-lista']/li/button")
    private List<WebElement> botoesCancelarConsulta;


    public boolean haConsultasAgendadas() {
        wait.until(ExpectedConditions.visibilityOf(historicoConsultasPaciente));
        return !botoesCancelarConsulta.isEmpty();
    }

    public void cancelarPrimeiraConsulta() {
        if (haConsultasAgendadas()) {
            WebElement botao = botoesCancelarConsulta.get(0);
            wait.until(ExpectedConditions.elementToBeClickable(botao));
            botao.click();
        } else {
            System.out.println("Nenhuma consulta para cancelar.");
        }
    }


}
