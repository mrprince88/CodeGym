class PalindromeCheck {

	//O(n) space && O(n) time
	static boolean Palindrome1(String str) {
		StringBuffer sb = new StringBuffer();
		for (int i = str.length() - 1; i >= 0; i--)
			sb.append(str.charAt(i));

		return sb.toString().equals(str);
	}

	//O(n) space && O(n) time
	static boolean PalindromeRecursive(String str, int i) {
		int j = str.length() - 1 - i;
		return i <= j ? true : str.charAt(i) == str.charAt(j) && PalindromeRecursive(str, i + 1);
	}

	// O(1) space && O(n) time
	static boolean Palindrome2(String str) {
		int i = 0, j = str.length() - 1;
		while (j > i) {
			if (str.charAt(i) != str.charAt(j))
				return false;
			j--;
			i++;
		}
		return true;
	}

	public static void main(String[] args) {
		String str = "abccba";
		System.out.println(Palindrome1(str));
		System.out.println(PalindromeRecursive(str, 0));
		System.out.println(Palindrome2(str));
	}
}