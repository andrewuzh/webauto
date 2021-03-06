
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginSearch1 {

    public WebDriver driver;
    public String baseUrl = "http://epidemz.co";
    public String login = "andrewuzh";
    public String pass = "andrewuzh";

    @Test
    public void main() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        login(driver, login, pass);

        Thread.sleep(2000);
        driver.findElement(By.id("story")).clear();
        driver.findElement(By.id("story")).sendKeys("java");
        driver.findElement(By.cssSelector("input[type=\"image\"]")).click();

        Thread.sleep(2000);
        driver.findElement(By.linkText("Выход")).click();
        Thread.sleep(2000);

        login(driver, "bad", "bad");

        Thread.sleep(2000);
        driver.findElement(By.id("story")).clear();
        driver.findElement(By.id("story")).sendKeys("bad");
        driver.findElement(By.cssSelector("input[type=\"image\"]")).click();
        Thread.sleep(2000);

        login(driver, "", "");

        Thread.sleep(2000);
        driver.findElement(By.id("story")).clear();
        driver.findElement(By.id("story")).sendKeys("empty");
        driver.findElement(By.cssSelector("input[type=\"image\"]")).click();
        Thread.sleep(3000);
        driver.close();

    }
    public void login (WebDriver driver, String login, String pass) {
        driver.get(baseUrl + "/");
        driver.findElement(By.cssSelector("b")).click();
        driver.findElement(By.id("login_name")).clear();
        driver.findElement(By.id("login_name")).sendKeys(login);
        driver.findElement(By.id("login_password")).clear();
        driver.findElement(By.id("login_password")).sendKeys(pass);
        driver.findElement(By.cssSelector("button.fbutton")).click();

    }
}
