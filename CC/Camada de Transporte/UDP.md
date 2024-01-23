Troca de dados não fiável e desordenada 

# Desmultiplexagem

Quando o host recebe umsegmento UDP:
• Verifica aporta# destino dosegmento
• direciona o segmento UDP para o socket com essa porta#

Datagramas IP com o mesmo IP Destino, Porta destino, mas com diferentes IP de origem e/ou portas de origem são dirigidos ao mesmo socket no destino!

![[Pasted image 20240104151523.png]]

# Funções do User Datagram Protocol
- protocolo de transporte fim-a-fim, não fiável
- orientado ao datagrama (sem conexão)
- actua como uma interface da aplicação com o IP para multiplexar e desmultiplexar tráfego
- usa o conceito de porta / número de porta
- forma de direccionar datagramas IP para o nível superior
- portas reservadas: 0 a 1023, dinâmicas: 1024 a 65535
- é utilizado em situações que não justificam o TCP
- exemplos: TFTP, RPC, DNS
- … ou quando as aplicações querem controlar o fluxo de dados e gerir erros de transmissão diretamente
## Controlo de erros
Usadno a técnica checksum
- complemento para 1 da soma de grupos de 16 bits
- cobre o datagrama completo (cabeçalho e dados)
- o cálculo é facultativo mas a verificação é obrigatória
- Checksum = 0 significa que o cálculo não foi efectuado
- se Checksum ≠ 0 e o receptor detecta erro na soma:
- o datagrama é ignorado (descartado);
- não é gerada mensagem de erro para o transmissor;
- a aplicação de recepção é notificada.

# Formato do Pacote

![[Pasted image 20240104150659.png]]



# Discussão

O  que pode levar um “developper” a escolher o UDP como suporte à comunicação na sua App, sabendo à partida que não dá garantias nenhumas e fornece serviço mínimo de multiplexagem/desmultiplexagem e verificação de erros opcional?
(E tendo alternativas que dão todas as garantias!)

- Maior controlo sobre o envio dos dados por parte da aplicação;
-  aplicação controla quando deve enviar ou reenviar os dados sem deixar essa decisão ao transporte:
	- fuga ao controlo de congestão do TCP;
- Aplicação decide quantos bytes envia realmente de cada vez
- Não há estabelecimento e terminação da conexão;
- Não é necessário manter informação de estado por conexão;
- Menor overhead por pacote (cabeçalho UDP são apenas 8 bytes)
