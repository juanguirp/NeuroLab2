package co.edu.udea.iw.bl.imp;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import co.edu.udea.iw.bl.InvestigadorBl;
import co.edu.udea.iw.dao.InvestigadorDao;
import co.edu.udea.iw.dto.Investigador;
import co.edu.udea.iw.exception.NeuroLabDaoException;
import co.edu.udea.iw.util.encode.Cifrar;
import co.edu.udea.iw.util.validations.Validaciones;

/**
 * Proporciona los metodos para la cumplir con la logica del negocio para un
 * investigador.
 * 
 * @author Juan Guillermo Restrepo Pineda <juan.restrepo48@udea.edu.co>
 */
public class InvestigadorBlImp implements InvestigadorBl {

	InvestigadorDao investigadorDao;

	static Logger LOGGER = Logger.getLogger(InvestigadorBlImp.class);

	public InvestigadorBlImp(InvestigadorDao investigadorDao) {
		this.investigadorDao = investigadorDao;
	}

	public InvestigadorDao getInvestigadorDao() {
		return investigadorDao;
	}

	public void setInvestigadorDao(InvestigadorDao investigadorDao) {
		this.investigadorDao = investigadorDao;
	}

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
	 * @see co.edu.udea.iw.bl.InvestigadorBl#validarInvestigador(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public Investigador validarInvestigador(String id, String contrasena) throws NeuroLabDaoException {
		BasicConfigurator.configure();
		Investigador investigador = new Investigador();
		Cifrar conversor = new Cifrar();
		String contrasenaEnBd;
		String contrasenaCifrada;

		try {
			investigador = investigadorDao.obtenerInvestigador(id);
			if (investigador != null) {
				contrasenaEnBd = investigador.getContrasena();
				LOGGER.info("Contrasena en db: " + contrasenaEnBd);
				contrasenaCifrada = conversor.encrypt(contrasena);
				LOGGER.info("Contrasena recibida: " + contrasenaCifrada);
				if (contrasenaEnBd.equals(contrasenaCifrada)) {
					return investigador;
				}
			}
		} catch (NeuroLabDaoException e) {
			// TODO: handle exception
		}
		return null;
	}

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
	 * @see co.edu.udea.iw.bl.InvestigadorBl#crearCuentaInvestigador(java.lang.String,
	 *      java.lang.String, java.lang.String, java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public void crearCuentaInvestigador(String id, String nombre, String apellidos, String correo, String contrasena)
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

		Investigador investigador = new Investigador(id, nombre, apellidos, correo, contrasenaCifrada);
		investigadorDao.registrarInvestigador(investigador);

	}

}
