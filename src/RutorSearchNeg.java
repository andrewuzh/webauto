
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class RutorSearchNeg {

    public WebDriver driver;
    public String baseUrl = "http://rutor.info/";

    @Test
    public void main() {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl + "/");
        driver.findElement(By.id("in")).clear();
        driver.findElement(By.id("in")).sendKeys("ja");
        driver.findElement(By.id("sub")).click();

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
