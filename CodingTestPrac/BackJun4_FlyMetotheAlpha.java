import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BackJun4_FlyMetotheAlpha {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inputNum = Integer.parseInt(br.readLine());
        int[] answer = new int[inputNum];
        for(int i = 0; i < inputNum; i++) {
            String[] line = br.readLine().split(" ");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);
            int mid = (x + y) / 2;
            int v = 0;
            int cnt = 0;
            while(x != y) {
                if(x < mid) x += ++v;
                else if(v > 1) x += --v;
                else x += v;
                cnt++;
            }
            answer[i] = cnt;
        }
        for(int i : answer) {
            System.out.println(i);
        }
    }
}
