package api.POJO.PartsOder;

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
public class CreatePosOrder {
    @JsonProperty("customerName")
    public String customerName;
    public String btobCustomerId;
    public String customerId;
    public String billingAddressId;
    public String shippingAddressId;
    public String createdBy;
    public String updatedBy;
    public String companyBranchId;
    public String orderStatus;
    public String paymentStatus;
    public String orderDt;
    public String etaDt;
    public String isStatusLog;
    public ArrayList<PartsOrderItem> posOrderItems;
    public String orderType;
    public String orderTotalAmount;
    public String orderSubTotalAmount;
    public String assignedToId;
    public String assignedToName;
    @JsonProperty("kEmpName")
    public String kEmpName;
    @JsonProperty("kEmpId")
    public String kEmpId;
    public String region;
    public String orderEnqNum;
    public String soId;
    public String orderEnqConfirmedDt;
    public String regionCode;
    public String customerCode;
    public String orderComments;
    public String customerKCategory;
    public String customerCategoryName;
    public String vehicleNumber;
    public String vehSegment;
    public String isSendNotification;
    public String notificationMessage;
    public String parentCompanyBranchId;
}
