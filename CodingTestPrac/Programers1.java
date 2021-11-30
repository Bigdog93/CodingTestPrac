public class Programers1 {
    class Solution {
        public int[] solution(String[][] places) {
            int[] answer = {1, 1, 1, 1, 1};
            for(int i = 0; i < places.length; i++) {
                // boolean[][] visit = new boolean[places[i].length][places[i][0].length()];
                for(int j = 0; j < places[i].length; j++) {
                    for(int z = 0; z < places[i][j].length(); z++) {
                        if(!dfs(places[i], j, z)) {
                            answer[i] = 0;
                            break;
                        }
                    }
                }
            }
    
            return answer;
        }
        public boolean dfs(String[] places, int j, int z) {
            int[] xMove = {-1, 0 ,1, 0};
            int[] yMove = {0, 1, 0, -1};
            int count = 0;
            for(int i = 0 ; i < 4; i++) {
                if(j + xMove[i] < 0 || j + xMove[i] > 4 || z + yMove[i] < 0 || z + yMove[i] > 4) continue;
                if(places[j].charAt(z) == 'P') {
                    if(places[j + xMove[i]].charAt(z + yMove[i]) == 'P') {
                        return false;
                    }
                }else if(places[j].charAt(z) == 'O') {
                    if(places[j + xMove[i]].charAt(z + yMove[i]) == 'P') {
                        count++;
                        if(count == 2) return false;
                    }
                }
            }
            return true;
        }
    }
}
