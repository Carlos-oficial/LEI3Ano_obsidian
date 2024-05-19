#Classificação 
**Modelos de decisão**
Top-down:
- O modelo é construído a partir do conhecimento de especialistas;
- O “todo” é dividido em “partes”;
Bottom-up:
- O modelo é construído pela identificação de relações entre os atributos do *dataset*
- O modelo é induzido por “generalização” dos dados
Árvores de decisão são *Bottom-up*

Uma Árvore de Decisão é um grafo hierarquizado (árvore!) em que:
- Cada ramo representa a seleção entre um conjunto de alternativas;
- Cada nodo interno testa um atributo do dataset;
- Cada folha representa uma decisão;

Estes modelos podem lidar com *features* contínuas e discretas. 
# Algoritmos
## ID3
Constrói uma árvore da raiz até às folhas.
**Qual deve ser o atributo na raiz da árvore de decisão?**
Usando o conceito de **[[Entropia |Entropia]]**.
Uma perda de entropia coincide com ganho em infromação. Escolhe-se então o atributo que ofereça maior ganho (perda de entropia).

## Algoritmo C4.5:
Extensão do algoritmo ID3:
- Manipula atributos discretos e contínuos
	- Para lidar com atributos contínuos, é definido um *threshold* usado para dividir os valores acima e abaixo do limite
- Lida com *missing values*
	- 
- Permite atribuir pesos aos atributos
- Permite fazer poda (*pruning*)
	- Retrocede 1 iteração na árvore e remove ramos que contribuem menos ou não contribuem para a definição da solução, substituindo-os por folhas;
	- Ajuda a combater o *overfitting* que surge em árvores que podem crescer quase infinitamente, até que o número de casos refletidos numa folha é demasiado pequeno para fazer sentido
## outros
CART
CHAID

# Pros/Cons
## Pros
- Facilmente compreensíveis;
- Podem ser convertidas para regras;
- Manipulam missing values;
- Configuração simples (não tem demasiados parâmetros de configuração);
- Explicabilidade da tomada de decisão

## Cons
- Inadequadas para problemas caracterizados por muitas interações entre os atributos;
- Falta de poder expressivo;
- Não isenta a réplicas de subárvores;