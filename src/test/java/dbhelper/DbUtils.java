package dbhelper;

import pojo.Obj;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DbUtils {

    public static List<Map<String, String>> getCustomersDBData(String name) {
        List<Map<String, String>> dataList = new ArrayList<>();

        try {

            ResultSet rs = DbConfig.executeQuery(name);

            ResultSetMetaData metaData = rs.getMetaData();

            while (rs.next()) {

                Map<String, String> data = new HashMap<>();

                data.put("ID", String.valueOf(rs.getInt("ID")));
                data.put("NAME", rs.getString("NAME"));
                data.put("CUSTOMER_CODE", rs.getString("CUSTOMER_CODE"));
                data.put("CITY", rs.getString("CITY"));
                // data.put("EMAIL", rs.getString("EMAIL"));
                data.put("STATUS", rs.getString("STATUS"));
                data.put("MOBILE_NUM", rs.getString("MOBILE_NUM"));
                // data.put("CASH_OUTSTANDING_LIMIT",
                // String.valueOf(rs.getString("CASH_OUTSTANDING_LIMIT")));
                // data.put("CASH_OUTSTANDING_DAYS",
                // String.valueOf(rs.getString("CASH_OUTSTANDING_DAYS")));
                // data.put("GSTIN", rs.getString("GSTIN"));
                data.put("K_CATEGORY", rs.getString("K_CATEGORY"));
                data.put("CUSTOMER_TYPE", rs.getString("CUSTOMER_TYPE"));

                dataList.add(data);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataList;
    }

    public static List<Map<String, String>> getPosOrderDBData(String name) {
        List<Map<String, String>> dataList = new ArrayList<>();

        try {

            ResultSet rs = DbConfig.executeQuery(name);

            while (rs.next()) {

                Map<String, String> data = new HashMap<>();
                data.put("CUSTOMER_CODE", String.valueOf(rs.getInt("CUSTOMER_CODE")));
                data.put("ORDER_NUM", rs.getString("ORDER_NUM"));
                data.put("Active", rs.getString("is_active"));
                data.put("CUSTOMER_K_CATEGORY", rs.getString("CUSTOMER_K_CATEGORY"));
                data.put("VEHICLE_NUMBER", rs.getString("VEHICLE_NUMBER"));
                dataList.add(data);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataList;
    }

    public static List<Map<String, String>> getPosOrderDBDataByPartCode(String name) {
        List<Map<String, String>> dataList = new ArrayList<>();

        try {

            ResultSet rs = DbConfig.executeQuery(name);

            while (rs.next()) {

                Map<String, String> data = new HashMap<>();
                data.put("CUSTOMER_CODE", String.valueOf(rs.getInt("CUSTOMER_CODE")));
                data.put("ORDER_NUM", rs.getString("ORDER_NUM"));
                data.put("Active", rs.getString("is_active"));
                data.put("CUSTOMER_K_CATEGORY", rs.getString("CUSTOMER_K_CATEGORY"));
                data.put("MAT_NAME", rs.getString("MAT_NAME"));
                data.put("MAT_CODE", String.valueOf(rs.getLong("MAT_CODE")));
                dataList.add(data);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataList;
    }

    public static List<Map<String, String>> getOrderDBData(String name) {
        List<Map<String, String>> dataList = new ArrayList<>();

        try {

            ResultSet rs = DbConfig.executeQuery(name);

            while (rs.next()) {

                Map<String, String> data = new HashMap<>();
                data.put("CUSTOMER_ID", String.valueOf(rs.getInt("CUSTOMER_ID")));
                data.put("CUSTOMER_NAME", rs.getString("CUSTOMER_NAME"));
                data.put("ORDER_NUM", rs.getString("ORDER_NUM"));
                data.put("Active", rs.getString("is_active"));
                data.put("CUSTOMER_K_CATEGORY", rs.getString("CUSTOMER_K_CATEGORY"));

                dataList.add(data);
                // System.out.println(data);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataList;
    }

    public static Map<String, String> getSalesOrder(String name) {
        System.out.println("enter in this method");
        // List<Map<String, String>> dataList = new ArrayList<>();
        Map<String, String> datalist = new HashMap<>();
        try {
            System.out.println(name);
            try (ResultSet rst = DbConfig.executeQuery(name)) {
                ResultSetMetaData metaData1 = rst.getMetaData();
                while (rst.next()) {
                    // Map<String, String> data = new HashMap<>();
                    datalist.put("CUSTOMER_NAME", rst.getString("CUSTOMER_NAME"));
                    datalist.put("ORDER_NUM", rst.getString("SO_NUM"));
                    // dataList.add(data);
                }
            }
            // System.out.println(dataList);
            System.out.println("Number of records fetched: " + datalist.size());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return datalist;
    }

}
