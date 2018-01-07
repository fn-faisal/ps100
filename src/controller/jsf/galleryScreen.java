package controller.jsf;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;

import controller.GallerySB;
import controller.ProfileSB;
import model.Gallery;
import model.Profile;

public class galleryScreen {

	@EJB
	private GallerySB gallerySB;
	
	@EJB
	private ProfileSB profileSB;
	
	/**
	 * 
	 * @return a list of gallaries
	 */
	public List<Gallery> getAllGalleryItems(){
		return gallerySB.getGalleriesOrderDesc();
	}
	
	/**
	 * 
	 * @param galId the id of the gallery for which you want the profile 
	 * @return the profile associated with the entered gallery
	 */
	public Profile getProfileForGalleryId(int galId){
		Gallery gallery = gallerySB.getGalleryById(galId);
		if(gallery == null) return null;
		return gallery.getProfile();
	}
	
	public boolean addLikesToGalleryItems(int galleryId){
		return gallerySB.addLikeGalleryItem(galleryId);
	}
	
}
