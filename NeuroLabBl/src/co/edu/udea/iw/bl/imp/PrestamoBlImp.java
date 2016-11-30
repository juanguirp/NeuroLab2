package co.edu.udea.iw.bl.imp;

import java.util.Date;

import co.edu.udea.iw.bl.PrestamoBl;
import co.edu.udea.iw.dao.DispositivoDao;
import co.edu.udea.iw.dao.PrestamoDao;
import co.edu.udea.iw.dao.SolicitudPrestamoDao;
import co.edu.udea.iw.dto.Dispositivo;
import co.edu.udea.iw.dto.Prestamo;
import co.edu.udea.iw.dto.SolicitudPrestamo;
import co.edu.udea.iw.exception.NeuroLabDaoException;

/**
 * Proporciona los metodos para la cumplir con la logica del negocio para un
 * prestamo.
 * 
 * @author Juan Guillermo Restrepo Pineda <juan.restrepo48@udea.edu.co>
 */
public class PrestamoBlImp implements PrestamoBl {

	PrestamoDao prestamoDao;
	SolicitudPrestamoDao solicitudPrestamoDao;
	DispositivoDao dispositivoDao;

	public PrestamoBlImp(PrestamoDao prestamoDao) {
		this.prestamoDao = prestamoDao;
	}

	public PrestamoBlImp(PrestamoDao prestamoDao, SolicitudPrestamoDao solicitudPrestamoDao,
			DispositivoDao dispositivoDao) {
		this.prestamoDao = prestamoDao;
		this.solicitudPrestamoDao = solicitudPrestamoDao;
		this.dispositivoDao = dispositivoDao;
	}

	public PrestamoDao getPrestamoDao() {
		return prestamoDao;
	}

	public void setPrestamoDao(PrestamoDao prestamoDao) {
		this.prestamoDao = prestamoDao;
	}

	public SolicitudPrestamoDao getSolicitudDao() {
		return solicitudPrestamoDao;
	}

	public void setSolicitudDao(SolicitudPrestamoDao solicitudPrestamoDao) {
		this.solicitudPrestamoDao = solicitudPrestamoDao;
	}

	/**
	 * Permite crear un registro del prestamo de un dispositivo.
	 * 
	 * @param id
	 *            - Numero de identificacion del prestamo.
	 * @param solicitudAsociada
	 *            - Numero de identificacion de la solicitud asociada.
	 * @param dispositivoSolicitado
	 *            - Identificador del dispositivo a prestar.
	 * @param horaEntrega
	 *            - Fecha y hora de entrega del dispositivo.
	 * @param horaDevolucion
	 *            - Fecha y hora de devolucion del dispositivo.
	 * @param horasSolicitadas
	 *            - Numero de horas solicitadas.
	 * @throws NeuroLabDaoException
	 *             cuando hay algun problema en la conexion.
	 * @see co.edu.udea.iw.bl.PrestamoBl#registrarPrestamo(int,
	 *      co.edu.udea.iw.dto.SolicitudPrestamo,
	 *      co.edu.udea.iw.dto.Dispositivo, java.util.Date, java.util.Date, int)
	 */
	@Override
	public void registrarPrestamo(int id, int solicitudAsociada, Date horaEntrega, Date horaDevolucion,
			int horasSolicitadas) throws NeuroLabDaoException {

		if (id <= 0) {
			throw new NeuroLabDaoException("Debe especificar un numero de identificacion valido, mayor a cero.");
		}
		if (solicitudAsociada <= 0) {
			throw new NeuroLabDaoException(
					"Debe especificar un numero de identificacion de la solicitud asociada que sea valido, mayor a cero.");
		}
		if (horaEntrega == null) {
			throw new NeuroLabDaoException("Debe especificar la fechay hora de entrega del dispositivo.");
		}
		if (horaDevolucion == null) {
			throw new NeuroLabDaoException("Debe especificar la fecha y hora de devolucion del dispositivo.");
		}
		if (horasSolicitadas <= 0 || horasSolicitadas > 8) {
			throw new NeuroLabDaoException("Debe especificar un numero de horas de prestamo entre 1 y 8.");
		}

		try {
			SolicitudPrestamo solicitud = solicitudPrestamoDao.obtenerSolicitud(solicitudAsociada);
			if (solicitud == null) {
				throw new NeuroLabDaoException("Debe especificar un solicitud asociada que exista.");
			}
			Prestamo prestamo = new Prestamo(id, solicitud, horaEntrega, horaDevolucion, horasSolicitadas);
			prestamoDao.registrarPrestamo(prestamo);
		} catch (NeuroLabDaoException e) {
			// TODO: handle exception
		}

	}

}
