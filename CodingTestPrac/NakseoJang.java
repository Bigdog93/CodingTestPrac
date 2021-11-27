public class NakseoJang {
    public static void main(String[] args) {
        String str1 = "apple";
        String str2 = "apple";
        System.out.println(str1 == str2);
        
        str1 += "l";
        System.out.println(str1.equals(str2));
        System.out.println(str1);
        System.out.println(str2);
    }
}
