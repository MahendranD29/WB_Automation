package qa.data.testdata;

public class A {



        // Online Java Compiler
// Use this editor to write, compile and run your Java code online


        public static void main(String[] args) {

            int rev =0;

            for(int i = 459; i>=0;i++){

                int n = i%10;
                rev = (rev*10)+n;
                i = i/10;


            }
            System.out.println(rev);





    }

}
