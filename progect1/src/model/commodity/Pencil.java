package model.commodity;

public class Pencil extends Stationery{
   private PencilType type;
 public Pencil(String name,int cost,String manufacturingCountry,PencilType type,int amountOfInventory){
     super(name,cost,manufacturingCountry,amountOfInventory);
     this.type =type;
 }


    public PencilType getType() {
        return type;
    }

    public void setType(PencilType type) {
        this.type = type;
    }
}
enum PencilType{HB,B,F,H,_2H;}
