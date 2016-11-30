package co.edu.udea.iw.dto;

import java.util.Date;

/**
 * Clase que se utilizara como objeto de transferencia de datos para la tabla
 * tab_solicitudes_prestamo.
 * 
 * @author Juan Guillermo Restrepo Pineda <juan.restrepo48@udea.edu.co>
 */
public class SolicitudPrestamo {

	/*
	 * Variables de instancia global que representan las caracteristicas o
	 * atributos que posee una solicitud de prestamo.
	 */
	private int id;
	private Dispositivo dispositivoSolicitado;
	private Date fechaSolicitud;
	private Investigador solicitante;
	private Administrador adminProcesador;
	private Boolean respuesta;

	/**
	 * Constructores para un objeto de la clase SolicitudPrestamo.
	 * 
	 * @param id
	 *            - Numero que identifica una solicitud de prestamo.
	 * @param dispositivoSolicitado
	 *            - Numero de identificacion del dispositivo solicitado.
	 * @param fechaSolicitud
	 *            - Fecha en la que se hace la solicitud.
	 * @param solicitante
	 *            - Identificacion del investigador que hace la solicitud
	 * @param adminProcesador
	 *            -Identificacion del administrador que procesa la solicitud.
	 * @param respuesta
	 *            - 0 o false: No aprobada, 1 o true: Aprobada
	 */
	public SolicitudPrestamo(int id, Dispositivo dispositivoSolicitado, Date fechaSolicitud, Investigador solicitante,
			Administrador adminProcesador, Boolean respuesta) {
		this.id = id;
		this.dispositivoSolicitado = dispositivoSolicitado;
		this.fechaSolicitud = fechaSolicitud;
		this.solicitante = solicitante;
		this.adminProcesador = adminProcesador;
		this.respuesta = respuesta;
	}

	public SolicitudPrestamo() {

	}

	/*
	 * Getters y Setters para los atributos de una solicitud de prestamo.
	 */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Dispositivo getDispositivoSolicitado() {
		return dispositivoSolicitado;
	}

	public void setDispositivoSolicitado(Dispositivo dispositivoSolicitado) {
		this.dispositivoSolicitado = dispositivoSolicitado;
	}

	public Date getFechaSolicitud() {
		return fechaSolicitud;
	}

	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	public Investigador getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(Investigador solicitante) {
		this.solicitante = solicitante;
	}

	public Administrador getAdminProcesador() {
		return adminProcesador;
	}

	public void setAdminProcesador(Administrador adminProcesador) {
		this.adminProcesador = adminProcesador;
	}

	public Boolean getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(Boolean respuesta) {
		this.respuesta = respuesta;
	}

}
