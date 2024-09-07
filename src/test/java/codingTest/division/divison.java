package codingTest.division;

public class divison {

    static int answer = 0;
    static int[] arr ={0,2,3,8,9,11,13,15};
    static int[] visit = new int[arr.length+1];
    static  int div = 4;

    public static void main(String[]args){
        int point[] = new int[div-1];
        division(arr,div,0,point);
//        System.out.println(answer);
    }

    public static int division(int arr[],int div,int depth,int[] point){
;        if(depth == div-1)	// 분할 완료
        {
            for(int a : point){
                System.out.print(a+" ");

            }

            System.out.println();
            return 0;
        }

        for(int i = 0;i<=arr.length;i++){
            if(visit[i]==1) {
                continue;
            }
            // 한번 분할한 곳의 오른쪽 만 분할 가능.
            if(depth > 0  && point[depth-1] > i ) {continue;}

            point[depth] = i;
            visit[i] = 1;
            division(arr,div,depth+1,point);
            visit[i] = 0;
        }

        return 0;
    }

}
