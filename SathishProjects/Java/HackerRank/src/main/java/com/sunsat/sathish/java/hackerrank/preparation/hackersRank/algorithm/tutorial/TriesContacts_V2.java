package com.sunsat.sathish.java.hackerrank.preparation.hackersRank.algorithm.tutorial;

import java.util.Scanner;

/**
 * Created by ssundar2 on 03-02-2017.
 */
public class TriesContacts_V2 {
    Node rootNode = new Node();
    class Node {
        int chArrCount = 0;
        char[] chArr = new char[26];
        char ch = 0;

        Node parent = null;
        Node[] childNode = new Node[26];
        boolean isAvailable=false;
    }

    public static void main(String args[]) {
        TriesContacts_V2 triesCon = new TriesContacts_V2();
        triesCon.readData();
    }

    public void readData() {
        Scanner s = new Scanner(System.in);
        while(true) {
            String op = s.next();
            String value = s.next();
            if(op.equals("add")) {
                fillData(value,rootNode);
            } else if(op.equals("find")) {
                try {
                    findData(value,rootNode);
                } catch(Exception e) {
                    e.printStackTrace();
                }
            } else if(op.equals("exit")) {
                break;
            }
        }
    }
    public void fillData(String vlue,Node parentNode) {
        Node parent = parentNode;
        char[] chArr = vlue.toCharArray();
        for(int i=0;i<chArr.length;i++) {
            char c = chArr[i];
            Node node = parent.childNode[c-'a'];
            if(node == null) {
                node = new Node();
                parent.childNode[c-'a'] = node;
                node.parent = parent;
                node.parent.chArr[node.parent.chArrCount] = c;
                node.parent.chArrCount++;
                node.ch = c;
            }
            if(i == chArr.length-1) {
                node.isAvailable = true;
            }
            parent = node;
        }
    }

    public void findData(String value, Node parentNode) {
        String[] finalStr = null;
        Node parent = parentNode;
        char[] val = value.toCharArray();
        String finalSt = "";
        for(int i = 0;i<val.length;i++) {
            finalSt +=val[i]+"";
            Node node = parent.childNode[val[i]-'a'];
            if(node == null) {
                break;
            } else{
                if(i == val.length-1) {
                    String[][] stArr = getData(node);
                    int totalCon  =0;
                    for(String[] st : stArr) {
                        for(String s : st) {
                            System.out.println(finalSt.substring(0,finalSt.length()-1)+s);
                            totalCon++;
                        }
                    }
                    System.out.println("total contacts available is : " + totalCon);
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
        if(node.chArrCount == 0) {
            finalArr = new String[1][1];
            finalArr[0] = new String[]{node.ch+""};
            return finalArr;
        } else {
            int oriArrCount = node.chArrCount != 0 ? node.isAvailable == true ? node.chArrCount+1 : node.chArrCount : node.chArrCount;
            finalArr = new String[oriArrCount][];
            for(int i=0;i<node.chArrCount;i++) {
                String[][] chArr = getData(node.childNode[node.chArr[i]-'a']);
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
            if(node.chArrCount != 0 && node.isAvailable == true) {
                finalArr[node.chArrCount] = new String[]{node.ch+""};
            }
            return finalArr;
        }
    }
}
