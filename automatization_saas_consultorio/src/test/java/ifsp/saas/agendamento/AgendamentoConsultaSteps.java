package ifsp.saas.agendamento;

import ifsp.saas.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.*;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AgendamentoConsultaSteps {

    private AgendamentoConsultaLogic agendamentoConsultaLogic;
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = DriverManager.getDriver();
        agendamentoConsultaLogic = new AgendamentoConsultaLogic(driver);
    }

    @After
    public void tearDown() {
        DriverManager.quitDriver();
    }

    @Dado("que o usuário está logado no sistema")
    public void que_o_usuário_está_logado_no_sistema() {
        agendamentoConsultaLogic.acessarTelaDeAgendamentoComLogin();
        agendamentoConsultaLogic.acessarTelaAgendamento();
    }

    @Quando("o usuário seleciona a opção de agendar consulta")
    public void o_usuário_seleciona_a_opção_de_agendar_consulta() {
        agendamentoConsultaLogic.acessarTelaAgendamento();
    }

    @Quando("preenche os dados do paciente")
    public void preenche_os_dados_do_paciente() {
        agendamentoConsultaLogic.preencherDadosPaciente();
    }

    @Quando("escolhe o médico e a data da consulta")
    public void escolhe_o_médico_e_a_data_da_consulta() {
        agendamentoConsultaLogic.preencherMedicoEData();
    }

    @Quando("confirma o agendamento")
    public void confirma_o_agendamento() {
        agendamentoConsultaLogic.confirmarAgendamento();
    }

    @Então("o sistema deve exibir uma mensagem de sucesso")
    public void o_sistema_deve_exibir_uma_mensagem_de_sucesso() {
        assertTrue(agendamentoConsultaLogic.mensagemDeSucessoExibida(), "A mensagem de sucesso não foi exibida");
    }

    @Quando("o usuário tenta agendar uma consulta com dados inválidos")
    public void o_usuário_tenta_agendar_uma_consulta_com_dados_inválidos() {
        agendamentoConsultaLogic.tentarAgendarComDadosInvalidos();
    }

    @Então("o sistema deve exibir uma mensagem de erro informando os campos obrigatórios")
    public void o_sistema_deve_exibir_uma_mensagem_de_erro_informando_os_campos_obrigatórios() {
        assertTrue(agendamentoConsultaLogic.mensagemDeErroExibida(), "A mensagem de erro não foi exibida");
    }

    @Quando("o usuário verifica a disponibilidade do médico para a data selecionada")
    public void o_usuário_verifica_a_disponibilidade_do_médico_para_a_data_selecionada() {
        // Essa verificação pode ser feita após selecionar data
        agendamentoConsultaLogic.preencherMedicoEData();
    }

    @Então("o sistema deve informar se o médico está disponível ou não")
    public void o_sistema_deve_informar_se_o_médico_está_disponível_ou_não() {
        assertTrue(agendamentoConsultaLogic.medicoEstaDisponivel(), "O sistema não informou a disponibilidade do médico");
    }
}
