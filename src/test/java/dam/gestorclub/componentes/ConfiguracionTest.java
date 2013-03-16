/**
 * 
 */
package dam.gestorclub.componentes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dam.gestorclub.componentes.Configuracion.KEYS;

/**
 * @author under
 *
 */
public class ConfiguracionTest {


	/**
	 * Test method for {@link dam.gestorclub.componentes.Configuracion#getConfiguration()}.
	 */
	@Test
	public final void testGetConfiguration() {
		Configuracion config = Configuracion.getConfiguration();
		assertNotNull(config);
	}

	/**
	 * Test method for {@link dam.gestorclub.componentes.Configuracion#getKey(dam.gestorclub.componentes.Configuracion.KEYS)}.
	 */
	@Test
	public final void testGetKey() {
		//TODO mas pruebas cambiando los datos
		Configuracion config = Configuracion.getConfiguration();
		config.loadDefaults();
		
		assertEquals("undergrounder.no-ip.info", config.getKey(KEYS.DB_HOST));
		assertEquals("under", config.getKey(KEYS.DB_USER));
		assertEquals("qwerty69", config.getKey(KEYS.DB_PASS));
		assertEquals("UNDER", config.getKey(KEYS.DB_SCHEMA));
		
	}

	/**
	 * Test method for {@link dam.gestorclub.componentes.Configuracion#load()}.
	 */
	@Test
	public final void testLoad() {
		//TODO borrar configuracion para que falle
		Configuracion config = Configuracion.getConfiguration();
		assertTrue(config.load());
	}

	/**
	 * Test method for {@link dam.gestorclub.componentes.Configuracion#validate()}.
	 */
	@Test
	public final void testValidate() {
		Configuracion conf = Configuracion.getConfiguration();
		conf.loadDefaults();
		assertTrue(conf.validate());
	}
	
	/**
	 * Test method for {@link dam.gestorclub.componentes.Configuracion#loadDefaults()}.
	 */
	@Test
	public final void testLoadDefaults() {
		Configuracion conf = Configuracion.getConfiguration();
		conf.loadDefaults();
		assertTrue(conf.validate());
	}

	/**
	 * Test method for {@link dam.gestorclub.componentes.Configuracion#save()}.
	 */
	@Test
	public final void testSave() {
		Configuracion conf = Configuracion.getConfiguration();
		conf.loadDefaults();
		assertTrue(conf.save());
	}

}
