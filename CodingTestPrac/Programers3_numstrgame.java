import java.util.Scanner;

public class Programers3_numstrgame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Solution sol = new Solution();
        int result = sol.solution(input);
        System.out.println(result);
        sc.close();
    }
    static class Solution {
        public int solution(String s) {
            int answer = 0;
            String[] numbers = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
            String[] strs = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
            for(int i = 0; i < strs.length; i++) {
                s = s.replaceAll(strs[i], numbers[i]);
            }
            answer = Integer.parseInt(s);
            return answer;
        }
    }
}
