package org.ju.cse.gobinda.inventory.system;

public class NumberConverter {

	public static String convertBanglaNumberToEnglish(String banglaNumber) {
		int len = banglaNumber.length();
		char[] ch = banglaNumber.toCharArray();
		for (int i = 0; i < len; i++) {
			if (ch[i] == '-') {

			} else if ('০' <= ch[i] && ch[i] <= '৯') {
				ch[i] = (char) (ch[i] - '০' + '0');
			} else {
				return null;
			}
		}
		return String.valueOf(ch);
	}

	public static String convertEnglishNumberToBangla(String englishNumber) {
		int len = englishNumber.length();
		char[] ch = englishNumber.toCharArray();
		for (int i = 0; i < len; i++) {
			if (ch[i] == '-') {

			} else if ('0' <= ch[i] && ch[i] <= '9') {
				ch[i] = (char) (ch[i] + '০' - '0');
			} else {
				return null;
			}
		}
		return String.valueOf(ch);
	}

}
