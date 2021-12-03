public class Programers9_없는숫자더하기 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] input = {{1,2,3,4,6,7,8,0}, {5,8,4,0,6,7,9}};
        for(int[] indinput : input) {
            int sum = sol.solution(indinput);
            System.out.println(sum);
        }
    }
    static class Solution {
        public int solution(int[] numbers) {
            int answer = 0;
            int[] tonine = new int[10];
            for(int i = 0; i < numbers.length; i++) {
                int idx = numbers[i];
                tonine[idx]++;
            }
            for(int i = 0; i < tonine.length; i++) {
                if(tonine[i] == 0) answer += i;
            }
            return answer;
        }
    }
}
