import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class LongestPalindromicSubstring {

	static String getLongestPalindromicSubstring(String str) {
		int []current = {0, 1};

		for (int i = 1; i < str.length(); i++) {
			int[] odd = solve(str, i - 1, i + 1);
			int[] even = solve(str, i - 1, i);
			current=Collections.max(new ArrayList<int[]>(Arrays.asList(odd,even,current)),
				Comparator.comparing(a->a[1]-a[0]));
		}
		return str.substring(current[0],current[1]);
	}

	static int[] solve(String str,int pos1,int pos2){
		while(pos1>=0 && pos2<str.length()){
			if(str.charAt(pos1)!=str.charAt(pos2))
				break;
			pos1--;
			pos2++;
		}
		return new int[] {pos1+1,pos2};
	}

	public static void main(String[] args) {
		String s="abacgaabaa";
		System.out.println(getLongestPalindromicSubstring(s));
	}
}