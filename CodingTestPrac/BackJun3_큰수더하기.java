import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJun3_큰수더하기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);
        String a = st.nextToken();
        String b = st.nextToken();
        String big = a.length() >= b.length() ? a : b;
        String small = big == b ? a : b;
        int[] bigArr = new int[big.length()];
        int[] smallArr = new int[small.length()];
        for(int i = 0; i < bigArr.length; i++) {
            bigArr[bigArr.length - 1 - i] = big.charAt(i) - '0';
        }
        for(int i = 0; i < small.length(); i++) {
            smallArr[smallArr.length - 1 - i] = small.charAt(i) - '0';
        }
        boolean ten = false;
        StringBuilder answerSb = new StringBuilder();
        for(int i = 0; i < smallArr.length; i++) {
            int temp = smallArr[i] + bigArr[i];
            if(ten) {
                temp++;
                ten = false;
            }
            if(temp >= 10) {
                ten = true;
                temp -= 10;
            }
            answerSb.insert(0, String.valueOf(temp));
        }
        if(smallArr.length == bigArr.length && ten) {
            answerSb.insert(0, String.valueOf(1));
        }
        for(int i = smallArr.length; i < bigArr.length; i++) {
            int temp = bigArr[i];
            if(ten) {
                temp++;
                ten = false;
            }
            if(temp >= 10) {
                ten = true;
                temp -= 10;
            }
            answerSb.insert(0, String.valueOf(temp));
            if(ten && i == bigArr.length - 1) {
                answerSb.insert(0, String.valueOf(1));
            }
        }
        System.out.println(answerSb.toString());
    }
}
