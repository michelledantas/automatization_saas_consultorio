package ifsp.saas.loginsecretaria;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

  @FindBy(className = "btn-primary")
  private WebElement btnEntrar;

}
