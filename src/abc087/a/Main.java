package abc087.a;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int money = sc.nextInt();
        int A = sc.nextInt();
        int B = sc.nextInt();
        System.out.println((money-A)%B);
    }
}