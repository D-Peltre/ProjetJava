package model;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//Cette classe a pour role de lire le fichier model.properties et de renvoyer l'url, le login et le password qui sont dedans 
class DBProperties extends Properties {

	private static final long serialVersionUID = 5289057445894568927L;

	/** The Constant PROPERTIES_FILE_NAME. */
	private final static String PROPERTIES_FILE_NAME = "model.properties";

	/** The url. */
	private String url = "";

	/** The login. */
	private String login = "";

	/** The password. */
	private String password = "";

	/**
	 * Instantiates a new DB properties.
	 */
	public DBProperties() {
		InputStream inputStream;
		// imputStream est un flux d'entree qui permet de lire des données, ici
		// dans le fichier model.properties
		inputStream = this.getClass().getClassLoader().getResourceAsStream(DBProperties.PROPERTIES_FILE_NAME);

		if (inputStream != null) {
			try {
				this.load(inputStream);
			} catch (final IOException e) {
				e.printStackTrace();
			}
			// Si on peut lire le fichier, on recupere l'url, le login et le
			// password
			this.setUrl(this.getProperty("url"));
			this.setLogin(this.getProperty("login"));
			this.setPassword(this.getProperty("password"));
		}
	}

	/**
	 * Gets the url.
	 *
	 * @return the url
	 */
	public String getUrl() {
		return this.url;
	}

	/**
	 * Sets the url.
	 *
	 * @param url
	 *            the new url
	 */
	private void setUrl(final String url) {
		this.url = url;
	}

	/**
	 * Gets the login.
	 *
	 * @return the login
	 */
	public String getLogin() {
		return this.login;
	}

	/**
	 * Sets the login.
	 *
	 * @param login
	 *            the new login
	 */
	private void setLogin(final String login) {
		this.login = login;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password
	 *            the new password
	 */
	private void setPassword(final String password) {
		this.password = password;
	}

}
