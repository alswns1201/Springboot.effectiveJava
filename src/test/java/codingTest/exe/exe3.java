package codingTest.exe;

public class exe3 {

    public static void main(String[] args) {
        int N = 2; // Number of rows
        String S = "1A 2F 1C"; // Reserved seats list

        // Call the solution method and print the result
        int result = solution(N, S);
        System.out.println(result); // Expected output should be 2
    }

    public static int solution(int N, String S) {
        boolean[][] seats = new boolean[N][10];
        String[] reserved = S.split(" ");

        // Process reserved seats and mark them as occupied (true)
        for (String seat : reserved) {
            int row = Integer.parseInt(seat.substring(0, seat.length() - 1)) - 1;
            char column = seat.charAt(seat.length() - 1);
            seats[row][columnToIndex(column)] = true; // Mark as reserved
        }

        int count = 0;

        // Count available 4-seat families in each row
        for (int i = 0; i < N; i++) {
            count += counting(seats[i]);
        }

        return count;
    }

    private static int counting(boolean[] seats) {
        int count = 0;

        // Check all possible 4-seat groups in the row
        for (int i = 0; i <= 6; i++) { // Start index for a group of 4 seats
            if (canPlaceFamily(seats, i)) {
                count++;
            }
        }

        return count;
    }

    private static boolean canPlaceFamily(boolean[] row, int start) {
        // Check if 4 consecutive seats starting from 'start' are all available (false)
        for (int i = start; i < start + 4; i++) {
            if (row[i]) { // If any seat in the group is occupied
                return false;
            }
        }
        return true;
    }

    // Convert seat column letter to index (A=0, B=1, ..., J=9)
    private static int columnToIndex(char column) {
        return column - 'A';
    }
}