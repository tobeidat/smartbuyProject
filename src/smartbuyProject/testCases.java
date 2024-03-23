package smartbuyProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testCases extends parameters {

	@BeforeTest
	public void setup() {
		driver.get("https://smartbuy-me.com/smartbuystore/en/");
		driver.manage().window().maximize();

	}

	@Test(priority = 1)
	public void signup() throws InterruptedException {

		driver.get("https://smartbuy-me.com/smartbuystore/en/login");

		WebElement Title = driver.findElement(By.cssSelector("button[title='Title']"));
		Title.click();

		WebElement ListOfTitles = driver.findElement(
				By.cssSelector("div[class='btn-group bootstrap-select form-control f16 open'] div[role='combobox'"));
		List<WebElement> allTitles = ListOfTitles.findElements(By.tagName("li"));

		allTitles.get(1).click();

		WebElement firstName = driver.findElement(By.name("firstName"));
		firstName.sendKeys(firstNames[index]);

		WebElement lastName = driver.findElement(By.name("lastName"));
		lastName.sendKeys(lastNames[index1]);

		WebElement gnder = driver
				.findElement(By.cssSelector("button[title='Gender'] span[class='filter-option pull-left']"));
		gnder.click();
		WebElement femal = driver.findElement(By.cssSelector(
				"div[class='col-md-5 col-sm-5 registerGender'] li:nth-child(3) a:nth-child(1) span:nth-child(1)"));
		femal.click();

		WebElement dateOfBirth = driver.findElement(By.id("dateOfBirth"));
		dateOfBirth.sendKeys("9/9/2009");//

		WebElement code = driver.findElement(By.cssSelector("button[title='Code']"));
		code.click();

		WebElement theCode = driver.findElement(By.cssSelector("li:nth-child(114) a:nth-child(1)"));
		theCode.click();

		WebElement mobileNumber = driver.findElement(By.id("mobileNumber"));
		mobileNumber.sendKeys("0799865432");

		WebElement emailAddress = driver.findElement(By.name("email"));
		emailAddress.sendKeys(emails);

		WebElement nationality = driver.findElement(By.cssSelector("button[title='Nationality']"));
		nationality.click();

		WebElement nationalityElement = driver
				.findElement(By.cssSelector("div[class='col-md-12 col-sm-12'] li:nth-child(24) a:nth-child(1)"));
		nationalityElement.click();

		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("absAbs123");

		WebElement confirmPassword = driver.findElement(By.id("register.checkPwd"));
		confirmPassword.sendKeys("absAbs123");//

		WebElement checkBox = driver.findElement(By.name("termsAndConditions"));
		checkBox.click();

		WebElement RegisterButton = driver
				.findElement(By.cssSelector("div[class='form-actions clearfix'] button[type='submit']"));
		RegisterButton.click();

	}

	@Test(priority = 2)
	public void login() throws InterruptedException {
		driver.get("https://smartbuy-me.com/smartbuystore/en/login");

		WebElement emailAddress = driver.findElement(By.id("j_username"));
		emailAddress.sendKeys(emails);

		WebElement loginPassword = driver.findElement(By.xpath("//div[@class='col-md-12']//input[@id='j_password']"));
		loginPassword.sendKeys("absAbs123");//

		WebElement loginButton = driver
				.findElement(By.cssSelector("div[class='btn-block gr2_back'] button[type='submit']"));
		loginButton.click();
		Thread.sleep(2000);

		WebElement SearchBar = driver.findElement(By.id("js-site-search-input"));

		SearchBar.sendKeys(search[randomIndex], Keys.ENTER);

		List<WebElement> allItems = driver.findElements(By.className("product-item-data"));
		allItems.get(1).click();

		WebElement addToCart = driver.findElement(By.id("addToCartButton"));
		addToCart.click();

		Thread.sleep(2000);

		driver.get("https://smartbuy-me.com/smartbuystore/en/cart");

		WebElement numOfItemsInCart = driver.findElement(By.className("nav-items-total"));
		String expectedNumberOfItemsInTheCart = "1";
		Assert.assertEquals(numOfItemsInCart.getText(), expectedNumberOfItemsInTheCart);

		WebElement itemPrice = driver.findElement(By.className("cart__top--amount"));

		WebElement totalPrice = driver
				.findElement(By.cssSelector(".col-xs-6.cart-totals-right.text-right.grand-total"));

		Assert.assertEquals(totalPrice.getText(), itemPrice.getText());
	}

	@AfterTest
	public void postTest() {
	}
}
