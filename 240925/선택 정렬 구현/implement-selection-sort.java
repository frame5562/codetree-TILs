import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Main {
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		String[] str = br.readLine().split(" ");
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(str[i]);
		}
		
		// 선택정렬로 정렬하기
		for(int i=0; i<n; i++) {
			int min = i;
			
			for(int j=i+1; j<n; j++) {
				if(arr[j] < arr[min]) {
					min = j;
					
				}
			}
			
			int temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
		}
		
		
		// print
		for(int a: arr) {
			System.out.print(a + " ");
		}

	}
}