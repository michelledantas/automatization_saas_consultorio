package ifsp.saas.loginsecretaria;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginSecretariaLogic {

  private static final String LOGIN_SECRETARIA = "Login da Secretária";
  private static final String ERROR_LOGIN_SECRETARY = "Email ou senha inválidos.";

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

  public void inputPasswordInvalid() {
    loginSecretariaPage.getInputPassword().sendKeys("1234");
  }

  public void verifyIfErrorMessageApear() {
    loginSecretariaPage.waitForElement(loginSecretariaPage.getErrorLogin());
    assertThat(loginSecretariaPage.getErrorLogin().getText()).isEqualTo(ERROR_LOGIN_SECRETARY);
  }
}

