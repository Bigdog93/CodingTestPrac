import java.util.Scanner;

public class Prac1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if(num == 1) {
            System.out.println(1);
        }
        int count = 2;
        int min = 2;
        int diff = 6;
        
        while(true) {
            if(num >= min && num < min + diff) {
                System.out.println(count);
                break;
            }
            min = min + diff;
            diff = diff + 6;
            count++;
        }
    }
}