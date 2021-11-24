import java.util.Scanner;

public class Prac4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        sc.nextLine();
        int[] h = new int[testCase];
        int[] w = new int[testCase];
        int[] n = new int[testCase];
        String[] answer = new String[testCase];
        for(int i = 0 ; i < testCase; i++) {
            h[i] = sc.nextInt();
            w[i] = sc.nextInt();
            n[i] = sc.nextInt();
            sc.nextLine();
            answer[i] = solution(h[i], n[i]);
        }
        for(int i = 0 ; i < testCase; i++) {
            System.out.println(answer[i]);
        }

        sc.close();
    }
    static String solution(int h, int n) {
        int yy = n % h;
        int xx = n / h + 1;
        return String.format("%d%02d",yy,xx);
    }
}
