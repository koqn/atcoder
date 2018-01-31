package abc087.c;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int A[][] = new int[2][N];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < N; j++) {
                A[i][j] = sc.nextInt();
            }
        }

        int max_score = 0;
        int i_sum = 0;
        // i番目で曲がった
        for (int i = 0; i < N; i++) {
            i_sum += A[0][i];
            int score = i_sum;
            for (int j = i; j < N; j++) {
                score += A[1][j];
            }
            if (score > max_score) max_score = score;
        }
        System.out.println(max_score);
    }
}
