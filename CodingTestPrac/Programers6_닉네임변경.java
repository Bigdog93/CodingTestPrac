import java.util.HashMap;
import java.util.Map;

/*
채팅방에 들어오고 나가거나, 닉네임을 변경한 기록이 담긴 문자열 배열 record가 매개변수로 주어질 때, 모든 기록이 처리된 후, 
최종적으로 방을 개설한 사람이 보게 되는 메시지를 문자열 배열 형태로 return 하도록 solution 함수를 완성하라.

제한사항
record는 다음과 같은 문자열이 담긴 배열이며, 길이는 1 이상 100,000 이하이다.
다음은 record에 담긴 문자열에 대한 설명이다.
모든 유저는 [유저 아이디]로 구분한다.
[유저 아이디] 사용자가 [닉네임]으로 채팅방에 입장 - "Enter [유저 아이디] [닉네임]" (ex. "Enter uid1234 Muzi")
[유저 아이디] 사용자가 채팅방에서 퇴장 - "Leave [유저 아이디]" (ex. "Leave uid1234")
[유저 아이디] 사용자가 닉네임을 [닉네임]으로 변경 - "Change [유저 아이디] [닉네임]" (ex. "Change uid1234 Muzi")
첫 단어는 Enter, Leave, Change 중 하나이다.
각 단어는 공백으로 구분되어 있으며, 알파벳 대문자, 소문자, 숫자로만 이루어져있다.
유저 아이디와 닉네임은 알파벳 대문자, 소문자를 구별한다.
유저 아이디와 닉네임의 길이는 1 이상 10 이하이다.
채팅방에서 나간 유저가 닉네임을 변경하는 등 잘못 된 입력은 주어지지 않는다.

출력 예
"Prodo님이 들어왔습니다."
"Prodo님이 나갔습니다."
*/
public class Programers6_닉네임변경 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] input = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        String[] output = sol.solution(input);
        for(String out : output) {
            System.out.println(out);
        }
    }
    static class Solution {
        Map<String, String> idNm = new HashMap<String, String>();

        public String[] solution(String[] record) {
            int len = record.length;
            String[] commends = new String[len];
            String[] userIds = new String[len];
            int comdCnt = 0;
            for(int i = 0; i < len; i++) {
                String[] temp = record[i].split(" ");
                commends[i] = temp[0];
                userIds[i] = temp[1];
                switch (temp[0]) {
                    case "Enter":
                        idNm.put(temp[1], temp[2]);
                        comdCnt++;
                        break;
                    case "Change":
                        idNm.put(temp[1], temp[2]);
                        break;
                    case "Leave":
                        comdCnt++;
                }
            }
            String[] answer = new String[comdCnt];
            int idx = 0;
            for(int i = 0; i < len; i++) {
                switch (commends[i]) {
                    case "Enter":
                        answer[idx++] = String.format("%s님이 들어왔습니다.", idNm.get(userIds[i]));
                        break;
                    case "Leave":
                        answer[idx++] = String.format("%s님이 나갔습니다.",idNm.get(userIds[i]));
                }
            }

            return answer;
        }
    }
}
