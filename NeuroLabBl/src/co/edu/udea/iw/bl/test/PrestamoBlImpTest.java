package co.edu.udea.iw.bl.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.udea.iw.bl.PrestamoBl;
import co.edu.udea.iw.exception.NeuroLabDaoException;

/**
 * Prueba para la clase PrestamoBlImp.
 * 
 * @author Juan Guillermo Restrepo Pineda <juan.restrepo48@udea.edu.co>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = ("classpath:configuracion.cfg.xml"))
public class PrestamoBlImpTest {

	@Autowired
	PrestamoBl prestamoBl;

	static Logger LOGGER = Logger.getLogger(PrestamoBlImpTest.class);

	@Before
	public void inicializarLogger() {
		BasicConfigurator.configure();
	}

	@Test
	public void crearPrestamo() {
		try {
			prestamoBl.registrarPrestamo(8, 1, new Date(), new Date(), 3);
			assertTrue(true);
		} catch (NeuroLabDaoException e) {
			// TODO: handle exception
		}
	}

}
