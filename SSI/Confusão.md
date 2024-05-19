#propriedade_cifra
Cada *bit* do texto cifrado dece depender de várias partes da chave.
Esta propriedade ofusca a relação entre a chave e o texto cifrado.
"In [substitution–permutation networks](https://en.wikipedia.org/wiki/Substitution%E2%80%93permutation_network "Substitution–permutation network"), confusion is provided by [substitution boxes](https://en.wikipedia.org/wiki/Substitution_box "Substitution box")." ~ wikipedia
## Consequências de fraca difusão
Um exemplo de ausencia de confusão seria fazer apenas um ou exclusivo entre a chave o texto orignial para obter o texto cifrado.
Nesse caso cada bit no *cipher text* depende de um (e apenas um) bit na chave. Este problema manter-se-ia mesmo que houvesse *shuffling* da chave ou do texto original pelo meio