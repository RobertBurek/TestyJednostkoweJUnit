package electricity;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Robert Burek
 */
public class ElectrisityMeterTest {

    @Test
    public void addKwh_newMeter_properAddition() {
        ElectrisityMeter electrisityMeter = new ElectrisityMeter();
        electrisityMeter.addKwh(1);
        Assert.assertTrue(electrisityMeter.getKwhNoTariff()==1);
    }

    @Test
    public void addKwh_newMeter2_properAddition() {
        ElectrisityMeter electrisityMeter = new ElectrisityMeter();
        electrisityMeter.addKwh(1);
        electrisityMeter.addKwh(4);
        Assert.assertTrue(electrisityMeter.getKwhNoTariff()==5);
    }

    @Test
    public void addKwh_newMeter5_properAddition() {
        ElectrisityMeter electrisityMeter = new ElectrisityMeter();
        electrisityMeter.addKwh(1);
        electrisityMeter.addKwh(4);
        electrisityMeter.addKwh(4);
        electrisityMeter.addKwh(3);
        electrisityMeter.addKwh(2);
        Assert.assertTrue(electrisityMeter.getKwhNoTariff()==14);
    }

    @Test
    public void addKwh_newMeter12_properAddition() {
        ElectrisityMeter electrisityMeter = new ElectrisityMeter();
        for(int i=1; i<=12; i++)
            electrisityMeter.addKwh(i);
        Assert.assertTrue(electrisityMeter.getKwhNoTariff()==78);
    }

    @Test
    public void kwhCounterIncreaseIfNew() {
        ElectrisityMeter electrisityMeter = new ElectrisityMeter();
        electrisityMeter.addKwh(5);
        Assert.assertTrue(electrisityMeter.getKwhNoTariff()==5);
    }

    @Test
    public void kwhCounterIncreaseIfSecond() {
        ElectrisityMeter electrisityMeter = new ElectrisityMeter();
        electrisityMeter.addKwh(5);
        electrisityMeter.addKwh(4);
        Assert.assertTrue(electrisityMeter.getKwhNoTariff()==9);
    }

    @Test
    public void givenNewMeterWhenFirstAdditionThenProperCounter() {
        ElectrisityMeter electrisityMeter = new ElectrisityMeter();
        electrisityMeter.addKwh(5);
        Assert.assertTrue(electrisityMeter.getKwhNoTariff()==5);
    }

    @Test
    public void givenNewMeterWhenFirstAdditionThenProperCounterTwoAssert() {
        ElectrisityMeter electrisityMeter = new ElectrisityMeter();
        electrisityMeter.addKwh(5);
        Assert.assertTrue(electrisityMeter.getKwhNoTariff()==7);
        // gdy pierwsza nie przejdzie nie mamy informacji o drugiej
        Assert.assertTrue(electrisityMeter.getKwhNoTariff()==5);
    }
}