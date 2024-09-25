package generic;

public class Main {
    public static void main(String [] args){
        ComparableBox<Integer> box = new ComparableBox<>();
        box.setItem(10);
        System.out.print(box.isGreaterThan(4));
    }
}
