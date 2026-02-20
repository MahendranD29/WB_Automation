package qa.data.testdata;

public class ABCD {
//    public static void main(String[] args) {


    // java
// File: `src/test/java/tests/ProductNameExamples.java`
//    public class ProductNameExamples {

        private static String generateProductName(int index) {
            return "AutoProduct_" + index;
        }

        private static String generateMappedProductName(int index) {
            return String.format("Prod_%03d", index);
        }

        private static String sampleUnit(int index) {
            return (index % 2 == 0) ? "KG" : "pcs";
        }

        private static String sampleCategory(int index) {
            return "Category_" + ((index % 5) + 1);
        }

        private static int samplePurchasePrice(int index) {
            return 50 + index; // simple deterministic rule
        }

        private static int sampleSellingPrice(int index) {
            return 100 + index;
        }

        public static void main(String[] args) {
            System.out.println("Example names using AutoProduct_<n> pattern:");
            for (int i = 1; i <= 10; i++) {
                System.out.printf("%s  | unit: %s  | category: %s  | purchase: %d  | selling: %d%n",
                        generateProductName(i),
                        sampleUnit(i),
                        sampleCategory(i),
                        samplePurchasePrice(i),
                        sampleSellingPrice(i));
            }

            System.out.println("\nExample names using Prod_\\_NNN pattern:");
            for (int i = 1; i <= 10; i++) {
                System.out.printf("%s  | unit: %s  | category: %s  | purchase: %d  | selling: %d%n",
                        generateMappedProductName(i),
                        sampleUnit(i),
                        sampleCategory(i),
                        samplePurchasePrice(i),
                        sampleSellingPrice(i));
            }
        }
    }


