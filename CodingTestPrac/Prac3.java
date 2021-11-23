import java.util.Scanner;

public class Prac3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        double a = sc.nextInt();
        double b = sc.nextInt();
        double v = sc.nextInt();
        v = v - b;

        int answer = (int)(Math.ceil(v/(a-b)));

        System.out.println(answer);

        sc.close();
    }
}