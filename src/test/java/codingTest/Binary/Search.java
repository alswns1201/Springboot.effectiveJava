package codingTest.Binary;

public class Search {

    static int[] arr ={0,2,3,8,9,11,13,15};
    static int div = 3;

    public static void main(String[] args) {
        int answer = 0;
        answer = Binary(div,3,arr);
        System.out.println(answer);
    }

    public static int Binary(int K, int M, int[] A) {
        // 분할 했을때 한공간에 들어갈 최소 , 최대
        int left = 0;   // 최소         (left는 최대 value 값)
        int right = 0;  // 최대 초기화 . (right는 합계 )

        // 배열의 합과 최대값을 찾습니다.
        for (int value : A) {
            right += value;
            if (value > left) {
                left = value;
            }
        }

        // 이분 탐색을 시작합니다.
        while (left < right) {
            int tempRight = (left + right) / 2;

            if (canDivide(A, K, tempRight)) {
                right = tempRight; // 가능한 경우, 더 작은 값으로 탐색
            } else {
                left = tempRight + 1; // 불가능한 경우, 더 큰 값으로 탐색
            }
        }

        return left; // 최적의 값을 반환
    }

    // 블록의 최대 합이 maxSum 이하로 나눌 수 있는지 확인하는 함수
    public static boolean canDivide(int[] A, int K, int tempRight) {
        int blockCount = 1;
        int currentSum = 0;

        for (int value : A) {
            if (currentSum + value > tempRight) {
                blockCount++;
                currentSum = value;
                if (blockCount > K) {
                    return false;
                }
            } else {
                currentSum += value;
            }
        }

        return true;
    }
}
