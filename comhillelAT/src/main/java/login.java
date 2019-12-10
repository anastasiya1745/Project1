import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class login {
    private WebDriver driver;

    @Before
    public void preparationForTest(){
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://ru.duolingo.com/");
    }

    @Test
    public void testLogin() throws InterruptedException {
        System.out.println("1. Нажимаем 'Уже есть аккаунт' ");
        driver.findElement(By.xpath("/html//div[@id='root']//div[@class='_3nlUH']/span[1]/div/div[@class='_13-ro']//a[@href='javascript:;']")).click();
        Thread.sleep(2000);
        System.out.println("2. Ввводим данные");
        driver.findElement(By.xpath("/html/body/div[@class='ReactModalPortal']//div[@role='dialog']/form[@method='POST']//div[@class='_1fR85']/label[1]/div[@class='_2uEdv']/input")).sendKeys("testing_2020.hil@ukr.net");
        driver.findElement(By.xpath("/html/body/div[@class='ReactModalPortal']//div[@role='dialog']/form[@method='POST']//div[@class='_1fR85']/label[2]/div[@class='_2uEdv']/input") ).sendKeys("dywtr4ege5E");
        Thread.sleep(3000);
        System.out.println("3. Нажимаем войти ");
        driver.findElement(By.xpath("/html//div[@role='dialog']/form[@method='POST']//button[@type='submit']")).click();
        Thread.sleep(2000);


        Assert.assertNotNull(driver.findElements(By.className("/html//div[@id='root']/div/div[1]/div[2]/div[2]/div[@class='_3F_8q']//img[@src='//d35aaqx5ub95lt.cloudfront.net/images/icons/more-inactive.svg']"))); }

    @After
  public void afterTest (){
      driver.quit();
   }
}
