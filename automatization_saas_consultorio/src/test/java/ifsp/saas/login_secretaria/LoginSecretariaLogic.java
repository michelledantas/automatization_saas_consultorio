package ifsp.saas.login_secretaria;

import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginSecretariaLogic {

  private static final String LOGIN_SECRETARIA = "Login da Secretária";

  private final LoginSecretariaPage loginSecretariaPage;

  public LoginSecretariaLogic(WebDriver driver) {
    this.loginSecretariaPage = new LoginSecretariaPage(driver);
  }

  public void verifyIfIsPageLoginSecretaria() {
    assertThat(loginSecretariaPage.getLoginSecretaria().getText()).isEqualTo(LOGIN_SECRETARIA);
  }
}

