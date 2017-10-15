package com.sunsat.sathish.java.hackerrank.preparation.ideserv.dynamic_programming;

/**
 * Created by ssundar2 on 5/12/2017.
 */

/**
 * Given a dictionary of words and a string of characters, find if the string of characters can be broken into individual valid words from the dictionary.
 Example:
 Dictionary: arrays, dynamic, heaps, IDeserve, learn, learning, linked, list, platform, programming, stacks, trees
 String    : IDeservelearningplatform
 Output   : true
 Because the string can be broken into valid words: IDeserve learning platform
 */
public class DictionaryOfWordFindString {
    private boolean findIsStringAvailableInDictionary(Node root,String checkSt) {
        Node temp = root;
        if(checkSt == null || checkSt.length() == 0) throw new IllegalArgumentException("Not a valid or Empty String");
        for(int k=0;k<checkSt.length();k++) {
            char ch = checkSt.charAt(k);
            int val = ch - 'A';
            temp = temp.chArr[val];
            if(temp == null) return false;
            else {
                if(temp.isWord) {
                    if(temp.count > 1) {
                        if(checkSt.length() - 1 != k+1) {
                            if(temp.chArr[(checkSt.charAt(k+1))-'A'] == null) temp=root;
                        }
                    } else {
                        temp = root;
                    }
                }
            }
        }
        return true;
    }
    private Node constructDisctionay(String[] listOfSt, Node root) {
        Node temp = null;
        for(String st : listOfSt) {
            temp = root;
            for(int i=0;i<st.length();i++) {
                char ch = st.charAt(i);
                int val = ch - 'A';
                Node n = temp.chArr[val];
                if(n == null) {
                    n = new Node();
                    temp.chArr[val] = n;
                    n.c = ch;
                    n.count++;
                } else {
                    n.count++;
                }
                if(i == st.length() -1) {
                    n.isWord = true;
                }
                temp = temp.chArr[val];
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        DictionaryOfWordFindString dis = new DictionaryOfWordFindString();
        String[] disctionary = {"arrays" , "dynamic" , "heaps" , "IDeserve" , "learn" , "learning" , "linked" ,
                "list" , "platform" , "programming" , "stacks" , "trees"};
        Node n = new Node();
        dis.constructDisctionay(disctionary,n);
        System.out.println(dis.findIsStringAvailableInDictionary(n,"IDeservelearnplatform"));
    }
}
class Node {
    char c;
    Node[] chArr = new Node[58];
    boolean isWord =  false;
    int count=0;
}
