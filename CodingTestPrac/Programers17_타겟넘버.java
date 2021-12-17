/*
문제 설명
n개의 음이 아닌 정수가 있습니다. 이 수를 적절히 더하거나 빼서 타겟 넘버를 만들려고 합니다. 예를 들어 [1, 1, 1, 1, 1]로 숫자 3을 만들려면 다음 다섯 방법을 쓸 수 있습니다.

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3
사용할 수 있는 숫자가 담긴 배열 numbers, 타겟 넘버 target이 매개변수로 주어질 때 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 return 하도록 solution 
함수를 작성해주세요.

제한사항
주어지는 숫자의 개수는 2개 이상 20개 이하입니다.
각 숫자는 1 이상 50 이하인 자연수입니다.
타겟 넘버는 1 이상 1000 이하인 자연수입니다.
*/

public class Programers17_타겟넘버 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] inputNumbers = {1, 1, 1, 1, 1};
        int inputTarget = -5;
        int output = sol.solution(inputNumbers, inputTarget);
        System.out.println(output);
    }
    static class Solution {
        static int[] stNums;
        static int stTarget;
        static int cnt = 0;
        public int solution(int[] numbers, int target) {
            int answer = 0;
            stNums = numbers;
            stTarget = target;
            boolean[] pm = new boolean[numbers.length];
            shake(pm, 0);
            answer = cnt;
            return answer;
        }
        static void shake(boolean[] pm, int depth) {
            if(depth == pm.length) {
                int sum = 0;
                for(int i = 0; i < pm.length; i++) {
                    if(pm[i]) {
                        sum += stNums[i];
                    }else {
                        sum -= stNums[i];
                    }
                }
                if(sum == stTarget) {
                    cnt++;
                }
                return;
            }
            for(int i = 0; i < 2; i++) {
                if(i == 0) {
                    pm[depth] = true;
                    shake(pm, depth + 1);
                }else {
                    pm[depth] = false;
                    shake(pm, depth + 1);
                }
            }
        }
    }
}
