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

import co.edu.udea.iw.dao.SolicitudPrestamoDao;
import co.edu.udea.iw.dto.SolicitudPrestamo;
import co.edu.udea.iw.exception.NeuroLabDaoException;

/**
 * Prueba para la clase SolicitudPrestamoDaoHibernate.
 * 
 * @author Juan Guillermo Restrepo Pineda <juan.restrepo48@udea.edu.co>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = ("classpath:configuracion.cfg.xml"))
public class SolicitudPrestamoDaoHibernateTest {

	@Autowired
	SolicitudPrestamoDao solicitudPrestamoDao;

	static Logger LOGGER = Logger.getLogger(SolicitudPrestamoDaoHibernateTest.class);

	@Before
	public void inicializarLogger() {
		BasicConfigurator.configure();
	}

	@Test
	public void haySolicitudes() {
		List<SolicitudPrestamo> solicitudes;
		try {
			solicitudes = solicitudPrestamoDao.listarSolicitudes();

			LOGGER.info("********* Numero de solicitudes: " + String.valueOf(solicitudes.size()));

			assertTrue(solicitudes.size() > 0);
		} catch (NeuroLabDaoException e) {
			// TODO: handle exception
		}
	}

	@Test
	public void verSolicitudes() {
		List<SolicitudPrestamo> solicitudes;
		try {
			solicitudes = solicitudPrestamoDao.listarSolicitudes();
			for (SolicitudPrestamo solicitudPrestamo : solicitudes) {
				LOGGER.info("********* Id: " + String.valueOf(solicitudPrestamo.getId()));
				LOGGER.info("********* Respuesta: " + String.valueOf(solicitudPrestamo.getRespuesta()));
			}
			assertTrue(solicitudes.size() > 0);
		} catch (NeuroLabDaoException e) {
			// TODO: handle exception
		}
	}

}
