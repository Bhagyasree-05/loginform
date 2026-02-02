import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {

    @Test
    public void validLoginTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("file:///C:/selenium-login-demo/login.html");

        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("admin123");
        driver.findElement(By.tagName("button")).click();

        String actual = driver.findElement(By.id("message")).getText();
        Assert.assertEquals(actual, "Login Successful"); // ✅ Pass

        driver.quit();
    }

    @Test
    public void invalidLoginTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("file:///C:/selenium-login-demo/login.html");

        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("wrongpass");
        driver.findElement(By.tagName("button")).click();

        String actual = driver.findElement(By.id("message")).getText();
        Assert.assertEquals(actual, "Invalid Credentials"); // ❌ Fail (unintentional bug)

        driver.quit();
    }
}
