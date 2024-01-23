Acenta na camada de rede (protocolo [[IP]])

Fornece uma ligação lógica entre dois processos ou aplicações.

Dois principais protocolos:
- [[TCP]]
- [[UDP]]

# [[#Multiplexagem (no emissor) | Multiplexagem]] &  [[#Desmultiplexagem (no recetor) | Desmultiplexagem]]
Mecanismo pelo qual múltiplas aplicações numa máquina conseguem comunicar com o exterior, usando a mesma placa de rede.
Cria-se assim a abstração de múltiplos [[Socket |sockets]] (ou portas) que podem ser usados para enviar dados de um processo em específico.

## Multiplexagem  (no emissor)

Pacotes provenientes de vários [[Socket|sockets]] são delimitados por pacotes IP e respetivos cabeçalhos da camada de trannporte 

## Desmultiplexagem (no recetor)
Pacotes recebidos na camada de rede são distribuídos para o [[Socket]] correto
[[UDP#Desmultiplexagem|em UDP]]
[[TCP#Desmultiplexagem|em TCP]]

# Formato dos segmentos
Encapsulados num datagrama [[IP]] que já contém o endereço das máquina de destino e origem.

- 16 bits: porta de origem
- 16 bits: porta de destino
- outros campos
- payload
