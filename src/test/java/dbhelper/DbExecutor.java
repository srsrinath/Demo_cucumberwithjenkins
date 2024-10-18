package dbhelper;

import pages.BasePage;

import java.util.List;
import java.util.Map;

public class DbExecutor {
    DbConfig dbConfig = new DbConfig();

    public String getQueries(String query, String value) {

        return String.format(query, value);
    }

    public List<Map<String, String>> getCustomerDetails(String name) {
        List<Map<String, String>> data1 = DbUtils.getCustomersDBData(getQueries(Queries.customerquery, name));
        System.out.println(data1);
        return data1;
    }

    public List<Map<String, String>> getOrderDetails(String Id) {
        List<Map<String, String>> result = DbUtils.getOrderDBData(getQueries(Queries.orderquery, Id));
        System.out.println(result);
        return result;
    }

    public List<Map<String, String>> getVehicleOrderDetails(String Id) {
        List<Map<String, String>> result = DbUtils.getPosOrderDBData(getQueries(Queries.orderquery1, Id));
        System.out.println(result);
        return result;
    }

    public List<Map<String, String>> getVehiclePartNumberOrderDetails(String Id) {
        List<Map<String, String>> result = DbUtils.getPosOrderDBDataByPartCode(getQueries(Queries.orderquery2, Id));
        System.out.println(result);
        return result;
    }

    public Map<String, String> getsalesOrderDetails(String name) {
        Map<String, String> result = DbUtils.getSalesOrder(getQueries(Queries.salesOrderquery, name));
        System.out.println(result);
        return result;

    }
}
