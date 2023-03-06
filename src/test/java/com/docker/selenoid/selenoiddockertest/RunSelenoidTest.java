package com.docker.selenoid.selenoiddockertest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.util.concurrent.Uninterruptibles;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RunSelenoidTest {
@Test
public void selenoidChromeTest() throws MalformedURLException {
	DesiredCapabilities cap = new DesiredCapabilities();
	cap.setBrowserName(BrowserType.CHROME);
	cap.setCapability("enableVNC", true);
	cap.setCapability("enableVideo", true);
	cap.setCapability("videoName", "testvideo1.mp4");
	WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
	driver.get("https://www.google.com");
	System.out.println(driver.getTitle());
	driver.findElement(By.name("q")).sendKeys("selenoidtest",Keys.ENTER);
	Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
	driver.quit();
}

@Test
public void selenoidFirefoxTest() throws MalformedURLException {
	DesiredCapabilities cap = new DesiredCapabilities();
	cap.setBrowserName(BrowserType.FIREFOX);
	cap.setCapability("enableVNC", true);
	cap.setCapability("enableVideo", true);
	cap.setCapability("videoName", "testvideo2.mp4");
	WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
	driver.get("https://www.google.com");
	System.out.println(driver.getTitle());
	driver.findElement(By.name("q")).sendKeys("selenoidtest",Keys.ENTER);
	Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
	driver.quit();
}

   
}
