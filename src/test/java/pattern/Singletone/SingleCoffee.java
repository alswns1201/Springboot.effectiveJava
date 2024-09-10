package pattern.Singletone;

//싱글톤 구현
public class SingleCoffee {
     // final을 제거한다해도 멀티 쓰레드 환경에서 다양한 종류의 ber 생성시 문제 .
     // 그렇기 때문에 외부 주입이 필요하다.

     private final Beverage ber = new Beverage();
     private SingleCoffee(){};
     public static SingleCoffee Instance = new SingleCoffee();

}
