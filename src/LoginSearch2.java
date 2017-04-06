
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginSearch2 {

    public WebDriver driver;
    public String baseUrl = "http://rutor.info";
    public String login = "andrewuzh";
    public String pass = "andrewuzh";

    @Test
    public void main() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        login(driver, login, pass);

        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        driver.close();

        for (String winHandleBefore : driver.getWindowHandles()) {
            driver.switchTo().window(winHandleBefore);
        }

        Thread.sleep(3000);
        driver.findElement(By.id("in")).clear();
        driver.findElement(By.id("in")).sendKeys("java");
        driver.findElement(By.id("sub")).click();

        Thread.sleep(3000);
        driver.findElement(By.cssSelector("img[alt=\"logout\"]")).click();
        Thread.sleep(3000);

        login(driver, "bad", "bad");

        Thread.sleep(3000);
        driver.findElement(By.id("in")).clear();
        driver.findElement(By.id("in")).sendKeys("bad");
        driver.findElement(By.id("sub")).click();
        Thread.sleep(3000);

        login(driver, "", "");

        Thread.sleep(3000);
        driver.findElement(By.id("in")).clear();
        driver.findElement(By.id("in")).sendKeys("empty");
        driver.findElement(By.id("sub")).click();
        Thread.sleep(3000);
        driver.close();

    }
    public void login (WebDriver driver, String login, String pass) {
        driver.get(baseUrl + "/");
        driver.findElement(By.cssSelector("img[alt=\"login\"]")).click();
        driver.findElement(By.name("nick")).clear();
        driver.findElement(By.name("nick")).sendKeys(login);
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys(pass);
        driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();

    }

}
