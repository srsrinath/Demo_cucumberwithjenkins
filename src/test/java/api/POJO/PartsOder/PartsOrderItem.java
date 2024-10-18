package api.POJO.PartsOder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIgnoreProperties
public class PartsOrderItem {

    public String matId;
    public Object materialCategoryId;
    public String materialCategoryName;
    public int orderQty;
    public int unitPrice;
    public String matName;
    public String matCode;
    public Object hsnCode;
    public String materialType;
    public String tax1Id;
    public String tax2Id;
    public String companyBranchId;
    public String createdBy;
    public String updatedBy;
    public String isManageInventory;
    public String itemStatus;
    public String itemVendorStatus;
    public int totalPrice;
    public String btobCustomerId;
    public int maxRetailPrice;
    public String materialSubCategoryName;
    public Object materialSubCategoryId;
    public String orderType;
    public String vehicleId;
    public String vehMake;
    public String vehModel;
    public String vehicleVariant;
    public String vehicleDetails;
    public String fuelType;
    public String prdBrand;
    public String assignedToId;
    public String assignedToName;
    public String etaDate;
    public String soItemId;
    public String vinNum;
    public String materialUOM;
    public String regionCode;
    public String customerCode;
    public String orderEnqNum;
    public String customerKCategory;
    public String customerCategoryName;
    public int maxDiscount;
    public String vehSegment;
    public String orderDt;
    public String parentCompanyBranchId;
}
