package ifsp.saas.painelsecretaria;

import ifsp.saas.DriverManager;
import ifsp.saas.home.HomeStep;
import ifsp.saas.loginsecretaria.LoginSecretariaLogic;
import ifsp.saas.utils.Medico;
import ifsp.saas.utils.Paciente;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class PainelSecretariaStep {

  private static final Logger log = LoggerFactory.getLogger(HomeStep.class);
  private static WebDriver driver;
  private PainelSecretariaLogic painelSecretariaLogic;
  private LoginSecretariaLogic loginSecretariaLogic;


  @Before
  public void setUp() {
    driver = DriverManager.getDriver();
    painelSecretariaLogic = new PainelSecretariaLogic(driver);
    loginSecretariaLogic = new LoginSecretariaLogic(driver);
  }
  @After
  public static void tearDown() {
    DriverManager.quitDriver();
  }

  @Given("que o usuário esteja na página de painel da secretária")
  public void queOUsuarioEstejaNaPaginaDePainelDaSecretaria(){
    WebDriver driver = DriverManager.getDriver();
    driver.get("https://brenoaissa.github.io/SaaSConsultorioTC1/login-secretary.html");
    loginSecretariaLogic.verifyIfIsPageLoginSecretaria();
    loginSecretariaLogic.inputEmail();
    loginSecretariaLogic.inputPassword();
    loginSecretariaLogic.pressBtnEntrar();
    painelSecretariaLogic.verifyIfIsPagePainelSecretaria();
  }

  @When("preencher os dados do paciente")
  public void preencherOsDadosDoPaciente() {
    Paciente paciente = Paciente.criarPacienteAleatorio();
    painelSecretariaLogic.inputDadosPaciente(paciente);
  }

  @And("clicar no botão Cadastrar Paciente")
  public void clicarNoBotaoCadastrarPaciente() {
    painelSecretariaLogic.pressBtnCadastrarPaciente();
  }

  @Then("deve visualizar um alerta Paciente cadastrado com sucesso")
  public void deveUmAlertaPacienteCadastradoComSucesso() {
    painelSecretariaLogic.verifyAlertPacienteCadastrado(); //TODO PRECISA VALIDAR O ALERTA
  }

  @When("clicar no botão sair")
  public void clicarNoBotaoSair() {
    painelSecretariaLogic.pressBtnSair();
  }

  @When("preencher os dados do medico")
  public void preencherOsDadosDoMedico() throws InterruptedException {
    Medico medico = Medico.criarMedicoAleatorio();
    painelSecretariaLogic.inputDadosMedico(medico);
  }

  @And("clicar no botão Cadastrar Medico")
  public void clicarNoBotaoCadastrarMedico(){
    painelSecretariaLogic.pressBtnCadastrarMedico();
  }

  @Then("deve visualizar um alerta Medico cadastrado com sucesso")
  public void deveVisualizarUmAlertaMedicoCadastradoComSucesso() {
    Alert alerta = driver.switchTo().alert();
    String textoAlerta = alerta.getText();
    painelSecretariaLogic.deveVisualizarUmAlertaMedicoCadastradoComSucesso(textoAlerta);
  }
}
