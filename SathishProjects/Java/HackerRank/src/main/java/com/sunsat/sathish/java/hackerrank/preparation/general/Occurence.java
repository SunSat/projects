package com.sunsat.sathish.java.hackerrank.preparation.general;

import java.util.HashMap;
import java.util.Map;

public class Occurence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		String[] st=new String[] {"one", "what","Hello what", "How","how what","Good one", "Bad one", "badhello"};
		int n=0;
		HashMap<String, Integer> hm=new HashMap<String, Integer>();
		for(int i=0;i<st.length;i++){
			hm.put(st[i].toLowerCase(), 1);
		}
		for(int i=0;i<st.length;i++){
			String s1=st[i].toLowerCase();
			for(int j=i+1;j<=st.length-1;j++){
				String s2=st[j].toLowerCase();
				n=0;String s3="";
				int index2=s2.indexOf(s1);
				if(index2>=0 && hm.containsKey(s1)){
					hm.put(s1, hm.get(s1)+1);
				}
			}
		}
		for(Map.Entry<String, Integer> m: hm.entrySet()){
			System.out.println(m.getKey() +" : "+m.getValue());
		}
		
	}

}
