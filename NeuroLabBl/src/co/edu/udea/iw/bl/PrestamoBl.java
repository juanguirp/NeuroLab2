package co.edu.udea.iw.bl;

import java.util.Date;

import co.edu.udea.iw.dto.Dispositivo;
import co.edu.udea.iw.dto.SolicitudPrestamo;
import co.edu.udea.iw.exception.NeuroLabDaoException;

/**
 * Interface que define los metodos para la cumplir con la logica del negocio
 * para un prestamo.
 * 
 * @author Juan Guillermo Restrepo Pineda <juan.restrepo48@udea.edu.co>
 */
public interface PrestamoBl {

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
	 */
	public void registrarPrestamo(int id, int solicitudAsociada, Date horaEntrega, Date horaDevolucion,
			int horasSolicitadas) throws NeuroLabDaoException;

}
