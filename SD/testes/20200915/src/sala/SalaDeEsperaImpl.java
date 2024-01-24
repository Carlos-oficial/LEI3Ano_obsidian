package sala;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SalaDeEsperaImpl implements SalaDeEspera {

    List<String> a_espera = new ArrayList<String>();
    Set<String> atendido = new HashSet<String>();
    ReentrantLock l = new ReentrantLock();
    Condition c = l.newCondition();

    public boolean espera(String nome) {
        try {
            l.lock();
            while (a_espera.contains(nome) && !atendido.contains(nome))
                c.await();
            if (atendido.contains(nome))
                return true;
            else
                return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            l.unlock();
        }
    };

    public void desiste(String nome) {
        try {
            l.lock();
            a_espera.remove(nome);
            c.signalAll();
        } finally {
            l.unlock();
        }
    };

    public String atende() {
        try {
            l.lock();
            String a = a_espera.removeFirst();
            atendido.add(a);
            c.signalAll();
            return a;
        } finally {
            l.unlock();
        }
    };
}
