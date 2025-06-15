package ifsp.saas.loginpaciente;

import ifsp.saas.DriverManager;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class LoginPacientStep {

  private LoginPacienteLogic loginPacienteLogic;

  @Before
  public void setUp() {
    WebDriver driver = DriverManager.getDriver();
    loginPacienteLogic = new LoginPacienteLogic(driver);
  }

  @AfterAll
  public static void tearDown() {
    DriverManager.quitDriver();
  }

  @Given("que o usuário esteja na página de login do paciente")
  public void queOUsuárioEstejaNaPaginaDeLoginDoPaciente() {
    WebDriver driver = DriverManager.getDriver();
    driver.get("https://brenoaissa.github.io/SaaSConsultorioTC1/login-patient.html");
    loginPacienteLogic.verifyIfIsPageLoginPaciente();
  }

  @When("clicar em voltar para a página inicial")
  public void clicarEmVoltarParaAPaginaInicial() throws InterruptedException {
    Thread.sleep(2000);
    loginPacienteLogic.pressVoltarParaPaginaInicial();

  }
}
