/**
 * 
 */
package com.mobileum.roameranalytics.common;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.advaizer.common.CommonUtil;

/**
 * @author sarvesh
 *
 */
public class CommonUtilTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Test method for {@link com.advaizer.common.CommonUtil#convertToList(java.lang.String, java.lang.String)}.
	 */
	@Test
	@Ignore
	public void testConvertToList() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.advaizer.common.CommonUtil#parseSelectedAttributes(java.lang.String)}.
	 */
	@Test
	@Ignore
	public void testParseSelectedAttributes() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.advaizer.common.CommonUtil#convertToCommaSeparatedString(java.util.Collection)}.
	 */
	@Test
	public void testCovnertToCommaSeparatedString() {
		final List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		final String actual = CommonUtil.convertToCommaSeparatedString(list);
		final String expected = "'1','2','3'";
		assertEquals(expected, actual);
		
		final String css = "1,2,3";
		/*assertEquals(css, CommonUtil.convertToCommaSeparatedString(css,"java.lang.Integer"));
		assertEquals(expected, CommonUtil.convertToCommaSeparatedString(css,"java.lang.String"));*/
		
	}
}
