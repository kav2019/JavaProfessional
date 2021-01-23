import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    Semaphore semaphore;
    private CountDownLatch cdlFinish;

    public Tunnel(int tunnel_stops, CountDownLatch cdlFinish) {
        this.cdlFinish = cdlFinish;
        semaphore = new Semaphore(tunnel_stops);
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }

    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                semaphore.acquire();
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
                semaphore.release();
                cdlFinish.countDown();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
