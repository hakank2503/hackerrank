package strings.alternatingcharacter;

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
        for(byte T = Byte.parseByte(br.readLine()); T > 0; --T){

            //Solve
            sb.append(getMinDeletions(br.readLine().toCharArray()) + "\n");
        }
        System.out.print(sb);
    }

    private static int getMinDeletions(final char[] S){
        int deletions = 0;
        for(int i = 1, N = S.length; i < N; ++i){
            if(S[i] == S[i-1]){
                ++deletions;
            }
        }
        return deletions;
    }
}
