package api;

import api.POJO.InsuranceSalesOrder.CreateInsuranceSalesOrder;
import api.POJO.Orders;
import api.POJO.PartsOder.CreatePosOrder;
import api.POJO.PartsOder.PartsOrderItem;
import api.POJO.PartsOrderByPartNumber.CreateOrderByPartNumber;
import api.POJO.PartsorderVehicle.CreatePosByVehicle;
import com.fasterxml.jackson.databind.ObjectMapper;
import context.TestContext;
import org.apache.poi.ss.formula.atp.Switch;

import java.io.File;
import java.io.FileReader;

public class DataProvider {

    private ObjectMapper mapper = new ObjectMapper();

    public Object getData(String data) {
        Object object = new Object();
        try {
            switch (data) {
//                case "CREATE_SINGLEORDER_MOBILE":
//                    object = mapper.readValue(
//                            new File(System.getProperty("user.dir") + "\\src\\test\\resources\\JsonData\\Parts.json"),
//                            Orders.class);
//                    break;
                case "CREATE_PARTSORDER":
                    object = mapper.readValue(new File(
                            System.getProperty("user.dir") + "\\src\\test\\resources\\JsonData\\PartsOrder.json"),
                            CreatePosOrder.class);
                    break;

                case "CREATE_PARTSORDER_BY_VEHICLE":
                    object = mapper.readValue(
                            new File(System.getProperty("user.dir")
                                    + "\\src\\test\\resources\\JsonData\\PartsOrderByVehicle.json"),
                            CreatePosByVehicle.class);
                    break;

                case "CREATE_PARTSORDER_BY_PARTNUMBER":
                    object = mapper.readValue(
                            new File(System.getProperty("user.dir")
                                    + "\\src\\test\\resources\\JsonData\\PartsOrderByPartNumber.json"),
                            CreateOrderByPartNumber.class);
                    break;

                case "CREATE_INSURANCE_SALESORDER":
                    object = mapper.readValue(
                            new File(System.getProperty("user.dir")
                                    + "\\src\\test\\resources\\JsonData\\InsuranceOrder.json"),
                            CreateInsuranceSalesOrder.class);
                    break;

                default:
                    System.out.println("data not found");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }

}
