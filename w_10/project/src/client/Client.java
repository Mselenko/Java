package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Client extends Application {

	private DataOutputStream output;
	private DataInputStream input;
	private Socket socket = null;
	String serverMessage = "";
	TextArea ta = new TextArea();
	String clientName ="";

	@Override
	public void start(Stage primaryStage) {

		BorderPane paneForTextField = new BorderPane();
		Button btnSend = new Button("|>");
		paneForTextField.setPadding(new Insets(5, 5, 5, 5));
		paneForTextField.setRight(btnSend);

		TextField tf = new TextField();
		TextField tfName = new TextField();
		tf.setAlignment(Pos.BOTTOM_RIGHT);
		paneForTextField.setCenter(tf);

		BorderPane mainPane = new BorderPane();

		ta.setOnKeyReleased(event -> {
			if (event.getCode() == KeyCode.ENTER) 
			{
				clientName = ta.getText().substring(16);
				primaryStage.setTitle(clientName);
				
				try 
				{
					output.writeUTF(clientName);
					output.flush();
				} catch (IOException e1) 
				{
					e1.printStackTrace();
				}
			}
		});

		paneForTextField.getChildren().add(tfName);

		mainPane.setTop(new ScrollPane(ta));
		mainPane.setCenter(paneForTextField);

		Scene scene = new Scene(mainPane, 450, 270);
		
		primaryStage.setScene(scene);
		primaryStage.show();

		ta.appendText("Enter your name: ");

		btnSend.setOnAction(e -> {
			try {

				output.writeUTF(tf.getText() + "\n");
				output.flush();

			} catch (IOException ex) {
				ex.printStackTrace();
			}
		});

		try {

			socket = new Socket("127.0.0.1", 8000);

			input = new DataInputStream(socket.getInputStream());
			output = new DataOutputStream(socket.getOutputStream());

			new Thread(() -> {
				try {
					while (true) {

						System.out.println("Waiting for message");

						serverMessage = input.readUTF();

						System.out.println(serverMessage);

						Platform.runLater(() -> {

							ta.appendText(serverMessage);

						});
					}
				} catch (IOException e) {
					ta.appendText(e.toString() + "\n");
				}

			}).start();
		} catch (IOException ex) {
			ta.appendText(ex.toString() + '\n');
		}
	}

	public static void main(String[] args) {
		launch(args);
	}


}