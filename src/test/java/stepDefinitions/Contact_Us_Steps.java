package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class Contact_Us_Steps {
    private WebDriver driver;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "/src/main/java/drivers/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    public String generateRandomNumber(int length){
        return RandomStringUtils.randomNumeric(length);
    }

    public String generateRandomString(int length){
        return RandomStringUtils.randomAlphabetic(length);
    }

    @Given("I access the webdriver university contact us page")
    public void i_access_the_webdriver_university_contact_us_page() {
        driver.get("https://webdriveruniversity.com/Contact-Us/contactus.html");
    }
    @When("I enter a unique first name")
    public void i_enter_a_unique_first_name() {
        //driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("Farhana");
        driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("AutoFN" + generateRandomNumber(7));
    }
    @And("I enter a unique last name")
    public void i_enter_a_unique_last_name() {
        //driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys("Rahman");
        driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys("AutoLN" + generateRandomNumber(7));
    }
    @And("I enter a unique email address")
    public void i_enter_a_unique_email_address() {
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("AutoEmail" + generateRandomNumber(12) + "@mail.com");
    }
    @And("I enter a unique comment")
    public void i_enter_a_unique_comment() {
        driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys("Hello world " + generateRandomString(20));
    }
    @And("I click on submit button")
    public void i_click_on_submit_button() {
        driver.findElement(By.xpath("//input[@value='SUBMIT']")).click();
    }
    @Then("I should be presented with a successful contact us submission message")
    public void i_should_be_presented_with_a_successful_contact_us_submission_message() {
        //System.out.println("Test7");
        WebElement contactUs_Submission_Message = driver.findElement(By.xpath("//div[@id='contact_reply']/h1"));
        Assert.assertEquals(contactUs_Submission_Message.getText(),"Thank You for your Message!");
    }
}
