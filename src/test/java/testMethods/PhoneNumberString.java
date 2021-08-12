package testMethods;

public class PhoneNumberString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 System.out.println(convertPhoneNumber("8011001000"));
		 System.out.println(convertPhoneNumber("80110010000"));
		 System.out.println(convertPhoneNumber("abcdefcf"));
	}
	
	public static String convertPhoneNumber(String phoneNumber){
		if(phoneNumber.length()==10 && phoneNumber.matches("\\d{10}")){
			return phoneNumber.substring(0, 3)+"-"+phoneNumber.substring(3,6)+"-"+phoneNumber.substring(6);			
		}else{
			return "phone number should be 10 didgit only";
		}
	}

}
