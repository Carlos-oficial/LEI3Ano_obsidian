Método de encriptação que funciona com blocos de bits de comprimento fixo.
Adequados para encriptação de mensagens cujo tamanho é menor ou igual ao tamanho de um bloco.

## Propriedades
- [[Difusão|Difusão]]
- [[Confusão|Confusão]]

## Modos de operação
- [[Electronic Code Book]] - ECB
- [[Cipher Block Chaining]] - CBC
- [[Cipher FeedBack mode]] - CFB
- [[Output FeedBack mode]] 
 - [[Counter mode]] (CTR)


## Padding
Uma vez que estas cifras só funcionam em blocos, texto que não ocupe um bloco inteiro deve ser "esticado" de modo a encher o bloco.
Deve ser possível destinguir inambiguamente os bytes de padding dos bytes que fazem efetivamente parte da mensagem
Pode ser:
- orientado ao bit ou ao byte
- determinístico ou aleatório
- ...
### PKCS7 padding
![[Pasted image 20240329202941.png]]