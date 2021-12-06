import java.util.*;
/*
124 나라가 있습니다. 124 나라에서는 10진법이 아닌 다음과 같은 자신들만의 규칙으로 수를 표현합니다.

124 나라에는 자연수만 존재합니다.
124 나라에는 모든 수를 표현할 때 1, 2, 4만 사용합니다.
예를 들어서 124 나라에서 사용하는 숫자는 다음과 같이 변환됩니다.

    10진법	124 나라	10진법	124 나라
    1	    1	        6	    14
    2	    2	        7	    21
    3	    4	        8	    22
    4	    11	        9	    24
    5	    12	        10	    41
자연수 n이 매개변수로 주어질 때, n을 124 나라에서 사용하는 숫자로 바꾼 값을 return 하도록 solution 함수를 완성해 주세요.
*/

public class Programers13_124나라의숫자 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        String[] output = new String[input.length];
        for(int i = 0; i < input.length; i++) {
            output[i] = sol.solution(input[i]);
            System.out.println(input[i] + " : " + output[i]);
        }

    }
    
    static class Solution {
        public String solution(int n) {
            StringBuilder sb = new StringBuilder();
            while(n != 0) {
                if(n % 3 != 0) {
                    sb.insert(0, String.valueOf(n % 3));
                    n = n / 3;
                }else {
                    sb.insert(0, "3");
                    n = (n - 3) / 3;
                }
            }
            String answer = sb.toString();
            answer = answer.replace("3", "4");
            return answer;
        }
    }
}
