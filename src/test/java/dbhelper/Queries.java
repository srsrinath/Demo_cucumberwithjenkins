package dbhelper;

public interface Queries {
    public static final String orderquery = "select ORDER_NUM,CUSTOMER_ID ,CUSTOMER_NAME, is_active, CUSTOMER_K_CATEGORY from ktestdb01.pos_order ORDER BY CREATED_DT DESC LIMIT 1";
    public static final String orderquery1 = "select ORDER_NUM,CUSTOMER_CODE, is_active,VEHICLE_NUMBER,CUSTOMER_K_CATEGORY from ktestdb01.pos_order_items ORDER BY CREATED_DT DESC LIMIT 1";
    public static final String orderquery2 = "select ORDER_NUM,CUSTOMER_CODE,MAT_CODE, is_active,MAT_NAME,CUSTOMER_K_CATEGORY from ktestdb01.pos_order_items ORDER BY CREATED_DT DESC LIMIT 1";
    public static final String customerquery = "SELECT ID,CUSTOMER_CODE,NAME ,STATUS,K_CATEGORY,CITY,MOBILE_NUM, CUSTOMER_TYPE FROM ktestdb01.btob_customer WHERE NAME='%s'";
    public static final String salesOrderquery = "SELECT CUSTOMER_NAME,SO_NUM FROM ktestdb01.sales_order WHERE customer_name LIKE '%%s%%' ORDER BY CREATED_DT DESC LIMIT 1";
}
