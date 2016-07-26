package common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import javax.swing.tree.TreeNode;

public class common {

	 public int removeDuplicates(int[] nums) {
	        if(nums.length == 0) return 0;
	        int len = nums.length;
	        int temp = 0;
	        for(int i=1;i<len;i++){
	            if(nums[i]== nums[i-1])
	            {len--;
	             temp = i;
	             for(int j=temp+1;j<len;j++){
	                 nums[temp] = nums[j];
	                 temp++;
	             }
	             i--;
	            }
	            
	        }
	        return len;
	    } 
	 public List<List<Integer>> levelOrder(TreeNode root) {
	        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	        ArrayList<Integer> vals = new ArrayList<Integer>();
	        LinkedList<TreeNode> cur = new LinkedList<TreeNode>();
	        LinkedList<TreeNode> next = new LinkedList<TreeNode>();
	        if(!root) return null;
	        cur.add(root);
	        while(!cur.isEmpty()){
	        	TreeNode node = cur.remove();
	        	if(node.left!=null)
	        		next.add(node.left);
	        	if(node.right!=null) next.add(node.right);
	        	vals.add(node.val);
	        	if(cur.isEmpty()){
	        		cur = next;
	        		next = new LinkedList<TreeNode>();
	        		res.add(vals);
	        		vals = new ArrayList<Integer>();
	        	}
	        }
	        return res;
	    }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	String s = "a";
		//String t = "a";
//		System.out.println(strStr(s, t));
//		int[] a = {9};
		//String a ="111";
		//String b="111";
		HashSet<Integer> rec = new HashSet<Integer>();
		rec.contains(o)
		System.out.println(climbStairs(44));
//		System.out.println(lengthOfLastWord(s));
		HashMap<Character, ArrayList<Integer>> m = new HashMap<Character, ArrayList<Integer>>();
		
	}
	  public boolean static isIsomorphic(String s, String t) {
//		  HashMap<Character, ArrayList<Integer>> m = new HashMap<Character, ArrayList<Integer>>();
		  if(s.isEmpty()&&t.isEmpty()) return true;
		  if(s.length()!=t.length()) return false;
		  char[] schar = s.toCharArray();
		  char[] tchar = t.toCharArray();
		  HashMap<Character, Character> temp = new HashMap<Character, Character>();
		  for(int i=0;i<s.length();i++){
			  if (temp.containsKey(schar[i])) {
				if(temp.get(schar[i])!=tchar[i]) return false;
			}
			  else {
				if (temp.containsValue(tchar[i])) return false;
				else temp.put(schar[i], tchar[i]);
			}
		  }
		  return true;
	    }
public static List<List<Integer>> generate(int numRows) {
		if (numRows<1) return null;	
	    List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> mid = new ArrayList<Integer>();
        mid.add(1);
        res.add(mid);
        
        for(int i=2;i<=numRows;i++){

        	for(int j=1;j<=i;j++){
        		List<Integer> temp = new ArrayList<Integer>();
        		if(j==1) temp.add(1);
        		else if(j==i) {
        		temp.add(1);
        		res.add(temp);	}
        		else{
        			temp.add(res.get(i-1).get(j-1)+res.get(i-1).get(j));
        		}
        	}
        	
        }
        return res;
        
        
        
        
    }
	public static int climbStairs(int n) {
        if(n<=0) return 0;
        if(n==1) return 1;
        if(n==2) return 2;
        return climbStairs(n-1)+climbStairs(n-2);
    }
	 public static String addBinary(String a, String b) {
	        int la = a.length();
	        int lb = b.length();
	        int len = Math.max(la,lb);
	        if(la>lb){
	        	for (int i = 0; i < (la-lb); i++) {
					b="0"+b;
				}
	        }
	        if(la<lb){
	        	for (int i = 0; i < (lb-la); i++) {
					a="0"+a;
				}
	        }
	        System.out.println(a);
	        System.out.println(b);
//	        Integer.valueOf(a.charAt(0));
	        StringBuilder s1 = new StringBuilder();
	        String res = "";
	        int con = 0;
	        int mark=0;
	        for(int i =len-1;i>=0;i--){
	            con = a.charAt(i)+b.charAt(i)+mark-'0'-'0';
	         //   System.out.println(con+"valueX");
	            if (con==2) {
					con=0;
					mark=1;
				}
	            else if(con==3) {
					con=1;
					mark = 1;
				}else {
					mark = 0;
				}
	           res = con+res;
	          // System.out.println(res+"fdsa"+i);
	        }
	        if (mark==1) {
				res = "1"+res;
			}
	        return res;
	    }
	  public static int[] plusOne(int[] digits) {
	        int len = digits.length;
	        if(len==0) return null;
	       //int mark=0;
	       
	        for(int i=len-1;i>=0;i--){
	            if(digits[i]!=9){
	                digits[i]++;
	                break;
	            }
	            else if(i==0) 
	            {   
	              //  digits[0]=0;
	                int[] res = new int[digits.length+1];
	                res[0]=1;
	                return res;
	            }else{
	                digits[i]=0;
	                System.out.println("haha");
	            }
	            
	        }
	        return digits;
	    }
	public static  String countAndSay(int n) {
       
        String res = "1";
        if(n<=0) return null;
        if(n==1) return res;
        if(n>=2) res="11";
        //if(n==2) return s1.append(1).append(1).toString();
        for(int i=2;i<n;i++){
        	res = res(res);
        }
        return res;
    }
	public static String res(String x){
		 int count=1;
		StringBuilder s1 = new StringBuilder();
		String s;
        for(int j=1;j<x.length();j++){

           if(x.charAt(j)==x.charAt(j-1)){
               count++;
                            } 
           else{
                s1.append(count).append(x.charAt(j-1));
                s = s1.toString();
                count = 1;
                            }
           
        }
        s1.append(count).append(x.charAt(x.length()-1));
        s = s1.toString();
      //  count=1;
        //System.out.println(s);
        return s;
	}
	 public static int lengthOfLastWord(String s) {
	        int len= s.length();
	        if(len==0) return 0;
	        int max=0;
	        int count =0;
	        for(int i=0;i<len;i++){
	            if(s.charAt(i)!=' '){
	                count++;
	                System.out.println("here");
	            }
	            else{
	            	System.out.println("???");
	                System.out.println(max);
	                count=0;
	            }
	            if(count>max) max=count;
	            
	        }
	        return max;
	    }
	public static int strStr(String haystack, String needle) {
        int hlen = haystack.length();
        int nlen = needle.length();
        if(haystack==null || needle == null) return -1;
        if(nlen==0) return 0;
        int i=0;
        int j=0;
        for(i=0;i<hlen-nlen+1;i++){
            if(haystack.charAt(i)==needle.charAt(0)){
                for(j=(i+1);j<(nlen+i);j++){
                    if(haystack.charAt(j)!=needle.charAt(j-i)) break;
                }
            }
//            System.out.println("hahah"+j);
            if(j==nlen+i) break;
        }
        
        return i = (j-i==nlen)? i:-1;
        
    }
	

}
