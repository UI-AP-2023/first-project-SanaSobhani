package model.commodity;

public class PC extends DigitalCommodity{
   private String versionOfCPU;
    private int capacityOfRAM;
    public PC(String name,int cost,int weight,String dimension,String versionOfCPU,int capacityOfRAM,int amountOfInventory){
        super(name,cost,weight,dimension,amountOfInventory);
        this.capacityOfRAM = capacityOfRAM;
        this.versionOfCPU = versionOfCPU;
    }

    public String getVersionOfCPU() {
        return versionOfCPU;
    }

    public void setVersionOfCPU(String versionOfCPU) {
        this.versionOfCPU = versionOfCPU;
    }

    public int getCapacityOfRAM() {
        return capacityOfRAM;
    }

    public void setCapacityOfRAM(int capacityOfRAM) {
        this.capacityOfRAM = capacityOfRAM;
    }
}
