package ifsp.saas.home;
import ifsp.saas.login_secretaria.LoginSecretariaLogic;
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
  private static WebDriver driver;
  private HomeLogic loginLogic;
  private LoginSecretariaLogic loginSecretariaLogic;


  @Before
  public void setUp() {
    driver = new ChromeDriver();
    driver.get("https://brenoaissa.github.io/SaaSConsultorioTC1/index.html");
    loginLogic = new HomeLogic(driver);
    loginSecretariaLogic = new LoginSecretariaLogic(driver);
  }

  @AfterAll
  public static void tearDown() {
    if (driver != null) {
      driver.quit();
    }
  }

  @Given("que o usuário esteja na página home")
  public void queOUsuárioEstejaNaPáginaHome() {
    loginLogic.verifyIfIsInHomePage();
  }

  @When("clicar no botão Acesso a secretaria")
  public void clicarNoBotãoAcessoASecretaria() {
    loginLogic.pressToSecretariaButton();
  }

  @Then("deve vizualizar a tela de login da Secretaria")
  public void deveVizualizarATelaDeLoginDaSecretaria() {
    loginSecretariaLogic.verifyIfIsPageLoginSecretaria();
  }
}
