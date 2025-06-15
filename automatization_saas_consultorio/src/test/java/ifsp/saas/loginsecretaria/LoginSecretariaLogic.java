package ifsp.saas.loginsecretaria;

import ifsp.saas.home.HomeStep;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginSecretariaLogic {

  private static final String LOGIN_SECRETARIA = "Login da Secretária";
  private static final String ERROR_LOGIN_SECRETARY = "Email ou senha inválidos.";
  private static final Logger log = LoggerFactory.getLogger(HomeStep.class);


  private final LoginSecretariaPage loginSecretariaPage;

  public LoginSecretariaLogic(WebDriver driver) {
    this.loginSecretariaPage = new LoginSecretariaPage(driver);
  }

  public void verifyIfIsPageLoginSecretaria() {
    log.info("Verificando se está na página Login da Secretária");
    assertThat(loginSecretariaPage.getLoginSecretaria().getText()).isEqualTo(LOGIN_SECRETARIA);
  }

  public void inputEmail(){
    log.info("Inserindo o email");
    loginSecretariaPage.getInputEmail().sendKeys("secretaria@exemplo.com");
  }

  public void inputPassword() {
    log.info("Inserindo a senha válida");
    loginSecretariaPage.getInputPassword().sendKeys("123");
  }

  public void pressBtnEntrar() {
    log.info("Clicando no botão Entrar");
    loginSecretariaPage.getBtnEntrar().click();
  }

  public void inputPasswordInvalid() {
    log.info("Inserindo uma senha inválida");
    loginSecretariaPage.getInputPassword().sendKeys("1234");
  }

  public void verifyIfErrorMessageApear() {
    log.info("Verificando se irá aparecer a mensagem: Email ou senha inválidos.");
    loginSecretariaPage.waitForElement(loginSecretariaPage.getErrorLogin());
    assertThat(loginSecretariaPage.getErrorLogin().getText()).isEqualTo(ERROR_LOGIN_SECRETARY);
  }

  public void pressVoltarParaPaginaInicial() {
    log.info("Clicando em Voltar para a página inicial");
    loginSecretariaPage.getVoltarParaAPaginaInicial().click();
  }
}

