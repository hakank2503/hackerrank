package warmup.averybigsum;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * Created by hakank on 21/04/2016.
 */
    public class Solution {

        public static void main(String[] args) {
            long total = 0;
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int arr[] = new int[n];
            for(int arr_i=0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            System.out.println("array length : " + arr.length);
            for (int j=0; j < arr.length; j++){
                total += arr[j];
            }
            System.out.println(total);
        }
    }


