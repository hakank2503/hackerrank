package strings.pangram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by hakank on 22/04/2016.
 */
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final char[] C = br.readLine().toLowerCase().toCharArray();

        final int N = C.length;
        boolean isPangram = false;
        final int ALPHA_LEN = 'z' - 'a' + 1;
        if (N >= ALPHA_LEN){
            int count = 0;
            final boolean[] alpha = new boolean[ALPHA_LEN];
            for(int i = N-1; i >= 0; --i){
                char c = C[i];
                if (c >= 'a' && c <= 'z' && !alpha[c -= 'a']){
                    alpha[c] = true;
                    if (++count >= ALPHA_LEN){
                        isPangram = true;
                        break;
                    }
                }/* else if (count + i+1 < ALPHA_LEN){
                    break;
                }*/
            }
        }
        System.out.print(isPangram ? "pangram" : "not pangram");
    }
}
