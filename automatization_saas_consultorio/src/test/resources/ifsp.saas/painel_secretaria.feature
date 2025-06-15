@painel_secretaria
Feature: Painel Secretaria

  @sair_do_painel
  Scenario: Sair do Painel da Secretaria
    Given que o usuário esteja na página de painel da secretária
    When clicar no botão sair
    Then deve visualizar a tela de login da Secretaria

  @cadastrar_paciente
  Scenario: Cadastrar Paciente
    Given que o usuário esteja na página de painel da secretária
    When preencher os dados do paciente
    And clicar no botão Cadastrar Paciente
    Then deve visualizar um alerta Paciente cadastrado com sucesso