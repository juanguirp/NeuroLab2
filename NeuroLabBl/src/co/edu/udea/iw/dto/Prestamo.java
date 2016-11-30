package co.edu.udea.iw.dto;

import java.util.Date;

/**
 * Clase que se utilizara como objeto de transferencia de datos para la tabla
 * tab_prestamos.
 * 
 * @author Juan Guillermo Restrepo Pineda <juan.restrepo48@udea.edu.co>
 */
public class Prestamo {

	/*
	 * Variables de instancia global que representan las caracteristicas o
	 * atributos que posee un prestamo.
	 */
	private int id;
	private SolicitudPrestamo solicitudAsociada;
	private Date horaEntrega;
	private Date horaDevolucion;
	private int horasSolicitadas;

	/**
	 * Constructores para un objeto de la clase Prestamo.
	 * 
	 * @param solicitud
	 *            - Numero de identificacion de un prestamo asociada.
	 * @param horaEntrega
	 *            - Fecha en la que se entrego el dispositivo solicitado.
	 * @param horaDevolucion
	 *            - Fecha en la que se devolvio el dispositivo.
	 * @param horasSolicitadas
	 *            - Numero de horas reservadas.
	 */
	public Prestamo(int id, SolicitudPrestamo solicitudAsociada, Date horaEntrega, Date horaDevolucion,
			int horasSolicitadas) {
		this.id = id;
		this.solicitudAsociada = solicitudAsociada;
		this.horaEntrega = horaEntrega;
		this.horaDevolucion = horaDevolucion;
		this.horasSolicitadas = horasSolicitadas;
	}

	public Prestamo() {

	}

	/*
	 * Getters y Setters para los atributos de un objeto de la clase
	 * DetalleSolicitud.
	 */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public SolicitudPrestamo getSolicitudAsociada() {
		return solicitudAsociada;
	}

	public void setSolicitudAsociada(SolicitudPrestamo solicitudAsociada) {
		this.solicitudAsociada = solicitudAsociada;
	}

	public Date getHoraEntrega() {
		return horaEntrega;
	}

	public void setHoraEntrega(Date horaEntrega) {
		this.horaEntrega = horaEntrega;
	}

	public Date getHoraDevolucion() {
		return horaDevolucion;
	}

	public void setHoraDevolucion(Date horaDevolucion) {
		this.horaDevolucion = horaDevolucion;
	}

	public int getHorasSolicitadas() {
		return horasSolicitadas;
	}

	public void setHorasSolicitadas(int horasSolicitadas) {
		this.horasSolicitadas = horasSolicitadas;
	}

}
