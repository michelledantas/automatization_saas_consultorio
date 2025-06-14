package ifsp.saas.home;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Getter
public class HomePage {
  @FindBy(xpath = "/html/body/main/div/h1")
  private WebElement bemVindo;

  @FindBy(xpath = "/html/body/main/div/p/text()")
  private WebElement agende_suas_consultas;

  @FindBy(className = "btn-primary")
  private WebElement btnAcessoSecretaria;

  @FindBy(className = "btn-success")
  private WebElement btnAcessoPaciente;

  private WebDriver driver;

  public HomePage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public void waitForElement(WebElement element) {
    new WebDriverWait(driver, Duration.ofSeconds(10))
        .until(ExpectedConditions.visibilityOf(element));
  }
}
