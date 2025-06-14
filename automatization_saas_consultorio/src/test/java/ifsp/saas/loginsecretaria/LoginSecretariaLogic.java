package ifsp.saas.loginsecretaria;

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

  public void inputEmail(){
    loginSecretariaPage.getInputEmail().sendKeys("secretaria@exemplo.com");
  }

  public void inputPassword() {
    loginSecretariaPage.getInputPassword().sendKeys("123");
  }

  public void pressBtnEntrar() {
    loginSecretariaPage.getBtnEntrar().click();
  }
}

