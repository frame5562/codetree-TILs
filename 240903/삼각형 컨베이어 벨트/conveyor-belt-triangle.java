import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static Integer[] basket;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] nt = br.readLine().split(" ");
		int N = Integer.parseInt(nt[0]); // 각 변에 있는 숫자 개수 
		int T = Integer.parseInt(nt[1]); // 움직이는 시간 

		String arr = "";
		for(int i=0; i<3; i++) {
			String[] row = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				arr += row[j];
			}
		}
				
		// 계산식
		for(int i=0; i<T; i++) {
			arr = arr.charAt(arr.length()-1) + arr.substring(0, arr.length()-1);			
		}
		
		
		// 출력
		int idx = 0;
		for(int i=0; i<3; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(arr.charAt(idx++) + " ");
			}
			System.out.println();
		}
		
	}

}