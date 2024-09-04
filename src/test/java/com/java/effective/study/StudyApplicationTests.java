package com.java.effective.study;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedList;
import java.util.Queue;




@SpringBootTest
class StudyApplicationTests { // Coding Test

	@Test
	void contextLoads() {

	}






	static int answer = 0;
	static int[] arr ={0,2,3,8,9,11,13,15};
	static  int div = 3;
	public static void main(String[]args){


//		System.out.println(solution(numbers,target)==5);
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


	/**
	 * { 1,1,1,1,1,1} 의 배열에서  + - 하여 3이 되는 개수.
	 * @param  numbers = {1,1,1,1,1};
	 * @param target = 3
	 * @return
	 */
	public static int solution(int[] numbers, int target) {
		Queue<Integer> q = new LinkedList<>();
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




	/**
	 * dfs 예시 양식
	 */
	static int[] n= {1,2,3,4,5,6,7,8,9,10};

	static int[] temp = new int[n.length];
	static int visit[] = new int[n.length];

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






}
