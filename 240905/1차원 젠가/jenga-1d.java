import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		
		int n = Integer.parseInt(br.readLine());
		int cnt = n;
		int[] arr = new int[n];
		int[] copy = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
	
		for(int i=0; i<2; i++) {
			String[] se = br.readLine().split(" ");
			int start = Integer.parseInt(se[0])-1;
			int end = Integer.parseInt(se[1])-1;
			
			int idx = 0;
			for(int j=0; j<n; j++) {
				if(j >= start && j <= end) continue;
				copy[idx++] = arr[j];
			}

			cnt -= (end-start+1);
			arr = Arrays.copyOf(copy, copy.length);
		}
		
		// 출력
		System.out.println(cnt);
		
		for(int a: arr) {
			if(a == 0) break;
			System.out.println(a);
		}

	}

}