public class gurumEdu1 {
    public int solution(int n) {
        int answer = 1;
				int odd = 0;
				int diff = 1;
				for(int i = 1; i < n; i++) {
					diff += n * 2 - 2 - (odd * 4);
					answer += diff;
					if(i != 0 && i % 2 == 0) {
						odd++;
					}
				}
        return answer;
    }
    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        gurumEdu1 sol = new gurumEdu1();
        for(int i = 1; i < 7; i++) {
            int n1 = i;
            int ret1 = sol.solution(n1);
            // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
            System.out.println("solution 메소드의 반환 값은 " + ret1 + " 입니다.");
        }
    }
}

