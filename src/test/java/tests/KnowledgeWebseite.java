package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.TestBase;

public class KnowledgeWebseite extends TestBase {
    Faker faker = new Faker();

    @BeforeMethod
    public void before() {

        driver.get("https://www.knowledgepark-ag.de/");


    }

    @Test
    public void kontakt() throws InterruptedException {
        WebElement kontaktButton = driver.findElement(By.xpath("//*[text()='Kontakt']"));
        kontaktButton.click();
        WebElement kontaktFormular = driver.findElement(By.xpath("(//*[text()='Kontaktformular'])[1]"));
        kontaktFormular.click();
        Thread.sleep(2000);
        WebElement nameButton = driver.findElement(By.xpath("(//*[@class='logininput'])[1]"));
        nameButton.sendKeys(faker.name().fullName());
        Thread.sleep(2000);
        WebElement firmaButton = driver.findElement(By.xpath("(//*[@class='logininput'])[2]"));
        firmaButton.sendKeys(faker.company().name());
        Thread.sleep(2000);
        WebElement strasseButton = driver.findElement(By.xpath("(//*[@class='logininput'])[3]"));
        strasseButton.sendKeys(faker.address().streetName());
        Thread.sleep(2000);
        WebElement plzButton = driver.findElement(By.xpath("(//*[@class='logininput'])[4]"));
        plzButton.sendKeys(faker.address().zipCode());
        Thread.sleep(2000);
        WebElement ortButton = driver.findElement(By.xpath("(//*[@class='logininput'])[5]"));
        ortButton.sendKeys(faker.address().city());
        Thread.sleep(2000);
        WebElement telefonButton = driver.findElement(By.xpath("(//*[@class='logininput'])[6]"));
        telefonButton.sendKeys(faker.phoneNumber().cellPhone());
        Thread.sleep(2000);
        WebElement emailButton = driver.findElement(By.xpath("(//*[@class='logininput'])[7]"));
        emailButton.sendKeys(faker.internet().emailAddress());
        Thread.sleep(2000);
        WebElement nachrrichtButton = driver.findElement(By.xpath("(//*[@class='messageinput'])[1]"));
        nachrrichtButton.sendKeys("calm down only a test for bewerbung:)please dont answer");
        Thread.sleep(2000);
        WebElement sendentButton = driver.findElement(By.xpath("(//*[@class='messagebutton'])[1]"));
        sendentButton.click();
        Thread.sleep(2000);

        WebElement messagegesendet=driver.findElement(By.xpath("//*[@class='message message-Information']"));
        Assert.assertTrue(messagegesendet.isDisplayed());

    }

    @Test
    public void loginTest() throws InterruptedException {
        Thread.sleep(2000);
        WebElement cookies = driver.findElement(By.xpath("//*[text()='Einverstanden']"));
        cookies.click();
        Thread.sleep(2000);
        WebElement loginbutton = driver.findElement(By.xpath("(//*[text()='Login'])[1]"));
        loginbutton.click();
        Thread.sleep(2000);
        WebElement usernamesbutton = driver.findElement(By.xpath("(//*[@class='logininput'])[1]"));
        usernamesbutton.sendKeys(faker.name().username());
        Thread.sleep(2000);
        WebElement passwordsbutton = driver.findElement(By.xpath("(//*[@class='logininput'])[2]"));
        passwordsbutton.sendKeys(faker.internet().password());
        Thread.sleep(2000);
        WebElement absendenButton = driver.findElement(By.xpath("//*[text()='Absenden']"));
        absendenButton.submit();
        Thread.sleep(2000);
        WebElement loginControl = driver.findElement(By.xpath("//*[text()='Login fehlgeschlagen!']"));
        Assert.assertTrue(loginControl.isDisplayed());
    }
    @Test
    public void passwordVergessenTest(){

    }
}
