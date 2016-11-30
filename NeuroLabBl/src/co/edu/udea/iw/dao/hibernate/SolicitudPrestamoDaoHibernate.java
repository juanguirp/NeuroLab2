package co.edu.udea.iw.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import co.edu.udea.iw.dao.SolicitudPrestamoDao;
import co.edu.udea.iw.dto.SolicitudPrestamo;
import co.edu.udea.iw.exception.NeuroLabDaoException;

/**
 * Implementacion de la interface que permite acceder a la tabla
 * tab_solicitudes_prestamo.
 * 
 * @author Juan Guillermo Restrepo Pineda <juan.restrepo48@udea.edu.co>
 */
public class SolicitudPrestamoDaoHibernate implements SolicitudPrestamoDao {

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
	 * Entrega una lista con las solicitudes en la base de datos.
	 * 
	 * @return lista de solicitudes.
	 * @throws NeuroLabDaoException
	 *             cuando hay algun problema en la conexion.
	 * @see co.edu.udea.iw.dao.SolicitudPrestamoDao#listarSolicitudes()
	 */
	@Override
	public List<SolicitudPrestamo> listarSolicitudes() throws NeuroLabDaoException {
		Session session = null;
		List<SolicitudPrestamo> solicitudes = null;

		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(SolicitudPrestamo.class);
			solicitudes = criteria.list();
		} catch (HibernateException e) {
			throw new NeuroLabDaoException(e);
		}
		/*
		 * TODO: Analizar el cierre de la sesion: finally { if(session != null){
		 * session.close(); } }
		 */
		return solicitudes;
	}

	/**
	 * Entrega los datos de una solicitud dado su identificador.
	 * 
	 * @param id
	 *            - Numero que identifica una solicitud.
	 * @return DTO de una solicitud con sus datos.
	 * @throws NeuroLabDaoException
	 *             cuando hay algun problema en la conexion.
	 * @see co.edu.udea.iw.dao.SolicitudPrestamoDao#obtenerSolicitud(int)
	 */
	@Override
	public SolicitudPrestamo obtenerSolicitud(int id) throws NeuroLabDaoException {
		Session session = null;
		SolicitudPrestamo solicitudPrestamo = null;

		try {

			session = sessionFactory.openSession();
			solicitudPrestamo = (SolicitudPrestamo) session.load(SolicitudPrestamo.class, id);

		} catch (HibernateException e) {
			throw new NeuroLabDaoException(e);
		}
		/*
		 * TODO: Analizar el cierre de la sesion: finally { if(session != null){
		 * session.close(); } }
		 */
		return solicitudPrestamo;
	}

	/**
	 * Permite crear una nueva solicitud y registrarla en la base de datos.
	 * 
	 * @param solicitudPrestamo
	 *            - DTO con los datos de la solicitud a guardar.
	 * @throws NeuroLabDaoException
	 *             cuando hay algun problema en la conexion.
	 * @see co.edu.udea.iw.dao.SolicitudPrestamoDao#registrarSolicitud(co.edu.udea.iw
	 *      .dto.SolicitudPrestamo)
	 */
	@Override
	public void registrarSolicitud(SolicitudPrestamo solicitudPrestamo) throws NeuroLabDaoException {
		Session session = null;

		try {
			session = sessionFactory.openSession();
			// Descomentar tx para persistir los cambios hechos en las pruebas.
			// tx = session.beginTransaction();
			session.save(solicitudPrestamo);
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
	 * Actualiza la informacion de una solicitud en la base de datos.
	 * 
	 * @param solicitudPrestamo
	 *            - DTO con los datos de la solicitud a modificar.
	 * @throws NeuroLabDaoException
	 *             cuando hay algun problema en la conexion.
	 * @see co.edu.udea.iw.dao.SolicitudPrestamoDao#actualizarSolicitud(co.edu.udea.
	 *      iw.dto.SolicitudPrestamo)
	 */
	@Override
	public void actualizarSolicitud(SolicitudPrestamo solicitudPrestamo) throws NeuroLabDaoException {
		Session session = null;

		try {
			session = sessionFactory.openSession();
			session.update(solicitudPrestamo);
		} catch (HibernateException e) {
			throw new NeuroLabDaoException(e);
		}
		/*
		 * TODO: Analizar el cierre de la sesion: finally { if(session != null){
		 * session.close(); } }
		 */
	}

	/**
	 * Permite eliminar una solicitud de la base de datos.
	 * 
	 * @param id
	 *            - Numero que identifica una solicitud.
	 * @throws NeuroLabDaoException
	 *             cuando hay algun problema en la conexion.
	 * @see co.edu.udea.iw.dao.SolicitudPrestamoDao#eliminarSolicitud(int)
	 */
	@Override
	public void eliminarSolicitud(int id) throws NeuroLabDaoException {
		Session session = null;
		SolicitudPrestamo solicitud = new SolicitudPrestamo();
		solicitud.setId(id);

		try {
			session = sessionFactory.openSession();
			session.delete(solicitud);

		} catch (HibernateException e) {
			throw new NeuroLabDaoException(e);
		}
		/*
		 * TODO: Analizar el cierre de la sesion: finally { if(session != null){
		 * session.close(); } }
		 */

	}

}
