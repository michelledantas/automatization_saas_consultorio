@home
Feature: Navigation Home Saas

  @home_secretaria
  Scenario: Navegar para login de acesso a secretaria
    Given que o usuário esteja na página home
    When clicar no botão Acesso a secretaria
    Then deve vizualizar a tela de login da Secretaria

  @home_paciente
  Scenario: Navegar para login de acesso ao paciente
    Given que o usuário esteja na página home
    When clicar no botão Acesso ao paciente
    Then deve vizualizar a tela de login do Paciente
