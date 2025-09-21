package Getter_Setter;


public class Donor {
	static int did;
	static String name;
	static String contact;
	static String email;
	static String password;
	public static int getDid() {
		return did;
	}
	public static void setDid(int did) {
		Donor.did = did;
	}
	public static String getName() {
		return name;
	}
	public static void setName(String name) {
		Donor.name = name;
	}
	public static String getContact() {
		return contact;
	}
	public static void setContact(String contact) {
		Donor.contact = contact;
	}
	public static String getEmail() {
		return email;
	}
	public static void setEmail(String email) {
		Donor.email = email;
	}
	public static String getPassword() {
		return password;
	}
	public static void setPassword(String password) {
		Donor.password = password;
	}
	
}
