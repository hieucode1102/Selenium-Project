package hieucode;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import hieucode.TestComponents.BaseTest;
import hieucode.pageobjects.CartPage;
import hieucode.pageobjects.CheckoutPage;
import hieucode.pageobjects.ConfirmationPage;
import hieucode.pageobjects.LandingPage;
import hieucode.pageobjects.ProductCatalogue;

public class ErrorValidations extends BaseTest {

	@Test
	public void submitOrder() throws IOException, InterruptedException
	{
		String productName = "ZARA COAT 3";
		ProductCatalogue productCatalogue = landingPage.loginApplication("anshika@gmail.com", "Iamking@000");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
		
		
	}

}
