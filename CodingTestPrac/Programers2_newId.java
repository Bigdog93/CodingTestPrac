import java.util.Scanner;

/*
1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
     만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
*/

public class Programers2_newId {
    public static void main(String[] args) {
        Solution sol = new Solution();
        Scanner sc = new Scanner(System.in);
        String new_id = sol.solution(sc.nextLine());
        System.out.println(new_id);
    }
}
class Solution {
    public String solution(String new_id) {
        // 1 단계
        new_id = new_id.toLowerCase();
        // 2 단계
        // new_id = new_id.replaceAll("[^a-z0-9-_.]", "");
        new_id = new_id.replaceAll("[^a-z\\d\\-_.]*", "");
        //3 단계
        // String temp = "";
        // for(int i = 0; i < new_id.length(); i++) {
        //     if(i < new_id.length() - 1 && new_id.charAt(i) == '.' && new_id.charAt(i + 1) == '.') continue;
        //     temp += new_id.charAt(i);
        // }
        // new_id = temp;
        new_id = new_id.replaceAll("\\.{2,}", ".");
        // 4 단계
        // if(new_id.indexOf(".") == 0) new_id = new_id.substring(1);
        // if(new_id.indexOf(".") != -1 && new_id.indexOf(".") == new_id.length() - 1) new_id = new_id.substring(0, new_id.length() - 1);
        new_id = new_id.replaceAll("^[.]|[.]$", "");
        // 5 단계
        if(new_id.equals("")) new_id = "a";
        // 6 단계
        if(new_id.length() > 15) {
            new_id = new_id.substring(0, 15);
            // if(new_id.indexOf(".") == new_id.length() - 1) new_id = new_id.substring(0, new_id.length() - 1);
            new_id = new_id.replaceAll("[.]$", "");
        }
        // 7 단계
        if(new_id.length() < 3) {
            while(new_id.length() < 3) {
                new_id += new_id.charAt(new_id.length() - 1);
            }
        }
        String answer = new_id;
        return answer;
    }
}