package electricity;

import org.junit.*;
import org.mockito.Mock;

/**
 * Created by Robert Burek
 */
public class ExistElectricityMeterTest {

    public static ElectricityMeter electricityMeter;

    @BeforeClass
    public static void init() {   //metoda wykonywana przed całą klasą AppTest, może mieć dowolną nazwę
        //złożone obliczenia, ładowanie bazy, coś co ma być wykonane raz na początku zestawu testów
        ExistElectricityMeterTest.electricityMeter = new ElectricityMeter();
        //ExistElectrisityMeterTest robimy gdy chcemy wykonać tez zestaw testów na tej samej
        // intencji klasy
    }

    @Before
    public void setUp() {    //metoda wykonywana przed każdym testem klasy AppTest, może mieć dowolną nazwę
        //determinuje inicjowane pola i klasy, wykonywane przed każdym testem w zestawie
        //przed każdym testem następuje resetowanie, zerowanie pól testowanej klasy
        electricityMeter.addKwh(100);
    }

    @AfterClass
    public static void release() {
        //czyścimy wszystko co było w @BeforeClass, wykonuje się po wykonaniu klasy
        //zwalniamy zasoby
    }

    @After
    public void tearDown() {
        //wykonuje się po każdej metodzie, każdym teście
        electricityMeter.reset();
    }

    @Test
    public void addKwh_newMeter_properAddition() {
//        ElectrisityMeter electrisityMeter = new ElectrisityMeter();
        electricityMeter.addKwh(1);
        Assert.assertTrue(electricityMeter.getKwhNoTariff() == 101);
    }

    @Test
    public void addKwh_newMeter2_properAddition() {
//        ElectrisityMeter electrisityMeter = new ElectrisityMeter();
        electricityMeter.addKwh(1);
        electricityMeter.addKwh(4);
        Assert.assertTrue(electricityMeter.getKwhNoTariff() == 105);
    }

    @Test
    public void addKwh_newMeter5_properAddition() {
//        ElectrisityMeter electrisityMeter = new ElectrisityMeter();
        electricityMeter.addKwh(1);
        electricityMeter.addKwh(4);
        electricityMeter.addKwh(4);
        electricityMeter.addKwh(3);
        electricityMeter.addKwh(2);
        Assert.assertTrue(electricityMeter.getKwhNoTariff() == 114);
    }

    @Test
    public void addKwh_newMeter12_properAddition() {
//        ElectrisityMeter electrisityMeter = new ElectrisityMeter();
        for (int i = 1; i <= 12; i++)
            electricityMeter.addKwh(i);
        Assert.assertTrue(electricityMeter.getKwhNoTariff() == 178);
    }

    @Test
    public void kwhCounterIncreaseIfNew() {
//        ElectrisityMeter electrisityMeter = new ElectrisityMeter();
        electricityMeter.addKwh(5);
        Assert.assertTrue(electricityMeter.getKwhNoTariff() == 105);
    }

    @Test
    public void kwhCounterIncreaseIfSecond() {
//        ElectrisityMeter electrisityMeter = new ElectrisityMeter();
        electricityMeter.addKwh(5);
        electricityMeter.addKwh(4);
        Assert.assertTrue(electricityMeter.getKwhNoTariff() == 109);
    }

    //Given When Then - GWT   lub  Arrange-przygotuj, Act-zachowaj się, Assert-sprawdź,
    @Test
    public void givenNewMeterWhenFirstAdditionThenProperCounter7() {
        //Geven - sekcja założeń początkowych
//        ElectrisityMeter electrisityMeter = new ElectrisityMeter();
        //When - wykonujemy te akcje które są potrzebne aby nastał stan dla nas potrzebny
        electricityMeter.addKwh(5);
        //Then - sprawdzany zgodność z oczekiwaniami
        Assert.assertTrue(electricityMeter.getKwhNoTariff() == 105);
    }


    @Test
    public void givenNewMeterWhenFirstAdditionThenProperCounterTwoAssert() {
//        ElectrisityMeter electrisityMeter = new ElectrisityMeter();
        electricityMeter.addKwh(5);
        Assert.assertTrue("Celowo zrobiono błąd w Assercie.",electricityMeter.getKwhNoTariff() == 107);
        // gdy pierwsza nie przejdzie nie mamy informacji o drugiej
        Assert.assertTrue(electricityMeter.getKwhNoTariff() == 105);
    }

    @Test(expected = ArithmeticException.class) //test oczekuje wyjątku, gdy go nie ma, test jest błędny
    public void getHowMoreExpensiveNormalIs() {
//        ElectrisityMeter electrisityMeter = new ElectrisityMeter();
        electricityMeter.setCentsForKwh(90);
        electricityMeter.getHowMoreExpensiveNormalIs();

    }
}