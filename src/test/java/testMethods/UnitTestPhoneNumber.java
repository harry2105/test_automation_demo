package testMethods;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UnitTestPhoneNumber {
	
	@Test
	public void TC1_ValidTenDigits(){
		String phoneNumber="8088246521";
		String actualNumber=PhoneNumberString.convertPhoneNumber(phoneNumber);
		Assert.assertEquals(actualNumber, "808-824-6521");
	}
	
	@Test
	public void TC2_phoneNumebrWith10Characters(){
		String phoneNumber="abcdabcdef";
		String actualNumber=PhoneNumberString.convertPhoneNumber(phoneNumber);
		Assert.assertEquals(actualNumber, "phone number should be 10 didgit only");
	}
	
	@Test
	public void TC3_phoneNumebrWithMixCharactersandNumber(){
		String phoneNumber="0a1b2c3d4f";
		String actualNumber=PhoneNumberString.convertPhoneNumber(phoneNumber);
		Assert.assertEquals(actualNumber, "phone number should be 10 didgit only");
	}
	
	@Test
	public void TC4_phoneNumebrWithMoreThan10Digit(){
		String phoneNumber="80882465211";
		String actualNumber=PhoneNumberString.convertPhoneNumber(phoneNumber);
		Assert.assertEquals(actualNumber, "phone number should be 10 didgit only");
	}
	
	@Test
	public void TC5_phoneNumebrWithLessThan10Digit(){
		String phoneNumber="808824652";
		String actualNumber=PhoneNumberString.convertPhoneNumber(phoneNumber);
		Assert.assertEquals(actualNumber, "phone number should be 10 didgit only");
	}

}
