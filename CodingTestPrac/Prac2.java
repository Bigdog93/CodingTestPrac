import java.util.Scanner;

public class Prac2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numX = sc.nextInt();

        solution(numX);

    }
    static void solution(int numx) {
        int count = 1;
        int min = 1;
        int diff = 1;
        while(true) {
            if(numx >= min && numx < min + diff) {
                printSol(count, numx - min);
                break;
            }
            min = min + diff++;
            count++;
        }
    }
    static void printSol(int count, int numy) {
        int up = count - numy;
        int down = numy + 1;
        if(count%2 == 1) {
            System.out.println(up + "/" + down);
        }else {
            System.out.println(down + "/" + up);
        }

    }
}
