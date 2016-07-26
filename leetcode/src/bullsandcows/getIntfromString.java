package bullsandcows;

import java.util.ArrayList;
import java.util.HashSet;

public class getIntfromString {

	/**
	 * @param args
	 */
	public static ArrayList<Integer> getEle(String s1) {
		char[] a1 = new char[s1.length()];
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for (int i = 0; i < s1.length(); i++) {
			a1[i] = s1.charAt(i);
			nums.add(Integer.parseInt(String.valueOf(a1[i])));
		}
		return nums;
	}

	public static void getSingle(ArrayList<Integer> array) {
		HashSet<Integer> h = new HashSet<Integer>(array);
		array.clear();
		array.addAll(h);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String answer = "1122";
		String guess = "2211";

		ArrayList<Integer> aint1 = new ArrayList<Integer>();
		ArrayList<Integer> gint1 = new ArrayList<Integer>();
		int bulls = 0;
		int cows = 0;
		ArrayList<Integer> position = new ArrayList<Integer>();
		aint1 = getEle(answer);
		gint1 = getEle(guess);
		System.out.println(aint1);
		System.out.println(gint1);
		for (int i = 0; i < gint1.size(); i++) {
			if (aint1.get(i) == gint1.get(i)) {
				bulls++;
				position.add(i);
			}

		}
		position.forEach(s->System.out.println(s));
		System.out.println("above is the position");
		for (int i = position.size() - 1; i >= 0; i--) {
			// if (position.size() == aint1.size()) {
			// aint1.clear();
			// gint1.clear();
			// }
			// else {
			aint1.forEach(s->System.out.println(s));
			gint1.forEach(s->System.out.println(s));
			System.out.println(position.get(i));
			aint1.remove(position.get(i).intValue());
			gint1.remove(position.get(i).intValue());
//			aint1.remove(0);
//			gint1.remove(0);
			System.out.println("comes here");
			aint1.forEach(s->System.out.println(s));
			gint1.forEach(s->System.out.println(s));
//			System.out.println(aint1);
//			System.out.println(gint1);
			// }
		}
		// System.out.println(aint1);
		// System.out.println(gint1);
		// position.forEach(s->{
		// aint1.remove(s);
		// gint1.remove(s);
		// });
//		getSingle(aint1);
		getSingle(gint1);
		for (int i = 0; i < aint1.size(); i++) {
			// System.out.println(aint1.size());
			// System.out.println(gint1.size());
			for (int j = 0; j < gint1.size(); j++) {
				if (aint1.get(i) == gint1.get(j)) {
					cows++;
				}
			}
		}
		StringBuffer str = new StringBuffer();
		str.append(bulls);
		str.append('A');
		str.append(cows);
		str.append('B');
		System.out.println(str);
	}

}
