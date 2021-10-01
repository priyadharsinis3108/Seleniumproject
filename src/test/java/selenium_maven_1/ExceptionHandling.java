package selenium_maven_1;

package com.picnic.selenium;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ExceptionHandling {

public static void main(String[] args) throws InterruptedException {

System.setProperty("webdriver.chrome.driver","C:\\\\Users\\\\geetanjalip\\\\eclipse-workspace-Learning-Selenium\\\\FirstSelenium\\\\Drivers\\\\chromedriver.exe");
WebDriver driver=new ChromeDriver();

//Launching the site.
driver.get("http://demo.guru99.com/popup.php");
driver.manage().window().maximize();
// Thread.sleep(3000);

try {
driver.findElement(By.ExceptionHandling("/html/body/p/a")).click();
}
catch(InvalidSelectorException e){
System.out.println("------------ExceptionHandling---------");

}

String MainWindow=driver.getWindowHandle();

// To handle all new opened window.
Set<String> s1=driver.getWindowHandles();
Iterator<String> i1=s1.iterator();

while(i1.hasNext())
{
String ChildWindow=i1.next();

if(!MainWindow.equalsIgnoreCase(ChildWindow))
{
Thread.sleep(3000);
// Switching to Child window
driver.switchTo().window(ChildWindow);
driver.findElement(By.name("emailid"))
.sendKeys("gaurav.3n@gmail.com");


driver.findElement(By.name("btnLogin")).click();

// Closing the Child Window.
driver.close();
}
}
// Switching to Parent window i.e Main Window.
driver.switchTo().window(MainWindow);
}
}
