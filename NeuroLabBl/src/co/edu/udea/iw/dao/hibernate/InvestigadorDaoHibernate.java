package co.edu.udea.iw.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import co.edu.udea.iw.dao.InvestigadorDao;
import co.edu.udea.iw.dto.Investigador;
import co.edu.udea.iw.exception.NeuroLabDaoException;

/**
 * Implementacion de la interface que permite acceder a la tabla
 * tab_administradores.
 * 
 * @author Juan Guillermo Restrepo Pineda <juan.restrepo48@udea.edu.co>
 */
public class InvestigadorDaoHibernate implements InvestigadorDao {

	/*
	 * Variables de instancia global.
	 */
	private SessionFactory sessionFactory;

	/*
	 * Getters y Setters para los atributos de la clase.
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*
	 * Metodos implementados de la interface.
	 */

	/**
	 * Entrega una lista con los investigadores en la base de datos.
	 * 
	 * @return lista de investigadores.
	 * @throws NeuroLabDaoException
	 *             cuando hay algun problema en la conexion.
	 * @see co.edu.udea.iw.dao.InvestigadorDao#listarInvestigadores()
	 */
	@Override
	public List<Investigador> listarInvestigadores() throws NeuroLabDaoException {
		Session session = null;
		List<Investigador> investigadores = null;

		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Investigador.class);
			investigadores = criteria.list();
		} catch (HibernateException e) {
			throw new NeuroLabDaoException(e);
		}
		/*
		 * TODO: Analizar el cierre de la sesion: finally { if(session != null){
		 * session.close(); } }
		 */
		return investigadores;
	}

	/**
	 * Entrega los datos de un investigador dado su identificador.
	 * 
	 * @param id
	 *            - Identificador, login o nombre de usuario de un investigador.
	 * @return DTO de un investigador con sus datos.
	 * @throws NeuroLabDaoException
	 *             cuando hay algun problema en la conexion.
	 * @see co.edu.udea.iw.dao.InvestigadorDao#obtenerInvestigador(java.lang.String)
	 */
	@Override
	public Investigador obtenerInvestigador(String id) throws NeuroLabDaoException {

		Session session = null;
		Investigador investigador = null;

		try {

			session = sessionFactory.openSession();
			investigador = (Investigador) session.load(Investigador.class, id);

		} catch (HibernateException e) {
			throw new NeuroLabDaoException(e);
		}
		/*
		 * TODO: Analizar el cierre de la sesion: finally { if(session != null){
		 * session.close(); } }
		 */
		return investigador;
	}

	/**
	 * Permite crear un nuevo investigador y registrarlo en la base de datos.
	 * 
	 * @param administrador
	 *            - DTO con los datos del investigador a guardar.
	 * @throws NeuroLabDaoException
	 *             cuando hay algun problema en la conexion.
	 * @see co.edu.udea.iw.dao.InvestigadorDao#registrarInvestigador(co.edu.udea.iw.dto.Investigador)
	 */
	@Override
	public void registrarInvestigador(Investigador investigador) throws NeuroLabDaoException {
		Session session = null;
		// Transaction tx = null;
		try {
			session = sessionFactory.openSession();
			// Descomentar tx para persistir los cambios hechos en las pruebas.
			// tx = session.beginTransaction();
			session.save(investigador);
			// tx.commit();
		} catch (HibernateException e) {
			throw new NeuroLabDaoException(e);
		}
		/*
		 * TODO: Analizar el cierre de la sesion: finally { if(session != null){
		 * session.close(); } }
		 */

	}

	/**
	 * Actualiza la informacion de un investigador en la base de datos.
	 * 
	 * @param administrador
	 *            - DTO con los datos del investigador a modificar.
	 * @throws NeuroLabDaoException
	 *             cuando hay algun problema en la conexion.
	 * @see co.edu.udea.iw.dao.InvestigadorDao#actualizarInvestigador(co.edu.udea.iw.
	 *      dto.Investigador)
	 */
	@Override
	public void actualizarInvestigador(Investigador investigador) throws NeuroLabDaoException {
		Session session = null;

		try {
			session = sessionFactory.openSession();
			session.update(investigador);
		} catch (HibernateException e) {
			throw new NeuroLabDaoException(e);
		}
		/*
		 * TODO: Analizar el cierre de la sesion: finally { if(session != null){
		 * session.close(); } }
		 */

	}

	/**
	 * Permite eliminar un investigador de la base de datos.
	 * 
	 * @param id
	 *            - Identificador, login o nombre de usuario de un investigador.
	 * @throws NeuroLabDaoException
	 *             cuando hay algun problema en la conexion.
	 * @see co.edu.udea.iw.dao.InvestigadorDao#eliminarInvestigador(java.lang.String)
	 */
	@Override
	public void eliminarInvestigador(String id) throws NeuroLabDaoException {
		Session session = null;
		Investigador investigador = new Investigador();
		investigador.setId(id);

		try {
			session = sessionFactory.openSession();
			session.delete(investigador);

		} catch (HibernateException e) {
			throw new NeuroLabDaoException(e);
		}
		/*
		 * TODO: Analizar el cierre de la sesion: finally { if(session != null){
		 * session.close(); } }
		 */

	}

}
