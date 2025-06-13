package ifsp.saas.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
  private WebDriver driver;

  @FindBy(className = "landing-container")
  private WebElement bemVindo;

  @FindBy(xpath = "/html/body/main/div/p/text()")
  private WebElement agende_suas_consultas;

  @FindBy(className = "btn btn-primary")
  private WebElement btnAcessoSecretaria;

  @FindBy(className = "btn btn-success")
  private WebElement btnAcessoPaciente;

  public HomePage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public void clicarAcessoSecretaria() {
    btnAcessoSecretaria.click();
  }

  public void clicarAcessoPaciente() {
    btnAcessoPaciente.click();
  }
}
