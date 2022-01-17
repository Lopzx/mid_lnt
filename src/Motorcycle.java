
public class Motorcycle extends Kendaraan implements InterfaceKendaraan {
	private Integer _Helm;
	private Integer _HelmPrice;

	public Integer get_Helm() {
		return _Helm;
	}
	

	public Motorcycle(String _Type, String _Brand, String _Name, String _License, Integer _TopSpeed, Integer _GasCap,
			Integer _Wheel, String _Jenis, Integer _Helm) {
		super(_Type, _Brand, _Name, _License, _TopSpeed, _GasCap, _Wheel, _Jenis);
		this._Helm = _Helm;
	}
	
	public Integer get_HelmPrice() {
		return _HelmPrice;
	}


	public void set_HelmPrice(Integer _HelmPrice) {
		this._HelmPrice = _HelmPrice;
	}


	public void start_engine() {
		get_details();
		System.out.println(get_name() + " is standing!");
		this._HelmPrice =  (int) HelperFunct.numberInput("Price: ", "Invalid Input");
		System.out.println("Price: " + get_HelmPrice());
	}
	
	
}
