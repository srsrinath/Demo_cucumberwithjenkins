package api.applicationApi;

import api.DataProvider;
import api.POJO.PartsOder.CreatePosOrder;
import api.POJO.PartsOder.PartsOrderItem;
import api.POJO.PartsOrderByPartNumber.CreateOrderByPartNumber;
import api.POJO.PartsOrderByPartNumber.PosOrderByPartNumber;
import api.POJO.PartsorderVehicle.CreatePosByVehicle;
import api.POJO.PartsorderVehicle.PosOrderByVehicle;
import api.RestResource;
import api.Route;
import io.restassured.response.Response;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static api.RestResource.getCookieAndToken;

public class PartsOrderApi {

    DataProvider dataProvider = new DataProvider();
    public CreatePosOrder createPosOrder;
    public CreatePosByVehicle createPosByVehicle;
    public CreateOrderByPartNumber createOrderByPartNumber;

    public Map<String, String> createPartsOrder() {
        Map<String, String> data = getCookieAndToken();
        HashMap<String, String> result = new HashMap<>();
        Map<String, String> headers = new HashMap<>();
//        Response data = null;
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", data.get("Token"));
        headers.put("Cookie", data.get("Cookie"));
        createPosOrder = (CreatePosOrder) dataProvider.getData(String.valueOf(Ordersquery.CREATE_PARTSORDER));
        createPosOrder.setOrderDt(LocalDate.now().toString() + " " + new RestResource().currentLocalTime());
        createPosOrder.setEtaDt(LocalDate.now().toString() + " " + new RestResource().currentLocalTime());
        createPosOrder.setOrderEnqConfirmedDt(LocalDate.now().toString() + " " + new RestResource().currentLocalTime());
        List<PartsOrderItem> items = createPosOrder.getPosOrderItems();
        if (!items.isEmpty()) {
            PartsOrderItem item = items.get(0);
            item.setOrderDt(new RestResource().dbDateFormatter(LocalDate.now().toString()) + " "
                    + new RestResource().currentLocalTime());
        }
        Response response = RestResource.post(Route.partsorder, headers, createPosOrder);
        result.put("orderNo", response.path("RESPONSE_BODY.orderNum"));
        result.put("orderId", response.path("RESPONSE_BODY.id"));
        result.put("customerid", response.path("RESPONSE_BODY.customerId"));
        result.put("statuscode", String.valueOf(response.statusCode()));
        System.out.println(result.put("orderNo", response.path("RESPONSE_BODY.orderNum")));
        return result;

    }

    public Map<String, String> createPartsOrder_ByVehicle() {
        Map<String, String> data = getCookieAndToken();
        HashMap<String, String> result = new HashMap<>();
        Map<String, String> headers = new HashMap<>();
//        Response data = null;
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", data.get("Token"));
        headers.put("Cookie", data.get("Cookie"));
        createPosByVehicle = (CreatePosByVehicle) dataProvider
                .getData(String.valueOf(Ordersquery.CREATE_PARTSORDER_BY_VEHICLE));
        createPosByVehicle.setOrderDt(LocalDate.now().toString() + " " + new RestResource().currentLocalTime());
        createPosByVehicle.setEtaDt(LocalDate.now().toString() + " " + new RestResource().currentLocalTime());
        createPosByVehicle
                .setOrderEnqConfirmedDt(LocalDate.now().toString() + " " + new RestResource().currentLocalTime());
        List<PosOrderByVehicle> items = createPosByVehicle.getPosOrderItems();
        if (!items.isEmpty()) {
            PosOrderByVehicle item = items.get(0);
            item.setOrderDt(new RestResource().dbDateFormatter(LocalDate.now().toString()) + " "
                    + new RestResource().currentLocalTime());
        }
        Response response = RestResource.post(Route.partsorder, headers, createPosByVehicle);
        result.put("orderNo", response.path("RESPONSE_BODY.orderNum"));
        result.put("orderId", response.path("RESPONSE_BODY.id"));
        result.put("customerid", response.path("RESPONSE_BODY.customerId"));
        result.put("statuscode", String.valueOf(response.statusCode()));
        result.put("vehicleNumber", response.path("RESPONSE_BODY.posOrderItems[0].vehicleNumber"));
//        System.out.println("the customer id is"+result.put("customerid",response.path("RESPONSE_BODY.customerId")));
//        System.out.println("the order number is"+result.put("orderNo", response.path("RESPONSE_BODY.orderNum")));
        System.out.println("the vehicle number is "
                + result.put("vehicleNumber", response.path("RESPONSE_BODY.posOrderItems[0].vehicleNumber")));
        return result;

    }

    public Map<String, String> createPartsOrderByPartNumber() {
        Map<String, String> data = getCookieAndToken();
        HashMap<String, String> result = new HashMap<>();
        Map<String, String> headers = new HashMap<>();
//        Response data = null;
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", data.get("Token"));
        headers.put("Cookie", data.get("Cookie"));
        createOrderByPartNumber = (CreateOrderByPartNumber) dataProvider
                .getData(String.valueOf(Ordersquery.CREATE_PARTSORDER_BY_PARTNUMBER));
        createOrderByPartNumber.setOrderDt(LocalDate.now().toString() + " " + new RestResource().currentLocalTime());
        createOrderByPartNumber.setEtaDt(LocalDate.now().toString() + " " + new RestResource().currentLocalTime());
        createOrderByPartNumber
                .setOrderEnqConfirmedDt(LocalDate.now().toString() + " " + new RestResource().currentLocalTime());
        List<PosOrderByPartNumber> items = createOrderByPartNumber.getPosOrderItems();
        if (!items.isEmpty()) {
            PosOrderByPartNumber item = items.get(0);
            item.setOrderDt(new RestResource().dbDateFormatter(LocalDate.now().toString()) + " "
                    + new RestResource().currentLocalTime());
        }
        Response response = RestResource.post(Route.partsorder, headers, createOrderByPartNumber);
        result.put("orderNo", response.path("RESPONSE_BODY.orderNum"));
        result.put("orderId", response.path("RESPONSE_BODY.id"));
        result.put("customerid", response.path("RESPONSE_BODY.customerId"));
        result.put("statuscode", String.valueOf(response.statusCode()));
        result.put("vehicleNumber", response.path("RESPONSE_BODY.posOrderItems[0].vehicleNumber"));
//        System.out.println("the customer id is"+result.put("customerid",response.path("RESPONSE_BODY.customerId")));
//        System.out.println("the order number is"+result.put("orderNo", response.path("RESPONSE_BODY.orderNum")));
        // System.out.println("the vehicle number is "+result.put("vehicleNumber",
        // response.path("RESPONSE_BODY.posOrderItems[0].vehicleNumber")));
        return result;

    }

}
