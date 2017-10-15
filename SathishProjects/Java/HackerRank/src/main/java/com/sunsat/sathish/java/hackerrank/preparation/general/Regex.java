package com.sunsat.sathish.java.hackerrank.preparation.general;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
	public static void main(String ... args) {
		/*String regex = "[0-9]*\\.[0-9]*";
		String result = "";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher("left: 133.541%; margin-left: -5px; ");
		if(m.find()) {
			result = m.group();
		}
		System.out.println(result);*/
		String regex = "[\\d]+";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher("left: 502%;");
		System.out.println(m.find());
		System.out.println(m.group());
	}

}
