import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.io.IOException;
import java.time.Duration;

/*
Escaltion tickets
 */
public class Ticket_Escalation {

    WebDriverWait wait;


    @Test
    public void homePageLogin() throws InterruptedException, IOException {

        ChromeOptions options = new ChromeOptions();
        // Add the --disable-notifications argument
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://test.salesforce.com/");
        System.out.println("Page Title: " + driver.getTitle());
        driver.manage().window().maximize();
        //Login Page
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement elementUser = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@id='username']")
        ));
        elementUser.sendKeys("apptronik@logicrain.com.lrtdev");
        WebElement elementPwd = driver.findElement(By.xpath("//input[@id='password']"));
        elementPwd.sendKeys("Logicrain@2020");
        WebElement login = driver.findElement(By.id("Login"));
        login.click();


        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement record = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//a[@title='Cases']")
        ));
        record.click();


// Search In Progress Cases
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement inProgress = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@name='Case-search-input' and @aria-label='Search this list...']")));

        inProgress.click();
        inProgress.sendKeys("In Progress", Keys.ENTER);


        //click on the hyperlink

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement recordClick = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//a[@href='/lightning/r/500D1000008oPruIAE/view' and @title='00001111']")

        ));
        recordClick.click();

        //Escalate Button
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement escalateButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//button[normalize-space()='Escalate']")
        ));
        escalateButton.click();

        // Radio Button
        Thread.sleep(Duration.ofMillis(3000));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement radioButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[@part='formatted-rich-text'][normalize-space()='Engineering Team']")
        ));
        radioButton.click();

        //clickNextButton
        Thread.sleep(Duration.ofMillis(3000));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement nextButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//button[normalize-space()='Next']")
        ));
        nextButton.click();

        //Escalation Dropdown
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//select[@name='Escalation_Reason']")
        ));

        Select escalationReason = new Select(dropdown);
        escalationReason.selectByVisibleText("Software Bug / System Crash");

        //Escalation Details
        WebElement textarea = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//textarea[@part='textarea']")
        ));
        textarea.click();
        textarea.sendKeys("Test message");



        WebElement goToUpload = driver.findElement(By.xpath("//span[@class='slds-file-selector__text slds-medium-show' and text()='Or drop files']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", goToUpload);
        Thread.sleep(3000);
        goToUpload.click();




    /*

        // snippet to select RCA
        Thread.sleep(3000);
        WebElement rootCause = driver.findElement(By.xpath("//label[normalize-space()='Root Cause Analysis State']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", rootCause);
        Thread.sleep(3000);
        rootCause.click();

       *//* WebElement rcaReason = driver.findElement(By.xpath("//button[@aria-label='Root Cause Analysis State' and @data-value='--None--']"));
        rcaReason.click();*//*



       *//* WebElement goToUpload = driver.findElement(By.xpath("//span[@class='slds-file-selector__text slds-medium-show' and text()='Or drop files']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", goToUpload);
        Thread.sleep(3000);
        goToUpload.click();
*//*






       *//* //click on Submit
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement submitButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//button[normalize-space()='Submit']")
        ));
        submitButton.click();*/

    }
}

