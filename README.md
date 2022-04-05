# 1- Análise

## Requisitos:
- Consultar a lista de pedidos a serem entregues;
- Registrar a entrega de um pedido;
- Enviar um e-mail para o cliente quando o pedido for entregue.

## Fronteira da Análise:
- O entregador consulta a lista de pedidos a serem entregues;
- O entregador registra a entrega de um pedido;
- O sistema acessa o servidor de e-mails.

## Partes Envolvidas:
- O cliente;
- A loja;
- O entregador.

## Partes afetadas da corporação:
- Vendas;
- Logística.
## Diagrama de Caso de uso:
<figure><img src=img/useCase.png>
  <figcaption>Figura 1: Caso de uso de pagamento.
</figcaption>
</figure>

## Modelo de Processo de Negócio
<figure><img src=img/businessProcess.png></img>
  <figcaption>Figura 2: Caso de uso de pagamento.
</figcaption>
</figure>

## Criar os serviços candidatos e agrupá-los em contextos lógicos.
- Pedido:
  - Buscar e apresentar pedidos
- Entrega:
  - Processar pendência de entrega
  - Identificar registro de entrega
  - Registrar a validação da entrega
  - Gerar email de notificação
- Mensageiro:
  - Enviar email pro cliente notificando a entrega (legado)

## Aplicar os princípios de orientação a serviços e identificar sua composição
- Pedido: _(Classe Java)_
  - Buscar pedidos _(Método)_
- Entrega: _(Classe Java)_
  - Processar pendência _(Método)_
  - Registrar pendência _(Método)_
- Email: _(Classe Java)_
  - Gerar email _(Método)_
  - Enviar boleto pro cliente notificando a entrega _(Método)_
