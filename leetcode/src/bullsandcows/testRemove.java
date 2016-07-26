package bullsandcows;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class testRemove {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> a1 = new ArrayList<Integer>();
		a1.add(1);
		a1.add(2);
		a1.forEach(s->System.out.println(s));
		ArrayList<Integer> b1 = new ArrayList<Integer>();
		b1.add(0);
		int c = b1.get(0);
		a1.remove(c);
		a1.forEach(s->System.out.println(s));
	}

}
