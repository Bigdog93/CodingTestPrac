import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class Programers10_자르고정렬 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] inputArr = {1, 5, 2, 6, 3, 7, 4};
        int[][] inputCom = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int[] output = sol.solution(inputArr, inputCom);
        for(int i : output) {
            System.out.print(i + " ");
        }
    }
    static class Solution {
        public int[] solution(int[] array, int[][] commands) {
            int[] answer = new int[commands.length];
            for(int z = 0 ; z < commands.length; z++) {
                int i = commands[z][0];
                int j = commands[z][1];
                int k = commands[z][2];
                int len = j - i + 1;
                int[] res = new int[len];
                int idx = 0;
                for(int q = i - 1; q < j; q++) {
                    res[idx] = array[q];
                    idx++;
                }
                Arrays.sort(res);
                answer[z] = res[k - 1];
            }
            return answer;
        }
    }
}
