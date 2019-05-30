package electricity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

/**
 * Created by Robert Burek
 */
class ElectricityMeterTestJUnit5 {

    ElectricityMeter electricityMeter;
    TariffProvider tp;

//    @BeforeAll odpowiednik @BeforeClass w JUnit4
//    @BeforeEach odpowiednik @Before w JUnit4

    @BeforeEach
    void setUp() {
        tp = Mockito.mock(TariffProvider.class);
        electricityMeter = new ElectricityMeter(tp);
        electricityMeter.setTariffOn(true);
    }

//    @AfterAll odpowiednik @AfterClass w JUnit4
//    @AfterEach odpowiednik @After w JUnit4

    @Test
    public void givenTariffOnWhenAdditionThenKwhIncreased() {
        //Given
        //TODO setTariff Time mock isTariffNow() !
        Mockito.when(tp.isTariffNow()).thenReturn(true);
        //When
        electricityMeter.addKwh(50);
        //Then
        Assumptions.assumeTrue(tp.isTariffNow());
        Assertions.assertEquals(50, electricityMeter.getKwhTariff());
    }

    @Test
    public void getHowMoreExpensiveNormalIs() {
        //pełny zapis Executable
//        Assertions.assertThrows(ArithmeticException.class, new Executable() {
//            @Override
//            public void execute() throws Throwable {
//                ElectricityMeter electricityMeter = new ElectricityMeter();
//                electricityMeter.setCentsForKwh(90);
//                electricityMeter.getHowMoreExpensiveNormalIs();
//            }
//        });

        //zapis Executable przez lambdę
        // oczekiwany wyjątek ArithmeticException inny nie będzie obsłużony np IOException
        Throwable exception = Assertions.assertThrows(ArithmeticException.class, () -> {
            ElectricityMeter electricityMeter = new ElectricityMeter();
            electricityMeter.setCentsForKwh(90);
            electricityMeter.getHowMoreExpensiveNormalIs();
        });
        Assertions.assertEquals("/ by zero", exception.getMessage());
    }


}