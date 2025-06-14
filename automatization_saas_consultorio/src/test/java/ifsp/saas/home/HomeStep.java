package ifsp.saas.home;
import ifsp.saas.DriverManager;
import ifsp.saas.loginpaciente.LoginPacienteLogic;
import ifsp.saas.loginsecretaria.LoginSecretariaLogic;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomeStep {

  private static final Logger log = LoggerFactory.getLogger(HomeStep.class);

  private HomeLogic loginLogic;
  private LoginSecretariaLogic loginSecretariaLogic;
  private LoginPacienteLogic loginPacienteLogic;


  @Before
  public void setUp() {
    WebDriver driver = DriverManager.getDriver();
    loginSecretariaLogic = new LoginSecretariaLogic(driver);
    loginPacienteLogic = new LoginPacienteLogic(driver);
    loginLogic = new HomeLogic(driver);
  }

  @AfterAll
  public static void tearDown() {
    DriverManager.quitDriver();
  }

  @Given("que o usuário esteja na página home")
  public void queOUsuárioEstejaNaPáginaHome() {
    WebDriver driver = DriverManager.getDriver();
    driver.get("https://brenoaissa.github.io/SaaSConsultorioTC1/index.html");
    loginLogic.verifyIfIsInHomePage();
  }

  @When("clicar no botão Acesso a secretaria")
  public void clicarNoBotãoAcessoASecretaria() {
    loginLogic.pressToSecretariaButton();
  }

  @When("clicar no botão Acesso ao paciente")
  public void clicarNoBotãoAcessoAoPaciente() {
    loginLogic.pressToPacientButton();
  }

  @Then("deve visualizar a tela de login da Secretaria")
  public void deveVisualizarATelaDeLoginDaSecretaria() {
    loginSecretariaLogic.verifyIfIsPageLoginSecretaria();
  }

  @Then("deve visualizar a mensagem email ou senha inválidos")
  public void deveVisualizarAMensagemEmailOuSenhaInvalidos() {
    loginSecretariaLogic.verifyIfErrorMessageApear();
  }

  @Then("deve visualizar a tela de login do Paciente")
  public void deveVisualizarATelaDeLoginDoPaciente() {
    loginPacienteLogic.verifyIfIsPageLoginPaciente();
  }
}
