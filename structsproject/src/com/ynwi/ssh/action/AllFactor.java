package com.ynwi.ssh.action;

import java.util.ArrayList;

public class AllFactor {
    
	public static int[] getAllFactorLargestToSmallest(int arg){
		ArrayList<Integer> res = new ArrayList<Integer>();
		int factor = 2;
		if(arg<0)
			arg = -arg;
		int mid = arg/2;
		System.out.println("mid: "+mid);
		while(factor <= mid){
			if(arg%factor == 0){
				res.add(factor);
				System.out.println("factor: "+factor);
				for(int i=0; i<res.size(); i++){
				   if (factor!=res.get(i) && factor%res.get(i) == 0) {
					  res.remove(res.size()-1);
					  break;
				 }	
				}
			}
			factor++;
		}
		int[] array = new int[res.size()];
		for(int i=0; i<res.size(); i++){
			array[res.size()-1-i] = res.get(i);
			System.out.println(i+"tag"+"res: "+res.get(i));
		}
		return array;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("**********************************************");
		System.out.println("**                MENU 01                  ***");
		System.out.println("**   1. Calling getAllFactor()             ***");
		System.out.println("**   2. Quit                               ***");
		System.out.println("**********************************************");
		System.out.print("Select the option (1 or 2): ");
		java.util.Scanner sc1 = new java.util.Scanner(System.in);
		int option = sc1.nextInt();
		if(option == 2)
			System.out.println("  Have Fun ...");
		else if (option == 1){
			System.out.print("Enter an int: ");
			java.util.Scanner sc2 = new java.util.Scanner(System.in);
			int arg = sc2.nextInt();
			int[] array;
 			array = getAllFactorLargestToSmallest(arg);
 			StringBuilder sb = new StringBuilder();
 			for(int i=1; i< array.length; i++){
 				sb.append(array[array.length-1-i]);
 				sb.append(" ");
 			}
 			if (array.length>0) {
 				System.out.println(arg+" has the smallest factor of "+array[array.length-1]+"; and Other distinct factor(s) of "+sb.toString());
			}else{
				System.out.println(arg+" does not have a factor");
			}
 			
		}else{
			System.out.println("Wrong option number.");
		}
			
	}

}
