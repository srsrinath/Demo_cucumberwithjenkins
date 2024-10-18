package api.POJO.InsuranceSalesOrder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIgnoreProperties
public class CreateInsuranceSalesOrder {
    @JsonProperty("customerName")
    public String customerName;
    public String btobCustomerId;
    public String customerId;
    public String billingAddressId;
    public String dlvyAddressId;
    public String soStatus;
    public String soDt;
    public String orderType;
    public String isBtobOrder;
    public String isSendNotification;
    public String notificationMessage;
    public String createdBy;
    public String updatedBy;
    public String companyBranchId;
    @JsonProperty("kEmpId")
    public String kEmpId;
    @JsonProperty("kEmpName")
    public String kEmpName;
    public ArrayList<SalesOrderItem> salesOrderItems;
    public String region;
    public String customerCode;
    public String regionCode;
    public String customerKCategory;
    public String customerCategoryName;
    public String orderEnqCategory;
    public String vehSegment;
    public String insuranceProvider;
    public String insuranceNumber;
    public String serviceCategory;
    public String vehicleNumber;
    public String btocCustName;
}
