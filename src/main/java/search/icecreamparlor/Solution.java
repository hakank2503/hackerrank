package search.icecreamparlor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by hakank on 23/04/2016.
 */
public class Solution {
    public static void main(String[] args) throws IOException {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int T = Integer.parseInt(br.readLine()); T > 0; T--){
            int C = Integer.parseInt(br.readLine());
            int L = Integer.parseInt(br.readLine());
            String[] ar = br.readLine().split(" ");

            Map<Integer, List<Integer>> map = new TreeMap<Integer, List<Integer>>();
            for(int i = 0; i < L; i++){
                int v = Integer.parseInt(ar[i]);
                List<Integer> list = map.get(v);
                if (list == null){
                    map.put(v, list = new ArrayList<Integer>());
                }
                list.add(i+1);
            }

            for(Integer a : map.keySet()){
                int b = C - a;
                a = map.get(a).remove(0);
                List<Integer> list = map.get(b);
                if (list != null && !list.isEmpty()){
                    b = list.get(0);
                    if (a > b) {
                        int t = a;
                        a = b;
                        b = t;
                    }
                    sb.append(a + " " + b + "\n");
                    break;
                }
            }
        }
        System.out.print(sb);
    }
}
