import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GravarContatoParaVerity {
	
	private WebDriver driver;
	
	@Before
	public void inicia() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.verity.com.br");
	}
	
	
	@After
	public void fecha() {
		driver.quit();
	}
		
	
	@Test		
	public void preencherDados() throws InterruptedException {
		driver.findElement(By.id("comp-kevyodnk7label")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("comp-kex026e31input")).sendKeys("Ana");
		driver.findElement(By.id("comp-kex026ecinput")).sendKeys("Empresa Teste");
		driver.findElement(By.xpath("//*[@id=\"comp-kex026eeinput\"]")).sendKeys("teste@email.com");
		driver.findElement(By.xpath("//*[@id=\"comp-kex026eginput\"]")).sendKeys("(11)99999-9999");
		driver.findElement(By.id("comp-kex026eitextarea")).sendKeys("Esta é uma mensagem de teste.");
		driver.switchTo().frame(0);
		
		//NÃO GRAVA OS DADOS, DEVIDO A VALIDAÇÃO DO RECAPTCHA
		driver.findElement(By.xpath("//span[@id='recaptcha-anchor']/div")).click();
		driver.switchTo(). parentFrame();
		driver.findElement(By.id("comp-kex026eq2label")).click();	
	}

}

