package EntrataScreen.Screen;

import BaseScreen.BaseScreen;
import EntrataScreen.locators.EntrataLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class EntrataScreen extends BaseScreen {

     EntrataLocators entrataLocators=new EntrataLocators();
    public EntrataScreen(WebDriver driver) {
        super(driver);
    }

    public boolean scheduleYourDemo(){

        if(checkIfDisplay(entrataLocators.acceptCookie)){
            click(entrataLocators.acceptCookie);
        }

        fluentwaitAfterLoading(entrataLocators.schduledemo);
        clickNotvisible(entrataLocators.schduledemo);

        navigatieToanotherUrl();

        fluentwaitAfterLoading(entrataLocators.firstName);
        clearandEnterDetails(entrataLocators.firstName,"John");

        fluentwait(entrataLocators.lastName);
        clearandEnterDetails(entrataLocators.lastName,"wick");

        fluentwait(entrataLocators.Email);
        clearandEnterDetails(entrataLocators.Email,"xyz@gmail.com");

        fluentwait(entrataLocators.Company);
        clearandEnterDetails(entrataLocators.Company,"Entrata");

        fluentwait(entrataLocators.Phone);
        clearandEnterDetails(entrataLocators.Phone,"1234567890");

        fluentwait(entrataLocators.Unit_Count_c);
        click(entrataLocators.Unit_Count_c);

        fluentwait(entrataLocators.Unit_Count_Value);
        click(entrataLocators.Unit_Count_Value);

        fluentwait(entrataLocators.JobTitle);
        clearandEnterDetails(entrataLocators.JobTitle,"SDET");

        fluentwait(entrataLocators.demoRequest);
        click(entrataLocators.demoRequest);

        fluentwait(entrataLocators.demoRequest_value);
        click(entrataLocators.demoRequest_value);

        scrollToElement(entrataLocators.schduleType);
        return isDisplayOnscreen(entrataLocators.schduleType);
    }

    public boolean registerNow() throws InterruptedException {
        if(checkIfDisplay(entrataLocators.acceptCookie)){
            click(entrataLocators.acceptCookie);
        }

        Thread.sleep(5);

        scrollToElement(entrataLocators.regisyerNow);
        fluentwait(entrataLocators.regisyerNow);
        clickNotvisible(entrataLocators.regisyerNow);

        List<WebElement> list=getAllElements(entrataLocators.registerNowNavBar);

        int count=0;
        for(WebElement element:list){
            System.out.println(count);
            element.click();
            count++;
            if(count==4){
                break;
            }
        }

        driver.navigate().back();
        if(count== list.size()-2){         //checking that al nav bar are navigating properly
            return true;
        }
        return false;
    }

    public boolean discoverAi() throws InterruptedException {
        if(checkIfDisplay(entrataLocators.acceptCookie)){
            click(entrataLocators.acceptCookie);
        }

        scrollToElement(entrataLocators.seeHowItwork);

        fluentwait(entrataLocators.discoverAi);
        getAllElements(entrataLocators.discoverAi).get(0).click();

        Thread.sleep(7);
        driver.navigate().back();

        scrollUp();

        fluentwait(entrataLocators.schduledemo);
        return isDisplayOnscreen(entrataLocators.schduledemo);

    }
}
