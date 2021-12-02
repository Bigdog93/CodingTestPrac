/*
출판사의 편집자인 어피치는 네오에게 컬러링북에 들어갈 원화를 그려달라고 부탁하여 여러 장의 그림을 받았다. 여러 장의 그림을 난이도 
순으로 컬러링북에 넣고 싶었던 어피치는 영역이 많으면 색칠하기가 까다로워 어려워진다는 사실을 발견하고 그림의 난이도를 영역의 수로 정의하였다. 
(영역이란 상하좌우로 연결된 같은 색상의 공간을 의미한다.)

그림에 몇 개의 영역이 있는지와 가장 큰 영역의 넓이는 얼마인지 계산하는 프로그램을 작성해보자.

입력은 그림의 크기를 나타내는 m과 n, 그리고 그림을 나타내는 m × n 크기의 2차원 배열 picture로 주어진다. 제한조건은 아래와 같다.

1 <= m, n <= 100
picture의 원소는 0 이상 2^31 - 1 이하의 임의의 값이다.
picture의 원소 중 값이 0인 경우는 색칠하지 않는 영역을 뜻한다.
*/

public class Programers7_컬러링북 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] input = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        int[] output = sol.solution(input.length, input[0].length, input);
        for(int i : output)
            System.out.println(i);
    }
    static class Solution {
        int[] xmov = {-1, 0, 1, 0};
        int[] ymov = {0, 1, 0, -1};
        int cnt = 0;
        public int[] solution(int m, int n, int[][] picture) {
            int numberOfArea = 0;
            int maxSizeOfOneArea = 0;
            int[] answer = new int[2];

            boolean[][] visited = new boolean[m][n];
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    cnt = 0;
                    int sizeOfArea = dfs(visited, picture, i, j);
                    if(sizeOfArea > 0) {
                        numberOfArea++;
                        maxSizeOfOneArea = Math.max(maxSizeOfOneArea, sizeOfArea);
                    }
                }
            }
            answer[0] = numberOfArea;
            answer[1] = maxSizeOfOneArea;
            return answer;
        }
        public int dfs(boolean[][] visited, int[][] picture, int x, int y) {
            if(visited[x][y] || picture[x][y] == 0) return 0;
            visited[x][y] = true;
            cnt++;
            int currentColor = picture[x][y];
            for(int i = 0; i < 4; i++) {
                if(x + xmov[i] >= 0 && x + xmov[i] < picture.length && y + ymov[i] >= 0 && y + ymov[i] < picture[0].length 
                    && picture[x + xmov[i]][y + ymov[i]] == currentColor) {
                    dfs(visited, picture, x + xmov[i], y + ymov[i]);
                }
            }
            return cnt;
        }
    }
}
