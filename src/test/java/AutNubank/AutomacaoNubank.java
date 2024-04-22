package AutNubank;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class AutomacaoNubank {

	WebDriver driver;

	@BeforeEach
	void setUp() throws Exception {

		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("https://nubank.com.br/");
		driver. manage().window().maximize();
		driver.findElement(By.name("cpf")).sendKeys("144.699.577-12");
		driver.findElement(By.id("test")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("name")).sendKeys("Joaquim Calebe Silveira");
		Thread.sleep(2000);
		driver.findElement(By.name("phone")).sendKeys("81986970446");
		Thread.sleep(2000);
		driver.findElement(By.name("email")).sendKeys("joaquim_calebe_silveira@tursi.com.br");
		Thread.sleep(2000);
		driver.findElement(By.name("emailConfirmation")).sendKeys("joaquim_calebe_silveira@tursi.com.br");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[normalize-space()='Aceito receber comunicações do Nubank por WhatsApp.']")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#label-accepted > span.sc-bYWUiG.gaLLqc > svg")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#complete-form-drawer > div > div > div.sc-kxtUkE.jKEmYc > form > div > div.sc-dsKijY.dTZaxR > div > button")).click();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
	String texto;
	
	texto = driver.findElement(By.xpath("//*[@id=\"short-form\"]/h3")).getText();
	assertEquals("Peça sua conta e cartão de crédito do Nubank", texto);
		
	
	}

}
