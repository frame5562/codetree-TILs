import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		
		int N = Integer.parseInt(br.readLine());
		int[][] grid = new int[N][N];
		
		for(int i=0; i<N; i++) {
			String[] row = br.readLine().split(" ");
			for(int j=0; j<N; j++) grid[i][j] = Integer.parseInt(row[j]);
		}
		
		
		String[] boom = br.readLine().split(" ");
		int x = Integer.parseInt(boom[0])-1;
		int y = Integer.parseInt(boom[1])-1;
		
		// 과정
		int size = grid[x][y] -1; // size 만큼 상하좌우로 뻗어나간다.
		grid[x][y] = 0; // 우선 대상값을 0 으로 변경한다.
		
		int[] dxs = {0, -1, 0, 1};
		int[] dys = {-1, 0, 1, 0};
		
		// 상하좌우 총 4 방향을 하나씩 돌아가며 진행합니다.
		for(int i=0; i<4; i++) {
			int nx = x + dxs[i];
			int ny = y + dys[i];
			
			for(int j=0; j<size; j++) {
				if(nx < 0 || ny <0 || nx >= N || ny >= N) continue;

				grid[nx][ny] = 0;
				
				nx += dxs[i];
				ny += dys[i];
			}
		}
		

		// 열(col) 을 기준으로 탐색하며 0이 발견 될 경우 상단에 있는 값을 가져오고, 그 위치에는 0으로 대입합니다.
		for(int i=0; i<N; i++) {
			for(int j=N-1; j>=0; j--) {

				if(grid[j][i] == 0 && (j-1 >= 0)) {
					grid[j][i] = grid[j-1][i];
					grid[j-1][i] = 0;
				}
			}
		}

		
		
		// 출력
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
		
		

	}
}