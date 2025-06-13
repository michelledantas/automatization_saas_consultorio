package ifsp.saas.home;

import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class HomeLogic {
  public static final String BEM_VINDO = "Bem-vindo!";
  private final HomePage homePage;

  public HomeLogic(WebDriver driver) {
    this.homePage = new HomePage(driver);
  }

  public void pressToSecretariaButton() {
    homePage.getBtnAcessoSecretaria().click();
  }

  public void pressToPacientButton() {
    homePage.getBtnAcessoPaciente().click();
  }

  public void verifyIfIsInHomePage() {
    assertThat(homePage.getBemVindo().getText()).isEqualTo(BEM_VINDO);  }
}
