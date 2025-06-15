@login_paciente
Feature: Login Paciente

  @voltar_para_pagina_inicial
  Scenario: Voltar para a página inicial
    Given que o usuário esteja na página de login do paciente
    When clicar em voltar para a página inicial
    Then deve visualizar a pagina inicial

