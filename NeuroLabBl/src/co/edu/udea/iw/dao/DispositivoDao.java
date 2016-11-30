package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Dispositivo;
import co.edu.udea.iw.exception.NeuroLabDaoException;

/**
 * Interface que define los metodos para acceder a la tabla tab_dispositivos.
 * 
 * @author Juan Guillermo Restrepo Pineda <juan.restrepo48@udea.edu.co>
 */
public interface DispositivoDao {

	/**
	 * Entrega una lista con los dispositivos en la base de datos.
	 * 
	 * @return lista de dispositivos.
	 * @throws NeuroLabDaoException
	 *             cuando hay algun problema en la conexion.
	 */
	public List<Dispositivo> listarDispositivos() throws NeuroLabDaoException;

	/**
	 * Entrega los datos de un dispositivo dado su identificador.
	 * 
	 * @param id
	 *            - Identificador de un dispositivo.
	 * @return DTO de un dispositivo con sus datos.
	 * @throws NeuroLabDaoException
	 *             cuando hay algun problema en la conexion.
	 */
	public Dispositivo obtenerDispositivo(int id) throws NeuroLabDaoException;

	/**
	 * Permite crear un nuevo dispositivo y registrarlo en la base de datos.
	 * 
	 * @param administrador
	 *            - DTO con los datos del dispositivo a guardar.
	 * @throws NeuroLabDaoException
	 *             cuando hay algun problema en la conexion.
	 */
	public void registrarDispositivo(Dispositivo dispositivo) throws NeuroLabDaoException;

	/*
	 * Actualiza la informacion de un dispositivo en la base de datos.
	 * 
	 * @param administrador - DTO con los datos del dispositivo a modificar.
	 * 
	 * @throws NeuroLabDaoException cuando hay algun problema en la conexion.
	 */
	public void actualizarDispositivo(Dispositivo dispositivo) throws NeuroLabDaoException;

	/**
	 * Permite eliminar un dispositivo de la base de datos.
	 * 
	 * @param id
	 *            - Identificador de un dispositivo.
	 * @throws NeuroLabDaoException
	 *             cuando hay algun problema en la conexion.
	 */
	public void eliminarDispositivo(int id) throws NeuroLabDaoException;

}
