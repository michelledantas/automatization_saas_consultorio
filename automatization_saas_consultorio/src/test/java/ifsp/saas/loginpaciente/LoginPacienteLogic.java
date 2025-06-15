package ifsp.saas.loginpaciente;

import ifsp.saas.home.HomeStep;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginPacienteLogic {

  private static final String LOGIN_PACIENTE = "Login do Paciente";
  private static final Logger log = LoggerFactory.getLogger(HomeStep.class);

  private WebDriver driver;

  private final LoginPacientePage loginPacientePage;

  public LoginPacienteLogic(WebDriver driver) {
    this.loginPacientePage = new LoginPacientePage(driver);
  }

  public void verifyIfIsPageLoginPaciente() {
    log.info("Verificando se está na página Login do Paciente");
    assertThat(loginPacientePage.getLoginPaciente().getText()).isEqualTo(LOGIN_PACIENTE);
  }

  public void pressVoltarParaPaginaInicial() {
    loginPacientePage.getVoltarParaPaginaInicial().click();
  }
}

