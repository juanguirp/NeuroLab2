package co.edu.udea.iw.ws;

import java.rmi.RemoteException;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.edu.udea.iw.bl.PrestamoBl;
import co.edu.udea.iw.exception.NeuroLabDaoException;

/**
 * Clase que implementa los servicios rest para un prestamo.
 * 
 * @author Juan Guillermo Restrepo Pineda <juan.restrepo48@udea.edu.co>
 *
 */
@Path("ServicioPrestamo")
@Component
public class ServicioPrestamo {

	@Autowired
	PrestamoBl prestamoBl;

	/*
	 * Getters y Setters para los atributos de un prestamo.
	 */
	public PrestamoBl getPrestamoBl() {
		return prestamoBl;
	}

	public void setPrestamoBl(PrestamoBl prestamoBl) {
		this.prestamoBl = prestamoBl;
	}

	/**
	 * Permite registrar un nuevo prestamo.
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
	 * @throws RemoteException
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("registrarPrestamo/{id}/{solicitudAsociada}/{horaEntrega}/{horaDevolucion}/{horasSolicitadas}")
	public void registrarPrestamo(int id, int solicitudAsociada, Date horaEntrega, Date horaDevolucion,
			int horasSolicitadas) throws RemoteException {

		try {
			prestamoBl.registrarPrestamo(id, solicitudAsociada, horaEntrega, horaDevolucion, horasSolicitadas);
		} catch (NeuroLabDaoException e) {
			throw new RemoteException(e.getMessage(), e);
		}

	}

}
