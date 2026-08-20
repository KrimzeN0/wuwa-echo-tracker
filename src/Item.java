public class Item {
    private String name;
    private int count;
    public Item(String name, int count){
    if (count < 0){
        throw new IllegalArgumentException("Count не может быть отрицательным");
    }

        this.name = name;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public String getName() {
        return name;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setName(String name) {
        this.name = name;
    }
}
