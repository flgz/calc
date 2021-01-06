package calc;

import javafx.event.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.fxml.*;
import java.net.URL;
import java.util.ResourceBundle;


public class CalcViewController implements Initializable {
 	
	public Label label; 
	public TextField textField;
	
	private double x=0;
	private double y=0;
	private char lastOperation;
	
	public void putOnField(ActionEvent event){ 
		
		if (textField.getText().equals("0")){
				textField.setText(((Button)event.getSource()).getText());
	
		}else {
				textField.setText(textField.getText()+((Button)event.getSource()).getText());
	
		}
		
	}
	public void add (){ 
				y+=x;
				complete('+');
				
	}
	public void minus (){ 
				if (y==0) {y=x; x=0;};
				y-=x;
				complete('-');
	}
	public void multiply (){ 
				if (x!=0){
				switch ((int)y){
				case 0: y=x ;
				break;
				default : y*=x;
				break;
					}
				}
				complete('*');
	}
	public void divide (){ 
				if (x!=0){
				switch ((int)y){
				case 0: y=x ;
				break;
				default : y/=x;
				break;
					}
				}
				complete('/');
	}
	public void modulo (){ 
				y%=x;
				complete('%');
				
	}
	public void signIt (ActionEvent event){ 
		
		if (textField.getText(0,1).equals("-")){
			textField.setText(textField.getText(1,textField.getText().length()));
		}else {
			textField.setText("-"+textField.getText());
		}
	
	}
	public void delete (ActionEvent event){ 
		
		textField.setText(textField.getText(0,textField.getText().length()-1));
	
	}
	public void clean (ActionEvent event){ 
		x=0;
		y=0;
		textField.setText("0");
		label.setText("");
	}
	public void result (ActionEvent event){ 
			switch(lastOperation){
				case '+':add();
				break;
				case '-':minus();
                break;
				case '*':multiply();
                break;
				case '/':divide();
                break;
				case '%':modulo();
			    break;
			}
}
	private void complete (char operation){ 
				label.setText(""+y);
				textField.setText("0");
				lastOperation=operation;
}
	public void initialize(URL location,ResourceBundle rsrc){
		
		textField.textProperty().addListener((newVObj,oldV,newV)->{
			try{
			x=Double.parseDouble(newV);	
			}catch (Exception e){
				if (newV.equals("-")){
					
				}else {
				label.setText("error : Digits only !");
				textField.setText("0");
				}
				
			}
			
		});
	
}

}