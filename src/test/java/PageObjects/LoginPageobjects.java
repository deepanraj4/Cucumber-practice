package PageObjects;
import org.base.BaseClass;
import org.openqa.selenium.By;
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



   public void Select_Client(String ClientName) {
        try {
            WebElement clientElement = driver.findElement(By.xpath("//div[@id='clientList']//h2[normalize-space()='" + ClientName + "']"));
            if (clientElement.isDisplayed()) {
                clientElement.click();
                System.out.println("Client selected successfully: " + ClientName);
            } else {
                System.out.println("Client not found in the list: " + ClientName);
            }
        } catch (Exception e) {
            System.out.println("Error selecting client: " + e.getMessage());
        }


   }
}


