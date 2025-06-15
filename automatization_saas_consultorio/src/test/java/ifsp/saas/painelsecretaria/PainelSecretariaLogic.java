package ifsp.saas.painelsecretaria;

import ifsp.saas.home.HomeStep;
import ifsp.saas.utils.Medico;
import ifsp.saas.utils.Paciente;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

  public void inputDadosPaciente(Paciente paciente) {
    log.info("Preenchendo dados do Paciente");
    painelSecretariaPage.getInputPacientName().sendKeys(paciente.getNome());
    painelSecretariaPage.getInputPacienteDataNascimento().click();
    painelSecretariaPage.getInputPacienteDataNascimento().clear();
    painelSecretariaPage.getInputPacienteDataNascimento().sendKeys(paciente.getDataDeNascimento());
    painelSecretariaPage.getInputPacienteTelefone().sendKeys(paciente.getTelefone());
    painelSecretariaPage.getInputPacienteEmail().sendKeys(paciente.getEmail());
    painelSecretariaPage.getInputPacienteSenha().sendKeys(paciente.getSenha());
  }

  public void pressBtnCadastrarPaciente(){
    log.info("Clicando no botão Cadastrar Paciente");
    painelSecretariaPage.getBtnCadastrarPaciente().click();
  }

  public void verifyAlertPacienteCadastrado() {
    log.info("Verificando se o alerta Paciente Cadastrado com sucesso apareceu");

  }

  public void pressBtnSair() {
    log.info("Clicando no botão Sair");
    painelSecretariaPage.getBtnSair().click();
  }

  public void inputDadosMedico(Medico medico){
    log.info("Preenchendo dados do Médico");
    painelSecretariaPage.getInputMedicoNome().sendKeys(medico.getNome());
    painelSecretariaPage.getInputMedicoEspecialidade().sendKeys(medico.getEspecialidade());
    painelSecretariaPage.getInputMedicoCrm().sendKeys(medico.getCrm());
  }

  public void pressBtnCadastrarMedico(){
    log.info("Clicando no botão Cadastrar Médico");
    painelSecretariaPage.getBtnCadastrarMedico().click();
  }

  public void deveVisualizarUmAlertaMedicoCadastradoComSucesso(String textoAlerta) {
    assertEquals("Médico cadastrado com sucesso!", textoAlerta);
  }
}
