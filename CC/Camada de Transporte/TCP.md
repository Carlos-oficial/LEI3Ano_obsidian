Protocolo da camada de transporte, caracetrizado por proporcionar troca de dados <u>fiável  e ordenada</u>

- Controlo de Fluxo, Estabelecimento da Ligação
-  Controlo de erros
-  Controlo de congestão
# Desmultiplexagem

Socket TCP identifica-se com 4 items:
• endereço IP origem
• nº porta origem
• endereço IP destino
• nº porta destino

Recetor usa sempre os 4 valores para redirecionar para o socket correto!
-  Servidor pode ter várias conexões TCP distintas em simultâneo, com um socket distinto para cada uma delas!

![[Pasted image 20240104151341.png]]
# Funções do Transmission Control Protocol

- transporte fiável de dados fim-a-fim (aplicações)
- efetua associações lógicas fim-a-fim: conexões
-  cada conexão é identificada por um par de sockets: (IP_origem:porta_origem,IP_destino:porta_destino)
- uma conexão é um circuito virtual entre portas de aplicações (também designadas portas de serviço)
- multiplexa os dados de várias aplicações através de número de porta
- efetua controlo de erros, controlo de fluxo e controlo de congestão
# Formato do pacote

![[Pasted image 20240104151757.png]]

- Porta Orig/Dest – Nº da porta TCP da aplicação de Origem/Destino
- Número de Sequência - ordem do primeiro octeto de dados no segmento (se SYN = 1, este número é o initial sequence number, ISN)
- Número de Ack (32 bits) - o número de ordem do octeto seguinte na sequência que a entidade TCP espera receber.
- Comprimento Cabeçalho (4 bits) - número de palavras de 32 bits no cabeçalho.
- Flags (6 bits) - indicações específicas.
- Janela – nº de octetos que o receptor é capaz de receber (controlo fluxo)
- Soma de controlo (16 bits) – soma para detecção de erros (segm)
- Apontador de Urgência (16 bits) – adicionado ao nº de sequência dá o nº de sequência do último octeto de dados urgentes.
- Opções (variável) - especifica características opcionais (ex. MSS, timestamp, factor de escala para a janela, etc.)

**Flags TCP (1 bit por flag):**
- URG - indica se o apontador de urgência é válido
- ACK - indica se o nº de sequência de confirmação é válido
- PSH - o recetor deve passar imediatamente os dados à aplicação (aparece nos seg de transferência de dados)
- RST - indica que a conexão TCP vai ser reinicializada
- SYN - indica que os números de sequência devem ser sincronizados para se iniciar uma conexão
- FIN - indica que o transmissor terminou o envio de dados
Os segmentos SYN e FIN consomem um número de sequência

# Funcionemento do Protocolo

![[Pasted image 20240104152149.png]]
## Conexão
Maximum Segment Size (MSS) do TCP
- opção TCP que apenas aparece em segmentos SYN
- o MSS é o maior bloco de dados da aplicação que o TCP enviará na conexão
- ao iniciar-se uma conexão, cada lado tem a opção de anunciar ao outro o MSS que espera receber
- o maior MSS possível é igual ao MTU da interface menos os comprimentos dos cabeçalhos TCP e IP:

(sobre Ethernet o maior MSS é 1460 bytes)

## Estabelecimento de conexão

O emissor e o receptor TCP estabelecem uma ligação antes de iniciarem a troca de segmentos de dados.
- Inicialização de variáveis
	- números de sequência
	- buffers, controlo de fluxo (e.g. RcvWindow)
- Cliente: inicia a pedido de ligação 
	- `Socket clientSocket = new Socket("hostname","port number");`

