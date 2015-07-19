/**
 * 
 */
package roameranalytics;

import static org.junit.Assert.fail;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.advaizer.controller.HomeController;

/**
 * @author Quovantis_Dev
 *
 */
public class TrendControllerTest {

	/**
	 * Test method for {@link com.advaizer.controller.HomeController#showHome()}.
	 */
	@Autowired
	private HomeController tc;
	
	@Test
	public void testShowHome() {
	}

	/**
	 * Test method for {@link com.advaizer.controller.HomeController#showRoamingTrends()}.
	 */
	@Test
	@Ignore
	public void testShowRoamingTrends() {
		fail("Not yet implemented");
	}

}
