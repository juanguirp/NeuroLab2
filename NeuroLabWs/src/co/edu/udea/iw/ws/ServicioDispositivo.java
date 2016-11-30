package co.edu.udea.iw.ws;

import java.rmi.RemoteException;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import co.edu.udea.iw.bl.DispositivoBl;
import co.edu.udea.iw.dto.Dispositivo;
import co.edu.udea.iw.exception.NeuroLabDaoException;
import co.edu.udea.iw.ws.dto.DispositivoWs;

/**
 * Clase que implementa el servicio rest para la Dispositivo
 * @author Juan Fernando Moreno juan.moreno1@udea.edu.co
 */
@Path("ServicioDispositivo")
public class ServicioDispositivo {
	
	DispositivoBl dispositivoBl;

	/*
	 * Getters y Setters para los atributos de un dispositivo.
	 */
	public DispositivoBl getDispositivoBl() {
		return dispositivoBl;
	}

	public void setDispositivoBl(DispositivoBl dispositivoBl) {
		this.dispositivoBl = dispositivoBl;
	}
	
	/**
	 * Metodo que registra un dispositivo
	 * @param id
	 * @param tipoDispositivo
	 * @param disponible
	 * @param especificaciones
	 * @param adminRegistrador
	 * @return el dispositivo si se a creado exitosamente
	 * @throws RemoteException
	 */
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("registrarDispositivo/{id}/{tipoDispositivo}/{disponible}/{especificaciones}")
	public DispositivoWs registrarDispositivo(@PathParam("id")int id, @PathParam("tipoDispositivo")String tipoDispositivo, @PathParam("disponible")Boolean disponible, @PathParam("especificaciones")String especificaciones) throws RemoteException{
		

		DispositivoWs dispositivoWs = null;

		dispositivoWs = new DispositivoWs();
		dispositivoWs.setId(id);
		dispositivoWs.setTipoDispositivo(tipoDispositivo);
		dispositivoWs.setDisponible(disponible);
		dispositivoWs.setEspecificaciones(especificaciones);
		
		return dispositivoWs;
		
		
	}
	
	/**
	 * Elimina el dispositivo por la id
	 * @param id
	 * @throws RemoteException
	 */
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("eliminarDispositivo/{id}")
	public void eliminarDispositivo(int id) throws RemoteException{
		
		try {
			dispositivoBl.eliminarDispositivo(id);
		} catch (NeuroLabDaoException e) {
			throw new RemoteException(e.getMessage(), e);
		}
		
	}
	
	/**
	 * Lista los dispositivos
	 * @return lista de los dispotivos
	 * @throws RemoteException
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("listarDispositivo/{id}")
	public List<Dispositivo> listarDispositivo() throws RemoteException{
		
		List<Dispositivo> dispositivos = null;
		try {
			dispositivos = dispositivoBl.listarDispositivos();
		} catch (NeuroLabDaoException e) {
			throw new RemoteException(e.getMessage(), e);
		}
		return dispositivos;
		
	}

	
}
