package controller;

import db.DbConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Customer;

import java.sql.*;

public class ViewCustomerFormController {

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
    private TableView<Customer> tblCustomers;

    @FXML
    void btnReloadOnAction(ActionEvent event) {
        loadCustomerTable();
    }

    private void loadCustomerTable() {
        ObservableList<Customer> customerObservableList = FXCollections.observableArrayList();
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/thogakade", "root", "1234");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM customer");
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1));
                System.out.println(resultSet.getString(2));
                System.out.println(resultSet.getString(3));
                System.out.println(resultSet.getString(4));

                DbConnection.getInstance().getConnection().add(new Customer(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getDouble(4)
                ));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        DbConnection.getInstance().getConnection().forEach(customer -> {
            customerObservableList.add(customer);
        });
        tblCustomers.setItems(customerObservableList);
    }
}
