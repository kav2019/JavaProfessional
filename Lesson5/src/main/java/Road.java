import java.util.concurrent.CountDownLatch;

public class Road extends Stage {
    private CountDownLatch cdlFinish;
    private int cars_count;

    public Road(int length, CountDownLatch cdlFinish, int cars_count) {
        this.cars_count = cars_count;
        this.cdlFinish = cdlFinish;
        this.length = length;
        this.description = "Дорога " + length + " метров";
    }

    @Override
    public void go(Car c) {
        try {
            System.out.println(c.getName() + " начал этап: " + description);
            Thread.sleep(length / c.getSpeed() * 1000);
            System.out.println(c.getName() + " закончил этап: " + description);
            cdlFinish.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
