
import org.junit.Test;
import org.junit.Before;
import org.junit.Assert;

public class DriversManagerTest
{

    private final DriversManager driversManager = new DriversManager();

    @Before
    public void setup(){
        driversManager.addPassenger( new Passenger( "Carlos", "44234", 100 ) );
        driversManager.addPassenger( new Passenger( "Elise", "533434", 100 ) );
        driversManager.addPassenger( new Passenger( "Ian", "5343433", 100 ) );
        driversManager.addPassenger( new Passenger( "Debbie", "44555521", 100 ) );
        driversManager.addPassenger( new Passenger( "Cleon", "559988", 100 ) );
        driversManager.addPassenger( new Passenger( "Santiago", "1203123", 100 ) );

        driversManager.addDriver( new Driver( "Emilio", "1234990", 10f ) );
        driversManager.addDriver( new Driver( "Pedro", "12312440", 12f ) );
        driversManager.addDriver( new Driver( "Constanza", "9824990", 11f ) );
    }

    @Test
    public void Passenger(){
        Passenger fifthPassenger = driversManager.getPassenger("559988");
        boolean checkObj = false;
        if("Cleon" == fifthPassenger.getName() && "559988" == fifthPassenger.getId() && 100 == fifthPassenger.getBalance())
        {
            checkObj = true;
        }
        Assert.assertEquals("Passenger is Not added..!",true , checkObj);
        // Assert.assertEquals("Cleon",driversManager.getPassenger("559988").getName());
        // Assert.assertEquals("559988",driversManager.getPassenger("559988").getId());
        // Assert.assertEquals(100 ,driversManager.getPassenger("559988").getBalance());

    }
    @Test
    public void Driver(){
        Driver thirdDriver = driversManager.getDriver("9824990");
        boolean checkObj = false;
        if("Constanza" == thirdDriver.getName() && "9824990" == thirdDriver.getId() && 10f == thirdDriver.getFee())
        {
            checkObj = true;
        }
        Assert.assertEquals("Driver is Not added..!",true , checkObj);


    }
    @Test
    public void startTripTest(){
        driversManager.startTrip("559988","9824990");
        boolean checkTrip = false;
        if(driversManager.getDriver("9824990").isAvailable() == false && driversManager.getPassenger("44234").isOnTrip() == true)
        {
            checkTrip = true;
        }
        Assert.assertEquals("Trip not Started..!",true , checkTrip);
    }

    @Test
    public void endTripTest(){
        driversManager.endTrip("559988","1234990");
        boolean checkEndTrip = false;
        if(driversManager.getDriver("1234990").getBalance() >= 10f && driversManager.getPassenger("44234").getBalance() < 100)
        {
            checkEndTrip = true;
        }
        Assert.assertEquals("Trip not Ended..!",true , checkEndTrip);
    }

    @Test
    public void nextAvailableDriverTest(){
        driversManager.endTrip("558899","1234990");
        String availableDriver = driversManager.findNextAvailableDriver();
        Assert.assertEquals("1234990" , availableDriver);

    }
}
