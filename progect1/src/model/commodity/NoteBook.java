package model.commodity;

public class NoteBook extends Stationery{
    int pageCount;
    PaperType type;
    NoteBook(String name,int cost,String manufacturingCountry,PaperType type,int pageCount,int amountOfInventory){
        super(name,cost,manufacturingCountry,amountOfInventory);
        this.pageCount = pageCount;
        this.type = type;
    }

}
enum PaperType {RECYCLED, PRINTING, GLOSS, KRAFT}