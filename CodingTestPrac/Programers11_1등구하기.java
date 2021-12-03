import java.util.Arrays;

public class Programers11_1등구하기 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] input = {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2};
        int[] output = sol.solution(input);
        for(int i = 0; i < output.length; i++) {
            System.out.println(output[i]);
        }
    }
    static class Solution {
        public int[] solution(int[] answers) {
            int[] supoja = new int[3];
            int[] spj1 = {1, 2, 3, 4, 5};
            int[] spj2 = {2, 1, 2, 3, 2, 4, 2, 5};
            int[] spj3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
            int spj1idx = 0;
            int spj2idx = 0;
            int spj3idx = 0;
            for(int i = 0; i < answers.length; i++) {
                if(spj1idx == spj1.length) spj1idx = 0;
                if(spj2idx == spj2.length) spj2idx = 0;
                if(spj3idx == spj3.length) spj3idx = 0;
                if(answers[i] == spj1[spj1idx++]) supoja[0]++;
                if(answers[i] == spj2[spj2idx++]) supoja[1]++;
                if(answers[i] == spj3[spj3idx++]) supoja[2]++;
            }
            int winner = 0;
            for(int i = 0; i < supoja.length; i++) {
                if(winner <= supoja[i]) winner = supoja[i];
            }
            int cnt = 0;
            for(int i = 0; i < supoja.length; i++) {
                if(winner == supoja[i]) cnt++;
            }
            int[] answer = new int[cnt];
            int idx = 0;
            for(int i = 0; i < supoja.length; i++) {
                if(supoja[i] == winner) answer[idx++] = i + 1;
            }
            Arrays.sort(answer);
            
            
            return answer;
        }
    }
}
