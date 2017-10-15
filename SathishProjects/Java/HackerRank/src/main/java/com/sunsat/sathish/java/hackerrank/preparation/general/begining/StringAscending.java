package com.sunsat.sathish.java.hackerrank.preparation.general.begining;

public class StringAscending {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String x,y;
		String[] arr={"cc","kk","aa","ee"};
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr.length-1;j++)
			{
				x=arr[j];
				y=arr[j+1];
				if(x.compareTo(y)>0)
				{
				arr[j]=y;
				arr[j+1]=x;
				}
				
			}
		
		}
		for(String a : arr) {
			System.out.println(a);
		}	
	}
}
