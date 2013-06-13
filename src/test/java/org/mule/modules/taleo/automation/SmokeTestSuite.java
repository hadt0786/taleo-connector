/**
 * Mule Taleo Cloud Connector
 *
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 */

package org.mule.modules.taleo.automation;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;
import org.mule.modules.taleo.automation.testcases.SmokeTests;

@RunWith(Categories.class)
@IncludeCategory(SmokeTests.class)

@SuiteClasses({
	
		})

public class SmokeTestSuite {
	
}