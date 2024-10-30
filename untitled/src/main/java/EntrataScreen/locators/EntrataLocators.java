package EntrataScreen.locators;

import org.openqa.selenium.By;

public class EntrataLocators {

    public By acceptCookie=By.cssSelector("#cookie-accept");
    public By schduledemo=By.xpath("//div[text()=\"Schedule Your Demo\"]");
    public By firstName=By.cssSelector("#FirstName");
    public By lastName=By.cssSelector("#LastName");
    public By Email=By.cssSelector("#Email");
    public By Company=By.cssSelector("#Company");
    public By Phone=By.cssSelector("#Phone");
    public By Unit_Count_c=By.cssSelector("#Unit_Count__c");
    public By Unit_Count_Value=By.xpath("//option[@value=\"1 - 10\"]");
    public By JobTitle=By.cssSelector("#Title");
    public By demoRequest=By.cssSelector("#demoRequest");
    public By demoRequest_value=By.xpath("//option[@value=\"a Resident\"]");

    public By regisyerNow=By.xpath("//div[text()=\"Register Now\"]");
    public By registerNowNavBar=By.xpath("//div[@class=\"bc-nav-item-text\"]");
    public By discoverAi=By.xpath("//div[text()=\"Discover More \"]");

    public By seeHowItwork=By.xpath("//div[text()=\"See How it Works\"]");
    public By schduleType=By.xpath("//button[text()=\"SCHEDULE DEMO\"]");





}
