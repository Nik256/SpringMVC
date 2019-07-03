package com.epam.mvc;

import com.epam.mvc.controller.AuthControllerTest;
import com.epam.mvc.controller.ProductControllerTest;
import com.epam.mvc.controller.UserControllerTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({AuthControllerTest.class, ProductControllerTest.class, UserControllerTest.class})
public class ControllerTestSuite {
}
