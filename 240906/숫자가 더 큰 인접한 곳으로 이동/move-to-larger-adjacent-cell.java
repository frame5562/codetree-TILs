import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	static int N, r, c;
	static int[][] grid;
	
	public static void main(String[] args) throws Exception {
		
		// 우선순위 : 상/하/좌/우
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] nrc = br.readLine().split(" ");
		N = Integer.parseInt(nrc[0]);
		r = Integer.parseInt(nrc[1])-1; // 행렬시작위치는 -1 을 해주어야 계산하기 편함
		c = Integer.parseInt(nrc[2])-1;
		
		grid = new int[N][N];
		for(int i=0; i<N; i++) {
			String[] row = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				grid[i][j] = Integer.parseInt(row[j]);
			}
		}

		
		System.out.print(grid[r][c] + " ");
		searchBigNum();
	}

	public static void searchBigNum() {
		// 탐색 진행
		int[] dxs = {-1, 1, 0, 0};
		int[] dys = {0, 0, -1, 1};
		int i = 0;
		int cnt = 0; //4방향 탐색 후에도 더 큰 값을 찿지 못한 경우
		
		while(true) {
			
			int nx = r + dxs[i];
			int ny = c + dys[i];
			
	
			if(cnt == 4) break;
			
			if(nx < 0 || ny < 0 || nx >= N || ny >= N) {
				i = (i+1)%4;
				continue;
			}
			
			if(grid[r][c] < grid[nx][ny]) {
				System.out.print(grid[nx][ny] + " ");
				r = nx;
				c = ny;
				i = 0;
				cnt = 0;
				
				continue;
			}else {
				cnt ++;
				i = (i+1)%4; // 방향이동
			}
			
		}
		
	}


}