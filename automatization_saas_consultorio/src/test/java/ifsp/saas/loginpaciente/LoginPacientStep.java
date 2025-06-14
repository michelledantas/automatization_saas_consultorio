package ifsp.saas.loginpaciente;

import ifsp.saas.DriverManager;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
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
}
