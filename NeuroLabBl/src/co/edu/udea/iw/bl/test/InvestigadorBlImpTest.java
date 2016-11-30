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

import co.edu.udea.iw.bl.InvestigadorBl;
import co.edu.udea.iw.dto.Investigador;
import co.edu.udea.iw.exception.NeuroLabDaoException;

/**
 * Prueba para la clase InvestigadorBlImp.
 * 
 * @author Juan Guillermo Restrepo Pineda <juan.restrepo48@udea.edu.co>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = ("classpath:configuracion.cfg.xml"))
public class InvestigadorBlImpTest {

	@Autowired
	InvestigadorBl investigadorBl;

	static Logger LOGGER = Logger.getLogger(InvestigadorBlImpTest.class);

	@Before
	public void inicializarLogger() {
		BasicConfigurator.configure();
	}

	@Test
	public void validarInicioSesionInvestigador() {
		boolean validacion = false;
		try {
			//validacion = investigadorBl.validarInvestigador("dani01", "dani01");
			investigadorBl.validarInvestigador("dani01", "dani01");
			assertTrue(validacion);
		} catch (NeuroLabDaoException e) {
			// TODO: handle exception
		}
	}

	@Test
	public void validarRegistroInvestigador() {
		try {
			investigadorBl.crearCuentaInvestigador("dani04", "Danielo", "Cuarto", "elgrande@correo.com", "dani04");
			assertTrue(true);
		} catch (NeuroLabDaoException e) {
			// TODO: handle exception
		}
	}

}
