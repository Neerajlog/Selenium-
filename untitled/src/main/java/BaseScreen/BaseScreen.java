package BaseScreen;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeoutException;

public class BaseScreen {

    public static WebDriver driver;
    public JavascriptException jsExce;
    public WebDriverWait jsWait;

    public BaseScreen(WebDriver driver){
        this.driver=driver;
    }

    public void  fluentwait(By locator){
        Wait<WebDriver> wait=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(100))
                .pollingEvery(Duration.ofMillis(2000)).ignoring(NoSuchFieldException.class)
                .ignoring(TimeoutException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waituntilJSReady(){
        jsWait=new WebDriverWait(driver,Duration.ofSeconds(40));
        jsExce=(JavascriptException) driver;
        ExpectedCondition<Boolean> jsLoad=driver-> ((JavascriptExecutor) this.driver)
                .executeScript("return document.readyState").toString().equals("complete");

        boolean jsready=((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
        if(!jsready){
            jsWait.until(jsLoad);
        }
    }

    public void waitForJqueryLoad(){
        jsWait=new WebDriverWait(driver,Duration.ofSeconds(40));
        jsExce=(JavascriptException) driver;
        ExpectedCondition<Boolean> jsQueryLoad=driver->((long) ((JavascriptExecutor) this.driver)
                .executeScript("return jQuery.active") == 0);

        boolean jqReady=(Boolean) ((JavascriptExecutor) driver).executeScript("return jQuery.active==0");
        if(!jqReady){
            jsWait.until(jsQueryLoad);
        }
    }

    public void fluentwaitAfterLoading(By locator){
        fluentwait(locator);
//        waituntilJSReady();
//        waituntilJSReady();

    }

    public void click(By loactor){
        driver.findElement(loactor).click();
    }
    public void clickNotvisible(By locator){
        WebElement element=driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();",element);
    }

    public void clearandEnterDetails(By loactor,String value){
        driver.findElement(loactor).clear();
        driver.findElement(loactor).sendKeys(value);
    }

    public void scrollToElement(By loactor){
        WebElement element=driver.findElement(loactor);
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()",element);
    }

    public void navigatieToanotherUrl(){
        String currentwindow=driver.getWindowHandle();

            Set<String> windowHandles = driver.getWindowHandles();

            String newWindow = null;
            for (String window : windowHandles) {
                newWindow = window;
            }
            driver.switchTo().window(newWindow);
    }

    public void waitonlyForfewSeconds(By locator){
        Wait<WebDriver> wait=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofMillis(800)).ignoring(NoSuchFieldException.class)
                .ignoring(TimeoutException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//        waituntilJSReady();
//        waitForJqueryLoad();
    }

    public boolean checkIfDisplay(By locator){
        try{
            waitonlyForfewSeconds(locator);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public List<WebElement> getAllElements(By loactor){
        List<WebElement> elements=driver.findElements(loactor);
        return elements;
    }

    public static void scrollUp(){
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-350)","");
    }

    public boolean isDisplayOnscreen(By locator){
        return driver.findElement(locator).isDisplayed();
    }



}
