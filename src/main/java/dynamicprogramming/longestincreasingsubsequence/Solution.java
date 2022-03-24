package dynamicprogramming.longestincreasingsubsequence;

import java.util.*;

/**
 * Created by hakank on 24/04/2016.
 */
public class Solution {
    public static void main(String [] args) throws Exception{
        int[] arr = { 1, 5, 4, 2, 3, 7, 6, 11, 8, -1, 0, 22 };
        int[] arr2 = {5, 5, 6, 6, 6, 7, 7, 7, 10};
        int[] arr3 = {1,1,1,3,4,5,5,5,5,5,3,3,4,3,3};
        boolean[] arr4 = {true, true, false, true, false, false};
        int[] arr5 = {1, 1, 0, 1, 0, 0};
        //sout
        //System.out.println(getLIS(arr));
        //printMaxSum(arr);
        //System.out.println(lengthOfLIS(arr));
        //System.out.println(maxSubSequenceFirstAndLast(arr3, 1));
        //System.out.println(longestConsecutiveCoins(arr4));
        System.out.println(adjacentCoins2(arr5));
    }
    public static int getLIS(int[] arr)
    {
        // ordering should be applied, no duplicate, no key value needed : TreeSet
        TreeSet<Integer> treeSet = new TreeSet<Integer>();
        for(int i = 0; i < arr.length ; i++)
        {
            int current = arr[i];
            if( treeSet.add(current) )
            {
                int last = treeSet.last();
                if( current != last )
                {
                    int higher = treeSet.higher(current);
                    treeSet.remove(higher);
                }
            }
        }

        return treeSet.size();
    }

    static void printMaxSum(int[] arr){

        //1) For max continuous sub array
        int max_ending_here = 0;
        int max_so_far = Integer.MIN_VALUE;
    /*OR int max_so_far = arr[0];*/

        for(int x : arr){
            max_ending_here = Math.max(x, max_ending_here + x);
            max_so_far = Math.max(max_so_far, max_ending_here);
        }

        System.out.print(max_so_far);

        //2) For max non-continuous sub array, order doesn't matter
        Arrays.sort(arr);
        int sum = 0;

        //if there is none positive value in entire array
        if(arr[arr.length-1] <= 0)
            sum = arr[arr.length - 1];
            //accumulate all positive values in entire array
        else{
            for(int x : arr){
                if(x > 0)
                    sum += x;
            }
        }
        System.out.println(" " + sum);
    }

    public static int lengthOfLIS(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;

        ArrayList<Integer> list = new ArrayList<Integer>();

        for(int num: nums){
            if(list.size()==0 || num>list.get(list.size()-1)){
                list.add(num);
            }else{
                int i=0;
                int j=list.size()-1;

                while(i<j){
                    int mid = (i+j)/2;
                    if(list.get(mid) < num){
                        i=mid+1;
                    }else{
                        j=mid;
                    }
                }

                list.set(j, num);
            }
        }

        return list.size();
    }

    public static int maxSubSequenceFirstAndLast(int[] A, int maximumDifference) {
        Map<Integer, Integer> countsOf = new HashMap<Integer, Integer>();
        int maxCount = 0;

        for ( int number : A ) {
            Integer count = countsOf.get(number);
            if (null == count) {
                countsOf.put(number, 1);
            } else {
                countsOf.put(number, count + 1);
            }
        }

        for ( Map.Entry<Integer, Integer> countOf : countsOf.entrySet()) {
            int count = countOf.getValue();
            int number = countOf.getKey();

            for (int i = 1; i <= maximumDifference; i++) {
                Integer c = countsOf.get(number + i);
                if ( null != c ) {
                    count += c;
                }
            }

            if ( count > maxCount ) {
                maxCount = count;
            }
        }

        return maxCount;

    }

    public static int longestConsecutiveCoins(boolean[]A) {
        int n=A.length;
        if (n<=1) return n;
        int[] f=new int[n], b=new int[n]; f[0]=1; b[n-1]=1;
        for (int i=1;i<n;++i) {
            f[i]=A[i]==A[i-1]?f[i-1]+1:1;
            b[n-i-1]=A[i]==A[i+1]?b[n-i]+1:1;
        }
        int rel=0;
        for (int i=1;i<n-1;++i)
            rel=Math.max(rel, 1+(!A[i]==A[i-1]?f[i-1]:0)+
                    (!A[i]==A[i+1]?b[i+1]:0));
        if (!A[0]==A[1]) rel=Math.max(rel, 1+b[1]);
        if (!A[n-1]==A[n-2]) rel=Math.max(rel, f[n-2]+1);
        return rel;
    }

    public static int adjacentCoins(int[] A) {
        boolean spAdjPowerBy2 = false, spAdjPowerBy1 = false;
        int totalAdj = 0;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] == A[i + 1]) {
                totalAdj++;
            }
            if (i < A.length - 2 && A[i] == A[i + 2] && A[i] != A[i + 1] && !spAdjPowerBy2) {
                spAdjPowerBy2 = true;
            } else if (i == A.length - 2 && A[i] != A[i + 1] && !spAdjPowerBy1) {
                spAdjPowerBy1 = true;
            } else if (i == 0 && A.length > 1 && A[i] != A[i + 1] && !spAdjPowerBy1) {
                spAdjPowerBy1 = true;
            }
        }
        totalAdj = totalAdj + ((spAdjPowerBy2) ? 2 : (spAdjPowerBy1 ? 1 : 0));
        return totalAdj;
    }

    public static int adjacentCoins2(int[] A) {
        int n = A.length;
        int result = 0;

        for (int i=0;i< n-1; i++){
            if(A[i] == A[i+1])
                result++;
        }

        int r = 0;
        for(int i=0; i<n; i++){
            int count = 0;
            if (i > 0) {
                if (A[i - 1] != A[i]) {
                    count++;
                } else {
                    count--;
                }
            }
            if (i < n - 1) {
                if (A[i + 1] != A[i]) {
                    count++;
                } else {
                    count--;
                }
            }
            r = Math.max(r, count);
        }
        return result + r;
    }
}
