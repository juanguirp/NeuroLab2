package co.edu.udea.iw.ws;

import java.rmi.RemoteException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.edu.udea.iw.exception.NeuroLabDaoException;
import co.edu.udea.iw.bl.AdministradorBl;
import co.edu.udea.iw.dto.Administrador;
import co.edu.udea.iw.ws.dto.AdministradorWs;

/**
 * Clase que implementa los servicios rest para un administrador.
 * 
 * @author Juan Guillermo Restrepo Pineda <juan.restrepo48@udea.edu.co>
 *
 */
@Path("ServicioAdministrador")
@Component
public class ServicioAdministrador {

	@Autowired
	AdministradorBl administradorBl;

	/*
	 * Getters y Setters para los atributos de un administrador.
	 */
	public AdministradorBl getAdministradorBl() {
		return administradorBl;
	}

	public void setAdministradorBl(AdministradorBl administradorBl) {
		this.administradorBl = administradorBl;
	}

	/**
	 * Permite validar la existencia de un administrador en el sistema.
	 * 
	 * @param id
	 *            - Identificador, login o nombre de usuario para un
	 *            administrador.
	 * @param contrasena
	 *            - Contrasena de un administrador.
	 * @return - Valor logico que indica si existe o no el administrador.
	 * @throws RemoteException
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("validarAdministrador/{id}/{contrasena}")
	public boolean validarAdministrador(@PathParam("id") String id, @PathParam("contrasena") String contrasena)
			throws RemoteException {

		boolean esAdminValido = false;

		try {
			esAdminValido = administradorBl.validarAdministrador(id, contrasena);
		} catch (NeuroLabDaoException e) {
			throw new RemoteException(e.getMessage(), e);
		}

		return esAdminValido;
	}

	/**
	 * Permite registrar a un nuevo administrador.
	 * 
	 * @param id
	 *            - Identificador, login o nombre de usuario para un
	 *            administrador.
	 * @param nombre
	 *            - Nombre real de un administrador.
	 * @param apellidos
	 *            - Apellidos de un administrador.
	 * @param correo
	 *            - Correo electronico de un administrador.
	 * @param contrasena
	 *            - Contrasena de un administrador.
	 * @throws RemoteException
	 */
	@GET
	@Path("registrarAdministrador/{id}/{nombre}/{apellidos}/{correo}/{contrasena}")
	public void crearCuentaAdministrador(String id, String nombre, String apellidos, String correo, String contrasena)
			throws RemoteException {

		try {
			administradorBl.crearCuentaAdministrador(id, nombre, apellidos, correo, contrasena);
		} catch (NeuroLabDaoException e) {
			throw new RemoteException(e.getMessage(), e);
		}

	}

}
