package sorting.countingsort1;

import java.util.Scanner;

/**
 * Created by hakank on 23/04/2016.
 */
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int SIZE = 100;
        int[] ar = new int[SIZE];
        for (int i = 0; i < SIZE; ar[i++] = 0) {
        }
        for (int N = in.nextInt(); N-- > 0; ar[in.nextInt()]++) {
        }
        for (int i = 0; i < SIZE; System.out.print(ar[i] + (++i < SIZE ? " " : ""))) {
        }
    }
}
