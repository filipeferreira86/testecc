#language: pt

Funcionalidade: Title of your feature
  I want to use this template for my feature file


  Cenário: Login no mainframe da login incorreto
    Dado estou na tela inicial da LDC
    Quando eu informar "tollel" no campo correspondente a linha 17 e coluna 44
    E informar "tollel" no campo senha
    Então deve logar no sistema exibindo o label "MANO" na linha 0 coluna 1


  Cenário: Login no mainframe da LDC
    Dado estou na tela inicial da LDC
    Quando eu informar "tollel" no campo correspondente a linha 17 e coluna 44
    E informar "tollel" no campo senha
    Então deve logar no sistema exibindo o label "MAIN" na linha 0 coluna 1
