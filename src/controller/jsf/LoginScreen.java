package controller.jsf;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.servlet.http.HttpSession;

import controller.ProfileSB;

@ManagedBean
public class LoginScreen {

	private boolean isLoggedIn = false;
	
	@EJB
	private ProfileSB profile;
	
	public boolean loginWithEmail(String email, String password){
		boolean validate = profile.loginWithEmailAddress(email, password);
		if ( validate ){
			isLoggedIn = true;
		}
		return validate;
	}

	public boolean isLoggedIn() {
		return isLoggedIn;
	}

	public void setLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}
	
	
	
}
