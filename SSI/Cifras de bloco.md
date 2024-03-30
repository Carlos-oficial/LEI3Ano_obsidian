Método de encriptação que funciona com blocos de bits de comprimento fixo.
Os blocos são a uni

## Propriedades
### Difusão
Diferenças no texto original são distribuídas pelo texto cifrado.
### Confusão
A relação entre o texto cifrado e a chava deve ser tão complexa quanto possível



## Modos de operação
### Electronic Code Book (ECB)
![[Pasted image 20240329203431.png]]
![[Pasted image 20240329203448.png]]
Os vários blocos de texto são cifrados com uma só chave, o que pode resultar no surgimento de padrões no total do texto encriptado.
Este modo é vulnerável ao ataque conhecido como [_Codebook attack_](https://link.springer.com/referenceworkentry/10.1007/978-1-4419-5906-5_563) que é um ataque de **known plaintext attack**.
Implementações com blocos pequenos são particularmente vulneráveis.

### Cipher Block Chaining (CBC)
![[Pasted image 20240330113321.png]]
![[Pasted image 20240330113330.png]]

O resultado da encriptação do bloco anterior é usado na encriptação no próximo, isto cria uma dependência de um bloco para com o anterior.
O processo começa com um IV (vetor de inicialização)

### Cipher FeedBack mode (CFB)
### Output FeedBack mode (OFB)
### CounTeR mode (CTR)


### Padding
Uma vez que estas cifras só funcionam em blocos, texto que não ocupe um bloco inteiro deve ser "esticado" de modo a encher o bloco.
Deve ser possível destinguir inambiguamente os bytes de padding dos bytes que fazem efetivamente parte da mensagem
Pode ser:
- orientado ao bit ou ao byte
- determinístico ou aleatório
- ...

#### exemplo PKCS7 padding
![[Pasted image 20240329202941.png]]