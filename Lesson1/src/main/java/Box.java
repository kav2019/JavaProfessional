import java.util.ArrayList;

public class Box <T extends Fruit>{
    private ArrayList<T> box;
    private T fruit;

    public Box(T fruit){
        box = new ArrayList<>();
        this.fruit = fruit;
        box.add(fruit);
    }

    public void addInBox(T fruit){
        box.add(fruit);
    }

    public ArrayList<T> getBox() {
        return box;
    }

    public int ArraySize(){
        return box.size();
    }

    public void info(){
        System.out.println(fruit.getClass().getName());
    }

    public float getWeightBox(){ // Метод взвешивания корзинки
        float weight = box.size() * fruit.getWeight();
        return weight;
    }

    public boolean compare(Box box){ // меетод сравнения веса
        return  Math.abs(this.getWeightBox() - box.getWeightBox()) < 0.0001;
    }

    public void pour(Box<T> box1, Box<T> box2){ //Пересыпает из box1 в box2
        for (int i = 0; i < box1.getBox().size(); i++) {
            box2.getBox().add(box1.getBox().get(i));
        }
        box1.getBox().clear();
    }

}
