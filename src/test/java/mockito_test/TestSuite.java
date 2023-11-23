package mockito_test;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({PortfolioServiceTest.class, ClientServiceTest.class})
public class TestSuite {
}
