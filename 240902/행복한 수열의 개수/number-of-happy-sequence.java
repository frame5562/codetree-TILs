import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] temp = sc.nextLine().split(" ");
        
        int answer = 0;
        int n = Integer.parseInt(temp[0]);
        int m = Integer.parseInt(temp[1]);
        int[][] arr = new int[n][n];

        // 입력값 받기
        for(int i=0; i<n; i++){
            String[] row = sc.nextLine().split(" ");
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(row[j]);
            }
        }

        /* 행복한 수열 찾기 */
        if(n == 1){
            System.out.println(2);
        }else{

        // 가로로만 탐색하기
        for(int i=0; i<n; i++){
            int cnt = 1;
            for(int j=1; j<n; j++){
                if(arr[i][j-1] == arr[i][j]){
                    cnt++;
                }else{
                    cnt=1;
                }
                
                // 만약 행복한 수열이라면 중단
                if(cnt == m){
                    answer++;
                    break;
                }
            }
        }

        // 세로로 탐색하기
        for(int i=0; i<n; i++){
            int cnt = 1;
            for(int j=1; j<n; j++){
                if(arr[j-1][i] == arr[j][i]){
                    cnt++;
                }else{
                    cnt = 1;
                }

                // 만약 행복한 수열이라면 중단
                if(cnt == m){
                    answer++;
                    break;
                }

            }
        }

        System.out.println(answer);
        }


    }
}