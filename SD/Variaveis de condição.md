Uma estratégia para notificar outras threads de um evento.

```java
Lock l = new ReentrantLock();
Condition c = l.newCondition();

void waitForEvent(){
l.lock();
...
while (!happened){
c.await();
}
...
l.unlock;
}
```

