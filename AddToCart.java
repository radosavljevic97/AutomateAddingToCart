import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;

public class AddToCart {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

        String[] itemsNeeded = {"Cucumber", "Brocolli", "Beetroot", "Pumpkin"};
        int j = 0;

        Thread.sleep(3000);
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
        for(int i = 0; i < products.size(); i++){
            String[] name = products.get(i).getText().split("-");
            String formattedName = name[0].trim();
            // Konvertovanje array to ArrayList
            List itemsNeededList = Arrays.asList(itemsNeeded);

            if(itemsNeededList.contains(formattedName)){
                j++;
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                if(j == itemsNeeded.length){
                    break;
                }
            }
        }
    }
}
