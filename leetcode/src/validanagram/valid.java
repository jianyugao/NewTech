package validanagram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class valid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String s;
//		String t;
//		if (s.length()!=t.length()) {
//			return false;
//		}		
		String[] strs  = new String[2];
		String s2 = "()";
		System.out.println(isValid(s2));
		Stack<Character> s1 = new Stack<Character>();
		
		//System.out.println(isPalindrome(100));
		
	}
	public static boolean isValid(String s) {
        if(s.length()==0 || s.length()%2==1) return false;
        Stack<Character> s1 = new Stack<Character>();
        // s1.push(s.charAt(0));
        for(int i=0;i<s.length();i++){
        	System.out.println(s.charAt(i));
            if(s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{') 
            {
            	s1.push(s.charAt(i));
            	System.out.println("comes here");	
            }
            else
 {
				if (s1.isEmpty())
				{System.out.println("comes here1");	
				return false;}
				switch (s1.pop()) {
				case '(':
					if (s.charAt(i) != ')')
						{System.out.println("comes here2");	
						return false;}
					System.out.println("here2");
					//break;
				case '[':
					if (s.charAt(i) != ']')
					{System.out.println("comes here3");	
					return false;}
					System.out.println("here3");
				case '{':
					if (s.charAt(i) != '}')
					{System.out.println("comes here4");	
					return false;}
					System.out.println("here4");

				}
			}
                
            }
            if(s1.isEmpty()) return true;
            else return false;
        //return true;
        }
	 public static boolean isPalindrome(int x) {
	        if(x<=9 ) return true;
	        //if(x<0) return false;
	        String s = Integer.toString(x);
	        char[] a1 = new char[s.length()/2];
	        char[] a2= new char[s.length()/2];
	        for(int i=0; i<s.length()/2;i++)
	        a1[i] = s.charAt(i);
	        int j=0;
	        for(int i=(s.length()-1);i>(s.length()%2==0?s.length()/2-1:s.length()/2);i--){
	        	System.out.println(i);
	        	System.out.println();
	        	System.out.println(j);
	        	a2[j] = s.charAt(i);
	            j++;
	        }
	        for(int i=0; i<s.length()/2;i++){
	            if(a1[i]!=a2[i]) return false;
	        }
	        return true;
	    }
}
