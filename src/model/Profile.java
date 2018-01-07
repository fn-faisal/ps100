package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the profile database table.
 * 
 */
@Entity
@NamedQuery(name="Profile.findAll", query="SELECT p FROM Profile p")
public class Profile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="about_self")
	private String aboutSelf;

	private int age;

	private String education;

	private String email;

	private String jobstatus;

	private String password;

	private String ppic;

	private float rating;

	private String sex;

	private int spectators;

	@Column(name="user_name")
	private String userName;

	//bi-directional many-to-one association to Comment
	@OneToMany(mappedBy="profile")
	private List<Comment> comments;

	//bi-directional many-to-one association to Gallery
	@OneToMany(mappedBy="profile")
	private List<Gallery> galleries;

	public Profile() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAboutSelf() {
		return this.aboutSelf;
	}

	public void setAboutSelf(String aboutSelf) {
		this.aboutSelf = aboutSelf;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEducation() {
		return this.education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getJobstatus() {
		return this.jobstatus;
	}

	public void setJobstatus(String jobstatus) {
		this.jobstatus = jobstatus;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPpic() {
		return this.ppic;
	}

	public void setPpic(String ppic) {
		this.ppic = ppic;
	}

	public float getRating() {
		return this.rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getSpectators() {
		return this.spectators;
	}

	public void setSpectators(int spectators) {
		this.spectators = spectators;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<Comment> getComments() {
		return this.comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Comment addComment(Comment comment) {
		getComments().add(comment);
		comment.setProfile(this);

		return comment;
	}

	public Comment removeComment(Comment comment) {
		getComments().remove(comment);
		comment.setProfile(null);

		return comment;
	}

	public List<Gallery> getGalleries() {
		return this.galleries;
	}

	public void setGalleries(List<Gallery> galleries) {
		this.galleries = galleries;
	}

	public Gallery addGallery(Gallery gallery) {
		getGalleries().add(gallery);
		gallery.setProfile(this);

		return gallery;
	}

	public Gallery removeGallery(Gallery gallery) {
		getGalleries().remove(gallery);
		gallery.setProfile(null);

		return gallery;
	}

}