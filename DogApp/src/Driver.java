public class Driver {
    public static void main(String[] args) {

        //creates the new corgi and sets the topTrick
        Corgi newCorgi = new Corgi("cattle herding", "Pembroke Welsh Corgi", "Java", 38, 5);
        newCorgi.setTopTrick("ringing the bell to go outside");

        //Outputs the toString() call from the classes.
        System.out.println(newCorgi.toString());

    }

}
