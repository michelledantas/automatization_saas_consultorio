Feature: Navigation Home Saas

  Scenario: Navegar para login de acesso a secretaria
    Given que o usuário esteja na página home
    When clicar no botão Acesso a secretaria
    Then deve vizualizar a tela de login da Secretaria
