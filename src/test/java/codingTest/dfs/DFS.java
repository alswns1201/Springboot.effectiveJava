package codingTest.dfs;

public class DFS {


    static int[] n= {1,2,3,4,5,6,7,8,9,10};

    static int[] temp = new int[n.length];
    static int visit[] = new int[n.length];
    static int answer = 0;

    public static void main(String[]args){
        dfs(0,0);
    }

    /**
     * dfs 예시 양식
     */


    static void dfs(int depth,int start) {

        if(depth==5)	// 5�� �̴´�.
        {
            for(int i=0;i<5;i++)
            {
                System.out.print(temp[i]);
            }
            System.out.println();
        }


        for(int i=start;i<n.length;i++)
        {
            if(visit[i]==1)continue;

            visit[i]=1;
            temp[depth]=n[i];
            dfs(depth+1,i);
            visit[i]=0;

        }
    }

    /**
     * 깊이 우선 탐색
     */
    public void dfsS(int[] numbers, int depth, int target, int sum){
        if(depth == numbers.length){ // 마지막 노드까지 탐색한 경우
            if(target == sum) answer++;
        } else { // 탐색할 노드가 남아있는 경우
            dfsS(numbers, depth + 1, target, sum + numbers[depth]); // 해당 노드의 값을 더하고 다음 깊이 탐색
            dfsS(numbers, depth + 1, target, sum - numbers[depth]); // 해당 노드의 값을 빼고 다음 깊이 탐색
        }
    }

}
