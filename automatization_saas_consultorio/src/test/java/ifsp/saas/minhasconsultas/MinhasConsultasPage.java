package ifsp.saas.minhasconsultas;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Getter
public class MinhasConsultasPage {
  private WebDriver driver;

  public MinhasConsultasPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  @FindBy(xpath = "/html/body/header/h1")
  private WebElement minhasConsultas;

  @FindBy(className = "patient-welcome")
  private WebElement patientWelcome;

  @FindBy(id = "lista-minhas-consultas")
  private WebElement listaMinhasConsultas;

  @FindBy(id = "historico-consultas-paciente")
  private WebElement historicoConsultasPaciente;


}
