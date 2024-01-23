*HyperText Transfer Protocol*
- Protocolo da camada apilcacional.
- Acenta em cima de [[TCP]]
- É um protocolo *stateless*
- Opção mais popular para aplicações WEB

Unform Resource Locator - URL: 
```
http://www.di.uminho.pt/cursos/miei.html
        ^ Host Name ^    ^ Path Name ^     
```


## Funcionamento
- Segue uma arquitetura cliente / servidor:
	- O cliente faz pedidos, aos quais o servidor responde.
- Utiliza o TCP:
	- O cliente cria um socket e inicia uma conexão TCP com um servidor HTTP (por defeito, à escuta na porta 80);
	- O servidor TCP aceita o pedido de conexão do cliente;
	- São trocadas mensagens HTTP
	- A ligação TCP é terminada

### HTTP não persistente

Envia-se um objeto por conexão
Mínimo de 2RTT por objeto
Alguns browsers abrem várias conexões TCP em paralelo para pedirem vários objetos referidos no mesmo objeto.


### HTTP não persistente

Servidor mantém conexão TCP aberta.
Com ou sem estratégia de pipelining.
#### Pipelining
- O cliente envia os pedido assim que os encontra no objeto referenciador.
- No cenário mais otimista é consumido um RTT para o conjunto de todos os objetos referenciados.

#### Sem Pipelining
- O cliente envia um novo pedido apenas quando recebe a resposta ao anterior.
- No cenário mais otimista consome-se um RTT por cada objeto referido
## Formato das mensagens

![[Pasted image 20240104180111.png]]

![[Pasted image 20240104180209.png]]

### Pedidos

O protocolo HTTP serve para implementar uma API que segue o princípio REST,
CRUD: (Create, Read, Update, Delete)

HTTP implementa esta funcionalidade com os métodos básicos:
- [[HTTP#POST|POST]]
- [[HTTP#GET|GET]]
- [[HTTP#PUT|PUT]]
- [[HTTP#DELETE|DELETE]]

![[Pasted image 20240104182103.png]]
##### POST
Tem payload. 
Normalmente usado em formulários
##### GET
Não tem payload
##### PUT
Tem payload
##### DELETE
Não tem payload

### Respostas

![[Pasted image 20240104183615.png]]

Tipos de Resposta
- 200 OK
- 301 Moved permanently, location: xyz
- 304 Not modified
- 400 Bad request (pedido não entendido)
- 401 Authorization required
- 404 Not found (objecto não encontrado)
- 505 HTTP version not supported

## Cookies
Mecanismo usado para manter estado, de modo a poupar recursos e melhorar a experiencia do utilizador.
O browser encarrega-se de guardas os cookies relevantes (client-side)

## Servidores Proxy – Cache
Um servidor que funciona tanto como servidor (para o uilizador), como cliente (para os servidores que os clientes tentam acessar).

O browser enviar todas as *HTTP request messages* para o servidor proxy:
- Se uma cópia do objeto requerido está na cache do proxy o servidor proxy retorna essa cópia;
- Senão, o servidor proxy contacta o servidor HTTP alvo, envia-lhe a HTTP request message, aguarda a resposta que guarda em cache e retorna ao cliente.

### GET Condicional

![[Pasted image 20240104224108.png]]





### HTTP 1.* 
#### Problemas
#####  Paralelismo limitado
-  O paralelismo está limitado ao número de conexões
-  Na prática, mais ou menos 6 conexões por origem 
	- cada uma destas requer um 3-way handshake inicial
	- se for HTTPS ainda requer handshake TLS
	- cada conexão gasta recursos no servidor	 
##### Head-of-line blocking
- Bloqueio do cabeça de fila, acumula pedidos em queue e atrasa a solicitação por parte do cliente
-  Servidor obrigado a responder pela ordem (ordem restrita)
##### Overhead protocolar 
- Metadados do cabeçalho não são compactados
- Aproximadamente 800 bytes de metadados por pedido, mais os cookies
#### Truques
##### Domain Sharding
- (+) Aumenta o paralelismos --- passamos a ter 6 conexões por subdomínio
- (-) Aumenta as consultas ao DNS...
- (-) Mais servidores, competição nas conexões, complexidade nas aplicações
##### Concatenated Assets
- (+) Vários CSS ou vários JS num único objeto
- (-) Atrasa o processamento no cliente, pode dificultar o uso da cache
##### Inline objects



## HTTP2

**Uma estensão do HTTP 1.***

### Objetivo - Mitigar as limitações de desempenho das versões anteriores
-  Primeiras versões do HTTP foram desenhadas para serem de fácil implementação!
- Clientes HTTP/1.* obrigados a lançar várias conexões em paralelo para baixar a latência.
- Não há compressão nem prioridades
- **Mau uso da conexão TCP de suporte!...


Pedidos&Respostas são multiplexados em streams

### SPDY

