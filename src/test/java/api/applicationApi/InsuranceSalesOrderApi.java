package api.applicationApi;

import api.DataProvider;
import api.POJO.InsuranceSalesOrder.CreateInsuranceSalesOrder;
import api.POJO.InsuranceSalesOrder.SalesOrderItem;
import api.POJO.PartsOder.CreatePosOrder;
import api.POJO.PartsOder.PartsOrderItem;
import api.POJO.PartsOrderByPartNumber.CreateOrderByPartNumber;
import api.POJO.PartsorderVehicle.CreatePosByVehicle;
import api.RestResource;
import api.Route;
import io.restassured.response.Response;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static api.RestResource.getCookieAndToken;

public class InsuranceSalesOrderApi {

    DataProvider dataProvider = new DataProvider();
    public CreateInsuranceSalesOrder createInsuranceSalesOrder;

    public Map<String, String> createSalesOrder() {
        Map<String, String> data = getCookieAndToken();
        HashMap<String, String> result = new HashMap<>();
        Map<String, String> headers = new HashMap<>();
//        Response data = null;
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", data.get("Token"));
        headers.put("Cookie", data.get("Cookie"));
        createInsuranceSalesOrder = (CreateInsuranceSalesOrder) dataProvider
                .getData(String.valueOf(Ordersquery.CREATE_INSURANCE_SALESORDER));
        createInsuranceSalesOrder.setSoDt(new RestResource().dbDateFormatter(LocalDate.now().toString()) + " "
                + new RestResource().currentLocalTime());
        List<SalesOrderItem> items = createInsuranceSalesOrder.getSalesOrderItems();
        if (!items.isEmpty()) {
            SalesOrderItem item = items.get(0);
            item.setSoDt(new RestResource().dbDateFormatter(LocalDate.now().toString()) + " "
                    + new RestResource().currentLocalTime());
        }
        Response response = RestResource.post(Route.salesorder, headers, createInsuranceSalesOrder);
        result.put("salesNo", response.path("RESPONSE_BODY.soNum"));
        result.put("salesId", response.path("RESPONSE_BODY.id"));
        result.put("customerid", response.path("RESPONSE_BODY.customerId"));
        result.put("statuscode", String.valueOf(response.statusCode()));
        result.put("ordertype", response.path("RESPONSE_BODY.orderType"));
        System.out.println(result.put("salesNo", response.path("RESPONSE_BODY.soNum")));
        // System.out.println(result.put("The estimate order of OrderType is
        // "+"orderType", response.path("RESPONSE_BODY.orderType")));
        return result;

    }
}
