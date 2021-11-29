import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prac5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        int[] k = new int[testCase];
        int[] n = new int[testCase];
        int[] answer = new int[testCase];
        for(int i = 0; i < testCase; i++) {
            k[i] = Integer.parseInt(br.readLine());
            n[i] = Integer.parseInt(br.readLine());
            int sum = 0;
            for(int j = 0; j < k[i]; j++) {
                for(int z = 0; z < n[i]; z++) {
                    sum += z + 1;
                }
            }
            answer[i] = sum;
        }
        for(int i = 0; i < testCase; i++) {
            System.out.println(answer[i]);
        }
    }

    public static int selfSol(int k, int n) {
        if(k == 0) return n;
        for(int i = 0; i < k; i++) {
            for(int j = 0; j < n; j++) {
                
            }
        }
    }
}
