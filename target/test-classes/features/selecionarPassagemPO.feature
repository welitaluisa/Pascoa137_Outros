Feature: Selecionar Passagem PO
  Scenario: Selecionar Passagem com Sucesso PO
    Given que acesso o site Blazedemo PO
    When seleciono a origem como "São Paolo" e destino "Berlin" PO
    And clico em Procurar Voo PO
    Then exibe a frase indicando voo entre "São Paolo" e "Berlin" PO