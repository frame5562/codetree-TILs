import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int n;
    public static int r, c; // 현재 위치를 의미합니다.
    public static int[][] grid;

    // 범위가 격자 안에 들어가는지 확인합니다.
    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    // 범위가 격자 안이고, 해당 위치의 값이 더 큰지 확인합니다.
    public static boolean canGo(int x, int y, int currNum) {
        return inRange(x, y) && grid[x][y] > currNum;
    }

    public static boolean simulate() {
        int[] dx = new int[]{-1, 1,  0, 0};
        int[] dy = new int[]{ 0, 0, -1, 1};

        // 각각의 방향에 대해 나아갈 수 있는 곳이 있는지 확인합니다.
        for(int i = 0; i < 4; i++) {
            int nextX = r + dx[i];
            int nextY = c + dy[i];

            // 갈 수 있는 곳이라면
            // 이동하고 true를 반환합니다.
            if(canGo(nextX, nextY, grid[r][c])) {
                r = nextX;
                c = nextY;
                return true;
            }
        }

        // 움직일 수 있는 곳이 없었다는 의미
        return false;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력:
        String[] nrc = br.readLine().split(" ");
        n = Integer.parseInt(nrc[0]);
        r = Integer.parseInt(nrc[1])-1;
        c = Integer.parseInt(nrc[2])-1;
        grid = new int[n][n];

        for(int i = 0; i < n; i++) {
        	String[] row = br.readLine().split(" ");
        	for(int j=0; j<n; j++) {
        		grid[i][j] = Integer.parseInt(row[j]);
        	}
        }

        // 초기 위치에 적혀있는 값을 답에 넣어줍니다.
        System.out.print(grid[r][c] + " ");

        while(true) {
            // 조건에 맞춰 움직여봅니다.
            boolean greaterNumberExist = simulate();

            // 인접한 곳에 더 큰 숫자가 없다면 종료합니다.
            if(!greaterNumberExist) break;
            
            // 출력
            System.out.print(grid[r][c] + " ");
        }

    }
}