import electricity.ExistElectricityMeterTest;
import electricity.NewElectricityMeterTest;
import electricity.TariffElectricityMeterTest;
import electricity.TwoElectricityMeterTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by Robert Burek
 */

@RunWith(Suite.class)

@Suite.SuiteClasses({
        NewElectricityMeterTest.class,
        ExistElectricityMeterTest.class,
//        ExistElectrisityMeterTest.class, gdy mamy @BeforeClass i init() robimy testy na tej samej intencji (bazie danych)
        TwoElectricityMeterTest.class,
        TariffElectricityMeterTest.class
})

public class ElectricityMeterSuite {
}
