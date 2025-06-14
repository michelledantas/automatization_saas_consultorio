package ifsp.saas.loginsecretaria;

import ifsp.saas.home.HomeStep;
import ifsp.saas.painelsecretaria.PainelSecretariaLogic;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginSecretariaStep {

  private static final Logger log = LoggerFactory.getLogger(HomeStep.class);
  private static WebDriver driver;
  private LoginSecretariaLogic loginSecretariaLogic;
  private PainelSecretariaLogic painelSecretariaLogic;

  @Before
  public void setUp() {
    driver = new ChromeDriver();
    driver.get("https://brenoaissa.github.io/SaaSConsultorioTC1/login-secretary.html");
    loginSecretariaLogic = new LoginSecretariaLogic(driver);
    painelSecretariaLogic = new PainelSecretariaLogic(driver);
  }

  @AfterAll
  public static void tearDown() {
    if (driver != null) {
      driver.quit();
    }
  }

  @Given("que o usuário esteja na página de login da secretária")
  public void queOUsuarioEstejaNaPaginaDeLoginDaSecretaria() {
    loginSecretariaLogic.verifyIfIsPageLoginSecretaria();
  }

  @When("preencher o email")
  public void preencherOEmail() {
    loginSecretariaLogic.inputEmail();
  }

  @And("preencher a senha")
  public void preencherASenha() {
    loginSecretariaLogic.inputPassword();
  }

  @And("clicar no botão entrar")
  public void clicarNoBotãoEntrar() {
    loginSecretariaLogic.pressBtnEntrar();
  }

  @Then("deve visualizar a tela painel da secretária")
  public void deveVisualizarATelaPainelDaSecretaria() {
    painelSecretariaLogic.verifyIfIsPagePainelSecretaria();
  }
}
