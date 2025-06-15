package ifsp.saas.painelsecretaria;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Getter
public class PainelSecretariaPage {
  private WebDriver driver;

  public PainelSecretariaPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  @FindBy(xpath = "/html/body/header/h1")
  private WebElement painelDaSecretaria;

  @FindBy(id = "paciente-nome")
  private WebElement inputPacientName;

  @FindBy(id = "error-paciente-nome")
  private WebElement errorPacienteNome;

  @FindBy(id = "paciente-data-nascimento")
  private WebElement inputPacienteDataNascimento;

  @FindBy(id = "error-paciente-data-nascimento")
  private WebElement errorPacienteDataNascimento;

  @FindBy(id = "paciente-telefone")
  private WebElement inputPacienteTelefone;

  @FindBy(id = "error-paciente-telefone")
  private WebElement errorPacienteTelefone;

  @FindBy(id = "paciente-email")
  private WebElement inputPacienteEmail;

  @FindBy(id = "paciente-senha")
  private WebElement inputPacienteSenha;

  @FindBy(id = "error-paciente-senha")
  private WebElement errorPacienteSenha;

  @FindBy(xpath = "//*[@id=\"form-paciente\"]/button")
  private WebElement btnCadastrarPaciente;

  @FindBy(xpath = "*[@id=\"form-medico\"]/button")
  private WebElement btnCadastrarMedico;

  @FindBy(id = "consulta-paciente")
  private WebElement selectPaciente;

  @FindBy(id = "medico-nome")
  private WebElement inputMedicoNome;

    @FindBy(id = "error-medico-nome")
  private WebElement errorMedicoNome;

  @FindBy(id = "medico-especialidade")
  private WebElement inputMedicoEspecialidade;

  @FindBy(id = "error-medico-especialidade")
  private WebElement errorMedicoEspecialidade;

  @FindBy(id = "medico-crm")
  private WebElement inputMedicoCrm;

  @FindBy(id = "error-medico-crm")
  private WebElement errorMedicoCrm;

  @FindBy(id = "consulta-medico")
  private WebElement selectMedico;

  @FindBy(id = "consulta-data-hora")
  private WebElement inputConsultaDataEHora;

  @FindBy(id = "error-consulta-data-hora")
  private WebElement errorConsultaDataEHora;

  @FindBy(xpath = "*[@id=\"form-consulta\"]/button")
  private WebElement btnCadastrarAgendarConsulta;

  @FindBy(id = "consultas-agendadas-lista")
  private WebElement consultasAgendadasLista;

  public void waitForElement(WebElement element) {
    new WebDriverWait(driver, Duration.ofSeconds(10))
        .until(ExpectedConditions.visibilityOf(element));
  }
}
