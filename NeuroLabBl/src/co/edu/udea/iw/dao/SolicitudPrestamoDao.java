package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.SolicitudPrestamo;
import co.edu.udea.iw.exception.NeuroLabDaoException;

/**
 * Interface que define los metodos para acceder a la tabla
 * tab_solicitudes_prestamo.
 * 
 * @author Juan Guillermo Restrepo Pineda <juan.restrepo48@udea.edu.co>
 */
public interface SolicitudPrestamoDao {
	/**
	 * Entrega una lista con las solicitudes en la base de datos.
	 * 
	 * @return lista de solicitudes.
	 * @throws NeuroLabDaoException
	 *             cuando hay algun problema en la conexion.
	 */
	public List<SolicitudPrestamo> listarSolicitudes() throws NeuroLabDaoException;

	/**
	 * Entrega los datos de una solicitud dado su identificador.
	 * 
	 * @param id
	 *            - Numero que identifica una solicitud.
	 * @return DTO de una solicitud con sus datos.
	 * @throws NeuroLabDaoException
	 *             cuando hay algun problema en la conexion.
	 */
	public SolicitudPrestamo obtenerSolicitud(int id) throws NeuroLabDaoException;

	/**
	 * Permite crear una nueva solicitud y registrarla en la base de datos.
	 * 
	 * @param solicitudPrestamo
	 *            - DTO con los datos de la solicitud a guardar.
	 * @throws NeuroLabDaoException
	 *             cuando hay algun problema en la conexion.
	 */
	public void registrarSolicitud(SolicitudPrestamo solicitudPrestamo) throws NeuroLabDaoException;

	/**
	 * Actualiza la informacion de una solicitud en la base de datos.
	 * 
	 * @param solicitudPrestamo
	 *            - DTO con los datos de la solicitud a modificar.
	 * @throws NeuroLabDaoException
	 *             cuando hay algun problema en la conexion.
	 */
	public void actualizarSolicitud(SolicitudPrestamo solicitudPrestamo) throws NeuroLabDaoException;

	/**
	 * Permite eliminar una solicitud de la base de datos.
	 * 
	 * @param id
	 *            - Numero que identifica una solicitud.
	 * @throws NeuroLabDaoException
	 *             cuando hay algun problema en la conexion.
	 */
	public void eliminarSolicitud(int id) throws NeuroLabDaoException;
}
