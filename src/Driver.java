// AUSTEN CRUZ
// CSC 161 MIDTERM PROJECT
// 17 EXISTING MOVIES IN LIST
// PASSWORD: 123456 --- ENCRYPTED --- 3 ATTEMPTS ALLOWED

import java.util.Scanner;


public class Driver extends Sorting {
    public static String typedPassword;
    public static Methods methods = new Methods();
    private static String password = Encryption.encryptPassword("123456");
    public static void main(String[] args) {

        Scanner stdIn = new Scanner(System.in);
        String username;
        String password = Encryption.encryptPassword("123456");
        int sortChoice;
        int searchChoice;
        int guestChoice = 0;
        boolean tryAgain = true;
        methods.fillArray();
        MainMenu dialog = new MainMenu();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);


//        do {
//            System.out.println("Main Menu.\nEnter A for Admin, C for customer or Q to quit.");
//            username = stdIn.next().toLowerCase();
//            if (!username.equals("q")) {
//
//
//                boolean isValid;
//                switch (username) {
//
//                    case "a":
//                        for (int i = 0; i < 3; i++) {
//                            System.out.println("Enter Password");
//                            typedPassword = stdIn.next();
//
//                            if (Encryption.encryptPassword(typedPassword).equals(password)) {
//
//                                System.out.println("1. Display All\n2. Search\n3. Add Movies\n" +
//                                        "4. Remove Movies\n5. Sort\n6. Main Menu");
//
//                                while (!stdIn.hasNextInt()) {
//                                    System.out.println("Invalid Entry. Select either from one of the above options.");
//                                    stdIn.next();
//                                }
//                                searchChoice = stdIn.nextInt();
//
//                                switch (searchChoice) {
//
//                                    case 1:
//                                        System.out.println(methods.toString());
//                                        break;
//
//                                    case 2:
//                                        methods.searchMovie();
//                                        break;
//
//
//                                    case 3:
//                                        methods.addMovies();
//                                        System.out.println(methods.toString());
//                                        break;
//
//                                    case 4:
//
//                                        methods.removeMovie();
//                                        break;
//
//                                    case 5:
//
//                                        sortFound(stdIn,movieList);
//                                        break;
//
//                                    case 6:
//                                        i = 3;
//                                        break;
//                                    default:
//                                        System.out.println("Invalid selection.");
//
//
//                                }
//                            } else {
//                                System.out.println("Invalid Password! " + (2 - i) + " attempt(s) remaining.");
//                            }
//                        }
//                        break;
//                    case "c":
//
//
//                        System.out.println("1. Display All\n2. Search\n3. Sort\n4. Main Menu");
//
//                        isValid =false;
//                        while(!isValid) {
//                            while (!stdIn.hasNextInt()) {
//                                System.out.println("Number not entered. Enter 1, 2, 3, or 4");
//                                stdIn.next();
//                            }
//                            guestChoice = stdIn.nextInt();
//                            if (guestChoice != 1 && guestChoice != 2 && guestChoice !=3 && guestChoice != 4) {
//                                System.out.println("Select either 1, 2, 3, or 4");
//                                continue;
//                            }
//                            isValid = true;
//                        }
//                        switch (guestChoice) {
//                            case 1:
//                                System.out.println(methods.toString());
//                                break;
//
//                            case 2:
//                                methods.searchMovie();
//                                break;
//
//                            case 3:
//                                System.out.println("1. Quick Sort\n" +
//                                        "2. Bubble Sort");
//                                sortChoice = 0;
//                                getSortChoice(stdIn, sortChoice);
//                                long time = sortMovies(sortChoice);
//                                System.out.println(methods.toString());
//                                System.out.println("List sorted in " + time + " nano seconds.");
//
//                                break;
//                            case 4:
//                                break;
//                            default:
//                                System.out.println("Invalid Entry");
//                        }
//                        break;
//                    default:
//                        System.out.println("Entry invalid.");
//                }
//
//
//
//            } else {
//                System.out.println("Goodbye!");
//                tryAgain = false;
//
//            } } while (tryAgain);
    }
    public static void setTypedPassword(String password){
        typedPassword = password;
    }

    public static boolean testPassword(){
        return password.equals(Encryption.encryptPassword(typedPassword));
    }



}