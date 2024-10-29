package org.eu.flam.bivi.models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User extends BaseModel {

	@NotNull
	@NotEmpty
	@Size(min = 3, max = 18)
	private String firstName;

	@NotNull
	@NotEmpty
	@Size(min = 3, max = 18)
	private String lastName;

	@NotNull
	@NotEmpty
	@Email
	@Column(unique = true)
	private String email;

	@NotNull
	@NotEmpty
	@Size(min = 8, max = 100, message = "La contraseña debe tener entre 8 y 100 caracteres")
	private String password;

	@Transient
	private String passwordConfirmation;

	private String descriptionPerfil;

	@NotNull
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
		name = "users_roles",
		joinColumns = @JoinColumn(name = "user_id"), 
		inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Book> books;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name = "genre_likes", 
		joinColumns = @JoinColumn(name = "user_id"), 
		inverseJoinColumns = @JoinColumn(name = "genre_id")
	)	 
	private List<Genre> genreLikes;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name = "comments", 
		joinColumns = @JoinColumn(name = "user_id"), 
		inverseJoinColumns = @JoinColumn(name = "book_id")
	)	 
	private List<Book> commentBooks;

	public String fullName() {
		return firstName.concat(" ").concat(lastName);
	}

}