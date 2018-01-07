package controller.jsf;

import java.util.List;

import javax.ejb.EJB;

import controller.GallerySB;
import model.Profile;

public class MainScreenController {
	@EJB
	private GallerySB gallery;
	
	public List<Profile> getTopTen(){
		return gallery.getTopTen();
	}

	
}
