package co.edu.udea.iw.bl.imp;

import java.util.List;

import co.edu.udea.iw.bl.SolicitudPrestamoBl;
import co.edu.udea.iw.dao.AdministradorDao;
import co.edu.udea.iw.dao.DispositivoDao;
import co.edu.udea.iw.dao.InvestigadorDao;
import co.edu.udea.iw.dao.SolicitudPrestamoDao;
import co.edu.udea.iw.dto.SolicitudPrestamo;
import co.edu.udea.iw.exception.NeuroLabDaoException;

/**
 * Proporciona los metodos para la cumplir con la logica del negocio para una
 * solicitud.
 * 
 * @author Juan Guillermo Restrepo Pineda <juan.restrepo48@udea.edu.co>
 */
public class SolicitudPrestamoBlImp implements SolicitudPrestamoBl {

	SolicitudPrestamoDao solicitudPrestamoDao;
	AdministradorDao administradorDao;
	InvestigadorDao investigadorDao;
	DispositivoDao dispositivoDao;

	public SolicitudPrestamoBlImp(SolicitudPrestamoDao solicitudPrestamoDao) {
		this.solicitudPrestamoDao = solicitudPrestamoDao;
	}

	public SolicitudPrestamoBlImp(SolicitudPrestamoDao solicitudPrestamoDao, AdministradorDao administradorDao,
			InvestigadorDao investigadorDao, DispositivoDao dispositivoDao) {
		this.solicitudPrestamoDao = solicitudPrestamoDao;
		this.administradorDao = administradorDao;
		this.investigadorDao = investigadorDao;
		this.dispositivoDao = dispositivoDao;
	}

	public SolicitudPrestamoDao getSolicitudPrestamoDao() {
		return solicitudPrestamoDao;
	}

	public void setSolicitudPrestamoDao(SolicitudPrestamoDao solicitudPrestamoDao) {
		this.solicitudPrestamoDao = solicitudPrestamoDao;
	}

	public AdministradorDao getAdministradorDao() {
		return administradorDao;
	}

	public void setAdministradorDao(AdministradorDao administradorDao) {
		this.administradorDao = administradorDao;
	}

	public InvestigadorDao getInvestigadorDao() {
		return investigadorDao;
	}

	public void setInvestigadorDao(InvestigadorDao investigadorDao) {
		this.investigadorDao = investigadorDao;
	}

	public DispositivoDao getDispositivoDao() {
		return dispositivoDao;
	}

	public void setDispositivoDao(DispositivoDao dispositivoDao) {
		this.dispositivoDao = dispositivoDao;
	}

	/**
	 * Retorna una lista con todas las solicitudes en el sistema.
	 * 
	 * @return - Lista de solicitudes.
	 * @throws NeuroLabDaoException
	 *             cuando hay algun problema en la conexion.
	 * @see co.edu.udea.iw.bl.SolicitudPrestamoBl#listarSolicitudes()
	 */
	@Override
	public List<SolicitudPrestamo> listarSolicitudes() throws NeuroLabDaoException {
		List<SolicitudPrestamo> solicitudes = null;
		try {
			solicitudes = solicitudPrestamoDao.listarSolicitudes();
		} catch (NeuroLabDaoException e) {
			// TODO: handle exception
		}
		return solicitudes;
	}

	/**
	 * Permite aprobar o rechazar una solicitud de prestamo.
	 * 
	 * @param id
	 *            - Identificador de la solicitud a procesar.
	 * @param respuesta
	 *            - Respuesta de aprobacion o rechazo.
	 * @throws NeuroLabDaoException
	 *             cuando hay algun problema en la conexion.
	 * @see co.edu.udea.iw.bl.SolicitudPrestamoBl#responderSolicitud(int,
	 *      boolean)
	 */
	@Override
	public void responderSolicitud(int id, boolean respuesta) throws NeuroLabDaoException {
		SolicitudPrestamo solicitudPrestamo = null;
		try {
			solicitudPrestamo = solicitudPrestamoDao.obtenerSolicitud(id);
			solicitudPrestamo.setRespuesta(respuesta);
			solicitudPrestamoDao.actualizarSolicitud(solicitudPrestamo);
		} catch (NeuroLabDaoException e) {
			// TODO: handle exception
		}

	}

}
