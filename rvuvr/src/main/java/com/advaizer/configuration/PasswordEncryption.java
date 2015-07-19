/**
 * 
 */
package com.advaizer.configuration;

/**
 * @author smruti
 *
 */
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncryption {

	/**
	 * @param args
	 */
	public static void main(final String[] args) {
		// TODO Auto-generated method stub
	 System.out.println(getHashPassword("password"));

	}
	
	 public static String getHashPassword(final String password) {  
		  final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();  
		  final String hashedPassword = passwordEncoder.encode(password);  
		  
		  return hashedPassword;  
		 }  

}
