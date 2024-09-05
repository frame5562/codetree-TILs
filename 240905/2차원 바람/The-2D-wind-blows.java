import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

			
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int r1, c1, r2, c2;

		String[] nmq = br.readLine().split(" ");
		int N = Integer.parseInt(nmq[0]);
		int M = Integer.parseInt(nmq[1]);
		int Q = Integer.parseInt(nmq[2]);
		int[][] grid = new int[N][M];
		int[][] grid2 = new int[N][M];
		
		for(int i=0; i<N; i++) {
			String[] row = br.readLine().split(" ");
			
			for(int j=0; j<M; j++) {
				grid[i][j] = Integer.parseInt(row[j]);
				grid2[i][j] = Integer.parseInt(row[j]);;
			}
		}
		

		// 바람이 불어올 직사각형 영역 : r1, c1, r2, c2
		// 이때 각 값들의 시작은 1이므로, -1을 해주어야 한다.
		String[] row = br.readLine().split(" ");
		r1 = Integer.parseInt(row[0])-1;
		c1 = Integer.parseInt(row[1])-1;
		r2 = Integer.parseInt(row[2])-1;
		c2 = Integer.parseInt(row[3])-1;
		
		// 1.테두리 시계방향 회전
		// 위, 아래 먼저 회전해주고 값 두개만 백업, 이후 양 쪽 변 움직이기
		
		// Temp Value
		int topRight = grid[c1][c2];
		int bottomLeft = grid[r2][r1];
		
		
		// Top(왼쪽 <- 오른쪽 방향으로 채워나간다)
		for(int i=c2; i>r1; i--) {
			grid[r1][i] = grid[r1][i-1];
		}

		// Bottom
		for(int i=r1; i<c2; i++) {
			grid[r2][i] = grid[r2][i+1];
		}

		// Right
		for(int i=r2; i>c1+1; i--) {
			grid[i][c2] = grid[i-1][c2];
		}
		grid[c1+1][c2] = topRight;

		
		for(int i=r1; i<r2-1; i++) {
			grid[i][c1] = grid[i+1][c1];
		}
		grid[r2-1][c1] = bottomLeft;
		


		// 2. 주변 평균 합계 구하기 (테두리가 아닌 작사각형 영역내 모든 숫자)
		// 인접 영역의 합계평균을 구하기 위한 dx, dy
		int[] dxs = {-1, 0, 1, 0};
		int[] dys = {0, -1, 0, 1};
		
		for(int i=r1; i<=r2; i++) {
			for(int j=c1; j<=c2; j++) {
				
				// 현재칸 숫자+인접칸 숫자의 평균값
				int sum = grid[i][j];
				int cnt = 1;
				for(int k=0; k<4; k++) {
					int nx = i + dxs[k];
					int ny = j + dys[k];
					
					if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
					
					sum += grid[nx][ny];
					cnt++;
				}
				

				// 합계 평균으로 값 변경
				grid2[i][j] = sum/cnt;
				
			}
		}
		
		

		// 출력
		for(int[] a: grid2) {
			for(int b: a) System.out.print(b + " ");
			System.out.println();
		}
		
		
	}

}