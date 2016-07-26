package wordpattern;

import java.util.Arrays;

public class wordpattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String pattern = "abba";
		String str = "cat dog dag cat";
		boolean test=wordPattern(pattern, str);
		System.out.println(test);
	}

	public static boolean wordPattern(String pattern1, String str1) {
		String[] strings = str1.split(" ");
		char[] pat = pattern1.toCharArray();
		System.out.println(Arrays.toString(strings));
		System.out.println(Arrays.toString(pat));
		boolean result=true;
		for (int i = 0; i < pat.length; i++) {
			if (pat[i] == ' ') {
				System.out.println("here");
				continue;
			} else {

				for (int j = i+1; j < pat.length; j++) {

					if (pat[j]==' ') {
						continue;
					}
					if (pat[i] == pat[j]) {
						pat[i] = ' ';
						pat[j] = ' ';
						System.out.println("equalsbefor i:"+i+"j:"+j);
						if (!strings[i].equals(strings[j])) {
							result = false;
							System.out.println("i:"+i+"j:"+j);
//							return false;
						}

					}
				}
			}
		}
		System.out.println(Arrays.toString(pat));
		if (result) {
			return true;
		}
		else {
			return false;
		}
	}

}
