package model.commodity;

public enum CommodityCategory {
    DIGITAL("DIG"),STATIONERY("STA"),VEHICLE("VEH"),FOOD("FOO");
    private String code;
   private CommodityCategory(String code)
    {
        this.code=code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
