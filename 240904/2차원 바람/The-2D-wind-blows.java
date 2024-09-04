import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		
		String[] nmq = br.readLine().split(" ");
		int N = Integer.parseInt(nmq[0]);
		int M = Integer.parseInt(nmq[1]);
		int Q = Integer.parseInt(nmq[2]);
		int[][] grid = new int[N][M];
		
		for(int i=0; i<N; i++) {
			String[] row = br.readLine().split(" ");
			
			for(int j=0; j<M; j++) {
				grid[i][j] = Integer.parseInt(row[j]);
			}
		}
		
		// 인접 영역의 합계평균을 구하기 위한 dx, dy
		int[] dxs = {-1, 0, 1, 0};
		int[] dys = {0, -1, 0, 1};
		
		// 바람이 불어올 직사각형 영역 : r1, c1, r2, c2
		// 이때 각 값들의 시작은 1이므로, -1을 해주어야 한다.
		int[] box = new int[4];
		String[] row = br.readLine().split(" ");
		for(int i=0; i<4; i++) box[i] = Integer.parseInt(row[i])-1;
		
		// 1.테두리 시계방향 회전
		
		
		// 2. 주변 평균 합계 구하
		
		
		// 출력
		for(int[] a: grid) {
			for(int b: a) System.out.print(b + " ");
			System.out.println();
		}
		
		
	}

}