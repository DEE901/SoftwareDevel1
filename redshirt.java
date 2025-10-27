public class redshirt extends shirt {
    private String brandName;


    public redshirt(String size, String color, String brandName) {
        super(size, color);
        this.brandName = brandName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @Override
    public void displayShirtDetails() {
        super.displayShirtDetails();
        System.out.println("Brand Name: " + brandName);
        System.out.println("This is a red shirt!");
    }

    public static void main(String[] args) {
        redshirt myRedShirt = new redshirt("medium", "red", "Nike");
        myRedShirt.displayShirtDetails();
    }

}
