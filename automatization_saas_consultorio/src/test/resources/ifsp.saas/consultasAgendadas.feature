@consultasAgendadas
  Feature: Consultas Agendadas menu Secretaria

    Background:
      Given que o usuário está logado no sistema
      And o usuário é do tipo "Secretaria"

    Scenario: Verificar se o menu Consultas Agendadas está visível
      When o usuário acessa o menu Consultas Agendadas
      Then o sistema deve exibir a lista de consultas agendadas

    Scenario: Verificar detalhes de uma consulta agendada
      When o usuário seleciona uma consulta agendada
      Then o sistema deve exibir os detalhes da consulta selecionada

    Scenario: Cancelar uma consulta agendada
      When o usuário cancela uma consulta agendada
      Then o sistema deve exibir uma mensagem de confirmação de cancelamento
