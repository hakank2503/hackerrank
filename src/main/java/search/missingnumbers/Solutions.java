package search.missingnumbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by hakank on 23/04/2016.
 */
public class Solutions {
    private static int RADIUS = 100;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] C = new int[2*RADIUS];
        //First list
        int N = Integer.parseInt(br.readLine());
        String[] temp = br.readLine().split(" ");
        int offset = Integer.parseInt(temp[0]) - RADIUS;
        for(int i = 0; i < N; i++){
            short v = Short.parseShort(temp[i]);
            C[v - offset]--;
        }
        //Second list
        int M = Integer.parseInt(br.readLine());
        temp = br.readLine().split(" ");
        for(int i = 0; i < M; i++){
            short v = Short.parseShort(temp[i]);
            C[v - offset]++;
        }
        //Print
        StringBuffer str = new StringBuffer();
        for(int i = 0; i < C.length; i++){
            if (C[i] != 0){
                str.append((i + offset) + " ");
            }
        }
        System.out.print(str);
    }
}
