package strings.thelovelettermistery;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by hakank on 22/04/2016.
 */
public class Solution {
    public static void main(String[] args) throws IOException {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //For each test case
        for(byte t = Byte.parseByte(br.readLine()); t > 0; --t){

            //Get input
            final char[] str = br.readLine().toCharArray();

            //Solve
            int numOps = 0;
            for(short i = 0, j = (short)(str.length-1); i < j; numOps += Math.abs(str[i++] - str[j--])){}

            //Print output
            sb.append(numOps + "\n");
        }
        System.out.print(sb);
    }
}
