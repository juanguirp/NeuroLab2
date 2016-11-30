package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Prestamo;
import co.edu.udea.iw.exception.NeuroLabDaoException;

/**
 * Interface que define los metodos para acceder a la tabla tab_prestamos.
 * 
 * @author Juan Guillermo Restrepo Pineda <juan.restrepo48@udea.edu.co>
 */
public interface PrestamoDao {
	/**
	 * Entrega una lista con los prestamos en la base de datos.
	 * 
	 * @return lista de prestamos.
	 * @throws NeuroLabDaoException
	 *             cuando hay algun problema en la conexion.
	 */
	public List<Prestamo> listarPrestamos() throws NeuroLabDaoException;

	/**
	 * Entrega los datos de un prestamo dado su identificador.
	 * 
	 * @param id
	 *            - Numero que identifica un prestamo.
	 * @return DTO de un prestamo con sus datos.
	 * @throws NeuroLabDaoException
	 *             cuando hay algun problema en la conexion.
	 */
	public Prestamo obtenerPrestamo(int id) throws NeuroLabDaoException;

	/**
	 * Permite crear un nuevo prestamo y registrarlo en la base de datos.
	 * 
	 * @param -
	 *            DTO con los datos del administrador a guardar.
	 * @throws NeuroLabDaoException
	 *             cuando hay algun problema en la conexion.
	 */
	public void registrarPrestamo(Prestamo prestamo) throws NeuroLabDaoException;

	/**
	 * Actualiza la informacion de un prestamo en la base de datos.
	 * 
	 * @param prestamo
	 *            - DTO con los datos del prestamo a modificar.
	 * @throws NeuroLabDaoException
	 *             cuando hay algun problema en la conexion.
	 */
	public void actualizarPrestamo(Prestamo prestamo) throws NeuroLabDaoException;

	/**
	 * Permite eliminar un prestamo de la base de datos.
	 * 
	 * @param id
	 *            - Numero que identifica un prestamo.
	 * @throws NeuroLabDaoException
	 *             cuando hay algun problema en la conexion.
	 */
	public void eliminarPrestamo(int id) throws NeuroLabDaoException;
}
