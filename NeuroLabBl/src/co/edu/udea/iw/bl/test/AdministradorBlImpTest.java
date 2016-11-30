package co.edu.udea.iw.bl.test;

import static org.junit.Assert.*;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.udea.iw.bl.AdministradorBl;
import co.edu.udea.iw.exception.NeuroLabDaoException;

/**
 * Prueba para la clase AdministradorBlImp.
 * 
 * @author Juan Guillermo Restrepo Pineda <juan.restrepo48@udea.edu.co>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = ("classpath:configuracion.cfg.xml"))
public class AdministradorBlImpTest {

	@Autowired
	AdministradorBl administradorBl;

	static Logger LOGGER = Logger.getLogger(InvestigadorBlImpTest.class);

	@Before
	public void inicializarLogger() {
		BasicConfigurator.configure();
	}

	@Test
	public void validarInicioSesionAdministrador() {
		boolean validacion = false;
		try {
			validacion = administradorBl.validarAdministrador("juangui", "juangui");
			assertTrue(validacion);
		} catch (NeuroLabDaoException e) {
			// TODO: handle exception
		}
	}

	@Test
	public void validarRegistroAdmistrador() {
		try {
			administradorBl.crearCuentaAdministrador("elver", "Elver", "Zapata", "elver@zapata.com", "elver");
			assertTrue(true);
		} catch (NeuroLabDaoException e) {
			// TODO: handle exception
		}
	}

}
