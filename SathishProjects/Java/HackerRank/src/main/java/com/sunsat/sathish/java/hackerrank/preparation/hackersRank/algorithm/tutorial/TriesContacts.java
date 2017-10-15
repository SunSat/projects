package com.sunsat.sathish.java.hackerrank.preparation.hackersRank.algorithm.tutorial;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by ssundar2 on 31-01-2017.
 */
public class TriesContacts {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        HashMap<Character,ArrayList<String>> namesMap = new HashMap<>();
        ArrayList<Integer> output = new ArrayList<>();
        for(int a0 = 0; a0 < n; a0++){
            String op = in.next();
            String contact = in.next();
            if(op.equals("add")) {
                Character c = contact.charAt(0);
                ArrayList<String> namesLi = null;
                if(namesMap.containsKey(c)) {
                    namesLi = namesMap.get(c);
                } else {
                    namesLi = new ArrayList<String>();
                    namesMap.put(c,namesLi);
                }
                namesLi.add(contact);
            } else if(op.equals("find")) {
                int count = 0;
                Character c = contact.charAt(0);
                if(namesMap.containsKey(c)) {
                    ArrayList<String> namesLi = namesMap.get(c);
                    for(String st : namesLi) {
                        if(st.startsWith(contact)) {
                            count++;
                        }
                    }
                }
                output.add(count);
            }
        }
        for(Integer i :output) {
            System.out.println(i);
        }
    }
}
