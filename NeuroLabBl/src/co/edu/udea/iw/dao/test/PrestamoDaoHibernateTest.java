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

import co.edu.udea.iw.dao.PrestamoDao;
import co.edu.udea.iw.dto.Prestamo;
import co.edu.udea.iw.exception.NeuroLabDaoException;

/**
 * Prueba para la clase PrestamoDaoHibernate.
 * 
 * @author Juan Guillermo Restrepo Pineda <juan.restrepo48@udea.edu.co>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = ("classpath:configuracion.cfg.xml"))
public class PrestamoDaoHibernateTest {

	@Autowired
	PrestamoDao prestamoDao;

	static Logger LOGGER = Logger.getLogger(PrestamoDaoHibernateTest.class);

	@Before
	public void inicializarLogger() {
		BasicConfigurator.configure();
	}

	@Test
	public void hayPrestamos() {
		List<Prestamo> prestamos;
		try {
			prestamos = prestamoDao.listarPrestamos();

			LOGGER.info("********* Numero de prestamos: " + String.valueOf(prestamos.size()));

			assertTrue(prestamos.size() > 0);
		} catch (NeuroLabDaoException e) {
			// TODO: handle exception
		}
	}

	@Test
	public void verPrestamos() {
		List<Prestamo> prestamos;
		try {
			prestamos = prestamoDao.listarPrestamos();
			for (Prestamo prestamo : prestamos) {
				LOGGER.info("********* Id: " + String.valueOf(prestamo.getId()));
				LOGGER.info("********* Horas reservadas: " + String.valueOf(prestamo.getHorasSolicitadas()));
			}
			assertTrue(prestamos.size() > 0);
		} catch (NeuroLabDaoException e) {
			// TODO: handle exception
		}
	}

}
