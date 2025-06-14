package ifsp.saas.painelsecretaria;

import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class PainelSecretariaLogic {

  private static final String PAINEL_SECRETARIA = "Painel da Secretária";
  private final PainelSecretariaPage painelSecretariaPage;

  public PainelSecretariaLogic(WebDriver driver) {
    this.painelSecretariaPage = new PainelSecretariaPage(driver);
  }

  public void verifyIfIsPagePainelSecretaria() {
    assertThat(painelSecretariaPage.getPainelDaSecretaria().getText()).isEqualTo(PAINEL_SECRETARIA);
  }
}
