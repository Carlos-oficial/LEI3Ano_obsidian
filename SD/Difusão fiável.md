É importante garantir a **confiabilidade**.
Funciona como um TCP, espera por um *Ack* de cada recetor. 
Para mitigar o caso em que o emissor falha, todos os recetores trocam enviam *acks* uns aos outros. (*Ack imposion*)

# Gossip - Disseminação epidémica
Ao receber uma mensagem, envia-a para um subconjunto aleatório de *peers*