/**
 * Programers4_crain
 */
import java.util.Stack;

public class Programers4_crain {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
        int answer = sol.solution(board, moves);
        System.out.println(answer);
    }
    static class Solution {
        public int solution(int[][] board, int[] moves) {
            int last = 0;
            int cnt = 0;
            Stack<Integer> stk = new Stack<>();
            for(int i = 0; i < moves.length; i++) {
                for(int j = 0; j < board.length; j++) {
                    if(board[j][moves[i]-1] != 0) {
                        stk.push(board[j][moves[i]-1]);
                        board[j][moves[i]-1] = 0;
                        if(last != stk.peek()) last = stk.peek();
                        else if(last == stk.peek()) {
                            stk.pop();
                            stk.pop();
                            cnt += 2;
                            if(stk.empty()) last = 0;
                            else last = stk.peek();
                        } 
                        break;
                    }
                }
            }
            int answer = cnt;
            return answer;
        }
    }
}