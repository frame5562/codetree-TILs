import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static int n, m;
	public static int[][] grid;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// input 받기
		String[] nm = br.readLine().split(" ");
		n = Integer.parseInt(nm[0]);
		m = Integer.parseInt(nm[1]);
		
		grid = new int[n][m];
		for(int i=0; i<n; i++) {
			String[] row = br.readLine().split(" ");
			for(int j=0; j<m; j++) {
				grid[i][j] = Integer.parseInt(row[j]);
			}
		}
		
		
		// 함수로 만들어서 관리
		int answer = 0;
		
		// 모든 격자의 위치에 대하여 검사
		// 단, 범위가 벗어나더라도 함수문에서 판단하여 중단하므로, 문제가 되지 않음
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				answer = Math.max(answer, getMaxSum(i, j));
			}
		}
		
		
		System.out.println(answer);
	}

	
	// 표현 가능한 블럭의 모양을 모두 저장한 3차원 배열
	public static int[][][] block = new int[][][] {
        {{1, 1, 0},
        {1, 0, 0},
        {0, 0, 0}},
    
        {{1, 1, 0},
        {0, 1, 0},
        {0, 0, 0}},
    
        {{1, 0, 0},
        {1, 1, 0},
        {0, 0, 0}},
    
        {{0, 1, 0},
        {1, 1, 0},
        {0, 0, 0}},
    
        {{1, 1, 1},
        {0, 0, 0},
        {0, 0, 0}},
    
        {{1, 0, 0},
        {1, 0, 0},
        {1, 0, 0}},
    };
    
	private static int getMaxSum(int x, int y) {
		
		int maxValue = 0;
		
		// for: 블럭 크기만큼 전부
		for(int i=0; i<block.length; i++) {
			boolean isPossible = true;
			int sum = 0;
			
			for(int dx=0; dx<3; dx++) {
				for(int dy=0; dy<3; dy++) {
					// 0위치에 있는경우는 바로 다음 위치로
					if(block[i][dx][dy] == 0) continue;
					
					// 범위를 벗어나는 경우 false
					if(x+dx >=n || y+dy >= m) isPossible = false;
					else sum += grid[x+dx][y+dy];
				}
				
			}
			
			// for 끝 => 하나의 블럭 검사가 끝났다는 의미
			if(isPossible)
				maxValue = Math.max(maxValue, sum);
		}
		
		return maxValue;
	}
}