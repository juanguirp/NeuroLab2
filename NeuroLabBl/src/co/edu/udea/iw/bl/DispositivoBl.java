package co.edu.udea.iw.bl;

import java.util.Date;
import java.util.List;

import co.edu.udea.iw.dto.Administrador;
import co.edu.udea.iw.dto.Dispositivo;
import co.edu.udea.iw.exception.NeuroLabDaoException;

/**
 * Interface que define los metodos para la cumplir con la logica del negocio
 * para un dispositivo.
 * 
 * @author Juan Guillermo Restrepo Pineda <juan.restrepo48@udea.edu.co>
 */
public interface DispositivoBl {

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
	 */
	public void registrarDispositivo(int id, String tipoDispositivo, Boolean disponible, String especificaciones,
			String adminRegistrador, Date fechaRegistro) throws NeuroLabDaoException;

	/**
	 * Elimina un dispositivo del sistema.
	 * 
	 * @param id
	 *            - Numero que identifica al dispositivo a eliminar.
	 * @throws NeuroLabDaoException
	 *             cuando hay algun problema en la conexion.
	 */
	public void eliminarDispositivo(int id) throws NeuroLabDaoException;

	/**
	 * Lista todos los dispositivos en el sistema.
	 * 
	 * @return Lista de dispositivos.
	 * @throws NeuroLabDaoException
	 *             cuando hay algun problema en la conexion.
	 */
	public List<Dispositivo> listarDispositivos() throws NeuroLabDaoException;

}
