package api.POJO.PartsOrderByPartNumber;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIgnoreProperties
public class PosOrderByPartNumber {
    public String kpartNum;
    public String matId;
    public String materialCategoryId;
    public String materialCategoryName;
    public int orderQty;
    public String matName;
    public String matCode;
    public String hsnCode;
    public String materialType;
    public String tax1Id;
    public String tax2Id;
    public String companyBranchId;
    public String createdBy;
    public String updatedBy;
    public String isManageInventory;
    public String itemStatus;
    public String itemVendorStatus;
    public Object totalPrice;
    public String btobCustomerId;
    public String maxRetailPrice;
    public String materialSubCategoryName;
    public String materialSubCategoryId;
    public String orderType;
    public Object matGenericId;
    public String vehMake;
    public String vehModel;
    public String prdBrand;
    public String assignedToId;
    public String assignedToName;
    public String etaDate;
    public String soItemId;
    public String vinNum;
    public String materialUOM;
    public String quantityPerUom;
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
