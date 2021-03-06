package warmup.sherlockandthebeast;

import java.util.Scanner;

/**
 * Created by hakank on 21/04/2016.
 */
public class Solution {

    public static String createDescentNumber(int fives, int threes)
    {
        String []numArray = new String[fives+threes];
        StringBuilder numString = new StringBuilder();
        for(int i = 0;i<fives;i++){
            numString.append("5");
        }
        for(int i = 0;i<threes;i++){
            numString.append("3");
        }
        return numString.toString();

    }
    public static String descentNumber(int n)
    {
        String num = "-1";
        for(int i = n;i >= 0; i--){
            if((i)%3 == 0 && (((n-i))%5) == 0){
                num = createDescentNumber(i,n-i);
                break;
            }else if ((i)%5 == 0 && (((n-i))%3) == 0){
                num = createDescentNumber(i,n-i);
            }
        }
        return num;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numTestCases = Integer.parseInt(sc.nextLine());

        for(int i = 0;i < numTestCases; i++){
            int n = sc.nextInt();
            System.out.println(descentNumber(n));
        }
    }
}
