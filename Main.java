package com.aurimaskuniutis;

public class Main {

	public static void main(String[] args) {
		
		printBonusDatesBetween(2010, 2015);

	}
	
	public static void printBonusDatesBetween(int fromYear, int toYear) {
		for(int y = fromYear; y < toYear; y++) {
			for(int m = 1; m <= 12; m++) {
				for(int d = 1; d <= getDaysInMonth(m, y); d++) {
					
					if(m < 10) {
						if(d < 10) {
							if(isPalindrome(Integer.parseInt(y + "0" + m + "0" + d))) {
								System.out.println(y + "-0" + m + "-0" + d);
							}
						} else {
							if(isPalindrome(Integer.parseInt(y + "0" + m + "" + d))) {
								System.out.println(y + "-0" + m + "-" + d);
							}
						}
					} else {
						if (d < 10) {
							if(isPalindrome(Integer.parseInt(y + "" + m + "0" + d))) {
								System.out.println(y + "-" + m + "-0" + d);
							}
						} else {
							if(isPalindrome(Integer.parseInt(y + "" + m + "" + d))) {
								System.out.println(y + "-" + m + "-" + d);
							}
						}
					}
				}
			}
		}
	}
	
	public static boolean isPalindrome(int number) {
		if(number < 0) {
			number = number * -1;
		}
		
		int reversed = 0;
		int original = number;
		
		while(number != 0) {
			reversed = reversed * 10 + number % 10;
			number /= 10;
		} return original == reversed;	
	}
	
	public static int getDaysInMonth(int month, int year) {
		
		if(year < 1 || year > 9999 || month < 1 || month > 12) {
			return -1;
		} else {
			
			switch (month) {		
			case 4: case 6: case 9: case 11:
				return 30;

			case 2:
				return (isLeapYear(year)) ? 29 : 28;
				
			default:
				return 31;
			}
		}
		
	}
	public static boolean isLeapYear(int year) {
		if(year < 1 || year > 9999) {
			return false;
		} else if (year % 4 == 0) {
			if(year % 100 == 0) {
				if(year % 400 != 0) {
					return false;
				}
			}
		} else {
			return false;
		}
		return true;
	}

}
