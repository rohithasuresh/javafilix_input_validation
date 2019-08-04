
package InputValidate;

import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.net.URL; 

/**
 *
 * @author Suresh
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextField txtStudentID;
    
    @FXML
    private TextField txtComputingMCode;
    
    @FXML
    private TextField txtCamousRoomNumber;
    
    
    @FXML
    private TextField txtEmailAddress;
    
    @FXML
    private TextField txtPostCode;
    
    @FXML
    private Label lblStatus;
    
    @FXML
    private Label lblSuccess;
    //*****Check pass input values are Integer or not
    public boolean findInt(String input){
    
    boolean numeric = true;
        try {
            int num = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            numeric = false;
        }
        return numeric;
    }

    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        
       try{

        
        try{
        //****Get input values From Text Field*****    
        String sID=txtStudentID.getText();
        char caracter=sID.charAt(0);
        String computingMCode=txtComputingMCode.getText();
        String campusRoomNumber=txtCamousRoomNumber.getText();
        String emailAddress=txtEmailAddress.getText();
        String postCode=txtPostCode.getText();
        
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@glyndwr.ac.uk";//*****Set Email regex
  
         //validate Field*********
       if(sID.equals("")){//**************check is empty field
       lblStatus.setText("Please Fill Student ID Field");
       }else if(caracter!='S'){//***************Check first letter 'S' in  Student ID Field
         lblStatus.setText("First Letter must be 'S' in Student ID Field");
        }else if(sID.length()!=9){//***************Check length in  Student ID Field
         lblStatus.setText("Student ID Field has must be 9 caracters");
        }else if(sID!=null && !findInt(sID.substring(1,9))){  
        lblStatus.setText("After 'S' must be Integer");//*****Check 'S' All are integer in  Student ID Field
        } else if(computingMCode.equals("")){//********check is empty field
        lblStatus.setText("Please Fill Computing module code Field");
        }else if(computingMCode.length()!=7){//***************Check length in  "Computing Module Code Field
         lblStatus.setText("Computing Module Code Field has must be 7 caracters");
        }else if(computingMCode!=null && !computingMCode.substring(0,4).equals("COMM")){//***************Check Begining 'COMM' in Computing Module Code Field
         lblStatus.setText("Computing Modle Code begining 'COMM' ");
        }else if(computingMCode!=null && !findInt(computingMCode.substring(4,7))){//***************Check After 'COMM' All are Integer in Computing Module Code Field
         lblStatus.setText("After 'COMM' must be Integer ");
        }else if(campusRoomNumber.equals("")){//***********check is empty field
        lblStatus.setText("Please Fill campus room Number Field");
        }else if(campusRoomNumber!=null && campusRoomNumber.charAt(0)!='R'){//***************Check is first letter 'R' in Campus Room Number Field
         lblStatus.setText("First Letter must be 'R' in Campus Room Number Field");
        }else if(campusRoomNumber.length()!=3){//***************Check length in Campus Room Number Field
         lblStatus.setText("Campus Room Number  has must be 3 caracters");
        }else if(campusRoomNumber!=null && !findInt(campusRoomNumber.substring(1,3))){//***************Check after 'R' all are integer in Campus Room Number Field
         lblStatus.setText("After 'R' must be Integer ");
        }else if(emailAddress.equals("")){//*************check is empty field
        lblStatus.setText("Please Fill Email Address Field");
        } else if(!emailAddress.matches(regex)){//***************Check Email Address
         lblStatus.setText("Please Check Your Email ");
        }else if(postCode.equals("")){//*****************check is empty field
        lblStatus.setText("Please Fill postcode Field");
        }
        else if(postCode.length()!=7){//***************Check length in Postal Code
         lblStatus.setText("Postal Code must be 7 caracters");
        }else if(postCode!=null && !postCode.substring(0,2).equals("LL")){//***************Check Begining 'LL' in Postal Code
        lblStatus.setText("Post Code First Two latters must be 'LL'");
        }else if(postCode!=null && !findInt(postCode.substring(2,5))){//***************Check After 'LL' has a three integer in Postal Code
         lblStatus.setText("After 'LL' must be Three Integer ");
        }else if(postCode!=null && findInt(postCode.substring(5,7))){//***************Check last two caracters in Postal Code
         lblStatus.setText("After 'LL***' must be character");
        }else{
            lblStatus.setText("");
            lblSuccess.setText("All Fields Validated Sucessfully");
        }         
        }
        catch (Exception e)
        {
        System.out.println(e);
        }
        }catch(IndexOutOfBoundsException e){
       }
    
    }
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                        }    
}
