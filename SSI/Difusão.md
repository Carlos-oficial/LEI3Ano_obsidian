#propriedade_cifra
Pequenas mudanças no *plaintext* implicam grandes mudanças no texto *ciphertext*.

Idealmente, um *bit flip* no *plaintext* cerca de metade dos bits no *ciphertext* devem também mudar e viceversa.
Ver também [avalanche effect](https://en.wikipedia.org/wiki/Avalanche_effect "Avalanche effect")

## Consequências de fraca difusão
Um exemplo de cifra sem difusão é a cifra de césar, nesta, com base em apenas a distribuição de probabilidade dos characteres na mensagem cifrada é possível descobrir a chave, sabendo propriedades sobre o *plaintext* sem ter qualquer conhecimento concreto a respeito deste.

É possível "mexer" com o *ciphertext* sem saber o conteúdo do mesmo e ainda assim ter noção dos efeitos das alterações no texto desencriptado.

