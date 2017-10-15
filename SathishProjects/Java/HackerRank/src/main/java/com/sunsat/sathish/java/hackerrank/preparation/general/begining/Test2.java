package com.sunsat.sathish.java.hackerrank.preparation.general.begining;

public class Test2 {
public static void main(String[] args) {
String s1="";
int mid=0;
String[] nameArr=new String[]{"one","two","three","four","I","me","howareYou"};
for (int i = 0; i < nameArr.length; i++) {
s1=nameArr[i];
mid=s1.length()/2;
char c=s1.charAt(mid);
String s2=String.valueOf(c);
s2=s2.toUpperCase();
c=s2.charAt(0);
s1=s1.replace(s1.charAt(mid), c);
nameArr[i]=s1;
}

for (int i = 0; i < nameArr.length; i++) {
System.out.println(nameArr[i]);
}
}
}
