import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Autotest1 {
    private WebDriver driver;
    @Before
    public void preparationForTest (){
        System.out.println("0. подключаем хром драйвер");
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        System.out.println("1. создаем хром драйвер");
        driver = new ChromeDriver();
        System.out.println("2. открываем тестовую страницу");
        driver.get ("http://it-ebooks.info");

    }
    @Test
    public void testBooksSearch() throws InterruptedException {
        driver.findElement(By.id("q"));
        driver.findElement(By.id("q")).clear();
        System.out.println("3. передаем поисковый параметр");
        driver.findElement(By.id("q")).sendKeys("Ruby On Rails");
        Thread.sleep(2000);
        System.out.println("4. нажимаем энтер");
        driver.findElement(By.id("q")).sendKeys(Keys.RETURN);
        Thread.sleep(3000);
        Assert.assertNotNull(driver.findElement(By.className("gsc-result-info-container")));
        System.out.println("5. вывод результатов поиска");

    }
    @Test
    public void testSortbyDate() throws InterruptedException {

        System.out.println(driver.getTitle());
        driver.findElement(By.id("q"));
        driver.findElement(By.id("q")).clear();
        driver.findElement(By.id("q")).sendKeys("Ruby");
        Thread.sleep(2000);
        driver.findElement(By.id("q")).sendKeys(Keys.RETURN);
        Thread.sleep(3000);
        driver.findElement(By.className("gsc-selected-option")).click();
        Thread.sleep(2000);
        driver.findElement(By.className("gsc-option-menu")).click();
        Thread.sleep(2000);
        Assert.assertNotNull(driver.findElement(By.className("gsc-result-info")));
    }
    @After
    public void afterTest() {
        driver.quit();
    }

}


