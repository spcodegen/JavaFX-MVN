package controller;

import db.DbConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Customer;

import java.io.IOException;
import java.net.URL;
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
    private TableView<Customer> tblCustomers;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtSalary;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadCmb();
    }

    @FXML
    void btnAddOnAction(ActionEvent event) {
//
//        DbConnection.getInstance().getConnection().add(new Customer(
//                txtId.getText(),
//                cmbTitle.getValue(),
//                txtName.getText(),
//                dateDOB.getValue(),
//                txtAddress.getText(),
//                Double.parseDouble(txtSalary.getText())
//        ));
//
//        loadTable();
    }

    private void loadCmb() {
        ObservableList<String> titleList = FXCollections.observableArrayList();
        titleList.add("MR.");
        titleList.add("MRS.");
        titleList.add("MISS.");
        cmbTitle.setItems(titleList);
    }
    private void loadTable(){
        ObservableList<Customer> customerList = FXCollections.observableArrayList();
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colDob.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        DbConnection.getInstance().getConnection().forEach(customer -> {
            customerList.add(customer);
        });
        tblCustomers.setItems(customerList);
    }

    public void btnViewAllOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/view-customer.fxml"))));
        stage.show();
    }
}
