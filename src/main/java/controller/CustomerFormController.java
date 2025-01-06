package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class CustomerFormController implements Initializable {

    @FXML
    private ComboBox<String> cmbTitle;

    @FXML
    private TableColumn colAddress;

    @FXML
    private TableColumn colDob;

    @FXML
    private TableColumn colId;

    @FXML
    private TableColumn colName;

    @FXML
    private TableColumn colSalary;

    @FXML
    private DatePicker dateDOB;

    @FXML
    private TableView<?> tblCustomers;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtSalary;

    @FXML
    void btnAddOnAction(ActionEvent event) {
        String id = txtId.getText();
        String title = cmbTitle.getValue();
        String name = txtName.getText();
        LocalDate dob = dateDOB.getValue();
        String address = txtAddress.getText();
        Double salary = Double.parseDouble(txtSalary.getText());

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadMenu();
    }

    private void loadMenu() {
        ObservableList<String> menuList = FXCollections.observableArrayList();
        menuList.add("MR.");
        menuList.add("MRS.");
        menuList.add("MISS.");
        cmbTitle.setItems(menuList);
    }
}
