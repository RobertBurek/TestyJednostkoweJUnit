package electricity;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Robert Burek
 */
public class TwoElectricityMeterTest {

    @Test
    public void addKwh_newMeter_properAddition() {
        ElectricityMeter electrisityMeter = new ElectricityMeter();
        electrisityMeter.addKwh(1);
        Assert.assertTrue(electrisityMeter.getKwhNoTariff()==1);
    }

    @Test
    public void addKwh_newMeter2_properAddition() {
        ElectricityMeter electrisityMeter = new ElectricityMeter();
        electrisityMeter.addKwh(1);
        electrisityMeter.addKwh(4);
        Assert.assertTrue(electrisityMeter.getKwhNoTariff()==5);
    }

    @Test
    public void addKwh_newMeter5_properAddition() {
        ElectricityMeter electrisityMeter = new ElectricityMeter();
        electrisityMeter.addKwh(1);
        electrisityMeter.addKwh(4);
        electrisityMeter.addKwh(4);
        electrisityMeter.addKwh(3);
        electrisityMeter.addKwh(2);
        Assert.assertTrue(electrisityMeter.getKwhNoTariff()==14);
    }

    //Given When Then - GWT   lub  Arrange-przygotuj, Act-zachowaj się, Assert-sprawdź,
    @Test
    public void givenNewMeterWhenFirstAdditionThenProperCounter7() {
        //Geven - sekcja założeń początkowych
        ElectricityMeter electrisityMeter = new ElectricityMeter();
        //When - wykonujemy te akcje które są potrzebne aby nastał stan dla nas potrzebny
        electrisityMeter.addKwh(5);
        //Then - sprawdzany zgodność z oczekiwaniami
        Assert.assertTrue(electrisityMeter.getKwhNoTariff() == 5);
    }


    @Test
    public void givenNewMeterWhenFirstAdditionThenProperCounterTwoAssert() {
        ElectricityMeter electrisityMeter = new ElectricityMeter();
        electrisityMeter.addKwh(5);
        Assert.assertTrue("Celowo zrobiono błąd w Assercie.",electrisityMeter.getKwhNoTariff()==7);
        // gdy pierwsza nie przejdzie nie mamy informacji o drugiej
        Assert.assertTrue(electrisityMeter.getKwhNoTariff()==5);
    }

    @Test (expected = ArithmeticException.class) //test oczekuje wyjątku, gdy go nie ma, test jest błędny
    public void getHowMoreExpensiveNormalIs() {
        ElectricityMeter electrisityMeter = new ElectricityMeter();
        electrisityMeter.setCentsForKwh(90);
        electrisityMeter.getHowMoreExpensiveNormalIs();

    }
}