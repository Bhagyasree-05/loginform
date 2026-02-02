import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {

    @Test
    public void validLoginTest() {
        WebDriver driver = new ChromeDriver();

        String path = System.getProperty("user.dir");
        driver.get("file:///" + path + "/login.html");

        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("admin123");
        driver.findElement(By.tagName("button")).click();

        String msg = driver.findElement(By.id("message")).getText();
        Assert.assertEquals(msg, "Login Successful"); // PASS

        driver.quit();
    }

    @Test
    public void invalidLoginTest() {
        WebDriver driver = new ChromeDriver();

        String path = System.getProperty("user.dir");
        driver.get("file:///" + path + "/login.html");

        driver.findElement(By.id("username")).sendKeys("wrong");
        driver.findElement(By.id("password")).sendKeys("wrong");
        driver.findElement(By.tagName("button")).click();

        String msg = driver.findElement(By.id("message")).getText();
        Assert.assertEquals(msg, "Invalid Credentials"); // ❌ FAIL

        driver.quit();
    }
}
