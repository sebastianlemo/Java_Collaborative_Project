package org.eu.flam.bivi.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "genres")
@Getter
@Setter
@NoArgsConstructor
public class Genre extends BaseModel {

	@NotNull
	@NotEmpty
	private String description;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name = "genres_books", 
		joinColumns = @JoinColumn(name = "genre_id"), 
		inverseJoinColumns = @JoinColumn(name = "book_id")
	)	 
	private List<Book> books;
}