#cifra

Uma generalização da [[Cifra de Vigenère]]:
- chave do tamanho do *plaintext*
- chave completamente aleatória
- chave é apenas usada uma vez
- alfabeto binário

$$C = T \oplus K \land M = C \oplus K $$

Provado que é segura por Claude Shannon, mas inviável em aplicações reais porque:
- Cada chave só pode ser usada uma vez
- Chaves verdadeiramente aleatórias
- Chaves grandes
- Carece de [[Difusão]] e [[Confusão]] 
- Geração e distribuição (de chave) difíceis
