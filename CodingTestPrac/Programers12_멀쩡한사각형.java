public class Programers12_멀쩡한사각형 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int winput = 3;
        int hinput = 5;
        long output = sol.solution(winput, hinput);
        System.out.println(output);
    }
    static class Solution {
        public long solution(int w, int h) {
            if(w == h) return (long)w * h - w;
            long answer = (long)w * h;
            int big = w > h ? w : h;
            int small = w > h ? h : w;
            answer -= w + h - getGcd(big, small);

            return answer;

        }
        static int getGcd(int a, int b){ // 최대공약수
            if (a%b == 0) {
                return b;
            }
            return getGcd(b, a % b);
        }
    }
}
