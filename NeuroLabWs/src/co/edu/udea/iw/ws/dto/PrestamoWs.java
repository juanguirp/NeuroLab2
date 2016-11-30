package co.edu.udea.iw.ws.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import co.edu.udea.iw.dto.SolicitudPrestamo;

/**
 * Clase que almacena la informacion de un prestamo.
 * 
 * @author Juan Guillermo Restrepo Pineda <juan.restrepo48@udea.edu.co>
 *
 */
@XmlRootElement
public class PrestamoWs {

	private int id;
	private SolicitudPrestamo solicitudAsociada;
	private Date horaEntrega;
	private Date horaDevolucion;
	private int horasSolicitadas;

	/**
	 * Constructores para un objeto de la clase Prestamo.
	 * 
	 * @param id
	 *            - Identificador de una solicitud.
	 * @param solicitud
	 *            - Numero de identificacion de un prestamo asociada.
	 * @param horaEntrega
	 *            - Fecha en la que se entrego el dispositivo solicitado.
	 * @param horaDevolucion
	 *            - Fecha en la que se devolvio el dispositivo.
	 * @param horasSolicitadas
	 *            - Numero de horas reservadas.
	 */
	public PrestamoWs(int id, SolicitudPrestamo solicitudAsociada, Date horaEntrega, Date horaDevolucion,
			int horasSolicitadas) {
		this.id = id;
		this.solicitudAsociada = solicitudAsociada;
		this.horaEntrega = horaEntrega;
		this.horaDevolucion = horaDevolucion;
		this.horasSolicitadas = horasSolicitadas;
	}

	public PrestamoWs() {

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
