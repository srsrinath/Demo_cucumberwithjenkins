//package api.applicationApi;
//
//import api.DataProvider;
//import api.POJO.Orders;
//import api.RestResource;
//import api.Route;
//import context.TestContext;
//import io.restassured.response.Response;
//import org.openqa.selenium.WebDriver;
//import pages.BasePage;
//
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.HashMap;
//import java.util.Map;
//
//import static api.Route.*;
//
//public class KdmsApi extends BasePage {
//    DataProvider dataProvider = new DataProvider();
//    private Orders orders;
//    private BasePage basePage;
//
//    public KdmsApi(WebDriver driver) {
//        super(driver);
//    }
//
//    public Map<String, String> createPartsOrder() {
//        Response data = null;
//        HashMap<String, String> result = new HashMap<>();
//        try {
//            HashMap<String, String> headers = new HashMap<>();
//            headers.put("Content-Type", "application/json");
//            orders = (Orders) dataProvider.getData(String.valueOf(Ordersquery.CREATE_SINGLEORDER_MOBILE));
//            orders.setSoDt(todaysDate());
//            data = RestResource.post(Route.createOrder, headers, orders);
//            result.put("Estimate_order_number", data.path("RESPONSE_BODY.soNum"));
//            result.put("customerName", data.path("RESPONSE_BODY.customerName"));
//            result.put("orderDate", data.path("RESPONSE_BODY.soDt"));
//            result.put("CustomerId", data.path("RESPONSE_BODY.btobCustomerId"));
//            result.put("materialName", data.path("RESPONSE_BODY.salesOrderItems[0].matName"));
//            result.put("partCode", data.path("RESPONSE_BODY.salesOrderItems[0].partscode"));
//            result.put("totalPrice", data.path("RESPONSE_BODY.salesOrderItems[0].totalPrice"));
//            result.put("carName", data.path("RESPONSE_BODY.salesOrderItems[0].make"));
//            result.put("id",data.path("RESPONSE_BODY.id"));
//            result.put("statusCode", data.statusCode() + "");
//            result.put("orderId",data.path("RESPONSE_BODY.id"));
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return result;
//    }
//
//    public Map<String,String> getOrderDetails(String orderNumber )
//    {
//        Response data = null;
//        HashMap<String, String> result = new HashMap<>();
//        try{
//            HashMap<String, String> headers = new HashMap<>();
//            headers.put("Content-Type", "application/json");
//
//            data = RestResource.get(getOrder,headers,orderNumber);
//            result.put("customerName", data.path("RESPONSE_BODY.customerName"));
//            result.put("CustomerId", data.path("RESPONSE_BODY.btobCustomerId"));
//            result.put("partCode", data.path("RESPONSE_BODY.salesOrderItems[0].partscode"));
//            result.put("alternate_partsCode",data.path("RESPONSE_BODY.salesOrderItems[0].alternateSalesOrderItems[0].partscode"));
//            result.put("alternate_materialName",data.path("RESPONSE_BODY.salesOrderItems[0].alternateSalesOrderItems[0].matName"));
//            result.put("statusCode",data.statusCode()+"");
//
//
//
//        }catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//        return result;
//    }
//
//}
