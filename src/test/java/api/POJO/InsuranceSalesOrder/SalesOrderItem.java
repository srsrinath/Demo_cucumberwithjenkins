package api.POJO.InsuranceSalesOrder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIgnoreProperties
public class SalesOrderItem {
    public String matName;
    public String soQty;
    public String matCode;
    public String partscode;
    public String itemStatus;
    public int maxRetailPrice;
    public int matId;
    public int itemPrice;
    public String companyBranchId;
    public String vinNum;
    public String customerComments;
    public String materialType;
    public String itemType;
    public String vehicleId;
    public String vehicleDetails;
    public String make;
    public String model;
    public String yearOfMfg;
    public String vehicleVariant;
    public String releaseYear;
    public String expiryYear;
    public String fuelType;
    public String prdBrand;
    public String tax1Id;
    public String tax2Id;
    public String tax1Name;
    public String tax1Percentage;
    public String tax2Name;
    public String tax2Percentage;
    public Object hsnCode;
    public String itemImgFileName;
    public String mediaFolderPath;
    public String vehSegment;
    public String materialSubCategoryName;
    public String parentCompanyBranchId;
    public String btobCustomerId;
    public String soDt;
    public String customerName;
    public String createdBy;
    public String updatedBy;
    public String customerCode;
    public String regionCode;
    public String customerKCategory;
    public String customerCategoryName;
    public String totalPrice;
    public String needEstimateDateTime;
    public String orderType;
}
