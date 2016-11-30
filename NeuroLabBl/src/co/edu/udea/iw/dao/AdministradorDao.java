package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Administrador;
import co.edu.udea.iw.exception.NeuroLabDaoException;

/**
 * Interface que define los metodos para acceder a la tabla tab_administradores.
 * 
 * @author Juan Guillermo Restrepo Pineda <juan.restrepo48@udea.edu.co>
 */
public interface AdministradorDao {

	/**
	 * Entrega una lista con los administradores en la base de datos.
	 * 
	 * @return lista de administradores.
	 * @throws NeuroLabDaoException
	 *             cuando hay algun problema en la conexion.
	 */
	public List<Administrador> listarAdministradores() throws NeuroLabDaoException;

	/**
	 * Entrega los datos de un administrador dado su identificador.
	 * 
	 * @param id
	 *            - Identificador, login o nombre de usuario de un
	 *            administrador.
	 * @return DTO de un administrador con sus datos.
	 * @throws NeuroLabDaoException
	 *             cuando hay algun problema en la conexion.
	 */
	public Administrador obtenerAdministrador(String id) throws NeuroLabDaoException;

	/**
	 * Permite crear un nuevo administrador y registrarlo en la base de datos.
	 * 
	 * @param administrador
	 *            - DTO con los datos del administrador a guardar.
	 * @throws NeuroLabDaoException
	 *             cuando hay algun problema en la conexion.
	 */
	public void registrarAdministrador(Administrador administrador) throws NeuroLabDaoException;

	/**
	 * Actualiza la informacion de un administrador en la base de datos.
	 * 
	 * @param administrador
	 *            - DTO con los datos del administrador a modificar.
	 * @throws NeuroLabDaoException
	 *             cuando hay algun problema en la conexion.
	 */
	public void actualizarAdministrador(Administrador administrador) throws NeuroLabDaoException;

	/**
	 * Permite eliminar un administrador de la base de datos.
	 * 
	 * @param id
	 *            - Identificador, login o nombre de usuario de un
	 *            administrador.
	 * @throws NeuroLabDaoException
	 *             cuando hay algun problema en la conexion.
	 */
	public void eliminarAdministrador(String id) throws NeuroLabDaoException;

}
