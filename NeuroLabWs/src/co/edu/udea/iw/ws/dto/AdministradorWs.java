package co.edu.udea.iw.ws.dto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Clase que almacena la informacion de un administrador.
 * @author Juan Guillermo Restrepo Pineda <juan.restrepo48@udea.edu.co>
 *
 */
@XmlRootElement
public class AdministradorWs {
	
	/*
	 * Variables de instancia global que representan las caracteristicas o
	 * atributos que posee un administrador.
	 */
	private String id;
	private String nombre;
	private String apellidos;
	private String correo;
	private String contrasena;

	/**
	 * Constructores para la clase Administrador.
	 * 
	 * @param id
	 *            - Identificador, login o nombre de usuario para un
	 *            administrador.
	 * @param nombre
	 *            - Nombre real de un administrador.
	 * @param apellidos
	 *            - Apellidos de un administrador.
	 * @param correo
	 *            - Correo electronico de un administrador.
	 * @param contrasena
	 *            - Contrasena de un administrador.
	 */
	public AdministradorWs(String id, String nombre, String apellidos, String correo, String contrasena) {
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.correo = correo;
		this.contrasena = contrasena;
	}

	public AdministradorWs() {

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
