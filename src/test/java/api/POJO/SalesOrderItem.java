package api.POJO;

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
    public String matCode;
    public String partscode;
    public int soQty;
    public int matId;
    public int itemPrice;
    public int maxRetailPrice;
    public String itemType;
    public String materialType;
    public String fuelType;
    public String itemStatus;
    public String companyBranchId;
    public String materialCategoryName;
    public String materialSubCategoryName;
    public String vehicleId;
    public String vehicleDetails;
    public String make;
    public String model;
    public String yearOfMfg;
    public String vehicleVariant;
    public String releaseYear;
    public String expiryYear;
    public Object hsnCode;
    public String prdBrand;
    public String tax1Id;
    public String tax2Id;
    public String tax1Name;
    public String tax1Percentage;
    public String tax2Name;
    public String tax2Percentage;
    public String vehSegment;
    public String parentCompanyBranchId;
    public String vehicleNumber;
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
}