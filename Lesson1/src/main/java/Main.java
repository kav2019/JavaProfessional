import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Проверка первого задания");
        String[] array = new String[]{"One", "Two", "Three", "Four"};
        System.out.println("Оригинальный массив: " +Arrays.toString(array) + "\n" + "Измененный массив: " + Arrays.toString(change(array,0,3)));
        Integer[] array1 = new Integer[]{1,2,3,4};
        System.out.println("Оригинальный массив: " +Arrays.toString(array) + "\n" + "Измененный массив: " + Arrays.toString(change(array1,0,3)));


        System.out.println("Проверка торого задания");
        String[] array3 = new String[]{"One", "Two", "Three", "Four"};
        System.out.println(massToArray(array3));


        Box<Apple> appleBox = new Box<>(new Apple());
        appleBox.addInBox(new Apple());
        appleBox.addInBox(new Apple());
        appleBox.addInBox(new Apple());
        appleBox.addInBox(new Apple());
        appleBox.addInBox(new Apple());
        System.out.println(appleBox.getWeightBox());
        appleBox.info();


        Box<Orange> orangeBox = new Box<>(new Orange());
        orangeBox.addInBox(new Orange());
        orangeBox.addInBox(new Orange());
        orangeBox.addInBox(new Orange());
        System.out.println(orangeBox.getWeightBox());
        appleBox.info();

        System.out.println(orangeBox.compare(appleBox));

        Box<Orange> orangeBox1 = new Box<>(new Orange()); //Пробуем пересыпать
        orangeBox1.pour(orangeBox, orangeBox1);
        System.out.println(orangeBox.getWeightBox());
        System.out.println(orangeBox1.getWeightBox());



    }

    public static  <T> T[] change(T[] array, int positionA, int positionB){ // Задание 1. Метод замены элементов вмассиве
        T buffer = array[positionA];
        array[positionA] = array[positionB];
        array[positionB] = buffer;
        return array;
    }


    public static <T> ArrayList<T> massToArray(T[] array){ // Задание 2. Метод преобразования из массива в ArrayList
        ArrayList<T> arrayList = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            arrayList.add(array[i]);
        }
        return arrayList;
    }

}
