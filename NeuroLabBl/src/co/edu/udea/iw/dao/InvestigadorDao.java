package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Investigador;
import co.edu.udea.iw.exception.NeuroLabDaoException;

/**
 * Interface que define los metodos para acceder a la tabla tab_investigadores.
 * 
 * @author Juan Guillermo Restrepo Pineda <juan.restrepo48@udea.edu.co>
 */
public interface InvestigadorDao {

	/**
	 * Entrega una lista con los investigadores en la base de datos.
	 * 
	 * @return lista de investigadores.
	 * @throws NeuroLabDaoException
	 *             cuando hay algun problema en la conexion.
	 */
	public List<Investigador> listarInvestigadores() throws NeuroLabDaoException;

	/**
	 * Entrega los datos de un investigador dado su identificador.
	 * 
	 * @param id
	 *            - Identificador, login o nombre de usuario de un investigador.
	 * @return DTO de un investigador con sus datos.
	 * @throws NeuroLabDaoException
	 *             cuando hay algun problema en la conexion.
	 */
	public Investigador obtenerInvestigador(String id) throws NeuroLabDaoException;

	/**
	 * Permite crear un nuevo investigador y registrarlo en la base de datos.
	 * 
	 * @param administrador
	 *            - DTO con los datos del investigador a guardar.
	 * @throws NeuroLabDaoException
	 *             cuando hay algun problema en la conexion.
	 */
	public void registrarInvestigador(Investigador investigador) throws NeuroLabDaoException;

	/**
	 * Actualiza la informacion de un investigador en la base de datos.
	 * 
	 * @param administrador
	 *            - DTO con los datos del investigador a modificar.
	 * @throws NeuroLabDaoException
	 *             cuando hay algun problema en la conexion.
	 */
	public void actualizarInvestigador(Investigador investigador) throws NeuroLabDaoException;

	/**
	 * Permite eliminar un investigador de la base de datos.
	 * 
	 * @param id
	 *            - Identificador, login o nombre de usuario de un investigador.
	 * @throws NeuroLabDaoException
	 *             cuando hay algun problema en la conexion.
	 */
	public void eliminarInvestigador(String id) throws NeuroLabDaoException;

}
