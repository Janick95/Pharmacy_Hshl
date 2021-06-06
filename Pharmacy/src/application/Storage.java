package application;

public class Storage {
	private static String Gender;
	private static String SurName;
	private static String Name;
	private static String Email;
	private static String password;
	
	
	
	
	public static String getGender() {
		return Gender;
	}
	public static void setGender(String gender) {
		Gender = gender;
	}
	public static String getSurName() {
		return SurName;
	}
	public static void setSurName(String surName) {
		SurName = surName;
	}
	public static String getName() {
		return Name;
	}
	public static void setName(String name) {
		Name = name;
	}
	public static String getEmail() {
		return Email;
	}
	public static void setEmail(String email) {
		Email = email;
	}
	public static String getPassword() {
		return password;
	}
	public static void setPassword(String password) {
		Storage.password = password;
	}

	
	
}
