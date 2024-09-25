package codingTest.exe;

import java.util.*;

public class exe2 {

    public static void main(String[] args) {
        int N = 3;
        int[] A = {1, 3};
        int[] B = {2, 2};

        System.out.println(graph(N,A,B));
    }


    static Map<Integer, List<Integer>> graph = new HashMap<>();

    private static boolean graph(int N,int[] A, int[] B){

        // 먼저 정점에 대해서 기본 설정.
        for (int i = 1; i <= N; i++) {
            graph.put(i, new ArrayList<>());
        }
        // 간선 A B 따로 적용 하기 (양방향)
        for (int i = 0; i < A.length - 1; i++) {
            graph.get(A[i]).add(A[i + 1]);
            graph.get(A[i + 1]).add(A[i]);
        }
        for (int i = 0; i < B.length - 1; i++) {
            graph.get(B[i]).add(B[i + 1]);
            graph.get(B[i + 1]).add(B[i]);
        }

        //만들어진 간선을 DFS 탐색해보자
        boolean[] visited = new boolean[N + 1];
        return dfs(1, visited, 1, N);
    }

    private static boolean dfs(int current, boolean[] visited, int step, int N) {
        // 최종 방문시 true
        if (step == N) return true;
        if (visited[current]) return false; // 이미 방문한건 접근하지 않는다.

        visited[current] = true;


        for (int neighbor : graph.getOrDefault(current, Collections.emptyList())) {
            if (neighbor == step + 1) {
                if (dfs(neighbor, visited, step + 1, N)) {
                    return true;
                }
            }
        }

        // Backtrack
        visited[current] = false;
        return false;
    }


}