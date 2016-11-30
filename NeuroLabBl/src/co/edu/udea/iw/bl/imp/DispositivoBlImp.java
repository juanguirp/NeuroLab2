package co.edu.udea.iw.bl.imp;

import java.util.Date;
import java.util.List;

import co.edu.udea.iw.bl.DispositivoBl;
import co.edu.udea.iw.dao.AdministradorDao;
import co.edu.udea.iw.dao.DispositivoDao;
import co.edu.udea.iw.dto.Administrador;
import co.edu.udea.iw.dto.Dispositivo;
import co.edu.udea.iw.exception.NeuroLabDaoException;

/**
 * Proporciona los metodos para la cumplir con la logica del negocio para un
 * dispositivo.
 * 
 * @author Juan Guillermo Restrepo Pineda <juan.restrepo48@udea.edu.co>
 */
public class DispositivoBlImp implements DispositivoBl {

	DispositivoDao dispositivoDao;
	AdministradorDao administradorDao;

	public DispositivoBlImp(DispositivoDao dispositivoDao) {
		this.dispositivoDao = dispositivoDao;
	}

	public DispositivoBlImp(DispositivoDao dispositivoDao, AdministradorDao administradorDao) {
		this.dispositivoDao = dispositivoDao;
		this.administradorDao = administradorDao;
	}

	public DispositivoDao getDispositivoDao() {
		return dispositivoDao;
	}

	public void setDispositivoDao(DispositivoDao dispositivoDao) {
		this.dispositivoDao = dispositivoDao;
	}

	public AdministradorDao getAdministradorDao() {
		return administradorDao;
	}

	public void setAdministradorDao(AdministradorDao administradorDao) {
		this.administradorDao = administradorDao;
	}

	/**
	 * Crea un nuevo dispositivo y lo registra en el sistema.
	 * 
	 * @param id
	 *            - Numero que identifica al nuevo dispositivo.
	 * @param tipoDispositivo
	 *            - Tipo o clase de dispositivo.
	 * @param disponible
	 *            - Disponible o no para prestamo.
	 * @param especificaciones
	 *            - Caracteristicas del nuevo dispositivo.
	 * @param adminRegistrador
	 *            - Identificador del administrador que registra el nuevo
	 *            dispositivo en el sistema.
	 * @param fechaRegistro
	 *            - Fecha en la que se registra el nuevo dispositivo.
	 * @throws NeuroLabDaoException
	 *             cuando hay algun problema en la conexion.
	 * @see co.edu.udea.iw.bl.DispositivoBl#registrarDispositivo(int,
	 *      java.lang.String, java.lang.Boolean, java.lang.String,
	 *      co.edu.udea.iw.dto.Administrador, java.util.Date)
	 */
	@Override
	public void registrarDispositivo(int id, String tipoDispositivo, Boolean disponible, String especificaciones,
			String adminRegistrador, Date fechaRegistro) throws NeuroLabDaoException {

		if (id <= 0) {
			throw new NeuroLabDaoException("Debe especificar un numero de dispositivo valido, mayor a cero.");
		}
		if (tipoDispositivo == null || "".equals(tipoDispositivo.trim())) {
			throw new NeuroLabDaoException("Debe especificar un tipo de dispositivo.");
		}
		if (disponible == null) {
			throw new NeuroLabDaoException("Debe especificar la disponibilidad del dispositivo.");
		}
		if (especificaciones == null || "".equals(especificaciones.trim())) {
			throw new NeuroLabDaoException("Debe especificar las caracteristicas del nuevo dispositivo.");
		}
		if (adminRegistrador == null || "".equals(tipoDispositivo.trim())) {
			throw new NeuroLabDaoException("Debe especificar el administrador que registra el nuevo dispositivo.");
		}
		if (fechaRegistro == null) {
			throw new NeuroLabDaoException("Debe especificar la fecha de registro del dispositivo.");
		}

		try {
			Administrador admin = administradorDao.obtenerAdministrador(adminRegistrador);
			if (admin == null) {
				throw new NeuroLabDaoException("Debe especificar el administrador que registra el nuevo dispositivo.");
			}
			Dispositivo dispositivo = new Dispositivo(id, tipoDispositivo, disponible, especificaciones, admin,
					fechaRegistro);
			dispositivoDao.registrarDispositivo(dispositivo);
		} catch (NeuroLabDaoException e) {
			// TODO: handle exception
		}

	}

	/**
	 * Elimina un dispositivo del sistema.
	 * 
	 * @param id
	 *            - Numero que identifica al dispositivo a eliminar.
	 * @throws NeuroLabDaoException
	 *             cuando hay algun problema en la conexion.
	 * @see co.edu.udea.iw.bl.DispositivoBl#eliminarDispositivo(int)
	 */
	@Override
	public void eliminarDispositivo(int id) throws NeuroLabDaoException {
		if (id <= 0) {
			throw new NeuroLabDaoException("Debe especificar un numero de dispositivo valido, mayor a cero.");
		}
		try {
			dispositivoDao.eliminarDispositivo(id);
		} catch (NeuroLabDaoException e) {
			// TODO: handle exception
		}

	}

	/**
	 * Lista todos los dispositivos en el sistema.
	 * 
	 * @return Lista de dispositivos.
	 * @throws NeuroLabDaoException
	 *             cuando hay algun problema en la conexion.
	 * @see co.edu.udea.iw.bl.DispositivoBl#listarDispositivos()
	 */
	@Override
	public List<Dispositivo> listarDispositivos() throws NeuroLabDaoException {
		List<Dispositivo> dispositivos = null;
		try {
			dispositivos = dispositivoDao.listarDispositivos();
		} catch (NeuroLabDaoException e) {
			// TODO: handle exception
		}
		return dispositivos;
	}

}
