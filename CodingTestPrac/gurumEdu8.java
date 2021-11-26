public class gurumEdu8 {
    public int solution(int[] arr, int K) {
        int answer = 0;
        for(int i = 0; i < arr.length - 2; i++) {
					for(int j = i + 1; j < arr.length - 1; j++) {
						for(int z = j + 1; z < arr.length; z++) {
							if((arr[i] + arr[j] + arr[z])%K == 0) answer++;
						}
					}
				}
        return answer;
    }
    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        gurumEdu8 sol = new gurumEdu8();
        int[] arr = {1, 2, 3, 4, 5};
        int K = 3;
        int ret = sol.solution(arr, K);


        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
    }
}
