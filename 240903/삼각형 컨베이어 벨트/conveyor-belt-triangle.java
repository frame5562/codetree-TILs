import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
	
	public static Integer[] basket;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] nt = br.readLine().split(" ");
		int N = Integer.parseInt(nt[0]); // 각 변에 있는 숫자 개수 
		int T = Integer.parseInt(nt[1]); // 움직이는 시간
		
		int[] l = new int[N];
		int[] r = new int[N];
		int[] d = new int[N];
		

		String[] row = br.readLine().split(" ");
		for(int i=0; i<N; i++) l[i] = Integer.parseInt(row[i]);
		
		row = br.readLine().split(" ");
		for(int i=0; i<N; i++) r[i] = Integer.parseInt(row[i]);
		
		row = br.readLine().split(" ");
		for(int i=0; i<N; i++) d[i] = Integer.parseInt(row[i]);
		
		
		
		// 계산식
		while(T-- > 0) {
			// l 완성하기
			int temp = l[N-1];
			for(int i=N-1; i>=1; i--) l[i] = l[i-1];
			l[0] = d[N-1];
			
			// r 완성하기
			int temp2 = r[N-1];
			for(int i=N-1; i>=1; i--) r[i] = r[i-1];
			r[0] = temp;
			
			// d 완성하gi
			for(int i=N-1; i>=1; i--) d[i] = d[i-1];
			d[0] = temp2;
		}
				
		
		// 출력
		for(int i=0; i<N; i++) System.out.print(l[i] + " ");
		System.out.println();

		for(int i=0; i<N; i++) System.out.print(r[i] + " ");
		System.out.println();

		for(int i=0; i<N; i++) System.out.print(d[i] + " ");
		System.out.println();
		

		
	}

}