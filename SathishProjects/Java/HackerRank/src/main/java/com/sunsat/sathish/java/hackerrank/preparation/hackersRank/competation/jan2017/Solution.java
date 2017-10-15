package com.sunsat.sathish.java.hackerrank.preparation.hackersRank.competation.jan2017;

import java.util.*;

/**
 * Created by ssundar2 on 22-02-2017.
 */
public class Solution {

    private static Solution review = null;

    public static Solution getInstance() {
        if(review == null) {
            synchronized (review) {
                if(review == null) {
                    review = new Solution();
                }
            }
        }
        return review;
    }

    Scanner in = null;
    private Solution() {
        in = new Scanner(System.in);
    }

    public int getCount() {
        return in.nextInt();
    }

    public String[] getTotalNoStrings(int count) {
        String st[] = new String[count];
        in.nextLine();
        for (int i = 0; i < count; i++) {
            st[i] = in.nextLine();
        }
        return st;
    }

    public HashMap seperateOddEvenChars(int count,String[] st) {
        HashMap<String,String> map = new HashMap<>(count);
        for (int i = 0; i < count; i++) {
            char[] chArr = st[i].toCharArray();
            StringBuilder even = new StringBuilder();
            StringBuilder odd = new StringBuilder();
            for (int k = 0; k < chArr.length; k++) {
                if (k % 2 == 0) {
                    even.append(chArr[k]);
                } else {
                    odd.append(chArr[k]);
                }
            }
            map.put(st[i],even.toString()+" "+odd.toString());
        }
        return map;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Solution review = Solution.getInstance();
        int count = review.getCount();
        String st[] = review.getTotalNoStrings(count);
        Map<String,String> map = review.seperateOddEvenChars(count,st);
        for(String oddEven : map.keySet()){
            System.out.println(map.get(oddEven));
        }
    }
}
