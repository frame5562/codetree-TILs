import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nt = sc.nextLine().split(" ");
        
        int n = Integer.parseInt(nt[0]); // 한 줄에 들어오는 정수의 개수
        int t = Integer.parseInt(nt[1]);
        
        String[] a = sc.nextLine().split(" ");
        String[] b = sc.nextLine().split(" ");
        
        // 교환하기
        
        while(t-- > 0) {
        	
        	String temp = a[n-1];
        	for(int i=n-1; i>0; i--) a[i] = a[i-1];
        	a[0] = b[n-1];
        	
        	for(int i=n-1; i>0; i--) b[i] = b[i-1];
        	b[0] = temp;
        	
        }
        
        for(int i=0; i<n; i++) System.out.printf(a[i] + " ");

        System.out.println();
        
        for(int i=0; i<n; i++) System.out.printf(b[i] + " ");
        
    }
}