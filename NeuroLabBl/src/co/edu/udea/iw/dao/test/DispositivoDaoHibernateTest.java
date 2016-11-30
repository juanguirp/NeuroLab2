package co.edu.udea.iw.dao.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.udea.iw.dao.DispositivoDao;
import co.edu.udea.iw.dto.Administrador;
import co.edu.udea.iw.dto.Dispositivo;
import co.edu.udea.iw.exception.NeuroLabDaoException;

/**
 * Prueba para la clase DispositivoDaoHibernate.
 * 
 * @author Juan Guillermo Restrepo Pineda <juan.restrepo48@udea.edu.co>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = ("classpath:configuracion.cfg.xml"))
public class DispositivoDaoHibernateTest {

	@Autowired
	DispositivoDao dispositivoDao;

	static Logger LOGGER = Logger.getLogger(DispositivoDaoHibernateTest.class);

	@Before
	public void inicializarLogger() {
		BasicConfigurator.configure();
	}

	@Test
	public void hayDispositivos() {
		List<Dispositivo> dispositivos;
		try {
			dispositivos = dispositivoDao.listarDispositivos();

			LOGGER.info("********* Numero de dispositivos: " + String.valueOf(dispositivos.size()));

			assertTrue(dispositivos.size() > 0);
		} catch (NeuroLabDaoException e) {
			// TODO: handle exception
		}
	}

	@Test
	public void verDispositivos() {
		List<Dispositivo> dispositivos;
		try {
			dispositivos = dispositivoDao.listarDispositivos();
			for (Dispositivo dispositivo : dispositivos) {
				LOGGER.info("********* Id: " + String.valueOf(dispositivo.getId()));
				LOGGER.info("********* Especificaciones: " + String.valueOf(dispositivo.getEspecificaciones()));
			}
			assertTrue(dispositivos.size() > 0);
		} catch (NeuroLabDaoException e) {
			// TODO: handle exception
		}
	}

	@Test
	public void guardarDispositivo() {
		int id = 7;
		String tipoDispositivo = "Tableta";
		Boolean disponible = Boolean.TRUE;
		String especificaciones = "Tablet de 100 pulgadas marca Eiser";
		Administrador adminRegistrador = new Administrador("eduard", "Edwin", "Osorio", "", "");
		Date fechaRegistro = new Date();
		Dispositivo dispositivo = new Dispositivo(id, tipoDispositivo, disponible, especificaciones, adminRegistrador,
				fechaRegistro);
		try {
			dispositivoDao.registrarDispositivo(dispositivo);
		} catch (NeuroLabDaoException e) {
			// TODO: handle exception
		}
	}
}
