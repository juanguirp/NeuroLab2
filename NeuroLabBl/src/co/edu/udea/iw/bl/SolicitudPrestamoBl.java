package co.edu.udea.iw.bl;

import java.util.List;

import co.edu.udea.iw.dto.SolicitudPrestamo;
import co.edu.udea.iw.exception.NeuroLabDaoException;

/**
 * Interface que define los metodos para la cumplir con la logica del negocio
 * para una solicitud.
 * 
 * @author Juan Guillermo Restrepo Pineda <juan.restrepo48@udea.edu.co>
 */
public interface SolicitudPrestamoBl {

	/**
	 * Retorna una lista con todas las solicitudes en el sistema.
	 * 
	 * @return - Lista de solicitudes.
	 * @throws NeuroLabDaoException
	 *             cuando hay algun problema en la conexion.
	 */
	public List<SolicitudPrestamo> listarSolicitudes() throws NeuroLabDaoException;

	/**
	 * Permite aprobar o rechazar una solicitud de prestamo.
	 * 
	 * @param id
	 *            - Identificador de la solicitud a procesar.
	 * @param respuesta
	 *            - Respuesta de aprobacion o rechazo.
	 * @throws NeuroLabDaoException
	 *             cuando hay algun problema en la conexion.
	 */
	public void responderSolicitud(int id, boolean respuesta) throws NeuroLabDaoException;

}
