public class gurumEdu9 {
    public int solution(int[] arr) {
        int answer = 0;
				int temp = 1;
				for(int i = 0; i<arr.length - 1; i++) {
					if(arr[i] < arr[i+1]) temp++;
					else if(answer < temp) {
						answer = temp;
						temp = 1;
					}
				}
        return answer;
    }
    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        gurumEdu9 sol = new gurumEdu9();
        int[] arr = {3, 1, 2, 4, 5, 1, 2, 2, 3, 4};
        int ret = sol.solution(arr);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
    }
}
