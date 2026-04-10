// Deegan Hansen
// for software development 1
// debugging my past tshirt code with debug statements

public class tshirt {
    // to Debug set to true to enable debugging, false to disable
    private static final boolean DEBUG = true;

    private String size;
    private String color;

    public tshirt(String size, String color) {
        // Track when objects are being instantiated and what values are passed in
        // I want to verify the constructor is called with correct parameters
        if (DEBUG) {
            System.out.println("[DEBUG] Constructor called with size='" + size + "', color='" + color + "'");
        }
        
        this.size = size;
        this.color = color;
        
        // Debug Verify that the values were actually assigned to the instance variables
        if (DEBUG) {
            System.out.println("[DEBUG] After assignment: this.size='" + this.size + "', this.color='" + this.color + "'");
        }
    }

    public String getSize() {
        // Track when getSize is called and what value is being returned
        // This helps catch if size is null or has unexpected values
        if (DEBUG) {
            System.out.println("[DEBUG] getSize() called, returning: '" + size + "'");
        }
        return size;
    }

    public void setSize(String large) {
        // Log the old value and new value when setSize is called
        // This helps verify that setters are being used correctly and values are actually changing
        if (DEBUG) {
            System.out.println("[DEBUG] setSize() called - old value: '" + this.size + "', new value: '" + large + "'");
        }
        
        this.size = large;
        
        // Debug Confirm the value was actually updated
        if (DEBUG) {
            System.out.println("[DEBUG] After setSize: this.size is now '" + this.size + "'");
        }
    }

    public String getColor(String red) {
        // Note that this method takes a parameter 'red' but doesn't use it
        // This is likely a bug - I am logging it to show the issue
        if (DEBUG) {
            System.out.println("[DEBUG] getColor('" + red + "') called - WARNING: parameter 'red' is unused!");
            System.out.println("[DEBUG] getColor() returning: '" + color + "'");
        }
        return color;
    }

    public void setColor(String red) {
        // Log the old value and new value when setColor is called
        // Verify that the setter is working as expected
        if (DEBUG) {
            System.out.println("[DEBUG] setColor() called - old value: '" + this.color + "', new value: '" + red + "'");
        }
        
        this.color = red;
        
        // Debug Confirm the color was successfully updated
        if (DEBUG) {
            System.out.println("[DEBUG] After setColor: this.color is now '" + this.color + "'");
        }
    }

    @Override
    public String toString() {
        // Log when toString is called and what it's about to return
        // Helps verify the formatted output and catch any concatenation issues
        if (DEBUG) {
            System.out.println("[DEBUG] toString() called");
        }
        
        String result = "tshirt{" +
                "size='" + size + '\'' +
                ", color='" + color + '\'' +
                '}';
        
        // Debug it Shows the final formatted string before returning
        if (DEBUG) {
            System.out.println("[DEBUG] toString() returning: '" + result + "'");
        }
        
        return result;
    }
}