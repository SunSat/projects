package com.sunsat.sathish.java.hackerrank.preparation.general.begining;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Test3{
public static void main(String[] args) {
String nameArr [] = new String[]{"one","two","12","one","two","hello","one"} ;
  
Map map=new HashMap();
for (int i =0; i <nameArr.length; i++) {
String s=nameArr[i];
int occur=0;
for (int j = 0; j < nameArr.length; j++) {
String s1=nameArr[j];
if(s.equals(s1)){
occur++;
}
//map.put(s, occur);
}
}
Set set=map.entrySet();
Iterator it=set.iterator();
     while(it.hasNext()){
    Map.Entry en=(Map.Entry)it.next();
    System.out.println(en.getKey()+" "+en.getValue());
     }
}
}
