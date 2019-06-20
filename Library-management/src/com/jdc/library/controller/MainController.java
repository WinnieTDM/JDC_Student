package com.jdc.library.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.stereotype.Controller;

import com.jdc.library.Main;
import com.jdc.library.controller.MainController;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;

@Controller
public class MainController implements Initializable {

    @FXML
    private HBox header;
    
    @FXML
    private Label title;

    @FXML
    private StackPane content;
    
    
    public static void showMain() {
    	
    	try {
    	FXMLLoader loader=new FXMLLoader(MainController.class.getResource("view/Main.fxml"));
    	loader.setControllerFactory(Main::getController);
    	Stage st=new Stage();
    	
    	st.setScene(new Scene(loader.load()));
    	st.show();
    	
    	}catch(Exception ex) {
    		ex.printStackTrace();
    	}
    }

	public void loadView(String viewName) {

		title.setText(viewName + " Form");
		try {
			FXMLLoader loader = new FXMLLoader(MainController.class.getResource("view/" + viewName + ".fxml"));
			loader.setControllerFactory(Main::getController);
			Parent root = loader.load();

			content.getChildren().clear();

			content.getChildren().add(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		loadView("User");

		header.getChildren().forEach(box -> {
			box.setOnMouseClicked(event -> {
				String name = box.getId();

				if ("Logout".equals(name)) {
					Platform.exit();
				} else {
					System.out.println("id :"+name);
					loadView(name);
				}
			});
		});
	}
}
