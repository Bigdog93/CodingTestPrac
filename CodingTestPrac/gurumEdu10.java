public class gurumEdu10 {
    public int solution(String[] bishops) {
        // 여기에 코드를 작성해주세요.
        int answer = 0;
				boolean[][] chesspan = new boolean[8][8];
				int[] xarrows = {-1, 1, 1, -1};
				int[] yarrows = {1, 1, -1, -1};
				for(int i = 0; i < bishops.length; i++) {
					int x = bishops[i].charAt(0) - 'A';
					int y = bishops[i].charAt(1) - '1';
					for(int j = 0; j < 4; j++) {
						int[] xytemp = {x, y};
						while(xytemp[0] >= 0 && xytemp[0] < 8 && xytemp[1] >= 0 && xytemp[1] < 8) {
							chesspan[xytemp[0]][xytemp[1]] = true;
							xytemp[0] += xarrows[j];
							xytemp[1] += yarrows[j];
						}
					}
				}
				for(int i = 0; i < 8; i++) {
					for(int j = 0; j < 8; j++) {
						if(chesspan[i][j] == false) answer++;
					}
				}
        return answer;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        gurumEdu10 sol = new gurumEdu10();
        String[] bishops1 = {new String("D5")};
        int ret1 = sol.solution(bishops1);
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret1 + " 입니다.");

        String[] bishops2 = {new String("D5"), new String("E8"), new String("G2")};
        int ret2 = sol.solution(bishops2);
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret2 + " 입니다.");
    }

}
