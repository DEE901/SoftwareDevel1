public class redshirt extends shirt implements comparable<redshirt> {
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

    @Override
    public int compareTo(redshirt other) {
        return this.getSize().compareTo(other.getSize());
    }

    public static void main(String[] args) {
        redshirt myRedShirt = new redshirt("medium", "red", "Nike");
        myRedShirt.displayShirtDetails();

        redshirt anotherShirt = new redshirt("large", "red", "Adidas");
        int comparisonResult = myRedShirt.compareTo(anotherShirt);

        if (comparisonResult < 0) {
            System.out.println("\n" + myRedShirt.getSize() + " comes before " + anotherShirt.getSize() + " alphabetically.");
        } else if (comparisonResult > 0) {
            System.out.println("\n" + myRedShirt.getSize() + " comes after " + anotherShirt.getSize() + " alphabetically.");
        } else {
            System.out.println("\n" + myRedShirt.getSize() + " and " + anotherShirt.getSize() + " are the same.");
        }
    }

}
