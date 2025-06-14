package ifsp.saas.painelsecretaria;

import ifsp.saas.home.HomeStep;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class PainelSecretariaLogic {

  private static final String PAINEL_SECRETARIA = "Painel da Secretária";
  private static final Logger log = LoggerFactory.getLogger(HomeStep.class);

  private final PainelSecretariaPage painelSecretariaPage;

  public PainelSecretariaLogic(WebDriver driver) {
    this.painelSecretariaPage = new PainelSecretariaPage(driver);
  }

  public void verifyIfIsPagePainelSecretaria() {
    log.info("Verificando se está na página Painel da Secretária");
    assertThat(painelSecretariaPage.getPainelDaSecretaria().getText()).isEqualTo(PAINEL_SECRETARIA);
  }
}
