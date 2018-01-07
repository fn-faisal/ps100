package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the gallery database table.
 * 
 */
@Entity
@NamedQuery(name="Gallery.findAll", query="SELECT g FROM Gallery g")
public class Gallery implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String cat;

	private String discription;

	private int dislikes;

	private int likes;

	private String name;

	private float rating;

	private String tags;

	private String url;

	//bi-directional many-to-one association to Comment
	@OneToMany(mappedBy="gallery")
	private List<Comment> comments;

	//bi-directional many-to-one association to Profile
	@ManyToOne
	private Profile profile;

	public Gallery() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCat() {
		return this.cat;
	}

	public void setCat(String cat) {
		this.cat = cat;
	}

	public String getDiscription() {
		return this.discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public int getDislikes() {
		return this.dislikes;
	}

	public void setDislikes(int dislikes) {
		this.dislikes = dislikes;
	}

	public int getLikes() {
		return this.likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getRating() {
		return this.rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public String getTags() {
		return this.tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<Comment> getComments() {
		return this.comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Comment addComment(Comment comment) {
		getComments().add(comment);
		comment.setGallery(this);

		return comment;
	}

	public Comment removeComment(Comment comment) {
		getComments().remove(comment);
		comment.setGallery(null);

		return comment;
	}

	public Profile getProfile() {
		return this.profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

}