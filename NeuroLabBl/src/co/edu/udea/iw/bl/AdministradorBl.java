package co.edu.udea.iw.bl;

import co.edu.udea.iw.exception.NeuroLabDaoException;

/**
 * Interface que define los metodos para la cumplir con la logica del negocio
 * para un administrador.
 * 
 * @author Juan Guillermo Restrepo Pineda <juan.restrepo48@udea.edu.co>
 */
public interface AdministradorBl {

	/**
	 * Valida el ingreso de un administrador al sistema.
	 * 
	 * @param id
	 *            - Identificador o nombre de usuario para un administrador.
	 * @param contrasena
	 *            - Contrasena de un administrador
	 * @return - Valor logico que indica si el administrador existe o no en el
	 *         sistema.
	 * @throws NeuroLabDaoException
	 *             cuandsso hay algun problema en la conexion.
	 */
	public boolean validarAdministrador(String id, String contrasena) throws NeuroLabDaoException;

	/**
	 * Registra un nuevo administrador en el sistema.
	 * 
	 * @param id
	 *            - Identificador o nombre de usuario de un administrador
	 * @param nombre
	 *            - Nombre del nuevo administrador.
	 * @param apellidos
	 *            - Apellidos del nuevo administrador.
	 * @param correo
	 *            - Correo del nuevo administrador.
	 * @param contrasena
	 *            - Contrasena del nuevo administrador.
	 * @throws NeuroLabDaoException
	 *             cuando hay algun problema en la conexion.
	 */
	public void crearCuentaAdministrador(String id, String nombre, String apellidos, String correo, String contrasena)
			throws NeuroLabDaoException;

}
