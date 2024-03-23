package smartbuyProject;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class parameters {
	WebDriver driver = new ChromeDriver();
	String[] firstNames = { "ahmad", "anas", "yaman", "majed" };
	String[] lastNames = { "hani", "malek", "saber", "abdallah" };
	Random rand = new Random();
	int index = rand.nextInt(firstNames.length);
	int index1 = rand.nextInt(lastNames.length);
	String emails = firstNames[index] + lastNames[index1] + rand.nextInt(9999) + "@gmail.com";
	String[] search = { "iphone", "samsung", "huwaei" };
	int randomIndex = rand.nextInt(search.length);

}
