package com.jdc.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.jdc.library.entity.User;
import com.jdc.library.service.UserService;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

@Controller
public class LoginController {

	@FXML
	private TextField userName;

	@FXML
	private PasswordField password;

	@FXML
	private Label message;	
	
	@Autowired
	private UserService service;

	private static User user;
	
	
	public static User getUser() {
		return user;
	}

	@FXML
	void cancel() {

	}

	@FXML
	void enter() {

		try {
			user=service.findBylogin(userName.getText(), password.getText());
			
			MainController.showMain();
			password.getScene().getWindow().hide();

		} catch (Exception ex) {

			message.setText(ex.getMessage());
		}
	}

}
