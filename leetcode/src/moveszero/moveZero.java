package moveszero;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class moveZero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums= {0,  0};
		int leng = nums.length;
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			arrayList.add(nums[i]);
		}	
		for (int i = 0; i < nums.length; i++) {
			if(arrayList.get(i).intValue()==0){
				arrayList.add(0);
			}
		}
//		System.out.println(arrayList);
		for (int i = 0; i < leng; i++) {
			if(arrayList.get(i).intValue()==0){
				arrayList.remove(i);
				leng--;
				i--;
			}
			System.out.println(arrayList);
		}
//		if(arrayList.get(0).intValue()==0){
//			arrayList.remove(0);
//			//leng--;
//		}
		// nums=new int[arrayList.size()];
		for (int i = 0; i < arrayList.size(); i++) {
			nums[i]=arrayList.get(i).intValue();
		}
	//	int[] nums1 = (int[]) arrayList.toArray(new int[arrayList.size()]);
//		System.out.println(arrayList);
		System.out.println(Arrays.toString(nums));
	}

}
