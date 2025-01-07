package db;

import model.Customer;

import java.util.ArrayList;
import java.util.List;

public class DbConnection {
    private static DbConnection instance;
    private static List<Customer> customerList;

    private DbConnection(){
        customerList=new ArrayList<>();
    }

    public static DbConnection getInstance() {
        return instance==null?instance=new DbConnection():instance;
    }

    public List<Customer> getConnection(){
        return customerList;
    }
}
