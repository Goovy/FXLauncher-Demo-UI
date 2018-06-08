package com.example.launcherui;

import fxlauncher.FXManifest;
import fxlauncher.UIProvider;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CustomLauncherUI implements UIProvider {
	private ProgressBar progressBar;
	private Stage stage;
	private VBox root;
	private Label label;
	private Label header;

	public void init(Stage stage) {
		this.stage = stage;
		stage.getScene().getStylesheets().add(getClass().getResource("/launcherstyles.css").toExternalForm());
	}

	public Parent createLoader() {
		stage.setTitle("goovy.io updater");

		root = new VBox(30);
		root.setAlignment(Pos.CENTER);
		root.setPrefSize(500, 500);
		root.getStyleClass().add("updater");

		header = new Label("Portfolio App");
		header.getStyleClass().add("h1");

		label = new Label("Please wait...");
		label.getStyleClass().add("h2");

		root.getChildren().addAll(header, label);

		return root;
	}

	public Parent createUpdater(FXManifest manifest) {
		stage.setTitle("Updating...");

		progressBar = new ProgressBar();

		root.getChildren().remove(label);
		Label subTitle = new Label("Upgrading the app to the latest version...");
		subTitle.getStyleClass().add("h2");
		root.getChildren().add(subTitle);
		root.getChildren().add(progressBar);

//		Timeline tl = new Timeline(
//			new KeyFrame(Duration.seconds(4), new KeyValue(header.scaleXProperty(), 1.5)),
//			new KeyFrame(Duration.seconds(4), new KeyValue(header.scaleYProperty(), 1.5))
//		);
//		tl.play();

		return root;
	}

	public void updateProgress(double progress) {
		progressBar.setProgress(progress);
	}

}
