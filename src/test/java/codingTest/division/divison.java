package codingTest.division;

public class divison {

    static int answer = 0;
    static int[] arr ={0,2,3,8,9,11,13,15};
    static  int div = 3;

    public static void main(String[]args){
        answer = division(arr,div,0,0);
        System.out.println(answer);
    }

    public static int division(int arr[],int div,int depth,int min){
        if(depth == div-1)	// 분할 완료
        {
            //max 중에 최소값
//			min  = sum < min ? sum : min;
        }

        for(int i = 0;i<arr.length;i++){
            division(arr,div,depth+1,min);
        }

        return min;
    }

}
