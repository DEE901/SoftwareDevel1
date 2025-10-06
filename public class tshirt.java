public class tshirt {
    private String size;
    private String color;

    public tshirt(String size, String color) {
        this.size = size;
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String large) {
        this.size = large;
    }

    public String getColor(String red) {
        return color;
    }

    public void setColor(String red) {
        this.color = red;
    }

    @Override
    public String toString() {
        return "tshirt{" +
                "size='large" + size + '\'' +
                ", color='red" + color + '\'' +
                '}';
    }
}

