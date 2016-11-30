package co.edu.udea.iw.dto;

import java.util.Date;

/**
 * Clase que se utilizara como objeto de transferencia de datos para la tabla
 * tab_dispositivos.
 * 
 * @author Juan Guillermo Restrepo Pineda <juan.restrepo48@udea.edu.co>
 */
public class Dispositivo {

	/*
	 * Variables de instancia global que representan las caracteristicas o
	 * atributos que posee un dispositivo.
	 */
	private int id;
	private String tipoDispositivo;
	private Boolean disponible;
	private String especificaciones;
	private Administrador adminRegistrador;
	private Date fechaRegistro;

	/**
	 * Constructores para un objeto de la clase Dispositivo.
	 * 
	 * @param id
	 *            - Numero que identifica a un dispositivo.
	 * @param tipoDispositivo
	 *            - Tipo o clase de dispositivo.
	 * @param disponible
	 *            - 0: No disponible, 1: Disponible.
	 * @param especificaciones
	 *            - Informacion adicional del dispositivo.
	 * @param adminRegistrador
	 *            - Administrador que registro el dispositivo en el sistema.
	 * @param fechaRegistro
	 *            - Fecha en la que se registro el dispositivo.
	 */
	public Dispositivo(int id, String tipoDispositivo, Boolean disponible, String especificaciones,
			Administrador adminRegistrador, Date fechaRegistro) {
		this.id = id;
		this.tipoDispositivo = tipoDispositivo;
		this.disponible = disponible;
		this.especificaciones = especificaciones;
		this.adminRegistrador = adminRegistrador;
		this.fechaRegistro = fechaRegistro;
	}

	public Dispositivo() {

	}

	/*
	 * Getters y Setters para los atributos de un dispositivo.
	 */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipoDispositivo() {
		return tipoDispositivo;
	}

	public void setTipoDispositivo(String tipoDispositivo) {
		this.tipoDispositivo = tipoDispositivo;
	}

	public Boolean getDisponible() {
		return disponible;
	}

	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}

	public String getEspecificaciones() {
		return especificaciones;
	}

	public void setEspecificaciones(String especificaciones) {
		this.especificaciones = especificaciones;
	}

	public Administrador getAdminRegistrador() {
		return adminRegistrador;
	}

	public void setAdminRegistrador(Administrador adminRegistrador) {
		this.adminRegistrador = adminRegistrador;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

}
