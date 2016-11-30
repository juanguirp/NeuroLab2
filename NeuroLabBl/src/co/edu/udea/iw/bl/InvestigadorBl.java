package co.edu.udea.iw.bl;

import co.edu.udea.iw.dto.Investigador;
import co.edu.udea.iw.exception.NeuroLabDaoException;

/**
 * Interface que define los metodos para la cumplir con la logica del negocio
 * para un investigador.
 * 
 * @author Juan Guillermo Restrepo Pineda <juan.restrepo48@udea.edu.co>
 */
public interface InvestigadorBl {

	/**
	 * Valida el ingreso de un investigador al sistema.
	 * 
	 * @param id
	 *            - Identificador o nombre de usuario para un investigador.
	 * @param contrasena
	 *            - Contrasena de un investigador
	 * @return - Valor logico que indica si el investigador existe o no en el
	 *         sistema.
	 * @throws NeuroLabDaoException
	 *             cuando hay algun problema en la conexion.
	 */
	public Investigador
	validarInvestigador(String id, String contrasena) throws NeuroLabDaoException;

	/**
	 * Registra un nuevo investigador en el sistema.
	 * 
	 * @param id
	 *            - Identificador o nombre de usuario de un investigador
	 * @param nombre
	 *            - Nombre del nuevo investigador.
	 * @param apellidos
	 *            - Apellidos del nuevo investigador.
	 * @param correo
	 *            - Correo del nuevo investigador.
	 * @param contrasena
	 *            - Contrasena del nuevo investigador.
	 * @throws NeuroLabDaoException
	 *             cuando hay algun problema en la conexion.
	 */
	public void crearCuentaInvestigador(String id, String nombre, String apellidos, String correo, String contrasena)
			throws NeuroLabDaoException;
}
