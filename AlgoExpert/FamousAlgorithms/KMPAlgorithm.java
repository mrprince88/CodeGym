//String Matching Algorithm

// Complexity 0(N+M)
class KMPAlgorithm {

	static boolean KMPMatch(String string, String substring) {
		int N = string.length();
		int M = substring.length();

		int i = 0, j = 0;
		int []pattern = buildPattern(substring);

		while (i + M - j <= N) {

			if (string.charAt(i) == substring.charAt(j)) {
				if (j == M - 1)
					return true;
				i++; j++;
			}

			else if (j > 0)
				j = pattern[j - 1] + 1;

			else
				i++;
		}

		return false;
	}

	static int[] buildPattern(String substring) {

		int []pattern = new int[substring.length()];

		for (int i = 0; i < pattern.length; i++)
			pattern[i] = -1;

		int i = 1, j = 0;

		while (i < substring.length()) {

			if (substring.charAt(i) == substring.charAt(j)) {
				pattern[i] = j;
				i++; j++;
			}

			else if (j > 0)
				j = pattern[j - 1] + 1;

			else
				i++;
		}

		return pattern;
	}

	public static void main(String[] args) {
		String string = "aefaefaasefeafaase";
		String substring = "faase";
		System.out.println(KMPMatch(string, substring));
	}
}