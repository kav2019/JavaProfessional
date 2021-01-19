import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskOne {
    private static volatile char wordA = 'A';
    public static Object key = new Object();


    public static void main(String[] args) {
        ExecutorService thread = Executors.newFixedThreadPool(3);
        thread.submit(() ->{
            printABC('A', 'B');
        });
        thread.submit(() -> {
            printABC('B', 'C');
        });
        thread.submit(() -> {
            printABC('C', 'A');
        });
        thread.shutdown();
    }

    private static void printABC(char a, char b) {
        try{
            for (int i = 0; i < 5; i++){
                synchronized (key){
                    while (wordA != a){
                        key.wait();
                    }
                    System.out.println(a);
                    wordA = b;
                    key.notifyAll();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}


