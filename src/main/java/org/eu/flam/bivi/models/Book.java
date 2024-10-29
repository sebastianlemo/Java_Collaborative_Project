package org.eu.flam.bivi.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor
public class Book extends BaseModel {

	@NotNull
	@NotEmpty
	@Size(min = 2, max = 50, message = "El título debe tener entre 2 y 50 caracteres")
	private String title;

	@NotNull
	@NotEmpty
	@Size(min = 5, max = 100, message = "La descripción debe tener entre 5 y 100 caracteres")
	private String description;

	private Integer numberOfPages;

	private String imageUrl;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name = "genres_books", 
		joinColumns = @JoinColumn(name = "book_id"), 
		inverseJoinColumns = @JoinColumn(name = "genre_id")
	)	 
	private List<Genre> genres;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name = "comments", 
		joinColumns = @JoinColumn(name = "book_id"), 
		inverseJoinColumns = @JoinColumn(name = "user_id")
	)	 
	private List<User> commentUsers;

	@OneToMany(mappedBy = "book", fetch = FetchType.LAZY)
	private List<Comment> comments;

}