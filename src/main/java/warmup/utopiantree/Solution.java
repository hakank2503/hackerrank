package warmup.utopiantree;

import java.util.Scanner;

/**
 * Created by hakank on 21/04/2016.
 */
public class Solution {


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();   // test cases
        for(int i = 0; i < t; i++){
            int n = in.nextInt(); // growth cycle

            int length = 1;

            for(int j = 0; j < n; j++){
                if((j%2) == 0){
                    length *= 2;
                } else{
                    length +=1;
                }

            }
            System.out.println(length);
        }
    }
}
