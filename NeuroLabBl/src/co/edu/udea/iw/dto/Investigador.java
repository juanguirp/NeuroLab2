package co.edu.udea.iw.dto;

/**
 * Clase que se utilizara como objeto de transferencia de datos para la tabla
 * tab_investigadores.
 * 
 * @author Juan Guillermo Restrepo Pineda <juan.restrepo48@udea.edu.co>
 */
public class Investigador {

	/*
	 * Variables de instancia global que representan las caracteristicas o
	 * atributos que posee un investigador.
	 */
	private String id;
	private String nombre;
	private String apellidos;
	private String correo;
	private String contrasena;

	/**
	 * Constructores para la clase Investigador.
	 * 
	 * @param id
	 *            - Identificador, login o nombre de usuario para un
	 *            investigador.
	 * @param nombre
	 *            - Nombre real de un investigador.
	 * @param apellidos
	 *            - Apellidos de un investigador.
	 * @param correo
	 *            - Correo electronico de un investigador.
	 * @param contrasena
	 *            - Contrasena de un investigador.
	 */
	public Investigador(String id, String nombre, String apellidos, String correo, String contrasena) {
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.correo = correo;
		this.contrasena = contrasena;
	}

	public Investigador() {

	}

	/*
	 * Getters y Setters para los atributos de un administrador.
	 */

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

}
