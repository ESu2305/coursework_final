package com.sddevops.cwf_maven.eclipse;

public class User {
	
	protected String name;
	protected String password;
	protected String email;
	protected String language;
	
	/**
	 * @param name
	 * @param password
	 * @param email
	 * @param language
	 */
	
	public User(String name, String password, String email, String language) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		this.language = language;
	}

	/**
	 * @return the name
	 */

	public String getName() {
		return name;
	}

	/**
	 * @param the name to name
	 */

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the password
	 */

	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the email
	 */

	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */

	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the language
	 */

	public String getLanguage() {
		return language;
	}

	/**
	 * @param language the language to set
	 */

	public void setLangugae(String language) {
		this.language = language;
	}

}
