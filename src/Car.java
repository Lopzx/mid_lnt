
public class Car extends Kendaraan implements InterfaceKendaraan {
	private Integer _System;
	
	public Integer get_System() {
		return _System;
	}
	public Car(String _Type, String _Brand, String _Name, String _License, Integer _TopSpeed, Integer _GasCap,
			Integer _Wheel, String _Jenis, Integer _System) {
		super(_Type, _Brand, _Name, _License, _TopSpeed, _GasCap, _Wheel, _Jenis);
		this._System = _System;
	}
	
	public void start_engine() {
		super.get_details();
		System.out.println("Entertainment System: " + get_System());
		System.out.println("Turning on entertainment system...");
		if(get_jenis().matches("Supercar")) {
			System.out.println("Boosting!");
		}
	}
	
}