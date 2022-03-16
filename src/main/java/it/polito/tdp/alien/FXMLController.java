package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	private Model model;
	String regex = "[a-zA-Z]+";

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button btnClear;

	@FXML
	private Button btnTraduci;

	@FXML
	private TextArea txtArea;

	@FXML
	private TextField txtTraduci;

	@FXML
	void handleClear(ActionEvent event) {
		txtTraduci.clear();
		txtArea.clear();
	}

	@FXML
	void handleTranslate(ActionEvent event) {
		String celle[] = txtTraduci.getText().split(" ");
		if (celle.length == 2) {
			if (!celle[0].matches(regex) || !celle[1].matches(regex)) {
				txtArea.setText("Errore, caratteri speciali inseriti");
				return;
			}
			model.aggiungiAlDizionario(celle[0].toLowerCase(), celle[1].toLowerCase());
			txtArea.setText("Alien:" + celle[0] + ", ITA: " + celle[1]);
			txtTraduci.clear();

		} else if (celle.length == 1) {
			if (!celle[0].matches(regex)) {
				txtArea.setText("Errore, caratteri speciali inseriti");
				return;
			}
			txtArea.setText(model.traduci(celle[0].toLowerCase()));
			txtTraduci.clear();
		} else {
			return;
		}
	}

	public void setModel(Model model) {
		this.model = model;
	}

	@FXML
	void initialize() {
		assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'Scene.fxml'.";
		assert btnTraduci != null : "fx:id=\"btnTraduci\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtArea != null : "fx:id=\"txtArea\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtTraduci != null : "fx:id=\"txtTraduci\" was not injected: check your FXML file 'Scene.fxml'.";

	}

}
