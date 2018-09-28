import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class WebTest {
    @Test
    public  void test() throws InterruptedException {
        WebDriver driver;
//        System.setProperty("webdriver.chrome.driver", "D://web_selenium_test//chromedriver.exe");
//        driver = new ChromeDriver();
        System.setProperty("webdriver.ie.driver", "D://web_selenium_test//IEDriverServer.exe");
        driver = new InternetExplorerDriver();
        WebDriverWait wait = new WebDriverWait(driver, 1);
//        new WebTest().picc_new(driver);
        new WebTest().picc(driver);
    }
    private void picc(WebDriver driver) throws InterruptedException {
        driver.get("http://10.10.40.13:7014/piccallweb/haofeng3g.html");
//        DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
//        ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
        // ��ȡ ��ҳ�� title
        System.out.println("The testing page title is: " + driver.getTitle());
        //�������
        Select areaCode = new Select(driver.findElement(By.name("AreaCode")));
        areaCode.selectByVisibleText("����");
        driver.findElement(By.name("button")).click();
        Thread.sleep(1000);


        //ѡ�г�����ҳ��
         driver.switchTo().frame(1);
       driver.switchTo().frame(0);
        driver.switchTo().frame(0);

        //�ȴ�ҳ��������
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("CarBrandModelName")));
        //¼�롰����Ʒ���ͺš�
        WebElement carBrandModelName = driver.findElement(By.id("CarBrandModelName"));
        carBrandModelName.clear();
        carBrandModelName.sendKeys("qq");
        //�������ѯ���͡�
        driver.findElement(By.name("QueryCarBtn")).click();
        //ѡ����
        Select carkind = new Select(driver.findElement(By.name("CarQuerySelectList")));
        carkind.selectByIndex(2);
        //¼�복��
        WebElement yej_licenseNo = driver.findElement(By.id("YEJ_LicenseNo"));
        yej_licenseNo.sendKeys("201805");
        //¼���������
        WebElement enrollDate = driver.findElement(By.id("EnrollDate"));
        enrollDate.sendKeys("201805");
        driver.quit();
    }

    public void picc_new(WebDriver driver){
        driver.get("http://10.10.40.11:8101/tmgsp/html/haofeng3g.html");
        // ��ȡ ��ҳ�� title
        System.out.println("The testing page title is: " + driver.getTitle());
        //�������
        driver.findElement(By.name("button")).click();
        //ѡ�г�����ҳ��
        driver.switchTo().frame(0);
        //¼�롰����Ʒ���ͺš�
        driver.findElement(By.xpath("//div/input[@id='carbrandmodelname']")).sendKeys("qq");
        //�������ѯ���͡�
        driver.findElement(By.id("select_car")).click();
        driver.quit();
    }

}
