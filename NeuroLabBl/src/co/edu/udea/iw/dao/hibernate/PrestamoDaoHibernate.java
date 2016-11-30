package co.edu.udea.iw.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import co.edu.udea.iw.dao.PrestamoDao;
import co.edu.udea.iw.dto.Prestamo;
import co.edu.udea.iw.exception.NeuroLabDaoException;

/**
 * Implementacion de la interface que permite acceder a la tabla tab_prestamos.
 * 
 * @author Juan Guillermo Restrepo Pineda <juan.restrepo48@udea.edu.co>
 */
public class PrestamoDaoHibernate implements PrestamoDao {

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

	/**
	 * Entrega una lista con los prestamos en la base de datos.
	 * 
	 * @return lista de prestamos.
	 * @throws NeuroLabDaoException
	 *             cuando hay algun problema en la conexion.
	 * @see co.edu.udea.iw.dao.PrestamoDao#listarPrestamos()
	 */
	@Override
	public List<Prestamo> listarPrestamos() throws NeuroLabDaoException {
		Session session = null;
		List<Prestamo> prestamos = null;

		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Prestamo.class);
			prestamos = criteria.list();
		} catch (HibernateException e) {
			throw new NeuroLabDaoException(e);
		}
		/*
		 * TODO: Analizar el cierre de la sesion: finally { if(session != null){
		 * session.close(); } }
		 */
		return prestamos;
	}

	/**
	 * Entrega los datos de un prestamo dado su identificador.
	 * 
	 * @param id
	 *            - Numero que identifica un prestamo.
	 * @return DTO de un prestamo con sus datos.
	 * @throws NeuroLabDaoException
	 *             cuando hay algun problema en la conexion.
	 * @see co.edu.udea.iw.dao.PrestamoDao#obtenerPrestamo(int)
	 */
	@Override
	public Prestamo obtenerPrestamo(int id) throws NeuroLabDaoException {
		Session session = null;
		Prestamo prestamo = null;

		try {

			session = sessionFactory.openSession();
			prestamo = (Prestamo) session.load(Prestamo.class, id);

		} catch (HibernateException e) {
			throw new NeuroLabDaoException(e);
		}
		/*
		 * TODO: Analizar el cierre de la sesion: finally { if(session != null){
		 * session.close(); } }
		 */
		return prestamo;
	}

	/**
	 * Permite crear un nuevo prestamo y registrarlo en la base de datos.
	 * 
	 * @param -
	 *            DTO con los datos del administrador a guardar.
	 * @throws NeuroLabDaoException
	 *             cuando hay algun problema en la conexion.
	 * @see co.edu.udea.iw.dao.PrestamoDao#registrarPrestamo(co.edu.udea.iw.dto.
	 *      Prestamo)
	 */
	@Override
	public void registrarPrestamo(Prestamo prestamo) throws NeuroLabDaoException {
		Session session = null;

		try {
			session = sessionFactory.openSession();
			// Descomentar tx para persistir los cambios hechos en las pruebas.
			// tx = session.beginTransaction();
			session.save(prestamo);
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
	 * Actualiza la informacion de un prestamo en la base de datos.
	 * 
	 * @param prestamo
	 *            - DTO con los datos del prestamo a modificar.
	 * @throws NeuroLabDaoException
	 *             cuando hay algun problema en la conexion.
	 * @see co.edu.udea.iw.dao.PrestamoDao#actualizarPrestamo(co.edu.udea.iw.dto.
	 *      Prestamo)
	 */
	@Override
	public void actualizarPrestamo(Prestamo prestamo) throws NeuroLabDaoException {
		Session session = null;

		try {
			session = sessionFactory.openSession();
			session.update(prestamo);
		} catch (HibernateException e) {
			throw new NeuroLabDaoException(e);
		}
		/*
		 * TODO: Analizar el cierre de la sesion: finally { if(session != null){
		 * session.close(); } }
		 */
	}

	/**
	 * Permite eliminar un prestamo de la base de datos.
	 * 
	 * @param id
	 *            - Numero que identifica un prestamo.
	 * @throws NeuroLabDaoException
	 *             cuando hay algun problema en la conexion.
	 * @see co.edu.udea.iw.dao.PrestamoDao#eliminarPrestamo(int)
	 */
	@Override
	public void eliminarPrestamo(int id) throws NeuroLabDaoException {
		Session session = null;
		Prestamo prestamo = new Prestamo();
		prestamo.setId(id);

		try {
			session = sessionFactory.openSession();
			session.delete(prestamo);

		} catch (HibernateException e) {
			throw new NeuroLabDaoException(e);
		}
		/*
		 * TODO: Analizar el cierre de la sesion: finally { if(session != null){
		 * session.close(); } }
		 */
	}

}
