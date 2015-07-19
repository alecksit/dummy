/**
 * 
 */
package com.mobileum.roameranalytics.service;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.advaizer.enums.RoamType;
import com.advaizer.model.RoamingThresholds;
import com.advaizer.service.ConfigurationService;

/**
 * @author sarvesh
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "/spring-jdbc-test.xml"})
public class ConfigurationServiceImplTest {

	/**
	 * @throws java.lang.Exception
	 */
	
	@Autowired
	private ConfigurationService configurationService;
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSaveConfigurationOut() {
		final RoamingThresholds zero = new RoamingThresholds(1, 1, 10, 12, 15, 456);
		final RoamingThresholds mod = new RoamingThresholds(1, 2, 10, 12, 15, 456);
		final RoamingThresholds heavy = new RoamingThresholds(1, 3, 10, 12, 15, 456);
		final Map<String,Object> result = configurationService.saveThresholds(RoamType.OUT.getRoamType(), 1, zero, mod, heavy);
		System.out.println(result);
		final Boolean success = (Boolean) result.get("success");
		assertEquals(true, success);
	}

	@Test
	public void testSaveConfigurationIn() {
		final RoamingThresholds zero = new RoamingThresholds(1, 1, 10, 12, 15, 456);
		final RoamingThresholds mod = new RoamingThresholds(1, 2, 10, 12, 15, 456);
		final RoamingThresholds heavy = new RoamingThresholds(1, 3, 10, 12, 15, 456);
		final Map<String,Object> result = configurationService.saveThresholds(RoamType.IN.getRoamType(), 1, zero, mod, heavy);
		System.out.println(result);
		final Boolean success = (Boolean) result.get("success");
		assertEquals(true, success);
	}
}
