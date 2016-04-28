
public class palindrome {
	public static String longestPalindrome(String s) {
		if (s == null || s.length() == 0) return null;
		
		int len = s.length();
		int max = 0, begin = 0, end = 0;
		for (int i = 0; i < len; i++) {
			for (int j = i; j < len; j++) {
				if (isPalindrome(s, i, j)) {
					if (max < j - i + 1) {
						max = j - i + 1;
						begin = i;
						end = j;
					}
				}
			}
		}
		return s.substring(begin, end + 1);
	}
	
	private static boolean isPalindrome(String s, int i, int j) {
		if (i >= j) return true;
		return s.charAt(i) == s.charAt(j) && isPalindrome(s, i + 1, j - 1);
	}
	
	public static String longestPalindrome2(String s) {
		int len = s.length();
		boolean[][] palindrome = new boolean[len][len];
		int maxLength = 1, start = 0;
		
		for (int i = 0; i < len; i++) {
			palindrome[i][i] = true;
		}
		
		for (int i = 0; i < len - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				palindrome[i][i + 1] = true;
				maxLength = 2;
				start = i;
			}
		}
		
		for (int curLen = 3; curLen <= len; curLen++) {
			for (int i = 0; i < len - curLen + 1; i++) {
				int j = curLen + i - 1;
				if (s.charAt(i) == s.charAt(j) && palindrome[i + 1][j - 1]) {
					palindrome[i][j] = true;
					maxLength = curLen;
					start = i;
				}
			}
		}
		return s.substring(start, start + maxLength);
	}

	public static void main(String[] args) {
		String s = "abacc";
		System.out.println(longestPalindrome2(s));
    }
}
