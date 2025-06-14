package ifsp.saas.home;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class HomeLogic {
  private static final String BEM_VINDO = "Bem-vindo!";
  private static final Logger log = LoggerFactory.getLogger(HomeStep.class);
  private final HomePage homePage;

  public HomeLogic(WebDriver driver) {
    this.homePage = new HomePage(driver);
  }

  public void pressToSecretariaButton() {
    log.info("Clicando no botão Acesso Secretária");
    homePage.getBtnAcessoSecretaria().click();
  }

  public void pressToPacientButton() {
    log.info("Clicando no botão Acesso Paciente");
    homePage.getBtnAcessoPaciente().click();
  }

  public void verifyIfIsInHomePage() {
    log.info("Verificando se está na página home do Sistema de Agendamento de Consultas");
    assertThat(homePage.getBemVindo().getText()).isEqualTo(BEM_VINDO);  }
}
