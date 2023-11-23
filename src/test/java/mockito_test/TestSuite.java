package mockito_test;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({SpringManagerTest.class,PortfolioServiceTest.class, ClientServiceTest.class,FXMLHandlerTest.class,
        AuthControllerTest.class,SharedDataTest.class,JavaFXMainTest.class,BenchmarkTest.class,
        ClientServiceTest.class, PerformanceMetricsTest.class, InvestmentsTest.class,
        TransactionTest.class, InflationBenchmarkTest.class, MainControllerTest.class, JavaFXMainTest.class})
public class TestSuite {
}
