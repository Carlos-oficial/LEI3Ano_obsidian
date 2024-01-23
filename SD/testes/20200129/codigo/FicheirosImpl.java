import java.util.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class FicheirosImpl implements Ficheiros {
    private Map<String, Condition> ficheiros = new HashMap<String, Condition>();
    private Set<String> em_edicao = new HashSet<String>();
    private ReentrantLock l = new ReentrantLock();

    public FicheirosImpl(List<String> files) {
        files.forEach(f -> {
            ficheiros.put(f, l.newCondition());
        });
    }

    /*
     * Quando um utilizador pretende modificar um ficheiro, deve pedir licença com o
     * método using, indicando o nome do ficheiro.
     * A licença para utilizar um ficheiro só pode ser dada a um utilizador de cada
     * vez.
     */

    public void using(String path) {
        try {
            l.lock();
            while (em_edicao.contains(path)) // ficheiro a ser usado
                {
            System.out.println(Thread.currentThread().getName() + " à espera de  usar " + path);
                
                ficheiros.get(path).await();}
            em_edicao.add(path);
            System.out.println(Thread.currentThread().getName() + " estou a usar " + path);


        } catch (Exception e) {
        } finally {
            l.unlock();
        }
    };

    /*
     * O método notUsing assinala que já não está a usar o ficheiro, indicando o seu
     * nome e se foi modificado.
     */

    public void notUsing(String path, boolean modified) {
        try {
            l.lock();
            em_edicao.remove(path);
            ficheiros.get(path).signalAll();

        } finally {
            System.out.println(Thread.currentThread().getName() + " já não estou a usar " + path);
            l.unlock();
        }
    };

    /*
     * Para iniciar uma cópia de segurança usa-se o método startBackup, que espera
     * até os ficheiros não estarem a ser usados
     * e devolve a lista de todos os ficheiros modificados desde a cópia de
     * segurança anterior.
     */
    public List<String> startBackup() {
        List<String> files = new ArrayList<String>();
        try {
            l.lock();
            for (Map.Entry<String, Condition> entry : ficheiros.entrySet()) {
                var file = entry.getKey();
                var file_in_use = entry.getValue();

                while (em_edicao.contains(file)) {
                    file_in_use.await();
                }
                files.add(file);
            }
            return files;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            l.unlock();
        }
        return new ArrayList<String>();
    };

    /*
     * Depois de terminada a cópia de segurança, o utilizador deve usar o método
     * endBackup.
     */
    public void endBackup() {

    };
}