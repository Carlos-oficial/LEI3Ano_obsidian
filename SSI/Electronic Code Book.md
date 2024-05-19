# Funcionamento
![[Pasted image 20240329203431.png]]
![[Pasted image 20240329203448.png]]
Os vários blocos de texto são cifrados (e decifrados) com uma só chave.
# Vantagens
- Paralelizável
- Simples implementação
# Desvantagens
- O facto se se usar sempre a mesma chave pode resultar no surgimento de padrões no total do texto encriptado.
- Vulnerável a [_Codebook attack_](https://link.springer.com/referenceworkentry/10.1007/978-1-4419-5906-5_563) que é um ataque de **known plaintext attack**.
- Implementações com blocos pequenos são particularmente vulneráveis.