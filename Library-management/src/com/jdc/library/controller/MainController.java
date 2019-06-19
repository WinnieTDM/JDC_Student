package com.jdc.library.controller;

import org.springframework.stereotype.Controller;

import com.jdc.library.Main;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

@Controller
public class MainController {

    @FXML
    private HBox header;

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

}
