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

public class Login_Steps {
    private WebDriver driver;

    @Before ("@login")
    public void setup(){
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "/src/main/java/drivers/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }
    @After ("@login")
    public void tearDown(){
        driver.quit();
    }

    public String generateRandomNumber(int length){
        return RandomStringUtils.randomNumeric(length);
    }

    public String generateRandomString(int length){
        return RandomStringUtils.randomAlphabetic(length);
    }

    @Given("I access the webdriver university login page")
    public void i_access_the_webdriver_university_login_page() {
        driver.get("https://webdriveruniversity.com/Login-Portal/index.html");
    }

    @When("I enter a specific username {string}")
    public void i_enter_a_specific_username(String username) {
        driver.findElement(By.xpath("//input[@id='text']")).sendKeys(username);
    }

    @And("I enter a specific password {}")
    public void i_enter_a_specific_password(String password) {
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
    }

    @And("I click on Login button")
    public void i_click_on_login_button() {
        driver.findElement(By.xpath("//button[@id='login-button']")).click();
    }

    @Then("I should be presented with a successful login message")
    public void i_should_be_presented_with_a_successful_login_message() {
        String login_Successful_Message = driver.switchTo().alert().getText();
        Assert.assertEquals(login_Successful_Message,"validation succeeded");
    }

    @When("I enter a unique username")
    public void i_enter_a_unique_username() {
        driver.findElement(By.xpath("//input[@id='text']")).sendKeys("AutoUN" + generateRandomString(20));
    }
    @And("I enter a unique password")
    public void i_enter_a_unique_password() {
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("AutoPW" + generateRandomNumber(7));
    }

    @Then("I should be presented with an unsuccessful login message")
    public void i_should_be_presented_with_an_unsuccessful_login_message() {
        String login_UnSuccessful_Message = driver.switchTo().alert().getText();
        Assert.assertEquals(login_UnSuccessful_Message,"validation failed");
    }

}
