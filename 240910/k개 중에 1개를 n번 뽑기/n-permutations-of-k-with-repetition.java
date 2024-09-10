import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] numbers;
    static boolean[] isSelected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");
        N = Integer.parseInt(nm[0]);
        M = Integer.parseInt(nm[1]);
        numbers = new int[M];
        isSelected = new boolean[N+1];

        dfs(0);
    }

    public static void dfs(int cnt){

        // 기저부분
        if(cnt == M) {
            for(int i=0; i<numbers.length; i++){
                System.out.print(numbers[i] + " ");
            }
            System.out.println();
            return;
        }

        // 유도 부분
        for(int i=1; i<=N; i++){
            if(isSelected[i]) continue;

            numbers[cnt] = i;
            isSelected[cnt] = true;
            dfs(cnt+1);
            isSelected[cnt] = false;
        }
    }
}