package br.gov.inmetrics.bdd.funcionalidades;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import junit.framework.TestCase;

//import ftor_testng.TestUtils;
//import ftor_testng.ReportLog;

public class InserirContasSteps extends TestCase {

	WebDriver driver;

	String result;

	@Dado("^Acessar site Inmetrics$")
	public void acessar_site_Inmetrics() throws Throwable {

		// Chrome Driver

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\wellp\\Documents\\chromedriver.exe");

		// abrir o navegador
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Acessar a pagina dos correios

		driver.get("https://www.inmetrics.com.br/");

	}

	@Dado("^Acessar o menu carreiras$")
	public void acessar_o_menu_carreiras() throws Throwable {

		
		WebElement linkcarreiras = driver.findElement(By.xpath("//*[@id=\"linkcarreiras\"]"));
		linkcarreiras.click();
		//Thread.sleep(2000);
		clicarElemento(By.linkText("confira nossas vagas"),"vagas");

	}
	
	

	
		
		


		//driver.findElement(By.className("btn")).click();
		
//		WebElement vaga = driver.findElement(By.xpath(".//*[normalize-space(text()) and normalize-space(.)='Carreiras'])[2]/following::a[1]"));
//		vaga.click();
		
//		WebElement vaga = driver.findElement(By.xpath(".//*[normalize-space(text()) and normalize-space(.)='Certificações'])[1]/preceding::a[1]"));
//		vaga.click();
		
//		WebElement buscarvagas = driver.findElement(By.className("btn"));
//		buscarvagas.click();
		
//		WebElement buscarvagas = driver.findElement(By.cssSelector("#carreiras > div > div > a"));
//		buscarvagas.click();
		
		//driver.findElement(By.linkText("confira nossas vagas")).click();
		
		//WebElement buscarvagas =  driver.findElement(By.linkText("confira nossas vagas"));
		//buscarvagas.click();
		//#carreiras > div > div > a
		//div[@id='carreiras']/div/div/a
		
		//driver.findElement(By.xpath("xpath=//a[contains(text(),'confira nossas vagas')]")).click();

//	WebElement d = driver.findElement(By.cssSelector("css=.col-md-6 > .btn"));
//	d.click();
	
//	driver.findElement(By.xpath("//section[8]/div/div/div/a")).click();
		//driver.findElement(By.cssSelector("#carreiras > div > div > a"));
		
//		WebElement d = driver.findElement(By.xpath("//a[@href = 'https://inmetrics.gupy.io' and (text() = 'confira nossas vagas' or . = 'confira nossas vagas')]"));
//	 d.click();
	 
	 //driver.findElement(By.xpath("//section[8]/div/div/div/a")).click();;
		
		
	

	@Entao("^o sitema exibe a mensagem das vagas encontradas$")
	public void o_sitema_exibe_a_mensagem_das_vagas_encontradas() throws Throwable {

		// Grava na variável result a mensagem de retorno
		result = driver.findElement(By.xpath("//*[@id=\"menu-jobs\"]"))
				.getAttribute("innerHTML");

		// compara com a mensagem esperada com a encontrada
		assertEquals("Vagas", result);

	}
	
	public void clicarElemento(By by, String nomeElemento) throws Exception {
		try {
			aguardarPorElemento(by);
			driver.findElement(by).click();
			//logSucesso("Clica no elemento " + nomeElemento);
		} catch (Exception e) {
			System.out.println("Não foi possível clicar no elemento " + by);
		}
	}
	
	
	public void aguardarPorElemento(By by) throws Exception {
		long tempoEspera = 30;
		try {
			WebDriverWait wait = new WebDriverWait(driver, tempoEspera);
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		} catch (Exception e) {
			System.out.println("Timeout por aguardar pela presença do elemento " + by + " por " + tempoEspera + " segundos");
		}
	}
}
