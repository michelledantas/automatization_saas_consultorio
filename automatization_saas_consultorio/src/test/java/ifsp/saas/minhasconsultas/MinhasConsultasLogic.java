package ifsp.saas.minhasconsultas;

import ifsp.saas.loginsecretaria.LoginSecretariaLogic;
import org.openqa.selenium.WebDriver;

public class MinhasConsultasLogic {

  private final LoginSecretariaLogic loginSecretariaLogic;

  public MinhasConsultasLogic(WebDriver driver) {
    this.loginSecretariaLogic = new LoginSecretariaLogic(driver);
  }
}
