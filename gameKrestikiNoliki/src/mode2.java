public class mode2 {
    public static String exampleMode2 = "012345678";

    public static void main(String[] args) {
        for (int i = 0; i <= 2; i++) {
            for (int j = 1; j < 36; j++) {
//                if(j == 4){
//                    System.out.print(exampleMode2.charAt(0));
//
//                }
               switch(j){
                   case 4 -> System.out.print(exampleMode2.charAt(1));
                   case 9 -> exampleMode2.charAt(1);
               }
                if(j%6 == 0)
                System.out.print("|");
                else System.out.print(" ");
            }if(i != 2)
            System.out.println("\n ––––––––––––––– | –––––––––––––––");
        }
    }
}
