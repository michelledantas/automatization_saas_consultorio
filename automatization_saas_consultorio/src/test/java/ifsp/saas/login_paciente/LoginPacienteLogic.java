package ifsp.saas.login_paciente;

import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginPacienteLogic {

  private static final String LOGIN_PACIENTE = "Login do Paciente";
  private WebDriver driver;

  private final LoginPacientePage loginPacientePage;

  public LoginPacienteLogic(WebDriver driver) {
    this.loginPacientePage = new LoginPacientePage(driver);
  }

  public void verifyIfIsPageLoginPaciente() {
    assertThat(loginPacientePage.getLoginPaciente().getText()).isEqualTo(LOGIN_PACIENTE);
  }
}

