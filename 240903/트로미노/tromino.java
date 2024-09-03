import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().split(" ");
        int n = Integer.parseInt(arr[0]);
        int m = Integer.parseInt(arr[1]);

        int[][] grid = new int[n][m];

        for(int i=0; i<n; i++){
            String[] temp = sc.nextLine().split(" ");
            for(int j=0; j<m; j++){
                grid[i][j] = Integer.parseInt(temp[j]);
            }
        }


        System.out.println(getMaxSum(grid));
    }

    public static int getMaxSum(int[][] grid) {
        int maxSum = 0;
        int n = grid.length;
        int m = grid[0].length;

        // 1x3 블록 체크
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m - 2; j++) {

                // 가로 블럭
                int sum = grid[i][j] + grid[i][j + 1] + grid[i][j + 2];
                maxSum = Math.max(maxSum, sum);

                // 세로 블럭
                sum = grid[j][i] + grid[j+1][i] + grid[j+2][i];
                maxSum = Math.max(maxSum, sum);
            }
        }

        // ㄴ 모양 블록 체크 (4가지 형태)
        int[][][] lShapes = {
            {{0,0}, {1,0}, {1,1}}, // 기본
            {{1,0}, {1,1}, {0,1}}, // 90도
            {{1,1}, {0,1}, {0,0}}, // 180도
            {{0,1}, {0,0}, {1,0}}  // 270도
        };

        for (int[][] shape : lShapes) {
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < m - 1; j++) {
                    int sum = 0;
                    for (int[] pos : shape) {
                        int x = i + pos[0];
                        int y = j + pos[1];
                        if (x < n && y < m) {
                            sum += grid[x][y];
                        }
                    }
                    maxSum = Math.max(maxSum, sum);
                }
            }
        }

        return maxSum;
    }
}