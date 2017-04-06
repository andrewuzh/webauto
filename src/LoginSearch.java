
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginSearch {

    public WebDriver driver;
    public String baseUrl = "http://epidemz.co";

    @Test
    public void main() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl + "/");
        driver.findElement(By.cssSelector("b")).click();
        driver.findElement(By.id("login_name")).clear();
        driver.findElement(By.id("login_name")).sendKeys("andrewuzh");
        driver.findElement(By.id("login_password")).clear();
        driver.findElement(By.id("login_password")).sendKeys("andrewuzh");
        driver.findElement(By.cssSelector("button.fbutton")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("story")).clear();
        driver.findElement(By.id("story")).sendKeys("java");
        driver.findElement(By.cssSelector("input[type=\"image\"]")).click();

    }
}
