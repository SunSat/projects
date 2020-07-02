package com.sunsat.sathish.java.geeksforgeeks.palindrom;

public class CheckPalindromStringWithNumbers {
    public static void main(String[] args) {
        String st = "qqwwwqqqwwwqq11";
        boolean isPal = false;
        try {
            isPal = checkPalindrom(st);
        }catch (Exception e) {
            System.out.println("No");
        }
        if(isPal) System.out.println("Yes");
    }
    public static boolean checkPalindrom(String st) {
        for(int i=0, j=st.length() -1 ; i< st.length()/2;) {
            boolean isContinue = false;
            if(!(st.charAt(i) >= 'a' && st.charAt(i) <= 'z')) {
                isContinue =true;
                i++;
            }
            if(!(st.charAt(j) >= 'a' && st.charAt(j) <= 'z')) {
                isContinue = true;
                j--;
            }
            if(isContinue) continue;

            if(st.charAt(i++) != st.charAt(j--)) throw new RuntimeException();
        }
        return true;
    }
}
