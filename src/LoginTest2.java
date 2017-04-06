
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginTest2 {

    public WebDriver driver;
    public String baseUrl = "http://rutor.info/";

    @Test
    public void main() {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl + "/");
        driver.findElement(By.cssSelector("img[alt=\"login\"]")).click();
        driver.findElement(By.name("nick")).clear();
        driver.findElement(By.name("nick")).sendKeys("andrewuzh");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("andrewuzh");
        driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();

        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        driver.close();

        for (String winHandleBefore : driver.getWindowHandles()) {
            driver.switchTo().window(winHandleBefore);
        }
        driver.close();
    }
}
