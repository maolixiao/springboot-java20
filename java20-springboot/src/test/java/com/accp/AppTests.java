package com.accp;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.accp.controller.MyJunitControllerTest;
import com.accp.service.impl.StudentServiceImplTest;


/**
 * 
 * @author admin
 *
 */

@RunWith(Suite.class)
@SuiteClasses({MyJunitControllerTest.class,StudentServiceImplTest.class})
public class AppTests {

}
