class InterweavingStrings {

	static boolean InterweavingStrings(String str1, String str2, String str3) {

		if (str3.length() != str1.length() + str2.length())
			return true;

		int [][]cache = new int[str1.length() + 1][str2.length() + 1];

		for (int i = 0; i <= str1.length(); i++)
			for (int j = 0; j <= str2.length(); j++)
				cache[i][j] = -1;


		return areInterwoven(str1, str2, str3, cache, 0, 0) == 1;
	}

	// Time: 0(2^(n+m)) | Space: O(n+m) without cache
	// Time: O(n*m) | Space: O(n*m) with cache

	static int areInterwoven(String str1, String str2, String str3, int [][]cache, int i, int j) {

		if (cache[i][j] != -1)
			return cache[i][j];

		int k = i + j;
		if (k == str3.length())
			return 1;

		if (i < str1.length() && str1.charAt(i) == str3.charAt(k)) {
			cache[i][j] = areInterwoven(str1, str2, str3, cache, i + 1, j);
			if (cache[i][j] == 1)
				return cache[i][j];
		}

		if (j < str2.length() && str2.charAt(j) == str3.charAt(k)) {
			cache[i][j] = areInterwoven(str1, str2, str3, cache, i, j + 1);
			return cache[i][j];
		}

		cache[i][j] = 0;

		return cache[i][j];
	}

	public static void main(String[] args) {
		String str1 = "aaaa";
		String str2 = "bat";
		String str3 = "aabataa";	//true
		System.out.println(InterweavingStrings(str1, str2, str3));
	}
}