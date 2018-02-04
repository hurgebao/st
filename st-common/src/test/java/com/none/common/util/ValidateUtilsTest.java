package com.none.common.util;

import org.junit.Assert;
import org.junit.Test;

public class ValidateUtilsTest {

	@Test
	public void testCheckIsNull() {
		boolean isnull = ValidateUtils.checkIsNull("123", " ");
		Assert.assertTrue(isnull);
		isnull = ValidateUtils.checkIsNull("123", null);
		Assert.assertTrue(isnull);
		isnull = ValidateUtils.checkIsNull("123", "1 ");
		Assert.assertFalse(isnull);
	}

}
