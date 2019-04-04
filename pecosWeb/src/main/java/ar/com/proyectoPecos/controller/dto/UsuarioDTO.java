package ar.com.proyectoPecos.controller.dto;



public class UsuarioDTO {
	
	private Integer id;
	
	private String email;
	
	private String password;
	
	private String apellido;

	private String nombre;
	
    private Integer idDni;
	
    private Integer dni;
    
    private Integer idCalle;
    
    private String calle;
    
    private String numeroCalle;
	
    private String piso;
	
    private String depto;
		
	private Integer idLocalidad;
	
	private Integer idProvincia;
	
	private Integer idPais;
	
	private String telefonoFijo;
	
	private String telefonoMovil;

	
	public UsuarioDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UsuarioDTO(Integer id, String email, String password, String apellido, String nombre, Integer idDni,
			Integer dni, Integer idCalle,String calle, String numeroCalle, String piso, String depto, Integer idLocalidad,
			Integer idProvincia, Integer idPais, String telefonoFijo, String telefonoMovil) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.apellido = apellido;
		this.nombre = nombre;
		this.idDni = idDni;
		this.dni = dni;
		this.calle = calle;
		this.numeroCalle = numeroCalle;
		this.piso = piso;
		this.depto = depto;
		this.idLocalidad = idLocalidad;
		this.idProvincia = idProvincia;
		this.idPais = idPais;
		this.telefonoFijo = telefonoFijo;
		this.telefonoMovil = telefonoMovil;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getIdDni() {
		return idDni;
	}

	public void setIdDni(Integer idDni) {
		this.idDni = idDni;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public Integer getIdCalle() {
		return idCalle;
	}

	public void setIdCalle(Integer idCalle) {
		this.idCalle = idCalle;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNumeroCalle() {
		return numeroCalle;
	}

	public void setNumeroCalle(String numeroCalle) {
		this.numeroCalle = numeroCalle;
	}

	public String getPiso() {
		return piso;
	}

	public void setPiso(String piso) {
		this.piso = piso;
	}

	public String getDepto() {
		return depto;
	}

	public void setDepto(String depto) {
		this.depto = depto;
	}

	public Integer getIdLocalidad() {
		return idLocalidad;
	}

	public void setIdLocalidad(Integer idLocalidad) {
		this.idLocalidad = idLocalidad;
	}

	public String getTelefonoFijo() {
		return telefonoFijo;
	}

	public void setTelefonoFijo(String telefonoFijo) {
		this.telefonoFijo = telefonoFijo;
	}

	public String getTelefonoMovil() {
		return telefonoMovil;
	}

	public void setTelefonoMovil(String telefonoMovil) {
		this.telefonoMovil = telefonoMovil;
	}
	
	public Integer getIdProvincia() {
		return idProvincia;
	}

	public void setIdProvincia(Integer idProvincia) {
		this.idProvincia = idProvincia;
	}

	public Integer getIdPais() {
		return idPais;
	}

	public void setIdPais(Integer idPais) {
		this.idPais = idPais;
	}

}
