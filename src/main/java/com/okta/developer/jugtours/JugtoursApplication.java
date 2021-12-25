package com.okta.developer.jugtours;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JugtoursApplication {

	public static void main(String[] args) {
		SpringApplication.run(JugtoursApplication.class, args);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try (Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/myDb", "user1", "pass")) {
				// use con here
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
