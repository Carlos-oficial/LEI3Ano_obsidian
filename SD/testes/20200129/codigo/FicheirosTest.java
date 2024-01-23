import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FicheirosTest {

    public static void main(String[] args) throws InterruptedException {
        Ficheiros ficheiros = new FicheirosImpl(Arrays.asList("file1","file2"));

        Thread user1 = new Thread(() -> {
            ficheiros.using("file1");
            try {
                Thread.sleep(100); // Simulate an operation on the file
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            ficheiros.notUsing("file1", true);
        });

        Thread user2 = new Thread(() -> {
            ficheiros.using("file2");
            ficheiros.notUsing("file2", false);
        });

        Thread backupThread = new Thread(() -> {
            List<String> modifiedFiles = ficheiros.startBackup();
            System.out.println("Modified files before operations: " + modifiedFiles);

            user1.start();
            user2.start();

            try {
                user1.join();
                user2.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            modifiedFiles = ficheiros.startBackup();
            System.out.println("Modified files after operations: " + modifiedFiles);
            ficheiros.endBackup();
        });

        backupThread.start();
        backupThread.join();

        // Ensure that after the backup, the files are not in use
        ficheiros.using("file1");
        ficheiros.notUsing("file1", false);
        ficheiros.using("file2");
        ficheiros.notUsing("file2", false);
    }
}
