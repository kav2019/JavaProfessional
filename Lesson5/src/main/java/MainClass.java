import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.*;

public class MainClass {
    public static final int CARS_COUNT = 4;
    public static final int TUNNEL_STOPS = CARS_COUNT / 2;
    public static final int STEPS = 3;
    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");

        CountDownLatch cdlStart = new CountDownLatch(CARS_COUNT);
        CountDownLatch cdlFinish = new CountDownLatch(STEPS * CARS_COUNT);


        Race race = new Race(new Road(60, cdlFinish, CARS_COUNT), new Tunnel(TUNNEL_STOPS, cdlFinish),
                new Road(40, cdlFinish, CARS_COUNT));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10), CARS_COUNT, cdlStart);
        }
        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }

        // CountDownLatch для старта всех одновременно
        // Semaphor для заезда в тунель половины
        // join что бы

        try {
            cdlStart.await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
            cdlFinish.await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }




    }
}

