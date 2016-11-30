package co.edu.udea.iw.dao.test;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.udea.iw.dao.AdministradorDao;
import co.edu.udea.iw.dto.Administrador;
import co.edu.udea.iw.exception.NeuroLabDaoException;

/**
 * Prueba para la clase AdministradorDaoHibernate.
 * 
 * @author Juan Guillermo Restrepo Pineda <juan.restrepo48@udea.edu.co>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = ("classpath:configuracion.cfg.xml"))
public class AdministradorDaoHibernateTest {

	@Autowired
	AdministradorDao administradorDao;

	static Logger LOGGER = Logger.getLogger(AdministradorDaoHibernateTest.class);

	@Before
	public void inicializarLogger() {
		BasicConfigurator.configure();
	}

	@Test
	public void hayAdministradores() {
		// LOGGER.info("********* Numero de administradores: ");
		List<Administrador> administradores;
		try {
			administradores = administradorDao.listarAdministradores();
			LOGGER.info("********* Numero de administradores: " + String.valueOf(administradores.size()));
			assertTrue(administradores.size() > 0);
		} catch (NeuroLabDaoException e) {
			// TODO: handle exception
		}

	}

	@Test
	public void verAdministradores() {
		List<Administrador> administradores;
		try {
			administradores = administradorDao.listarAdministradores();
			for (Administrador administrador : administradores) {

				LOGGER.info("********* Nombre: " + String.valueOf(administrador.getNombre()));
				LOGGER.info("********* Apellido: " + String.valueOf(administrador.getApellidos()));

			}
			assertTrue(administradores.size() > 0);
		} catch (NeuroLabDaoException e) {
			// TODO: handle exception
		}
	}

}
