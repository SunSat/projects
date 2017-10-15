package com.sunsat.sathish.java.hackerrank.preparation.general;

public class StarPrograms {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s="*";
		int m=5,n=3;
	    int k=m/2;
        for(int i = 0; i < m; i++){
        	if(i<3){
                for(int j = 0; j < n; j++){
                    if(i <= j) {
                    	System.out.print(s);
                    }
                    else{
                        System.out.print(" ");
                    }
                 }
                 System.out.println("");
        	}
            if(i>3){
				for (int l = m - 1; l >= k; l--) {
                	if(i>=l){
                		System.out.print(s);
                	}else{
                       System.out.print(" ");
                   }
                }
                System.out.println("");
            }
        }
	}

}
/*
 * o/p   *****
 * 		  ****
 * 		   ***
 * 			**
 * 			 *
 * 			**
 * 		   ***
 * 		  ****
 * 		 *****				
 * */
