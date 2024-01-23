## requesitos:
- **safety**: nunca duas threads ocupam a secção crítica 
- **liveness**: não haver *starvation*
- **fairness**: 
- minimizar "hops"
- balanceamento de carga
## Alice & Bob
Alice e o Bob ambos têm um dinossauro aquático de estimação (for some reason) e os dois não podem coexistir no lago que há entre as casa dos donos (ainda se matavam ou assim idk).

> Simplesmente verificar que o lago está livre pode ser problemático, uma vez que ambos podem verificá-lo e soltar os animais, (e pronto, ficam um lago de sangue) - um só bool não chega!

Ambos têm uma bandeira (2 bools) que podem erguer para avisar que vão usar o lago (secção crítica).

Quando um quer usar a secção crítica

```
levantar bandeira
while (outra bandeira erguida){
	baixar bandeira
	esperar que a outra baixe
	levantar bandeira
}
soltar o dinorrauro - entrar na secção crítica
baixar a bandeira quando o bixo voltar
```

Pode haver um "loop", como consequencia da simetria do protocolo

| **Alice** | Bob |
| ---- | ---- |
| Raise | Raise |
| Look | Look |
| Lower | Lower |
| rpt... | rpt... |
É importante quebrar a simetria

O Bob continua bué simpático:

```
...
while (outra bandeira erguida){
	baixar bandeira
	esperar que a outra baixe
	levantar bandeira
}
... 
```

A Alice passa a ser mais assertiva

```
...
while (outra bandeira erguida){
	esperar que a outra baixe
}
... 
```

| Alice | Bob |  |
| ---- | ---- | ---- |
| Raise | Raise | 1 1 |
| Look | Look | 1 1 |
| ... | Lower | 1 0 |
| Look | Look | 1 0 |
| Release | ... | 1 0 |
Se a Alice quiser, ela manda nisto tudo. O algoritmo não é **justo**
## Algoritmo de Peterson (para 2 threads)
Funciona a **impedir** um thread de entrar

```
flags[2] = {0,0};

int I;
int Other;

--- Lock

flags[I] = 1; -- erguer a bandeira
victim = I;
while (flags[other] && victim == I) {}; -- esperar

--- Unlock
flag[I] = 0;

```


## Algortimo de filtros (para n threads)

como que sucessivas chamadas ao algoritmo de Peterson
## Algoritmo de Bakery

cada thread "tira" uma fita, desempata-se com um fator constante (ex: ordem lexicográfica dos ids das threads)

## Distribuída
Orquestrador central é una mierda!!!

**token ring** 