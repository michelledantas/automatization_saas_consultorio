@painel_secretaria
Feature: Painel Secretaria

  @cadastrar_paciente
  Scenario: Cadastrar Paciente
    Given que o usuário esteja na página de painel da secretária
    When preencher os dados do paciente
    And clicar no botão Cadastrar Paciente
    Then deve visualizar um alerta Paciente cadastrado com sucesso