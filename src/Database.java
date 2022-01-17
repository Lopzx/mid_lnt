import java.util.ArrayList;
import java.util.Arrays;



public class Database {
	final static private int hWIDTH = 40;
	final static private int hHEIGHT = 3;
	final static private int hPARTITION = hWIDTH/3;
	
	static private ArrayList<Indexing> Index = new ArrayList<>();
	static private ArrayList<Car> CarDatabase = new ArrayList<>();
	static private ArrayList<Motorcycle> MotorDatabase = new ArrayList<>();
	
	public static boolean license_verify(String license) {
		ArrayList<String> parse_value = HelperFunct.space_parse(license);
		if(parse_value.size() != 3) {
			return false;
		}
		Integer satisfy_flag = 0;
		String front = parse_value.get(0);
		String middle = parse_value.get(1);
		String back = parse_value.get(2);
		String sequenceNumber = "1234567890";
		String sequenceNonCapital = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toLowerCase();
		if(HelperFunct.each_char_checker(front, 'A' , 'Z') && front.length() == 1) {
			satisfy_flag++;
		}
		if(HelperFunct.each_char_checker(middle, '0' , '9') && middle.length() >= 1 && middle.length() <= 4 ) {
			satisfy_flag++;
		}
		if(HelperFunct.each_char_checker(back, 'A' , 'Z') && back.length() >= 1 && back.length() <= 3 ) {
			satisfy_flag++;
		}
		if(satisfy_flag == 3) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public static void input() {
		String input_type = "";
		while(true) {
			input_type = HelperFunct.strInput("Input type [Car | Motorcycle] > ","", "", true);
			if(HelperFunct.verify_option(input_type, new ArrayList<String>(Arrays.asList("Car","Motorcycle")),true)) {
				break;
			}else {
				System.out.println("Invalid Option");
			}
			
		}
		String input_brand = HelperFunct.string_length_verify(5, ">=", "Input brand [>= 5] > ", "", "Invalid Input", false);
		String input_name = HelperFunct.string_length_verify(5, ">=", "Input name [>= 5] > ", "", "Invalid Input", false);
		String input_license = "";
		while(true) {
			input_license = HelperFunct.strInput("Input license FORMAT :[[A-Z Length 1] [0-9 Length 1-4] [A-Z Length 1-3]] > " , "", "Invalid Input", false);
			if(license_verify(input_license)) {
				break;
			}else {
				System.out.println("Invalid Format");
			}
		}
		
		int input_speed = (int) HelperFunct.number_input_range(100, 250, ">==<", "Input top speed [100 <= topSpeed <= 250] > ", "Invalid Input");
		int input_cap = (int) HelperFunct.number_input_range(30 , 60, ">==<", "Input gas capacity [30 <= gasCap <= 60] > ", "Invalid Input");
		int input_wheel = 0;
		if(input_type.matches("Motorcycle")) {
			input_wheel = (int) HelperFunct.number_input_range(2 , 3, ">==<", "Input wheel [2 <= Wheel <= 3] > ", "Invalid Input");
			String input_motor_type = "";
			while(true) {
				input_motor_type = HelperFunct.strInput("Input type [Automatic | Manual] > ","", "", false);
				if(HelperFunct.verify_option(input_motor_type, new ArrayList<String>(Arrays.asList("Automatic","Manual")),true)) {
					break;
				}else {
					System.out.println("Invalid Option");
				}
			}
			int input_helm = 0;
			while(true) {
				input_helm = (int) HelperFunct.numberInput("Input helm [>= 1] > ", "Invalid Input");
				if(input_helm >= 1) {
					break;
				}else {
					System.out.println("Invalid Input");
				}
			}
			store(new Motorcycle(input_type,input_brand,input_name,input_license,input_speed,input_cap,input_wheel,input_motor_type,input_helm));
			
		}else if(input_type.matches("Car")) {
			input_wheel = (int) HelperFunct.number_input_range(4 , 6, ">==<", "Input wheel [4 <= gasCap <= 6] > ", "Invalid Input");
			String input_car_type = "";
			while(true) {
				input_car_type = HelperFunct.strInput("Input type [SUV | Supercar | Minivan] > ","", "", false);
				if(HelperFunct.verify_option(input_car_type, new ArrayList<String>(Arrays.asList("SUV","Supercar","Minivan")),true)) {
					break;
				}else {
					System.out.println("Invalid Option");
				}
			}
			int input_enter = 0;
			while(true) {
				input_enter = (int) HelperFunct.numberInput("Input entertainment system amount [>= 1] > ", "Invalid Input");
				if(input_enter >= 1) {
					break;
				}else {
					System.out.println("Invalid Input");
				}
			}
			store(new Car(input_type,input_brand,input_name,input_license,input_speed,input_cap,input_wheel,input_car_type,input_enter));
			
		
		}
		
		
	}
	
	public static void store(Motorcycle motor) {
		Index.add(new Indexing(MotorDatabase.size(),"Motorcycle"));
		MotorDatabase.add(motor);
	}
	
	public static void store(Car car) {
		Index.add(new Indexing(CarDatabase.size(),"Car"));
		CarDatabase.add(car);
	}
	
	
	public static void view() {
		final String TABLENAME = "TABLE"; 
		System.out.println("=".repeat(hWIDTH));
		for(int i = 0; i < hHEIGHT; i++) {
			if(hHEIGHT / 2 == i) {
				int calculate_middle = (hWIDTH - TABLENAME.length()) / 2;
				System.out.println("|"+" ".repeat(calculate_middle)+ TABLENAME + " ".repeat(calculate_middle-1) + "|");
			}else {
				System.out.printf("|%"+hWIDTH+"s","|\n");
			}
			
		}
		System.out.println("=".repeat(hWIDTH));
		System.out.printf("%-"+ hPARTITION+ "s" + "%-"+ hPARTITION+ "s" + "%-"+ hPARTITION+ "s\n","No", "Type", "Name");
		    for(int i = 0; i < Index.size(); i++) {
				Indexing data = Index.get(i);
				if(data.type.matches("Motorcycle")) {
					Motorcycle motor = MotorDatabase.get(data.index);
					System.out.printf("%-"+ hPARTITION+ "d" + "%-"+ hPARTITION+ "s" + "%-"+ hPARTITION+ "s\n",i+1, motor.get_type(), motor.get_name());
				}else if (data.type.matches("Car")) {
					Car car = CarDatabase.get(data.index);
					System.out.printf("%-"+ hPARTITION+ "d"+ "%-"+ hPARTITION+ "s" + "%-"+ hPARTITION+ "s\n",i+1, car.get_type(), car.get_name());
				}
				
			}
		    
		    int test_drive_option = (int) HelperFunct.number_input_range(0, Index.size(), ">==<", "Pick a vehicle number to test drive[Enter 0 to exit] > ", "Invalid Input!");
		    if(test_drive_option == 0) {
		    	return;
		    }
		    Indexing data = Index.get(test_drive_option-1);
		    if(data.type.matches("Car")) {
		    	CarDatabase.get(data.index).start_engine();
		    }else {
		    	MotorDatabase.get(data.index).start_engine();
		    }
		}
}
