import java.util.ArrayList;
import java.util.List;

/*
입력은 조건의 개수를 나타내는 정수 n과 n개의 원소로 구성된 문자열 배열 data로 주어진다. 
data의 원소는 각 프렌즈가 원하는 조건이 N~F=0과 같은 형태의 문자열로 구성되어 있다. 제한조건은 아래와 같다.

1 <= n <= 100
data의 원소는 다섯 글자로 구성된 문자열이다. 각 원소의 조건은 다음과 같다.

첫 번째 글자와 세 번째 글자는 다음 8개 중 하나이다. {A, C, F, J, M, N, R, T} 각각 어피치, 콘, 프로도, 제이지, 무지, 네오, 라이언, 튜브를 의미한다. 
첫 번째 글자는 조건을 제시한 프렌즈, 세 번째 글자는 상대방이다. 첫 번째 글자와 세 번째 글자는 항상 다르다.

두 번째 글자는 항상 ~이다.

네 번째 글자는 다음 3개 중 하나이다. {=, <, >} 각각 같음, 미만, 초과를 의미한다.

다섯 번째 글자는 0 이상 6 이하의 정수의 문자형이며, 조건에 제시되는 간격을 의미한다. 이때 간격은 두 프렌즈 사이에 있는 다른 프렌즈의 수이다.
*/

public class Programers8_단체사진 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nfriends = {2, 2};
        String[][] strfriends = {{"N~F=0", "R~T>2"}, {"M~C<2", "C~M>1"}};
        int[] output = new int[2];
        for(int i = 0; i < nfriends.length; i++) {
            output[i] = sol.solution(nfriends[i], strfriends[i]);
            System.out.println(output[i]);
        }
        
    }
    
    static class Solution {
        static int cnt = 0;
        static String[] data;
        StringBuffer friends = new StringBuffer("ACFJMNRT");
        public int solution(int n, String[] data) {
            cnt = 0;
            int answer = 0;
            Solution.data = data;
            doPerm(friends, 0);
            
            answer = cnt;
            return answer;
        }
        private static void doPerm(StringBuffer str, int index){
            if(index == str.length()) {
                boolean cond = true;
                for(int i = 0; i < data.length; i++) {
                    char me = data[i].charAt(0);
                    char you = data[i].charAt(2);
                    char condition = data[i].charAt(3);
                    int dist = data[i].charAt(4) - '0';
                    String rstr = str.toString();
                    switch (condition) {
                        case '=':
                            if(Math.abs(rstr.indexOf(me) - rstr.indexOf(you)) != dist + 1) cond = false;
                            break;
                        case '>':
                            if(Math.abs(rstr.indexOf(me) - rstr.indexOf(you)) <= dist + 1) cond = false;
                            break;
                        case '<':
                            if(Math.abs(rstr.indexOf(me) - rstr.indexOf(you)) >= dist + 1) cond = false;
                            break;
                    }
                }
                if(cond)
                    cnt++;
            }
            else { //recursively solve this by placing all other chars at current first pos
                doPerm(str, index+1);
                for (int i = index+1; i < str.length(); i++) {//start swapping all other chars with current first char
                    swap(str,index, i);
                    doPerm(str, index+1);
                    swap(str,i, index);//restore back my string buffer
                }
            }
        }
        private  static void swap(StringBuffer str, int pos1, int pos2){
            char t1 = str.charAt(pos1);
            str.setCharAt(pos1, str.charAt(pos2));
            str.setCharAt(pos2, t1);
        }
    }
    
}
