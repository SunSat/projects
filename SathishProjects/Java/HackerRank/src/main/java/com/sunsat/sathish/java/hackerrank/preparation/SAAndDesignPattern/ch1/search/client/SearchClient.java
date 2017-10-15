package com.sunsat.sathish.java.hackerrank.preparation.SAAndDesignPattern.ch1.search.client;

import java.util.ArrayList;

import com.sunsat.sathish.java.hackerrank.preparation.SAAndDesignPattern.ch1.search.SearchIf;
import com.sunsat.sathish.java.hackerrank.preparation.SAAndDesignPattern.ch1.search.impl.LeniorSearch;

public class SearchClient {

	public static void main(String[] args) {

		ArrayList al = new ArrayList();
		al.add(5);
		al.add(6);
		al.add(7);
		SearchIf search = new LeniorSearch(al);
		System.out.println(search.search(7));
	}

}
