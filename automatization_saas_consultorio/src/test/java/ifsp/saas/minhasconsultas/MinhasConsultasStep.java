package ifsp.saas.minhasconsultas;

import ifsp.saas.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class MinhasConsultasStep {

  private MinhasConsultasLogic minhasConsultasLogic;

  @Before
  public void setUp() {
    WebDriver driver = DriverManager.getDriver();
    minhasConsultasLogic = new MinhasConsultasLogic(driver);
  }

  @After
  public void tearDown() {
    DriverManager.quitDriver();
  }
}
