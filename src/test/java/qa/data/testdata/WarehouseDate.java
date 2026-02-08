package qa.data.testdata;

public class WarehouseDate {


    private final double wholesalePrice;
    private final double sellingPrice;
    private final double openingstock;


//    @Setter
//    private double wholesalePrice;
//    private double sellingPrice;
//    private double openingstock;

//    public WarehouseDate(double openingStockValue, double warehouseSellingPriceValue, double warehouseWholesalePriceValue) {
//    }

//    public WarehouseDate(int openingStockValue, int warehouseSellingPriceValue, WebElement warehouseSellingPrice) {
//    }


    public WarehouseDate(double openingstock,double wholesalePrice, double sellingPrice) {
        this.wholesalePrice = wholesalePrice;
        this.sellingPrice = sellingPrice;
        this.openingstock = openingstock;
    }

    public Object getWholesalePrice() {
        return wholesalePrice;
    }


    public Object getSellingPrice() {
        return sellingPrice;
    }

    public Object getOpeningstock() {
        return openingstock;
    }
}
