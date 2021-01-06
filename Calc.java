package calc;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.fxml.*;
import javafx.event.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.input.KeyEvent;
// Min (h238,w168)
// Max (h619,w765)

public class Calc extends Application {
	
	TextField textField;
	VBox root;
	public static void main (String [] args) {
	
				launch(args);
			}		
	public void start(Stage stage) throws Exception{
			
			root= FXMLLoader.load (getClass().getResource("CalcView.fxml"));
			textField=(TextField)((Pane)root.getChildren().get(1)).getChildren().get(0);
			Scene scene= new Scene(root);
			scene.setOnKeyPressed (e -> putOnField(e));
			stage.setScene (scene);
			
			stage.setMinWidth (168);
			stage.setMaxWidth (765);
			stage.setMinHeight (238);
			stage.setMaxHeight (619);
			
			stage.show();
		
	}
	public void putOnField(KeyEvent event){
		
		
		switch (event.getCode()){
			case BACK_SPACE:((Button)((Pane)root.getChildren().get(2)).getChildren().get(1)).fire();
			break;
			case DELETE: ((Button)((Pane)root.getChildren().get(2)).getChildren().get(0)).fire();
			break;
			case ADD: ((Button)((Pane)root.getChildren().get(5)).getChildren().get(3)).fire();
			break;
			case SUBTRACT: ((Button)((Pane)root.getChildren().get(4)).getChildren().get(3)).fire(); 
			break;
			case MULTIPLY: ((Button)((Pane)root.getChildren().get(3)).getChildren().get(3)).fire();
			break;
			case DIVIDE: ((Button)((Pane)root.getChildren().get(2)).getChildren().get(3)).fire();
			break;
			case ENTER: ((Button)((Pane)root.getChildren().get(6)).getChildren().get(3)).fire();
			break;
			case EQUALS: ((Button)((Pane)root.getChildren().get(6)).getChildren().get(3)).fire();
			break;
			// case PERCENT: ((Button)((Pane)root.getChildren().get(2)).getChildren().get(2)).fire();
			// break;
			default : {
				if (textField.getText().equals("0")){
				textField.setText(event.getText());
	
			}else {
				textField.setText(textField.getText()+event.getText());
			}
			} 
			break;
		}
		
		
	}
	


}
