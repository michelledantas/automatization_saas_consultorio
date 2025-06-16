@agendamento_consulta
Feature: Agendamento de Consulta

  Background:
    Given que o usuário está logado no sistema

  Scenario: Agendar uma consulta com sucesso
    When o usuário seleciona a opção de agendar consulta
    And preenche os dados do paciente
    And escolhe o médico e a data da consulta
    And confirma o agendamento
    Then o sistema deve exibir uma mensagem de sucesso

  Scenario: Agendar consulta com dados inválidos
    When o usuário tenta agendar uma consulta com dados inválidos
    Then o sistema deve exibir uma mensagem de erro informando os campos obrigatórios

  Scenario: Verificar disponibilidade do médico
    When o usuário verifica a disponibilidade do médico para a data selecionada
    Then o sistema deve informar se o médico está disponível ou não