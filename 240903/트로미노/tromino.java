import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// input 받기
		String[] nm = br.readLine().split(" ");
		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);
		
		int[][] grid = new int[n][m];
		for(int i=0; i<n; i++) {
			String[] row = br.readLine().split(" ");
			for(int j=0; j<m; j++) {
				grid[i][j] = Integer.parseInt(row[j]);
			}
		}
		
		
		// 함수로 만들어서 관리
		System.out.println(getMaxSum(grid));
	}

	private static int getMaxSum(int[][] grid) {
		int answer = 0;
		
		// 1*3 블럭 (가로/세로) : 별도로 좌표 정의 필요 없음
		for(int i=0; i<grid.length; i++) {
			for(int j=0; j<grid[0].length-2; j++) { // -2를 하는 이유는 1*3 블러깅므로 +2만큼 초과하기때문
				int rowSum = grid[i][j] + grid[i][j+1] + grid[i][j+2];
				int colSum = grid[j][i] + grid[j+1][i] + grid[j+2][i];
				answer = Math.max(answer, Math.max(rowSum, colSum));
			}
		}

		
		// ㄴ 모양 블럭 : 블럭의 위치? 를 정의하고 사용하기
		int[][][] shapes = {
				{{0,0}, {1,0}, {1,1}}, // 기본
	            {{1,0}, {1,1}, {0,1}}, // 90도
	            {{1,1}, {0,1}, {0,0}}, // 180도
	            {{0,1}, {0,0}, {1,0}}  // 270도	
		};
		
		// int[][] 는 2차원 배열 한줄씩 가져오게 된다.
		for(int[][] arr: shapes) {
			
			// x, y 좌표에 접근할 2중 for문을 추가로 생성한다.
			// 이때 최대값은 -1 을 해주어야한다. (ㄴ 블럭은 row, col 모두 2씩 차지하기 때문)
			for(int i=0; i<grid.length-1; i++) {
				for(int j=0; j<grid[0].length-1; j++) {
					int sum = 0;
					
					for(int[] position: arr) {
						// dx, dy 탐색처럼 기본으로 주어진 i/j 위치에서 ㄴ 모양 블럭만큼 위치를 이동
						int x = i + position[0];
						int y = j + position[1];
						if(x<grid.length && y<grid[0].length) {
							sum += grid[x][y];
						}
					}
					// 하나의 블럭 모양 검사가 끝나면 합계 계산
					answer = Math.max(answer, sum);
					
				}
			}
		}
		
		
		
		return answer;
	}
}