## Forwarding

Utiliza a tabela de reenvio previamente preenchida pelos protocolos de
encaminhamento ou pelo administrador;
- Procura na tabela, para um dado “destino”, o “próximo salto” e o “interface de saída”;
 - Comuta o pacote pelo interface respetivo, encapsulando-o numa trama de acordo com o tipo de interface.
### Algoritmos de encaminhamento dinâmico
#### Estado de Ligação (LS)
#### Vetores de Distância (DV)
#### Comparação entre DV e LS
### Protocolos de encaminhamento IP
#### Protocolos de encaminhamento interno (IGP)
#### Protocolos de encaminhamento externo (EGP)
## Routing - Encaminhamneto
- Preenche a tabela de encaminhamento com a(s) melhor(es) rotas para as redes de destino ( classfull ) ou para um conjunto de prefixos de endereços (classless );
- Pode ser um processo manual, feito pelo administrador – encaminhamento estático;
- Ou, no caso mais comum, um processo automático resultante da operação de um protocolo de **encaminhamento dinâmico**
### Plano de Controlo Distribuído
Existe uma componente de controlo em todos os routers !

### Plano de Controlo Centralizado
Um controlador remoto que interage com agentes locais (CA)!

### Algoritmo de Routing
A topologia de rede é um grafo em que:
- Os nós do grafo são os encaminhadores/routers ;
- Os arcos do grafo são as ligações/links da rede;
- O custo das ligações pode ser estabelecido em função de vários critérios (individualmente ou em conjunto), como por exemplo, o atraso, a capacidade/ritmo nominal, do nível de congestão, do custo operacional, da distância, etc.;
- Um “bom” caminho geralmente significa o caminho que minimiza ou maximiza o seu custo total…

![[Pasted image 20240105224851.png]]
#### Global
- Todos os encaminhadores têm um conhecimento completo da topologia e custo das ligações;
- Algoritmos de estado das ligações (Link State – LS).
##### Link State
Todos os nós da topologia espalham pela rede informação sobre o estado
das suas ligações de forma a construírem a base de dados topológica
(usando um método de inundação fiável –**Reliable Flooding ** ):
- Inicialmente necessitam de conhecer apenas os seus vizinhos diretos, para quem enviam a identificação de todos os outros seus vizinhos, bem como o custo das ligações respetivas;
- Um nó/encaminhador ao receber esta informação atualiza a sua base de dados topológica e reenvia a informação para todos os seus vizinhos;
- Ao fim de algum tempo todos os nós possuem um conhecimento completo da topologia e dos custos de todas as ligações.
#### Descentralizada:
- Os encaminhadores só conhecem os vizinhos a que estão fisicamente/logicamente ligados e o custo das ligações respetivas;
- O processo de computação é iterativo, havendo troca de informação entre vizinhos;
- Algoritmos de vetor de distância (Distance Vector – DV).
