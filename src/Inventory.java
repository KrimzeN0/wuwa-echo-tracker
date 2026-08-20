import java.util.HashMap;

public class Inventory {
    private HashMap<String, Integer> lootMap = new HashMap<>();

    public void addLoot(String name, int amount) {
        if(amount <= 0 || name == null || name.isEmpty() ) {
            throw new IllegalArgumentException("Error, amount or name is null or empty");
        }

        lootMap.put(name, lootMap.getOrDefault(name,  0)+ amount);
    }
    public Integer getItemCount(String name) {
        if(name == null || name.isEmpty() ) {
            throw new IllegalArgumentException("Error, name is null or empty");
        }
        return lootMap.getOrDefault(name, 0);
    }
    public void consumeLoot(String name, int amount){
        if(amount <= 0 || name == null || name.isEmpty() ) {
            throw new IllegalArgumentException("Error, amount or name is null or empty");
        }
        int itemCount = getItemCount(name);
        if(itemCount < amount) {
            throw new IllegalArgumentException("Error, amount is less than or equal to item count");
        }
        lootMap.put(name, itemCount - amount);
    }
    public void showAllLoot(){
        if(lootMap.isEmpty()){
            System.out.println("No items in this loot");
            return;
        }
        for (String name : lootMap.keySet()) {
            int count = getItemCount(name);
            System.out.println(name + ": " + count );
        }
    }
}
