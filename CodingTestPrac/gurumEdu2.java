public class gurumEdu2 {
    public int solution(String pos) {
        int answer = 0;
        boolean[][] cm = {
            {false, true, true, false},
            {true, false, false, true},
            {true, false, false, true},
            {false, true, true, false}
        };

        int x = pos.charAt(0) - 'A';
		int y = pos.charAt(1) - '1';
        if(x < 2 || x > 5) {
            x = x > 5 ? Math.abs(x - 7) : x;
            int bye = Math.abs(x-2);
            for(int i = 0 ; i < bye; i++) {
                for(int j = 0 ; j < 4; j++) {
                    cm[i][j] = false;
                }
            }
        }
        if(y < 2 || y > 5) {
            y = y > 5 ? Math.abs(y - 7) : y;
            int bye = Math.abs(y-2);
            for(int i = 0 ; i < bye; i++) {
                for(int j = 0 ; j < 4; j++) {
                    cm[j][i] = false;
                }
            }
        }
        for(int i = 0; i < cm.length; i++) {
            for(int j = 0; j<cm[i].length; j++) {
                if(cm[i][j] == true) answer++;
            }
        }
				
        return answer;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        gurumEdu2 sol = new gurumEdu2();
        String pos = "H8";
        int ret = sol.solution(pos);
    	
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
    }
}
