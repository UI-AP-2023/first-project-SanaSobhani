package model.commodity;

public class NoteBook extends Stationery{
    int pageCount;
    PaperType type;
    public NoteBook(String name, int cost, String manufacturingCountry, PaperType type, int pageCount, int amountOfInventory){
        super(name,cost,manufacturingCountry,amountOfInventory);
        this.pageCount = pageCount;
        this.type = type;
    }
    @Override
    public String toString()
    {
        return "Name: "+getName()+" Cost: "+getCost()+" ID: "+getCommodityID()+" PageCount: "+pageCount+" PaperType: "+type.name()+" Inventory: "+getAmountOfInventory();
    }

}
