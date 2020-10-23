import java.util.*;

class SmallestSubstringContaining {

	static String getSubstring(String str, String subchar) {

		HashMap<Character, Integer> freq = new HashMap<>();
		freq(subchar, freq);

		HashMap<Character, Integer> subfreq = new HashMap<>();
		char[] string = str.toCharArray();
		int numOfUnique = freq.size();

		int rightIdx = 0, leftIdx = 0, unique = 0, startIdx = 0, endIdx = Integer.MAX_VALUE;

		while (rightIdx < string.length) {

			int c = subfreq.getOrDefault(string[rightIdx], 0);
			subfreq.put(string[rightIdx], ++c);

			if (!freq.containsKey(string[rightIdx])) {
				rightIdx++;
				continue;
			}

			if (subfreq.get(string[rightIdx]) == freq.get(string[rightIdx]))
				unique++;

			while (unique == numOfUnique && leftIdx <= rightIdx) {

				if (endIdx - startIdx > rightIdx - leftIdx) {
					startIdx = leftIdx;
					endIdx = rightIdx;
				}

				if (!freq.containsKey(string[leftIdx])) {
					leftIdx++;
					continue;
				}

				if (subfreq.get(string[leftIdx]) == freq.get(string[leftIdx])) {
					unique--;
					subfreq.put(string[leftIdx], freq.get(string[leftIdx]) - 1);
				}
				leftIdx++;
			}
			rightIdx++;
		}

		return (endIdx < str.length()) ? str.substring(startIdx, endIdx + 1) : "";
	}

	static void freq(String str, HashMap<Character, Integer> freq) {
		for (int i = 0; i < str.length(); i++) {
			int c = freq.getOrDefault(str.charAt(i), 0);
			freq.put(str.charAt(i), ++c);
		}
	}

	public static void main(String[] args) {
		String str = "abcd$ef$axb$c$";
		String subchar = "$$abf";
		System.out.println(getSubstring(str, subchar));
	}
}

/*
OUTPUT: f$axb$
*/
