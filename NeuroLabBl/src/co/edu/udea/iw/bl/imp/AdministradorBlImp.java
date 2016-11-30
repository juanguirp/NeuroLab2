package co.edu.udea.iw.bl.imp;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import co.edu.udea.iw.bl.AdministradorBl;
import co.edu.udea.iw.dao.AdministradorDao;
import co.edu.udea.iw.dto.Administrador;
import co.edu.udea.iw.exception.NeuroLabDaoException;
import co.edu.udea.iw.util.encode.Cifrar;
import co.edu.udea.iw.util.validations.Validaciones;

/**
 * Proporciona los metodos para la cumplir con la logica del negocio para un
 * administrador.
 * 
 * @author Juan Guillermo Restrepo Pineda <juan.restrepo48@udea.edu.co>
 */
public class AdministradorBlImp implements AdministradorBl {

	AdministradorDao administradorDao;

	static Logger LOGGER = Logger.getLogger(AdministradorBlImp.class);

	public AdministradorBlImp(AdministradorDao administradorDao) {
		this.administradorDao = administradorDao;
	}

	public AdministradorDao getAdministradorDao() {
		return administradorDao;
	}

	public void setAdministradorDao(AdministradorDao administradorDao) {
		this.administradorDao = administradorDao;
	}

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
	 * @see co.edu.udea.iw.bl.AdministradorBl#validarAdministrador(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public boolean validarAdministrador(String id, String contrasena) throws NeuroLabDaoException {
		BasicConfigurator.configure();
		Administrador administrador = new Administrador();
		Cifrar conversor = new Cifrar();
		String contrasenaEnBd;
		String contrasenaCifrada;

		try {
			administrador = administradorDao.obtenerAdministrador(id);
			if (administrador != null) {
				contrasenaEnBd = administrador.getContrasena();
				LOGGER.info("Contrasena en db: " + contrasenaEnBd);
				contrasenaCifrada = conversor.encrypt(contrasena);
				LOGGER.info("Contrasena recibida: " + contrasenaCifrada);
				if (contrasenaEnBd.equals(contrasenaCifrada)) {
					return true;
				}
			}
		} catch (NeuroLabDaoException e) {
			// TODO: handle exception
		}
		return false;
	}

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
	 * @see co.edu.udea.iw.bl.AdministradorBl#crearCuentaAdministrador(java.lang.String,
	 *      java.lang.String, java.lang.String, java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public void crearCuentaAdministrador(String id, String nombre, String apellidos, String correo, String contrasena)
			throws NeuroLabDaoException {

		Cifrar conversor = new Cifrar();
		String contrasenaCifrada;

		if (id == null || "".equals(id.trim())) {
			throw new NeuroLabDaoException("Debe especificar un identificador o nombre de usuario valido");
		}
		if (nombre == null || "".equals(nombre.trim())) {
			throw new NeuroLabDaoException("Debe especificar su nombre");
		}
		if (apellidos == null || "".equals(apellidos.trim())) {
			throw new NeuroLabDaoException("Debe especificar sus apellidos");
		}
		if (correo == null || "".equals(correo.trim())) {
			throw new NeuroLabDaoException("Debe especificar un correo electronico");
		}
		if (contrasena == null || "".equals(contrasena.trim())) {
			throw new NeuroLabDaoException("Debe especificar una contrasena");
		}
		if (!Validaciones.isEmail(correo)) {
			throw new NeuroLabDaoException("El correo debe ser valido");
		}
		contrasenaCifrada = conversor.encrypt(contrasena);

		Administrador administrador = new Administrador(id, nombre, apellidos, correo, contrasenaCifrada);
		administradorDao.registrarAdministrador(administrador);

	}

}
