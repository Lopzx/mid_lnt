import java.util.ArrayList;

public class Main {
	final static private String _ProgramName = "MID LnT";
	final static private int hWIDTH = 20;
	final static private int hHEIGHT = 3;
	
	public static void log_menu() {
		System.out.println("=".repeat(hWIDTH));
		for(int i = 0; i < hHEIGHT; i++) {
			if(i == hHEIGHT/2) {
				int calculate_middle = (hWIDTH - _ProgramName.length()) / 2;
				System.out.println("|"+" ".repeat(calculate_middle)+ _ProgramName + " ".repeat(calculate_middle-1) + "|");
			}else {
				System.out.printf("|%"+hWIDTH +"s", "|\n");
			}
		}
		System.out.println("=".repeat(hWIDTH));
		
		System.out.println(HelperFunct.middle_my_string("1. Input", hWIDTH, ' '));
		System.out.println(HelperFunct.middle_my_string("2.View", hWIDTH, ' '));
	}
	
	public static void main(String[] args) {
		
		
		while(true) {
			log_menu();
			short input = (short) HelperFunct.numberInput("Pilih Option > ", "Option tersedia [ 1 | 2 ]");
			switch(input) {
				case 1:
					Database.input();
					break;
				case 2:
					Database.view();
					break;
			}
			
		}
	}

}
