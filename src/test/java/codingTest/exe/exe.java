package codingTest.exe;

public class exe {


    public static void main(String[]args){

        solution(120);

    }

    public static void solution(int N) {
        StringBuilder result = new StringBuilder();
        while (N > 0) {
            int enable_print = N % 10;
            System.out.print(enable_print);
            N = N / 10;
        }
    }


}
