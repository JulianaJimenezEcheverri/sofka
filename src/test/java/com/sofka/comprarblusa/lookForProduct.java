package com.sofka.comprarblusa;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**Author: Juliana Jim�nez
 * Feature: Buscar producto con usuario logueado

  Scenario:Buscar producto
    When Se ingresa el texto "Blouse" en el campo de texto "Search2
    And Se hace clic en la lupa
    Then El sistema debe permitir la b�squeda del producto ingresado 

  Scenario: A�adir producto al carrito de compras
    Given El usuario anteriormente registrado, se loguea en la p�gina
    And  El usuario hizo la b�squeda del producto "Blouse"
    And la p�gina arroja el resultado de la b�squeda del producto blouse
    When Se hace clic en e bot�n "Add to card"
    Then El producto es a�adido al carrito de compras
 * 
 * **/

public class lookForProduct {
	
	public static final String URL_MYSTORE = "http://automationpractice.com/index.php";
	public static final String EMAIL = "igjjimen@gmail.com";
	public static final String PASSWORD = "12345";
	public static final String TEXTSEARCH = "blouse";
	public static final int TIME_SLEEP = 2;
	public static final String RESULTADO = "El producto fu� agregado al carrito";
	private static String chrome = System.getProperty("user.dir") + "\\chromedriver.exe";
	
	
	public static   String searchRegisteredUser() throws InterruptedException {
		String resultado = RESULTADO;
		System.setProperty("webdriver.chrome.driver", chrome);// Se inicializa el chromeDriver como nuevo driver
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();// maximiza la ventana
		driver.get(URL_MYSTORE);// Ingresa a la p�gina de MyStore
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
		TimeUnit.SECONDS.sleep(TIME_SLEEP);
		//Se realiza autenticaci�n de usuario ya registrado
		driver.findElement(By.id("email")).sendKeys(EMAIL); //Se ingresa Email
		TimeUnit.SECONDS.sleep(TIME_SLEEP);
		driver.findElement(By.id("passwd")).sendKeys(PASSWORD); //Se ingresa el password
		driver.findElement(By.id("SubmitLogin")).click();//Se hace clic en el bot�n Sign In
		driver.findElement(By.id("search_query_top")).sendKeys(TEXTSEARCH); //Se ingresa el texto blouse 
    	driver.findElement(By.xpath("//*[@id=\"searchbox\"]/button")).click();
		driver.findElement(By.id("search")).click();//Se hace clic en el bot�n search
		//Se agrega el producto Blouse al carrito de compras
		driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li")).click();
		driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[1]/span")).click();
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a")).click();
		driver.findElement(By.xpath("//*[@id='button_order_cart']/span")).click();
		driver.findElement(By.id("cart_block_product_2_7_180369")).click();
		driver.findElement(By.id("button_order_cart")).click();
		return resultado;
	}
	public static void main(String[] args) throws InterruptedException {
		searchRegisteredUser();
	}

}





