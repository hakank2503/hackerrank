package dynamicprogramming.fibonaccimodified;

import java.util.Scanner;

/**
 * Created by hakank on 24/04/2016.
 */
public class Solution {
    public static void main(String[] args) {
        String result = "";
        Scanner sc = new Scanner(System.in);
        int numCases=Integer.parseInt(sc.nextLine());
        for(int i = 0;i<numCases;i++){
            int numStudents = sc.nextInt();
            int atLeastNumStudents = sc.nextInt();
            sc.nextLine();
            boolean isClass = true;
            int studentsAttending = 0;
            for(int j = 0;j<numStudents;j++){
                int timeArrival = sc.nextInt();
                if(timeArrival<=0){
                    studentsAttending++;
                }
            }
            result += studentsAttending>=atLeastNumStudents?"NO\n":"YES\n";

        }
        System.out.println(result);
    }
}
