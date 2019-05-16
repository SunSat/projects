package com.sunsat.sathish.java.hackerrank.preparation.interview.photon;

import java.util.Arrays;
import java.util.List;

public class MiddleElement {

    public static void main(String[] args) {
        String[] input = new String[]{"sam","teacher","ways","pencil","eclipse","wood"};
        List<String> li = Arrays.asList(input);

        for(String element:li){
            StringBuffer stBuffer=new StringBuffer();
            stBuffer.append(element);
            int index = element.length()/2;
            if(element.length()%2 == 1){
                char c = Character.toUpperCase(element.charAt(index));
                stBuffer.setCharAt(index, c);
                System.out.println(stBuffer.toString());
            }
            else{
                char c1 = Character.toUpperCase(element.charAt(index-1));
                //stBuffer.setCharAt(index-1, c1);
                char c2 = Character.toUpperCase(element.charAt(index));
                stBuffer.setCharAt(index, c2);
                System.out.println(stBuffer.toString());
            }
        }

    }
}
