package com.sunsat.sathish.java.hackerrank.preparation.general.begining;

public class Prog1 {
	public static void main(String[] args) {
		int s1=9;
		int s2=s1+1;
		int s=s2;
		int s3=s2/2;
		int rem=s1%2;

		if(rem!=0){

		for (int i = 0; i <s1; i++) {
		if(i<=s1/2){
		for (int j = 0; j <s2; j++) {
		if(j>=i&&j<s){
		if(j<5){
		System.out.print("* ");
		}else{
		System.out.print("$ ");
		}
		}
		else{
		System.out.print("  ");
		}
		}
		s--;
		System.out.println();
		}
		else{
		++s3;
		--s;
		for (int j = 0; j < s2; j++) {
		if(j>=s-1&&j<s3+1){
		if(j<5){
		System.out.print("$ ");
		}else{
		System.out.print("* ");
		}
		}
		else{
		System.out.print("  ");
		}
		}
		System.out.println();
		}

		}
		}
		else{
		System.out.println("Sorry !plz enter the Odd no");
		}
		}
		}



