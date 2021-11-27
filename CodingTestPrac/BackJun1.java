import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BackJun1 {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int testCaseNum = sc.nextInt();
        sc.nextLine();
        sc.close();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < testCaseNum; i++) {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            String nums_str = br.readLine();
            StringTokenizer st = new StringTokenizer(nums_str);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = a + b;
            bw.write(c + "\n");
            bw.flush();
            bw.close();
        }
    }
}
