package co.edu.udea.iw.dao.hibernate;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import co.edu.udea.iw.dao.AdministradorDao;
import co.edu.udea.iw.dto.Administrador;
import co.edu.udea.iw.exception.NeuroLabDaoException;

/**
 * Implementacion de la interface que permite acceder a la tabla
 * tab_administradores.
 * 
 * @author Juan Guillermo Restrepo Pineda <juan.restrepo48@udea.edu.co>
 */
public class AdministradorDaoHibernate implements AdministradorDao {

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
	 * Entrega una lista con los administradores en la base de datos.
	 * 
	 * @return lista de administradores.
	 * @throws NeuroLabDaoException
	 *             cuando hay algun problema en la conexion.
	 * @see co.edu.udea.iw.dao.AdministradorDao#listarAdministradores()
	 */
	@Override
	public List<Administrador> listarAdministradores() throws NeuroLabDaoException {
		Session session = null;
		List<Administrador> administradores = null;

		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Administrador.class);
			administradores = criteria.list();
		} catch (HibernateException e) {
			throw new NeuroLabDaoException(e);
		}
		/*
		 * TODO: Analizar el cierre de la sesion: finally { if(session != null){
		 * session.close(); } }
		 */
		return administradores;
	}

	/**
	 * Entrega los datos de un administrador dado su identificador.
	 * 
	 * @param id
	 *            - Identificador, login o nombre de usuario de un
	 *            administrador.
	 * @return DTO de un administrador con sus datos.
	 * @throws NeuroLabDaoException
	 *             cuando hay algun problema en la conexion.
	 * @see co.edu.udea.iw.dao.AdministradorDao#obtenerAdministrador(java.lang.
	 *      String)
	 */
	@Override
	public Administrador obtenerAdministrador(String id) throws NeuroLabDaoException {
		Session session = null;
		Administrador administrador = null;

		try {

			session = sessionFactory.openSession();
			administrador = (Administrador) session.load(Administrador.class, id);

		} catch (HibernateException e) {
			throw new NeuroLabDaoException(e);
		}
		/*
		 * TODO: Analizar el cierre de la sesion: finally { if(session != null){
		 * session.close(); } }
		 */
		return administrador;
	}

	/**
	 * Permite crear un nuevo administrador y registrarlo en la base de datos.
	 * 
	 * @param administrador
	 *            - DTO con los datos del administrador a guardar.
	 * @throws NeuroLabDaoException
	 *             cuando hay algun problema en la conexion.
	 * @see co.edu.udea.iw.dao.AdministradorDao#registrarAdministrador(co.edu.udea.iw
	 *      .dto.Administrador)
	 */
	@Override
	public void registrarAdministrador(Administrador administrador) throws NeuroLabDaoException {
		Session session = null;

		try {
			session = sessionFactory.openSession();
			// Descomentar tx para persistir los cambios hechos en las pruebas.
			// tx = session.beginTransaction();
			session.save(administrador);
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
	 * Actualiza la informacion de un administrador en la base de datos.
	 * 
	 * @param administrador
	 *            - DTO con los datos del administrador a modificar.
	 * @throws NeuroLabDaoException
	 *             cuando hay algun problema en la conexion.
	 * @see co.edu.udea.iw.dao.AdministradorDao#actualizarAdministrador(co.edu.udea.
	 *      iw.dto.Administrador)
	 */
	@Override
	public void actualizarAdministrador(Administrador administrador) throws NeuroLabDaoException {
		Session session = null;

		try {
			session = sessionFactory.openSession();
			session.update(administrador);
		} catch (HibernateException e) {
			throw new NeuroLabDaoException(e);
		}
		/*
		 * TODO: Analizar el cierre de la sesion: finally { if(session != null){
		 * session.close(); } }
		 */

	}

	/**
	 * Permite eliminar un administrador de la base de datos.
	 * 
	 * @param id
	 *            - Identificador, login o nombre de usuario de un
	 *            administrador.
	 * @throws NeuroLabDaoException
	 *             cuando hay algun problema en la conexion.
	 * @see co.edu.udea.iw.dao.AdministradorDao#eliminarAdministrador(java.lang.
	 *      String)
	 */
	@Override
	public void eliminarAdministrador(String id) throws NeuroLabDaoException {
		Session session = null;
		Administrador administrador = new Administrador();
		administrador.setId(id);
		try {
			session = sessionFactory.openSession();
			session.delete(administrador);

		} catch (HibernateException e) {
			throw new NeuroLabDaoException(e);
		}
		/*
		 * TODO: Analizar el cierre de la sesion: finally { if(session != null){
		 * session.close(); } }
		 */

	}

}
