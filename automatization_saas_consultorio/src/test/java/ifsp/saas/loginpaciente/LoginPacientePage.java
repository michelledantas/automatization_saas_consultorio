package ifsp.saas.loginpaciente;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class LoginPacientePage {
  private WebDriver driver;

  public LoginPacientePage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }


  @FindBy(xpath = "/html/body/header/h1")
  private WebElement loginPaciente;

  @FindBy(xpath = "/html/body/footer/p")
  private WebElement copyright;

  @FindBy(id = "patient-login-email")
  private WebElement inputEmail;

  @FindBy(id = "patient-login-password")
  private WebElement inputPassword;

  @FindBy(className = "btn-success")
  private WebElement btnEntrar;

}
