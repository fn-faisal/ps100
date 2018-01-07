package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the comment database table.
 * 
 */
@Entity
@NamedQuery(name="Comment.findAll", query="SELECT c FROM Comment c")
public class Comment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int dislikes;

	private int likes;

	private String msg;

	private String timetag;

	//bi-directional many-to-one association to Comment
	@ManyToOne
	@JoinColumn(name="reply_to")
	private Comment comment;

	//bi-directional many-to-one association to Comment
	@OneToMany(mappedBy="comment")
	private List<Comment> comments;

	//bi-directional many-to-one association to Gallery
	@ManyToOne
	private Gallery gallery;

	//bi-directional many-to-one association to Profile
	@ManyToOne
	private Profile profile;

	public Comment() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getMsg() {
		return this.msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getTimetag() {
		return this.timetag;
	}

	public void setTimetag(String timetag) {
		this.timetag = timetag;
	}

	public Comment getComment() {
		return this.comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public List<Comment> getComments() {
		return this.comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Comment addComment(Comment comment) {
		getComments().add(comment);
		comment.setComment(this);

		return comment;
	}

	public Comment removeComment(Comment comment) {
		getComments().remove(comment);
		comment.setComment(null);

		return comment;
	}

	public Gallery getGallery() {
		return this.gallery;
	}

	public void setGallery(Gallery gallery) {
		this.gallery = gallery;
	}

	public Profile getProfile() {
		return this.profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

}