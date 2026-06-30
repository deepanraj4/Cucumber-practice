package PageObjects;
import org.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageobjects extends BaseClass {

    public LoginPageobjects(WebDriver driver) {
        this.driver = driver;
        if (driver == null) {
            System.out.println("WARNING: driver is null during PageObject initialization");
        } else {
            System.out.println("Driver initialized successfully, initializing page elements");
        }

        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//*[@id=\"ctl00_cphMainContent_txtUserName\"]")
    public WebElement USERNAME_FIELD;

    @FindBy(xpath = "//*[@id=\"ctl00_cphMainContent_txtPassword\"]")
    public WebElement PASSWORD_FIELD;

    @FindBy(xpath = "//*[@id=\"ctl00_cphMainContent_btnLogin\"]")
    public WebElement LOGIN_BUTTON;


}


