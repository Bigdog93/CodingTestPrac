import java.util.ArrayList;
import java.util.List;
/*
데이터 처리 전문가가 되고 싶은 "어피치"는 문자열을 압축하는 방법에 대해 공부를 하고 있습니다. 
최근에 대량의 데이터 처리를 위한 간단한 비손실 압축 방법에 대해 공부를 하고 있는데, 문자열에서 같은 값이 연속해서 나타나는 것을 
그 문자의 개수와 반복되는 값으로 표현하여 더 짧은 문자열로 줄여서 표현하는 알고리즘을 공부하고 있습니다.
간단한 예로 "aabbaccc"의 경우 "2a2ba3c"(문자가 반복되지 않아 한번만 나타난 경우 1은 생략함)와 같이 표현할 수 있는데, 
이러한 방식은 반복되는 문자가 적은 경우 압축률이 낮다는 단점이 있습니다. 예를 들면, "abcabcdede"와 같은 문자열은 전혀 압축되지 않습니다. 
"어피치"는 이러한 단점을 해결하기 위해 문자열을 1개 이상의 단위로 잘라서 압축하여 더 짧은 문자열로 표현할 수 있는지 방법을 찾아보려고 합니다.

예를 들어, "ababcdcdababcdcd"의 경우 문자를 1개 단위로 자르면 전혀 압축되지 않지만, 2개 단위로 잘라서 압축한다면 "2ab2cd2ab2cd"로 표현할 수 있습니다. 
다른 방법으로 8개 단위로 잘라서 압축한다면 "2ababcdcd"로 표현할 수 있으며, 이때가 가장 짧게 압축하여 표현할 수 있는 방법입니다.

다른 예로, "abcabcdede"와 같은 경우, 문자를 2개 단위로 잘라서 압축하면 "abcabc2de"가 되지만, 3개 단위로 자른다면 "2abcdede"가 되어 3개 단위가 
가장 짧은 압축 방법이 됩니다. 이때 3개 단위로 자르고 마지막에 남는 문자열은 그대로 붙여주면 됩니다.

압축할 문자열 s가 매개변수로 주어질 때, 위에 설명한 방법으로 1개 이상 단위로 문자열을 잘라 압축하여 표현한 문자열 중 가장 짧은 것의 길이를 return 
하도록 solution 함수를 완성해주세요.
*/
public class Programers5_문자열압축 {
    public static void main(String[] args) {
        String[] testcase = {
            "aabbaccc",
            "ababcdcdababcdcd",
            "abcabcdede",
            "abcabcabcabcdededededede",
            "xababcdcdababcdcd"
        };
        int[] answer = new int[testcase.length];
        for(int i = 0 ; i < testcase.length; i++) {
            answer[i] = solution(testcase[i]);
            System.out.println(answer[i]);
        }
    }
    public static int solution(String s) {
        int answer = 0;
        int len = s.length(); // 초기 문자열 길이
        int halfLen = (int) Math.ceil((double) len / 2); // 문자열의 반
        for(int i = 0; i < halfLen; i++) { // 몇 글자 단위로 자를 지 순회
            int unit = i + 1; // 단위 글자 수
            int arrCnt = (int)(Math.ceil((double)len / unit)); // 단위 글자로 자른 글자 배열 수
            String[] tempStrArr = new String[arrCnt]; // 자른 글자 담을 배열
            int idx = 0;
            for(int j = 0; j < len; j += unit) { // 글자 잘라 배열에 담기
                if(j + unit <= len) tempStrArr[idx++] = s.substring(j, j + unit);
                else tempStrArr[idx++] = s.substring(j);
            }
            int cnt = 1; // 압축된(반복된) 수
            String tempStr = ""; // 임시로 담을 문자열
            for(int j = 0; j < tempStrArr.length - 1; j++) { // 자른 문자열들을 순회
                if(tempStrArr[j].equals(tempStrArr[j + 1])) { // 다음 문자열과 같을 경우(압축 가능)
                    cnt++; // 압축 수 증가
                }else { // 아닐 경우
                    tempStr += cnt != 1 ? cnt + tempStrArr[j] : tempStrArr[j]; // 문자열 붙여 만들기
                    cnt = 1;
                }
                if(j == tempStrArr.length - 2) tempStr += cnt != 1 ? cnt + tempStrArr[j + 1] : tempStrArr[j + 1];
            }
            if(answer == 0) answer = tempStr.length();
            else answer = Math.min(answer, tempStr.length());
            System.out.println(tempStr);
        }
        if(answer == 0) answer = s.length();
        return answer;
    }
}