import java.util.*;


public class NakseoJang {
    public static void main(String[] args) {
        String str1 = "";
        String str2 = "apple";
        System.out.println(str1.indexOf(","));
        
        str1 += "l";
        System.out.println(str1.equals(str2));
        System.out.println(str1);
        System.out.println(str2);
        Map menu = new HashMap();
    }
    public int solution(String s) {
        int answer = 0;
        char[] keyboard = {'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 
                            'p', 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k',
                            'l' ,'z', 'x', 'c', 'v', 'b', 'n', 'm'};
        List<char[]> keyList = Arrays.asList(keyboard);
        for(int i = 1; i < s.length(); i++) {
            for(int j = 0; j < s.length() - i + 1; j++) {
                String temp = s.substring(j, j + i);
                for(int z = 0; z < temp.length() - 1; z++) {
                    int dist = Math.abs(keyList.indexOf(temp.charAt(z))
                     - keyList.indexOf(temp.charAt(z + 1)));
                    answer += dist % 9 + dist / 9;
                }
            }
        }
        return answer;
    }
}
