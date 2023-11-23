package mockito_test;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({PortfolioServiceTest.class, ClientServiceTest.class,FXMLHandlerTest.class,
        AuthControllerTest.class,SharedDataTest.class,JavaFXMainTest.class,SpringManagerTest.class})
public class TestSuite {
}
