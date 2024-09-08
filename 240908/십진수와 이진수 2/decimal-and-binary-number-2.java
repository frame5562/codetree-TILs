import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        // 2 To 10
        n = Integer.parseInt(String.valueOf(n), 2) * 17;

        // 10 To 2
        String ans = Integer.toBinaryString(n);

        System.out.println(ans);
    }
}