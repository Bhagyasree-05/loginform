@Test
public void validLoginTest() {
    WebDriver driver = new ChromeDriver();

    String projectPath = System.getProperty("user.dir");
    driver.get("file:///" + projectPath + "/login.html");

    driver.findElement(By.id("username")).sendKeys("admin");
    driver.findElement(By.id("password")).sendKeys("admin123");
    driver.findElement(By.tagName("button")).click();

    String actual = driver.findElement(By.id("message")).getText();
    Assert.assertEquals(actual, "Login Successful"); // PASS

    driver.quit();
}
