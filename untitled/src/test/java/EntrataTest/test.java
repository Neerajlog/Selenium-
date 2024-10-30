package EntrataTest;

import BaseTest.BaseTest;
import EntrataScreen.Screen.EntrataScreen;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class test extends BaseTest {

    EntrataScreen entrataScreen;

    @BeforeMethod
    public void setup(){
        openBrowser();
        navigateUrl();
        entrataScreen=new EntrataScreen(driver);
    }

   @Test(priority = 1)
    public void ScheduleYourDemo(){
        boolean check=entrataScreen.scheduleYourDemo();
       Assert.assertTrue(check);
    }

    @Test(priority = 2)
    public void RegisterNow() throws InterruptedException {
        boolean check=entrataScreen.registerNow();
        Assert.assertTrue(check);
    }

    @Test(priority = 2)
    public void AutomationAi() throws InterruptedException {
        boolean check=entrataScreen.discoverAi();
        Assert.assertTrue(check);
    }



}
