Relógios não são perfeitos, têm "drift" (a frequencia dos ticks mode variar).

Relógios sincronizados são úteis, mas um problema não trivial.

## Sincronização 
Deve ser feita de forma gradual, para não haver saltos no tempo.
É difícil consultar um relógio de referência, porque isto é feito por mensagens, com tempo de propagação e processamento variáveis e imprevisíveis.

### NTP Network Time Protocol
- Assume-se que o o envio e a receção demoram sensivelmente o mesmo.
- Repete-se a troca várias vezes e escolhe-se o menor RTT
### RBS Reverence Base Synchronization
- Assumir delay de zero