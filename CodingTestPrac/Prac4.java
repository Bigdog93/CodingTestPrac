import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prac4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        int[] h = new int[testCase];
        int[] w = new int[testCase];
        int[] n = new int[testCase];
        String[] answer = new String[testCase];
        for(int i = 0; i < testCase; i++) {
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            h[i] = Integer.parseInt(st.nextToken());
            w[i] = Integer.parseInt(st.nextToken());
            n[i] = Integer.parseInt(st.nextToken());
            answer[i] = solution(h[i], n[i]);
        }
        for(int i = 0 ; i < testCase; i++) {
                System.out.println(answer[i]);
            }
    }
    static String solution(int h, int n) {
        int yy = n % h != 0 ? n % h : h;
        int xx = n % h != 0 ? n / h + 1 : n / h;
        return String.format("%d%02d",yy,xx);
    }
}
