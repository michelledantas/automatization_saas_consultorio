package ifsp.saas.loginsecretaria;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Getter
public class LoginSecretariaPage {
  private WebDriver driver;

  public LoginSecretariaPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }


  @FindBy(xpath = "/html/body/header/h1")
  private WebElement loginSecretaria;

  @FindBy(xpath = "/html/body/footer/p")
  private WebElement copyright;

  @FindBy(id = "secretary-email")
  private WebElement inputEmail;

  @FindBy(id = "secretary-password")
  private WebElement inputPassword;

  @FindBy(xpath = "//*[@id=\"error-login-secretary\"]")
  private WebElement errorLogin;

  @FindBy(xpath = "/html/body/main/div/p/a")
  private WebElement voltarParaAPaginaInicial;

  @FindBy(className = "btn-primary")
  private WebElement btnEntrar;

  public void waitForElement(WebElement element) {
    new WebDriverWait(driver, Duration.ofSeconds(10))
        .until(ExpectedConditions.visibilityOf(element));
  }

}
