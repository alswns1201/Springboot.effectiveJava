package pattern.Supplier;

import java.awt.desktop.SystemEventListener;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class WithSupplier {


     public static void main(String[] args) {
         long startTime = System.currentTimeMillis();
         for(int i = 0; i < 5; i++){
             printRandom(getRandom(), i);
             // printRandom 가 Supplier 가 아닐 경우 get 하는 시점이 아닌 모든 count 즉 5번 전부 실행되어 성능 악화
         }
         System.out.println((System.currentTimeMillis() - startTime)/1000 + "seconds");
    }


    public  static Supplier<Double> getRandom(){
        return () -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return Math.random();
        };
    }

    public static void printRandom(Supplier<Double>d ,int c){
         if(c % 2 ==0){
             System.out.println(d.get());
         }
    }



}
