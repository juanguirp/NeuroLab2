package co.edu.udea.iw.ws.dto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Clase que almacena la informacion de un investigador.
 * @author Juan Guillermo Restrepo Pineda <juan.restrepo48@udea.edu.co>
 *
 */
@XmlRootElement
public class InvestigadoWs {

	private String id;
	private String nombre;
	private String apellidos;
	private String correo;
	private String contrasena;
	
	public InvestigadoWs(String id, String nombre, String apellidos, String correo, String contrasena) {
		
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.correo = correo;
		this.contrasena = contrasena;
	}
	
	public InvestigadoWs() {}

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
