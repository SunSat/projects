package com.sunsat.sathish.java.hackerrank.preparation.hackersRank.algorithm.tutorial;

import java.util.Scanner;

/**
 * Created by ssundar2 on 01-02-2017.
 */
public class TriesContacts_V1 {
    class Node {
        int chCount = 0;
        char[] chArr = new char[26];

        char ch = 0;
        Node parent = null;

        Node[] namesOrder = new Node[26];
        int namesCount = 0;
    }

    Node currNode = null;
    public TriesContacts_V1() {
        currNode = new Node();
    }

    Node getCurrNode() {
        return currNode;
    }

    public void readData() {
        Scanner s = new Scanner(System.in);
        while(true) {
            String op = s.next();
            String value = s.next();
            if(op.equals("add")) {
                fillData(value,currNode);
            } else if(op.equals("find")) {
                try {
                    findData(value,currNode);
                } catch(Exception e) {
                    System.out.println(e.getMessage());
                }
            } else if(op.equals("exit")) {
                break;
            }
        }
    }
    public void findData(String value, Node parentNode) {
        String[] finalStr = null;
        Node parent = parentNode;
        char[] val = value.toCharArray();
        String finalSt = "";
        for(int i = 0;i<val.length;i++) {
            finalSt +=val[i]+"";
            Node node = parent.namesOrder[val[i]-'a'];
            if(node == null) {
                break;
            } else{
                if(i == val.length-1) {
                    String[][] stArr = getData(node);
                    for(String[] st : stArr) {
                        for(String s : st) {
                            System.out.println(finalSt.substring(0,finalSt.length()-1)+s);
                            //System.out.println(s);
                        }
                    }
                }
                parent = node;
            }
        }
        if(finalStr != null) {
            for(String st : finalStr) {
                System.out.println(st);
            }
        }
    }

    public String[][] getData(Node node) {
        String[][] finalArr = null;
        if(node.chCount == 0) {
            finalArr = new String[1][];
            int originalArrSi = node.chCount == node.namesCount ? node.chCount : node.chCount+1;
            String[] chiArr = new String[originalArrSi];
            for(int z1 = 0;z1 < originalArrSi;z1++) {
                chiArr[z1] = node.ch+"";
            }
            finalArr[0] = chiArr;
            return finalArr;
        } else {
            int originalArrSi = node.chCount == node.namesCount ? node.chCount : node.chCount+1;
            finalArr = new String[originalArrSi][];
            for(int i=0;i<node.chCount;i++) {
                String[][] chArr = getData(node.namesOrder[node.chArr[i]-'a']);
                int subArrTotal = 0;
                for(int z=0;z<chArr.length;z++) {
                    String[] stArr = chArr[z];
                    subArrTotal +=  stArr.length;
                    for(int x=0;x<stArr.length;x++) {
                        stArr[x] = node.ch+stArr[x];
                    }
                }
                String[] finalSubStr = new String[subArrTotal];
                for(int z=0,j=0;z<chArr.length;z++) {
                    String[] stArr = chArr[z];
                    for(int x=0;x<stArr.length;x++) {
                        finalSubStr[j++] = stArr[x];
                    }
                }
                finalArr[i] = finalSubStr;
            }
            if(node.chCount != node.namesCount) {
                finalArr[node.chCount] = new String[]{node.ch+""};
            }
            return finalArr;
        }
    }
    public void fillData(String vlue,Node parentNode) {
        Node parent = parentNode;
        for(char c : vlue.toCharArray()) {
            Node node = parent.namesOrder[c-'a'];
            if(node == null) {
                node = new Node();
                parent.namesOrder[c-'a'] = node;
                node.parent = parent;
                node.parent.chArr[node.parent.chCount] = c;
                node.parent.chCount++;
                node.ch = c;
            }
            node.namesCount++;
            parent = node;
        }
    }

    public static void main(String args[]) {

        TriesContacts_V1 triesCon = new TriesContacts_V1();
        triesCon.readData();
    }

}
