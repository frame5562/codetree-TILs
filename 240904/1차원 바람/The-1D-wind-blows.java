import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	static int n,m, q;
	static int[][] arr;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
    public static void main(String[] args) throws IOException {
    	
        String[] nmq = br.readLine().split(" ");
        
        n = Integer.parseInt(nmq[0]); // 행렬 크기
        m = Integer.parseInt(nmq[1]); // 행렬 크기
        q = Integer.parseInt(nmq[2]); // 바람이 불어온 횟수
        arr = new int[n][m];

        // 입력값 받기
        for(int i=0; i<n; i++) {
        	String[] row = br.readLine().split(" ");
        	for(int j=0; j<m; j++) arr[i][j] = Integer.parseInt(row[j]);
        }
        
        
        // 함수 호출 : 바람의 방향 값을 입력받고, shift 연산을 하는 함수를 호출합니다.
        for(int i=0; i<q; i++) {
        	String[] ld = br.readLine().split(" ");
        	int line = Integer.parseInt(ld[0])-1; // 0번째 인덱스 값을 1번째 줄로 인식해야하기 때문

        	// 최초 1회는 무조건 sihif 기능 수행
        	shiftMethod(null, line, ld[1]);

        	// 이후 위+아래로 이동하며 수행
        	String dirc = ld[1].equals("L") ? "R" : "L";
        	checkSameValue("up", line-1, dirc); // 위쪽검사 기준 line 을 지정 (올라갈 수록 index 는 작아짐)
        	checkSameValue("down", line+1, dirc);
        }

        
        // 출력
        for(int i=0; i<n; i++) {
        	for(int j=0; j<m; j++) {
        		System.out.print(arr[i][j] + " ");
        	}
        	System.out.println();
        }
    }
    

    // 기준 row 에서 위 혹은 아래와 비교하여 전파 가능한 상태인지 확인하기
	private static void checkSameValue(String updown, int line, String dirc) {

		if(line < 0 || line >= n) return;
		
		// 새롭게 받은 
		if(updown.equals("up")) {
			// line -1 한 줄의 값과 동일한 값이 있는지
			for(int i=0; i<m; i++) {
				if(arr[line][i] == arr[line+1][i]) { // 기준값 == 원래비교대상
					shiftMethod(updown, line, dirc);
					break;
				}
			}
		}else {
			// line +1 한 줄과 같은 값이 있는지
			for(int i=0; i<m; i++) {
				if(arr[line][i] == arr[line-1][i]) {
					shiftMethod(updown, line, dirc);
					break;
				}
			}
		}
		
	}
	
	
	private static void shiftMethod(String updown, int line, String dirc) {
		if(dirc.equals("R")) {
			// 바람방향: 왼쪽 <- 오론쪽
			int temp = arr[line][0];
			for(int i=0; i<m-1; i++) arr[line][i] = arr[line][i+1];
			arr[line][m-1] = temp;
		}else {
			// 바람방향: 왼쪽 -> 오른쪽
			int temp = arr[line][m-1];
			for(int i=m-1; i>0; i--) arr[line][i] = arr[line][i-1];
			arr[line][0] = temp;
		}
		
		
		dirc = dirc.equals("L") ? "R" : "L";
		if(updown == null) {
			return;
		}else if(updown.equals("up")) {
			checkSameValue(updown, line-1, dirc);
		}else {
			checkSameValue(updown, line+1, dirc);
		}
	}


}