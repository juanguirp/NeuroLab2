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

import co.edu.udea.iw.bl.SolicitudPrestamoBl;
import co.edu.udea.iw.exception.NeuroLabDaoException;

/**
 * Prueba para la clase SolicitudPrestamoBlImp.
 * 
 * @author Juan Guillermo Restrepo Pineda <juan.restrepo48@udea.edu.co>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = ("classpath:configuracion.cfg.xml"))
public class SolicitudPrestamoBlImpTest {

	@Autowired
	SolicitudPrestamoBl solicitudPrestamoBl;

	static Logger LOGGER = Logger.getLogger(SolicitudPrestamoBlImpTest.class);

	@Before
	public void inicializarLogger() {
		BasicConfigurator.configure();
	}

	@Test
	public void darRespuestaASolicitud() {
		try {
			solicitudPrestamoBl.responderSolicitud(1, true);
			assertTrue(true);
		} catch (NeuroLabDaoException e) {
			// TODO: handle exception
		}
	}

}
