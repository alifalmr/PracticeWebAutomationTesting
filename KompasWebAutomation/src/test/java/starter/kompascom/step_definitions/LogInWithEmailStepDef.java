package starter.kompascom.step_definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import starter.Hooks;
import starter.kompascom.LogInPage;

import java.awt.*;
import java.awt.event.KeyEvent;

public class LogInWithEmailStepDef {
    private WebDriver webDriver;
    public LogInWithEmailStepDef(){
        super();
        this.webDriver = Hooks.webDriver;
    }

//    LogInPage logInPage = new LogInPage(webDriver);

    @Given("User navigates to the log in page")
    public void verifyPage(){
        LogInPage logInPage = new LogInPage(webDriver);
        logInPage.getLogInLink();
        logInPage.goToLogInPage();
        Assert.assertEquals("KG Media ID",logInPage.getTitle());
    }

    @When("User log in with \"(.*)\" as an email and \"(.*)\" as a password")
    public void inputCredential(String email, String password) {
        LogInPage logInPage = new LogInPage(webDriver);
        logInPage.inputEmail(email);
        logInPage.inputPass(password);
        logInPage.clickLogIn();
    }

    @When("User clicks view password button")
    public void clickViewButton() {
        LogInPage logInPage = new LogInPage(webDriver);
        logInPage.clickviewPass();
    }

    @When("User clicks sign up button")
    public void clickSignUpButton() {
        LogInPage logInPage = new LogInPage(webDriver);
        logInPage.clickSignUp();
        System.out.println("here1");
    }

    @When("User clicks lupa password button")
    public void clickForgotPassword() {
        LogInPage logInPage = new LogInPage(webDriver);
        logInPage.clickForgotPass();
    }

    @When("User clicks go back button")
    public void goBackButton() {
        LogInPage logInPage = new LogInPage(webDriver);
        logInPage.clickGoBackButton();
    }

    @When("User input \"(.*)\" as a keyword submit it to search")
    public void searchKeyword(String keyword) throws AWTException {
        LogInPage logInPage = new LogInPage(webDriver);
        logInPage.inputKeyword(keyword);
        logInPage.typeEnter();
    }

    @When("User go to the second search result")
    public void goSecondResult() {
        LogInPage logInPage = new LogInPage(webDriver);
        logInPage.clickSecondResult();
    }

    @Then("User should be directed to home page")
    public void verifyProfilePage() throws InterruptedException {
        Thread.sleep(10000);
        LogInPage logInPage = new LogInPage(webDriver);
        Assert.assertEquals("Headline",logInPage.getHomeTitle());
    }

    @Then("User should get an error message")
    public void verifyLogInErrorMessage() {
        LogInPage logInPage = new LogInPage(webDriver);
        Assert.assertEquals("KG Media ID atau password yang kamu masukkan salah",logInPage.getErrorLogInMessage());
    }

    @Then("User should see the password")
    public void verifyViewPassword() {
        LogInPage logInPage = new LogInPage(webDriver);
        Assert.assertEquals("text",logInPage.getInputType());
    }

    @Then("User should be directed to the sign up page")
    public void verifySignUpPage() {
        LogInPage logInPage = new LogInPage(webDriver);
        Assert.assertEquals("Daftar KG Media ID", logInPage.getTitleSignUpPage());
    }

    @Then("User should be directed to forgot password page")
    public void verifyForgotPassPage() {
        LogInPage logInPage = new LogInPage(webDriver);
        Assert.assertEquals("Lupa Password",logInPage.getForgotPassTitlePage());
    }

    @Then("User should be directed to search result")
    public void verifySearchPage() {
        LogInPage logInPage = new LogInPage(webDriver);
        Assert.assertTrue(logInPage.getSearchPageTitle());
    }

    @Then("User should be on the news page")
    public void verifyNewsPage() {
        LogInPage logInPage = new LogInPage(webDriver);
        Assert.assertTrue(logInPage.checkArticleTitle());
    }

}
