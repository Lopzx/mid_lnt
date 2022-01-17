import java.util.ArrayList;
import java.util.Scanner;

class HelperFunct{
	static public Scanner scan = new Scanner(System.in);
	
	//beforePrintMessage = Message yang akan di tampilkan sebelum meminta input
	//characterToCheck = Jika String yang di input mengandung character tsb maka akan di minta input ulang
	//invalidInputMessage = Jika string yang di input tidak sesuai format maka akan print string invalidInput Message
	//Case Sensitive = false Not case Sensitive true if Case Sensitive
	public static String strInput(String beforePrintMessage, String characterToCheck, String invalidInputMessage , boolean caseSensitive) {
		String result = "";
		int characterToCheckLength = -1;
		while(true) {
			System.out.print(beforePrintMessage);
			result = scan.nextLine();
			characterToCheckLength = characterToCheck.length();
			if(result.length() == 0) {
				System.out.println("Input cannot be empty");
				continue;
			}
				
			boolean tempoFlag = true;
			if(caseSensitive) {
				while(--characterToCheckLength >= 0) {
					if(result.contains("" + characterToCheck.charAt(characterToCheckLength))){
						System.out.println(invalidInputMessage);
						tempoFlag = false;
						break;
					}else {
						tempoFlag = true;
					}
				}
			}else {
				while(--characterToCheckLength >= 0) {
					if(result.toLowerCase().contains("" + characterToCheck.toLowerCase().charAt(characterToCheckLength))){
						System.out.println(invalidInputMessage);
						tempoFlag = false;
						break;
					}else {
						tempoFlag = true;
					}
				}
			}
			if(tempoFlag) break;
		}
		return result;
	}
	
	//Return Number With Type Long
	public static long numberInput(String beforePrintMessage, String invalidInputMessage) {
		long number = (long) 0;
		while(true) {
			System.out.print(beforePrintMessage);
			try {
				number = scan.nextLong();
			} catch (Exception e) {
				System.out.println(invalidInputMessage);
				scan.nextLine();
				continue;
			}
			scan.nextLine();
			return number;
		}
	}
	
	public static String middle_my_string(String string, int Width, Character Padding) {
		int paddingLength = (Width - string.length()) / 2;
		String padding = Padding.toString().repeat(paddingLength);
		return padding + string + padding;
	}
	
	public  static <Type> boolean verify_option(Type to_be_check, ArrayList<Type> list) {
		return list.contains(to_be_check);
	}
	
	public  static boolean verify_option(String to_be_check, ArrayList<String> list,boolean case_sensitive) {
		if(case_sensitive) {
			return list.contains(to_be_check);
		}else {
			for(int i = 0; i < list.size(); i++) {
				list.set(i, list.get(i).toLowerCase());
			}
			return list.contains(to_be_check.toLowerCase());
		}
	}
	
	public static String string_length_verify(Integer value, String LogicalOperator, String beforePrintMessage, String characterToCheck, String invalidInputMessage , boolean caseSensitive) {
		boolean flag = true;
		String current = "";
		while(flag) {
			current = strInput(beforePrintMessage,characterToCheck,invalidInputMessage,caseSensitive);
			switch (LogicalOperator) {
			case ">=":
			  flag = (current.length() >= value ) ?  false : true;
			  break;
			case ">":
				flag = (current.length() > value ) ? false : true;
				break;
			case "<=":
				flag = (current.length() <= value) ? false : true;
				break;
			case "<":
				flag = (current.length() < value) ? false : true;
				break;
			case "=":
				flag = (current.length() == value) ? false : true;
				break;
			default:
				System.out.println(invalidInputMessage);
				break;
			}
		}
		return current;
	}
	
	public static String string_length_verify(Integer min, Integer max, String LogicalOperator, String beforePrintMessage, String characterToCheck, String invalidInputMessage , boolean caseSensitive) {
		boolean flag = true;
		String current = "";
		while(flag) {
			current = strInput(beforePrintMessage,characterToCheck,invalidInputMessage,caseSensitive);
			switch (LogicalOperator) {
			case ">==<":
			  flag = (current.length() >= min && current.length() <= max) ?  false : true;
			  break;
			case "><":
				flag = (current.length() > min && current.length() < max) ? false : true;
				break;
			case ">=<<":
				flag = (current.length() >= min && current.length() < max) ? false : true;
				break;
			case ">>=<":
				flag = (current.length() > min && current.length() <= max) ? false : true;
				break;
			default:
				System.out.println(invalidInputMessage);
				break;
			}
		}
		return current;
	}
	
	public static ArrayList<String> space_parse(String value){
		ArrayList<String> result = new ArrayList<>();
		String temporary = "";
		for(int i = 0 ; i < value.length(); i++) {
			if(value.charAt(i) != ' ') {
				temporary += value.charAt(i);
			}
			if(value.charAt(i) == ' ' || i == value.length() - 1) {
				result.add(temporary);
				temporary = "";
			}
		}
		return result;
	}
	
	public static boolean each_char_checker(String to_be_check,Character start, Character end) {
		int characterToCheckLength = to_be_check.length();
		boolean tempoFlag = false;
		for(int i = 0; i < characterToCheckLength; i++) {
			if(to_be_check.charAt(i) >= start && to_be_check.charAt(i) <= end ) {
				tempoFlag = true;
			}else {
				tempoFlag = false;
				return false;
			}
		}
		
		return tempoFlag;
	}
	
	public static long number_input_range(int min,int max,String logical,String beforePrintMessage, String invalidInputMessage) {
		long number = 0;
		boolean flag = true;
		while(flag) {
			number = numberInput(beforePrintMessage,invalidInputMessage);
			switch (logical) {
			case ">==<":
			  flag = (number >= min && number <= max) ?  false : true;
			  break;
			case "><":
				flag = (number > min && number < max) ? false : true;
				break;
			case ">=<<":
				flag = (number >= min && number < max) ? false : true;
				break;
			case ">>=<":
				flag = (number > min && number <= max) ? false : true;
				break;
			default:
				System.out.println(invalidInputMessage);
				break;
			}
		}
		return number;
	}
	
}
