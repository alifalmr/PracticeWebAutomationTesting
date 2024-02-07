package starter.kompascom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogInPage {
    public static WebDriver driver;
    public WebDriverWait wait;

    public LogInPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        LogInPage.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy(xpath = "//i[@id='sso__icon__login_top']/parent::*")
    private WebElement logInIcon;
    public void getLogInLink(){
        wait.until(ExpectedConditions.elementToBeClickable(logInIcon));
        logInIcon.click();
    }

    @FindBy(xpath = "//span[contains(.,'Login')]")
    private WebElement logInPageLink;
    public void goToLogInPage(){
        wait.until(ExpectedConditions.elementToBeClickable(logInPageLink));
        logInPageLink.click();
    }

    @FindBy(xpath = "//h1[@class='title']")
    private WebElement pageTitle;
    public String getTitle(){
        return pageTitle.getText();
    }

    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailField;
    public void inputEmail(String email) {
        emailField.sendKeys(email);
    }

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passField;
    public void inputPass(String pwd) {
        passField.sendKeys(pwd);
    }
    public String getInputType() {
        return passField.getAttribute("type");
    }

    @FindBy(xpath = "//button[@class='form-view icon-view js-view']")
    private WebElement viewPassBtn;
    public void clickviewPass() {
        viewPassBtn.click();
    }

    @FindBy(xpath = "//input[@value='Login']")
    private WebElement logInButton;
    public void clickLogIn() {
        logInButton.click();
    }

    @FindBy(xpath = "//div[@class='form-error text-center']")
    private WebElement errorLogInMessage;
    public String getErrorLogInMessage() {
        return errorLogInMessage.getText();
    }

    @FindBy(xpath = "//a[.='Daftar KG Media ID?']")
    private WebElement signUpBtn;
    public void clickSignUp() {
        signUpBtn.click();
    }

    @FindBy(xpath = "//div[@id='container1']//h1[@class='title']")
    private WebElement signUpPage;
    public String getTitleSignUpPage() {
        return signUpPage.getText();
    }

    @FindBy(xpath = "//a[.='lupa password?']")
    private WebElement forgotPass;
    public void clickForgotPass(){
        forgotPass.click();
    }

    @FindBy(xpath = "//span[@class='icon icon-back']/parent::*")
    private WebElement backButton;
    public void clickGoBackButton() {
        backButton.click();
    }

    @FindBy(xpath = "//h1[@class='title']")
    private WebElement forgotPassTitlePage;
    public String getForgotPassTitlePage() {
        return forgotPassTitlePage.getText();
    }

    @FindBy(xpath = "//div[@class='hlSubtitle']")
    private WebElement homePageTitle;
    public String getHomeTitle(){
        return homePageTitle.getText();
    }

}
