@login_secretaria
Feature: Login Secretaria

  @login
  Scenario: Realizar login da secretária
    Given que o usuário esteja na página de login da secretária
    When preencher os dados de login
    And clicar no botão entrar
    Then deve visualizar a tela painel da secretária

  @login_invalido
  Scenario: Tentar realizar login da secretária com senha inválida
    Given que o usuário esteja na página de login da secretária
    When preencher os dados de login invalido
    And clicar no botão entrar
    Then deve visualizar a mensagem email ou senha inválidos


