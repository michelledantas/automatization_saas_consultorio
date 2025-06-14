package ifsp.saas.painelsecretaria;

import ifsp.saas.DriverManager;
import ifsp.saas.home.HomeStep;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PainelSecretariaStep {

  private static final Logger log = LoggerFactory.getLogger(HomeStep.class);
  private static WebDriver driver;
  private PainelSecretariaLogic painelSecretariaLogic;

  @Before
  public void setUp() {
    WebDriver driver = DriverManager.getDriver();
//    driver.get("https://brenoaissa.github.io/SaaSConsultorioTC1/secretary-dashboard.html");
    painelSecretariaLogic = new PainelSecretariaLogic(driver);
  }
  @After
  public static void tearDown() {
    DriverManager.quitDriver();
  }
}