- Servidor: é contactado pelo cliente e aceita o pedido de ligação
	- `Socket connectionSocket = welcomeSocket.accept();

Três passos:
1. O cliente envia segmento SYN para o servidor
	- especifica o número de sequência inicial
	- sem dados
2. O servidor recebe o SYN e responde com um segmento SYNACK
	- aloca espaço de armazenamento
	- especifica o número de sequência inicial
3.  O cliente recebe o segmento SYNACK, e responde com um segmento ACK que pode conter dados

![[Pasted image 20240104155954.png]]

## Final da conexão
![[Pasted image 20240104160937.png]]

## Transporte fiável

“A” pretende mandar – de forma fiável – uma mensagem “m” para “B”, usando uma ligação de “rede” não fiável.
- Como posso ter a certeza que B recebeu a mensagem “m”?
- O que pode correr mal no envio de “m”?
- Tendo em atenção que estamos na camada de transporte
- Como lidar com os erros?

Nas redes o mecanismo preferencial é o ARQ (Automatic Repeat reQuest)

 > "**Automatic repeat request** (**ARQ**), also known as **automatic repeat query**, is an [error-control](https://en.wikipedia.org/wiki/Error_control "Error control") method for [data transmission](https://en.wikipedia.org/wiki/Data_transmission "Data transmission") that uses [acknowledgements](https://en.wikipedia.org/wiki/Acknowledgement_(data_networks) "Acknowledgement (data networks)") (messages sent by the receiver indicating that it has correctly received a message) and [timeouts](https://en.wikipedia.org/wiki/Timeout_(computing) "Timeout (computing)") (specified periods of time allowed to elapse before an acknowledgment is to be received) to achieve [reliable data transmission](https://en.wikipedia.org/wiki/Reliability_(computer_networking) "Reliability (computer networking)") over an unreliable [communication channel](https://en.wikipedia.org/wiki/Communication_channel "Communication channel"). ARQ is appropriate if the communication channel has varying or unknown [capacity](https://en.wikipedia.org/wiki/Channel_capacity "Channel capacity"). If the sender does not receive an acknowledgment before the timeout, it [re-transmits](https://en.wikipedia.org/wiki/Retransmission_(data_networks) "Retransmission (data networks)") the message until it receives an acknowledgment or exceeds a predefined number of retransmissions.
 > Variations of ARQ protocols include [Stop-and-wait ARQ](https://en.wikipedia.org/wiki/Stop-and-wait_ARQ "Stop-and-wait ARQ"), [Go-Back-N ARQ](https://en.wikipedia.org/wiki/Go-Back-N_ARQ "Go-Back-N ARQ"), and [Selective Repeat ARQ](https://en.wikipedia.org/wiki/Selective_Repeat_ARQ "Selective Repeat ARQ"). All three protocols usually use some form of [sliding window protocol](https://en.wikipedia.org/wiki/Sliding_window_protocol "Sliding window protocol") to help the sender determine which (if any) packets need to be retransmitted. These protocols reside in the [data link](https://en.wikipedia.org/wiki/Data_link_layer "Data link layer") or [transport layers](https://en.wikipedia.org/wiki/Transport_layer "Transport layer") (layers 2 and 4) of the [OSI model](https://en.wikipedia.org/wiki/OSI_model "OSI model")." ~ From Wikipedia


![[Pasted image 20240104162843.png]]

CRC aka [Cyclic Redundancy Check ](https://en.wikipedia.org/wiki/Cyclic_redundancy_check)


- sequenciação necessária para ordenação na chegada
- o número de sequência é incrementado pelo número de bytes do campo de dados
- cada segmento TCP tem de ser confirmado (ACK), contudo é válido o ACK de múltiplos segmentos
- o campo ACK indica o próximo byte (sequence) que o receptor espera receber (piggyback)
-  o emissor pode retransmitir por timeout: o protocolo define o tempo máximo de vida dos segmentos ou MSL (maximum
segment lifetime)

**Não há NAcks (negative acknowlegments)**

### Retransmissão

![[Pasted image 20240104165241.png]]![[Pasted image 20240104165305.png]]
### RTT

Como definir o valor do Timeout no TCP?
- Com base no RTT (mas o RTT varia)
- Demasiado curto aumenta o número de retransmissões desnecessárias?
- Demasiado longo atrasa a reacção a um segmento perdido

**É necessário estimar o RTT**

EstimatedRTT = (1- a)*EstimatedRTT + a*SampleRTT
- média móvel de peso exponencial
- o peso do passado decresce exponencialmente…
- valor tipico: a = 0.125
Oferece alguma inércia ao RTT estimado, para que este não mude violentamente

O Desvio do RTT é estimado de uma forma semelhante, e o timetout é defindio à sua custa
**DevRTT = (1-b)*DevRTT +b*|SampleRTT - EstimatedRTT|**
(typically, b = 0.25)
**Timeout = EstimatedRTT + 4* DevRTT**

![[Pasted image 20240105145707.png]]

