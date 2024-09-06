package codingTest.queue;

import java.util.LinkedList;

public class Queue {

    static int answer = 0;


    public static void main(String[]args){
        int[] numbers = { 1,1,1,1,1,1};
        int target =3;
        System.out.println(solution(numbers,target)==5);



    }

    public static int solution(int[] numbers, int target) {
        java.util.Queue<Integer> q = new LinkedList<>();
        q.add(0);
        int temp  = 0;
        for(int i = 0; i<numbers.length;i++) // i가  depth
        {
            int size = q.size();
            for(int j =0;j<size;j++)	// 하나의 depth 에서 다음 depth 크기
            {
                temp = q.poll();
                q.add(temp + numbers[i]);
                q.add(temp - numbers[i]);
            }

        }

        //남아 있는 큐에 대해 확인 .
        while(!q.isEmpty())
        {
            if(target == q.poll()){
                answer++;
            }
        }

        return answer;
    }


}
