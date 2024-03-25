package Assignments;

import engine.PropertiesReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class StepDefinitions {
    private WebDriver driver;

    @Given("user goes to the {string}")
    public void userGoesToPage(String pageurl) {
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver();
        String path = "C:/Users/Admin/TestProjectCucumber/hellocucumber/src/main/resources/configuration.properties";
        PropertiesReader.readPropertyFile(path);
        driver.navigate().to(PropertiesReader.props.getProperty(pageurl));
    }

    @Then("user waits for {int} seconds")
    public void userWaitsForSeconds(int second) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @And("verifies that the page title contains the word {string}")
    public void verifiesThatThePageTitleContainsTheWord(String arg0) {
        String actualTitle = driver.getTitle();
        Assertions.assertTrue(actualTitle.contains(arg0));
    }

    @And("closes the page")
    public void closesThePage() {
        driver.quit();
    }
}
