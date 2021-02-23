package Selenium

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class Task1{
WebDriver driver;

      @Before
      public void setUp(){

      }
        /* #1 TestCase
        1) Navigate to "https://www.seleniumeasy.com/test/basic- first-form-demo.html"
        2) Validate the title is equals to "Selenium Easy Demo - Simple Form to Automate using Selenium"
        3) Enter message "First Test Case" on the single input field Click Show Message
        4) Validate the result is "Your Message: First Test Case
         */

@Test

public void test1() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
        assertEquals(driver.getTitle(), "Selenium Easy Demo - Simple Form to Automate using Selenium");

        Thread.sleep(2000);

        WebElement closeButton = driver.findElement(By.id("at-cv-lightbox-close"));
        closeButton.click();

        Thread.sleep(3000);

        WebElement message = driver.findElement(By.xpath("//input[@id='user-message']"));
        message.sendKeys("First Test Case");

        WebElement showMessageButton = driver.findElement(By.xpath("//button[@onclick='showInput();']"));
        showMessageButton.click();
        Thread.sleep(3000);
        WebElement button = driver.findElement(By.xpath("//div[@id='user-message']//child::span"));

        String result = button.getText();
        assertEquals("First Test Case", result);




        }

    /* #2 TestCase:
    Navigate to "https://www.seleniumeasy.com/test/basic- first-form-demo.html"
    Enter a - 12 on Two Input Fields
    Enter b - 17 on Two Input Fields
    Click Get Total button
    Validate the result is "Total a + b = 29"
     */

    @Test
    public void test2() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
        Thread.sleep(2000);
        WebElement closeButton = driver.findElement(By.id("at-cv-lightbox-close"));
        closeButton.click();

        WebElement inputField1 = driver.findElement(By.xpath("//input[@id='sum1']"));
        inputField1.sendKeys("12");
        WebElement inputField2 = driver.findElement(By.xpath("//input[@id='sum2']"));
        inputField2.sendKeys("17");

        WebElement totalButton = driver.findElement(By.xpath("//button[@onclick='return total()']"));
        totalButton.click();

        WebElement getResult = driver.findElement(By.xpath("//div[@style='height: 50px; width: 100%;']"));
        String result = getResult.getText();
        assertEquals("Total a + b = 29", result);




    }

    /*  #3 TestCase:
    Navigate to "https://www.seleniumeasy.com/test/basic- first-form-demo.html"
    Enter a - Chicago
    Enter b - Illinois
    Click Get Total button
    Validate the result is "Total a + b = NaN"
     */

    @Test
    public void test3() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();
        driver.navigate().to("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
        Thread.sleep(2000);
        driver.findElement(By.id("at-cv-lightbox-close")).click();
        Thread.sleep(2000);
        WebElement fieldA = driver.findElement(By.id("sum1"));
        fieldA.sendKeys("ChicagoEnter");
        WebElement fieldB = driver.findElement(By.id("sum2"));
        fieldB.sendKeys("IllinoisClick");
        WebElement totalButton = driver.findElement(By.xpath("//button[@onclick='return total()']"));
        totalButton.click();
    }



    /* TESTCASE #4
     Navigate to "https://www.seleniumeasy.com/test/basic-checkbox-demo.html"
     Click the checkbox on Single Checkbox Demo
     Validate the text "Success - Check box is checked" is displayed
     Click check box one more time Validate the message is not displayed

     */

    @Test

    public void testcase4() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        WebElement checkBox = driver.findElement(By.id("isAgeSelected"));
        checkBox.click();

        Assert.assertTrue(checkBox.isSelected());
        Thread.sleep(2000);

        WebElement txt = driver.findElement(By.id("'txtAge"));
        String result = txt.getText();
        assertEquals(result,"Success - Check box is checked");
      //  checkBox.click();







    }




    /*   #5 TestCase:
    Navigate to "https://www.seleniumeasy.com/test/basic- radiobutton-demo.html"
    Click on the Female radio button under Radio Button Demo Validate 'Female' is checked
    Validate 'Male' is not checked Validate the success message
     */
    @Test
    public void test5() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://www.seleniumeasy.com/test/basic-radiobutton-demo.html");
        WebElement femaleButton = driver.findElement(By.xpath("//*[@id='easycont']/div/div[2]/div[1]/div[2]/label[2]/input"));
        Assert.assertFalse(femaleButton.isSelected());
        femaleButton.click();
        WebElement maleButton = driver.findElement(By.xpath("//*[@id='easycont']/div/div[2]/div[1]/div[2]/label[1]/input"));
        Assert.assertFalse(maleButton.isSelected());
        WebElement submit = driver.findElement(By.xpath("//*[@id='buttoncheck']"));
        submit.click();
        WebElement message=driver.findElement(By.xpath("//p[@class='radiobutton']"));
        String getText=message.getText();

    }






      /*   #6 TestCase:
      Navigate to "https://www.seleniumeasy.com/test/basic- radiobutton-demo.html"
      Click on the Male radio button under Radio Button Demo Validate 'Male' is not checked
      Validate 'Female' is not checked Validate the success message
       */
    @Test
    public void test6() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.seleniumeasy.com/test/basic-radiobutton-demo.html");
        WebElement maleButton = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div[2]/label[1]/input"));
        maleButton.click();
        assertEquals(true, maleButton.isSelected());
        WebElement femaleButton = driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[1]/div[2]/label[2]/input"));
        Assert.assertFalse(femaleButton.isSelected());
        WebElement checkButton = driver.findElement(By.id("buttoncheck"));
        checkButton.click();
        WebElement message = driver.findElement(By.xpath("//p[@class='radiobutton']"));
        System.out.println(message.getText());


    }



    //Task 7
    /*
    Navigate to "https://www.seleniumeasy.com/test/basic- radiobutton-demo.html"
    Click on the Male radio button under Group Radio Buttons
    Demo Validate 'Male' is checked
    Validate 'Female' is not checked
    Select 15-50 "Age Group" under Group Radio Buttons Demo
    Validate the message after clicking on Get Values button
     */
    @Test
    public void test7() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.seleniumeasy.com/test/basic-radiobutton-demo.html");
        // Click on the Male radio button under Group Radio Buttons
        WebElement maleButton=driver.findElement(By.xpath("//input[@value='Male'][@name='gender']"));
        maleButton.click();
        Assert.assertTrue(maleButton.isSelected());
        // Validate 'Female' is not checked
        WebElement femaleButton= driver.findElement(By.xpath("//input[@value='Female'][@name='gender']"));
        Assert.assertFalse(femaleButton.isSelected());
        //  Select 15-50 "Age Group" under Group Radio Buttons Demo
        WebElement ageGroupButton = driver.findElement(By.xpath("//input[@value='5 - 15'][@name='ageGroup']"));
        ageGroupButton.click();
        //Validate the message after clicking on Get Values button
        WebElement getValues=driver.findElement(By.xpath("//button[@onclick='getValues();']"));
        getValues.click();
        WebElement resultText= driver.findElement(By.xpath("//p[@class='groupradiobutton']")); ////*[@class='groupradiobutton']
        String text=resultText.getText();
        System.out.println(text);
        assertEquals("Sex : Male \n " +
                " Age group: 5 - 15",text);

    }





    @Test
    public void test8() {
        /*
        Navigate to "http://blazedemo.com/purchase.php" Enter Name "David"
        Enter Address "2000 E devon Ave"
        Enter City "Chicago"
        Enter State "Illinois"
        Enter ZipCode "60606"
        Enter Credit Card Number "4566998734522988"
        Enter Month 09
        Enter Year 2024
        Enter Name on Card "David Trump"
        Click Remember me check box
        Click Purchase Flight Button
        Validate the current url is "http://blazedemo.com/confirmation.php"
        Validate title of page is "BlazeDemo Confirmation" Validate "Thank you for your purchase today!" is displayed
         */

        WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();

        driver.get("https://blazedemo.com/purchase.php");
        driver.findElement(By.id("inputName")).sendKeys("David");
        driver.findElement(By.id("address")).sendKeys("202 E devon Ave");
        driver.findElement(By.id("city")).sendKeys("Chicago");
        driver.findElement(By.xpath("//*[@id=\"state\"]")).sendKeys("Illinois");
        driver.findElement(By.xpath("//*[@for='state']/parent::div/following-sibling::div[1]/div/child::input")).sendKeys("60606");
        WebElement cardType = driver.findElement(By.xpath("//select[@id='cardType']"));
        Select select = new Select(cardType);
        select.selectByVisibleText("Visa");
        driver.findElement(By.xpath("//input[@id='creditCardNumber']")).sendKeys("4566998734522988");
        driver.findElement(By.xpath("//input[@id='creditCardMonth']")).sendKeys("09");
        driver.findElement(By.xpath("//input[@id='creditCardYear']")).sendKeys("2024");
        driver.findElement(By.xpath("//input[@id='nameOnCard']")).sendKeys("David Trump");
        WebElement rememberMeButton = driver.findElement(By.xpath("//input[@id='rememberMe']"));
        Assert.assertFalse(rememberMeButton.isSelected());
        rememberMeButton.click();
        Assert.assertTrue(rememberMeButton.isSelected());
        driver.findElement(By.xpath("//*[@value='Purchase Flight']")).click();
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://blazedemo.com/confirmation.php";
        assertEquals(expectedUrl, currentUrl);
        String currentTitle = driver.getTitle();
        String expectedTitle = "BlazeDemo Confirmation";
        assertEquals(currentTitle, expectedTitle);
        String h1 = driver.findElement(By.tagName("h1")).getText();
        String h1Expected = "Thank you for your purchase today!";
        assertEquals(h1Expected, h1);


    }


    /*
    #9 TestCase:
     Navigate to "https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html"
     Under Select List Demo select Monday by visible text Select Friday by index.
     Get all the options and validate the total number of the options.
     */

    @Test

    public void TestCase9() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");

        WebElement dropdown = driver.findElement(By.id("select-demo"));
        Select MondaydropdownHandler = new Select(dropdown);
        MondaydropdownHandler.selectByVisibleText("Monday");
        Thread.sleep(3000);

        WebElement firstSelectedOption = MondaydropdownHandler.getFirstSelectedOption();
        assertEquals("Monday",firstSelectedOption.getText());


        WebElement getAllDropOption = driver.findElement(By.id("select-demo"));
        Select allDropDownHandler = new Select(getAllDropOption);
        List<WebElement> allDrop = allDropDownHandler.getOptions();
        System.out.println(allDrop.size());

        for (WebElement option : allDrop){
            System.out.println(option.getText());
        }

    }




    @After
    public void tearDown(){

        driver.quit();
    }

}
