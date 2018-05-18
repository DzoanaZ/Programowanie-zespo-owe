package rental.employee;

import javafx.scene.control.Label;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import rental.AController;

public class EmployeeController extends AController {

    private Label activeLabel;
    private PersonalData personalData;
    private ActualOrders actualOrders;
    private HistoryOrders historyOrders;
    private AvailableCars availableCars;
    private ProcessOrders processOrders;
        
    @FXML
    private AnchorPane contentBox;
    
    @FXML
    private Label myPersonalDataLabel;
    @FXML
    private Label myCurrentOrdersLabel;
    @FXML
    private Label myRentalHistoryLabel;
    @FXML
    private Label processOrderLabel;

    @FXML
    private Label rzeszowLabel;
    @FXML
    private Label stalowaLabel;
    @FXML
    private Label dynowLabel;
    @FXML
    private Label jasloLabel;


    public EmployeeController() {
        //TODO: log4j implemented
        System.out.println("---EmployeeController opened");
    }

    @FXML
    public void menuItem_Clicked(MouseEvent mouseEvent) {
        Object sender = mouseEvent.getSource();
        Label selectedItem = null;
        LabelType item = null;

        if (sender instanceof Label) {
            selectedItem = (Label) sender;
        }

        if (selectedItem != null) {
            if (selectedItem.getId().equals("myPersonalDataLabel")) {
                item = LabelType.myPersonalDataLabel;
            } 
            else if (selectedItem.getId().equals("myCurrentOrdersLabel")) {
                item = LabelType.myCurrentOrdersLabel;
            } 
            else if (selectedItem.getId().equals("myRentalHistoryLabel")) {
                item = LabelType.myRentalHistoryLabel;
            } 
            else if (selectedItem.getId().equals("processOrderLabel")) {
                item = LabelType.processOrderLabel;
            }
            else if (selectedItem.getId().equals("dynowLabel")) {
                item = LabelType.dynowLabel;
            } 
            else if (selectedItem.getId().equals("jasloLabel")) {
                item = LabelType.jasloLabel;
            } 
            else if (selectedItem.getId().equals("rzeszowLabel")) {
                item = LabelType.rzeszowLabel;
            } 
            else if (selectedItem.getId().equals("stalowaLabel")) {
                item = LabelType.stalowaLabel;
            }
        }
        if (item != null) {
            readPuzzel(item);
        }

    }

    private void readPuzzel(LabelType item) {
        if (item == null) {
            return;
        }
        switch (item) {
            case myPersonalDataLabel:
                personalData = new PersonalData();
                contentBox.getChildren().setAll(personalData);
                // personalData.setEmail(login);
                selectMenuItem(this.myPersonalDataLabel);
                break;
            case myCurrentOrdersLabel:
                actualOrders = new ActualOrders();
                contentBox.getChildren().setAll(actualOrders);
                selectMenuItem(this.myCurrentOrdersLabel);
                break;
            case myRentalHistoryLabel:               
                historyOrders = new HistoryOrders();
                contentBox.getChildren().setAll(historyOrders);
                selectMenuItem(this.myRentalHistoryLabel);
                break;
            case processOrderLabel:               
                processOrders = new ProcessOrders();
                contentBox.getChildren().setAll(processOrders);
                selectMenuItem(this.processOrderLabel);
                break;
            case dynowLabel:
                availableCars = new AvailableCars("Dynów");
                contentBox.getChildren().setAll(availableCars);
                selectMenuItem(this.dynowLabel);
            break;
            case jasloLabel:
                availableCars = new AvailableCars("Jasło");
                contentBox.getChildren().setAll(availableCars);
                selectMenuItem(this.jasloLabel);
                break;
            case rzeszowLabel:
                availableCars = new AvailableCars("Rzeszów");
                contentBox.getChildren().setAll(availableCars);
                selectMenuItem(this.rzeszowLabel);
                break;
            case stalowaLabel:
                availableCars = new AvailableCars("Stalowa Wola");
                contentBox.getChildren().setAll(availableCars);
                selectMenuItem(this.stalowaLabel);
                break;
        }
    }

    private void selectMenuItem(Label label) {
        if (activeLabel != null) {
            activeLabel.getStyleClass().setAll("menuItem");
        }
        activeLabel = label;
        activeLabel.getStyleClass().add("active");
    }

    enum LabelType {
        myPersonalDataLabel,
        myCurrentOrdersLabel,
        myRentalHistoryLabel,
        processOrderLabel,
        dynowLabel,
        jasloLabel,
        rzeszowLabel,
        stalowaLabel
    }
}
