package pageObjects;

public class LoginHelioScreen {

	 public String txtEmail;
	 public String txtPassword;
	 public String btnLogin;
	
	 public String getTxtEmail() {
		 return txtEmail="//*[@id='edtEmail']";
	 }
	 public String getTxtPassword() {
		 return txtEmail="//*[@id='edtPassword']";
	 }
	 public String getBtnLogin() {

		 return btnLogin="//*[@id='btnLogin']";
		 
	 }
}
