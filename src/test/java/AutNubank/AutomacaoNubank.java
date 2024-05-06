package AutNubank;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class AutomacaoNubank {

	WebDriver driver;

	@BeforeEach
	void setUp() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");

		driver = new ChromeDriver();
		driver. manage().window().maximize();
		driver.get("https://www.4devs.com.br/gerador_de_pessoas");
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		driver.findElement(By.cssSelector("#bt_gerar_pessoa")).click();
		Thread.sleep(1000);
		String cpf = driver.findElement(By.id("cpf")).getText();
		System.out.println(cpf);
		Thread.sleep(1000);
		String nome = driver.findElement(By.id("nome")).getText();
		System.out.println(nome);
		Thread.sleep(1000);
		String celular = driver.findElement(By.id("celular")).getText();
		System.out.println(celular);
		Thread.sleep(1000);
		String email = driver.findElement(By.id("email")).getText();
		System.out.println(email);
		Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("window.open();");
		for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
		driver.get("https://nubank.com.br/");
		Thread.sleep(1000);
		driver.findElement(By.name("cpf")).sendKeys(cpf);
		driver.findElement(By.id("test")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("name")).sendKeys(nome);
		Thread.sleep(2000);
		driver.findElement(By.name("phone")).sendKeys(celular);
		Thread.sleep(2000);
		driver.findElement(By.name("email")).sendKeys(email);
		Thread.sleep(2000);
		driver.findElement(By.name("emailConfirmation")).sendKeys(email);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[normalize-space()='Aceito receber comunicações do Nubank por WhatsApp.']")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#label-accepted > span.sc-bYWUiG.gaLLqc > svg")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#complete-form-drawer > div > div > div.sc-kxtUkE.jKEmYc > form > div > div.sc-dsKijY.dTZaxR > div > button")).click();
		Thread.sleep(5000);
	
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
