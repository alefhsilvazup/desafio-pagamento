## Desafio Implementação de pagamento

Vamos implementar um provedor de serviços de pagamento. A ideia é que a gente receba transações referentes a compras de produtos de lojistas e que, depois, esses lojistas possam realizar seus saques em cima do saldo disponível(recebíveis).

Sobre a implementação
Você vai receber um projeto com uma parte de código pronta responsável por passar os dados necessários para que você consiga implementar um fluxo completo de geração de recebíveis. Ainda neste mesmo projeto você vai encontrar arquivos de testes que testam o código que você vai desenvolver contra cenários diferentes.

Você vai perceber que o retorno esperado pelo método também já pronto.

O seu objetivo é implementar o fluxo complexo para que os retornos esperados aconteçam.

Cada cartão implementado vai habilitar que mais cenários de testes passem.

O ponto de entrada da sua solução é classe Solucao e seu método executa. Todos os testes rodam em cima deste método.

Você não pode mexer em nada que exista no pacote *pronto*.

Sobre a entrada dos dados
O ponto de entrada da sua aplicação vai receber duas listas de Strings com valores separados por virgula.

Para o parâmetro que representa as transações, a String está formatada da seguinte maneira:

```
"valor,metodoPagamento,numeroCartao,nomeCartao,validade,cvv,idTransacao"
```


## Desafio

### Necessidades

1. Caso a transação tenha sido feito com ***cartão de débito***: 
   
   - O recebível deve ser criado com o status `pago` e com o dia de recebimento apontando para o dia da transação (D + 0)
   
   - A taxa de processamento é de `3%`


2. Caso a transação tenha sido feito com ***cartão de crédito*** 
   
    - O recebível deve ser criado com o status `aguardando_pagamento` e com o dia de recebimento apontando para o dia da transação mais 30 dias (D + 30)
    
    - A taxa de processamento é de `5%`


3. O retorno da solução deve ser uma Lista de Arrays, seguindo o padrão:
   
   - Contrato
      - ```status, valorOriginal, valorComTaxa, dataDoPagamento```
     
   - Exemplo de retorno
      - ``` [["pago", "200", "195", "30/04/2021"]] ```