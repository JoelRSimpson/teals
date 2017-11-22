package teals.org;

public class Fundamentals {

    //this creates a place to store an Integer called classVariable and it can be used anywhere in this class
    private static int classVariable = 10;

    /**
     *
     * @param myMethodParameter An example of a method parameter, it can be used anywhere in this method
     * @return int
     */
    private static int myMethod(int myMethodParameter){

        String methodVariable = "What??"; //This is creating a place to store a String and immediately storing "What??" in it.

        classVariable += myMethodParameter;
        System.out.println("Class Variable:" + classVariable);

        return classVariable; //the current value of classVariable is being returned
    }

    public static void main(String[] args) {
        int result; //this is a method variable, only usable in this method main(){}.

        //the following two method calls are equivalent, both call myMethod and pass in the value of 10;
        int ten = 10;
        result = myMethod(10);
        result = myMethod(ten);


        //This is the ONLY way (for now) to see anything happen when running our program.
        // Calling functions, assigning variables, and all other activities happen in the computer behind the scenes.
        System.out.println(result);
    }
}
