import java.util.ArrayList;

public class Box <T extends Fruit>{
    private ArrayList<T> box = new ArrayList<>();
    private T weightOneElement;

    public void addInBox(T fruit){
        box.add(fruit);
    }

    public ArrayList<T> getBox() {
        return box;
    }

    public float getWeightBox(){ ///Дописать!!!!
        float w = weightOneElement.getWeight();
        return box.size() * w;
    }

    public boolean compare(Box box){
        return  Math.abs(this.getWeightBox() - box.getWeightBox()) < 0.0001;
    }

    public void pour(Box<T> box1, Box<T> box2){ //Пересыпает из box1 в box2
        for (int i = 0; i < getBox().size(); i++) {
            box2.getBox().add(box1.getBox().get(i));

        }
        box1.getBox().clear();
    }

}
