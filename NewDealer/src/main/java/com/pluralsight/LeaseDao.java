package com.pluralsight;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LeaseDao {
    private final DataSourceManager dataSource;

    public LeaseDao(DataSourceManager dataSource) {
        this.dataSource = dataSource;
    }

    public void save(LeaseContract contract) {
        String sql = "INSERT INTO lease_contracts (vin, customer_name, customer_email, date, lease_fee, monthly_payment) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, contract.getVin());
            stmt.setString(2, contract.getCustomerName());
            stmt.setString(3, contract.getCustomerEmail());
            stmt.setString(4, contract.getDate());
            stmt.setDouble(5, contract.getLeaseFee());
            stmt.setDouble(6, contract.getMonthlyPayment());

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error saving lease contract: " + e.getMessage());
        }
    }
}
