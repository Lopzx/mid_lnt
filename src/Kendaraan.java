
public class Kendaraan {
	private String _Type;
	private String _Brand;
	private String _Name;
	private String _License;
	private Integer _TopSpeed;
	private Integer _GasCap;
	private Integer _Wheel;
	private String _Jenis;
	
	public String get_type() {
		return _Type;
	}

	public String get_brand() {
		return _Brand;
	}

	public String get_name() {
		return _Name;
	}

	public String get_license() {
		return _License;
	}

	public Integer get_topspeed() {
		return _TopSpeed;
	}

	public Integer get_gascap() {
		return _GasCap;
	}

	public Integer get_wheel() {
		return _Wheel;
	}

	public String get_jenis() {
		return _Jenis;
	}
	
	public Kendaraan(String _Type, String _Brand, String _Name, String _License, Integer _TopSpeed, Integer _GasCap,
			Integer _Wheel, String _Jenis) {
		this._Type = _Type;
		this._Brand = _Brand;
		this._Name = _Name;
		this._License = _License;
		this._TopSpeed = _TopSpeed;
		this._GasCap = _GasCap;
		this._Wheel = _Wheel;
		this._Jenis = _Jenis;
	}
	
	public void get_details() {
		System.out.println("Brand: " + get_brand());
		System.out.println("Name: " + get_name());
		System.out.println("License Plate: " + get_license());
		System.out.println("Type: " + get_type());
		System.out.println("Gas Capacity: " + get_gascap());
		System.out.println("Top Speed: " + get_topspeed());
		System.out.println("Wheel(s): " + get_wheel());
	}
}
