import java.util.Scanner;

public class Main {
    public static final int MAX_N = 100;
    
    public static int n, m, k;
    public static int[][] grid = new int[MAX_N][MAX_N];
    
    // 해당 row에 [colS, colE] 열에
    // 전부 블럭이 없는지를 확인합니다.
    public static boolean allBlank(int row, int colS, int colE) {
        for(int col = colS; col <= colE ; col++)
            if(grid[row][col] > 0)
                return false;
    
        return true;
    }
    
    // 최종적으로 도달하게 될 위치는
    // 그 다음 위치에 최초로 블럭이 존재하는 순간임을 이용합니다.
    public static int getTargetRow() {
        for(int row = 0; row < n - 1; row++)
            // allBlank 가 false 일 때, 즉 더이상 움직일 수 없는 상황
            // 0번째 줄에서 시작하므로 검사대상은 row+1 번째가 되어야 한다.
            if(!allBlank(row + 1, k, k + m - 1))
                return row;
    
        // for-if 조건에 걸리지 않는 경우, 가장 마지막까지 도달할 수 있음을 의미한다.
        return n - 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 격자 크기
        m = sc.nextInt(); // 블록크기 => 1*m 사이즈
        k = sc.nextInt(); // 블럭이 떨어질 위치
        k--;
        
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        // ... 입력값 받기
        
        // 최종적으로 멈추게 될 위치를 구합니다. (x 의 위치)
        int targetRow = getTargetRow();
        

        // 최종 위치에 전부 블럭을 표시합니다.
        for(int col = k; col < k + m; col++)
            grid[targetRow][col] = 1;
        

        // 출력
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++)
                System.out.print(grid[i][j] + " ");
            System.out.println();
        }
    }
}