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


}