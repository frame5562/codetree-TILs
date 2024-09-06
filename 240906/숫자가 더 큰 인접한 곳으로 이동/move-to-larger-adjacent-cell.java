import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    
    static int N, r, c;
    static int[][] grid;
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] nrc = br.readLine().split(" ");
        N = Integer.parseInt(nrc[0]);
        r = Integer.parseInt(nrc[1])-1; 
        c = Integer.parseInt(nrc[2])-1;
        
        grid = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(row[j]);
            }
        }
        
        System.out.print(grid[r][c] + " ");

        while(true){
            boolean aa = searchBigNum();

            if(!aa) break;

            System.out.print(grid[r][c] + " ");
        }
        //searchBigNum();
    }
    
    public static boolean searchBigNum() {
        // 상/하/좌/우 탐색
        int[] dxs = {-1, 1, 0, 0};
        int[] dys = {0, 0, -1, 1};

        for(int i=0; i<4; i++){
            int nx = r + dxs[i];
            int ny = c + dys[i]; 

            if(canGo(nx, ny, grid[r][c])){
                r = nx;
                c = ny;

                //System.out.print(grid[r][c] + " ");
                return true;
            }
        }

        return false;
    }

    public static boolean canGo(int x, int y, int currNum){
        return isRange(x, y) && grid[x][y] > currNum;
    }
    
    public static boolean isRange(int x, int y){
        return 1 <= x && x<=N && 1<= y && y<= N;
    }
}