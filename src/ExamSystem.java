import java.io.*;
import java.util.*;
public class ExamSystem {
        Scanner input = new Scanner(System.in);
        HashMap<String, Integer> data = new HashMap<String, Integer>();

        public void login() {
            data.put("Tejas", 0070);
            data.put("Ankit", 0000);
            System.out.println("\n\nWelcome to Exam Portal");
            String userid;
            int pwd;
            System.out.println("Please Login");
            System.out.print("Enter user id : ");
            userid = input.next();
            System.out.print("Enter password : ");
            pwd = input.nextInt();
            if (data.containsKey(userid) && data.get(userid) == pwd) {
                System.out.println("Logged In!!");
                option_menu();
            } else if(!data.containsKey(userid)){
                System.out.println("Sorry, Invalid User Id");
                System.out.println("Enter User Id again");
                login();
            } else if (data.get(userid)!=pwd) {
                System.out.println("Sorry, Invalid Password");
                System.out.println("Enter your password again");
                login();
            }
        }

        public void option_menu() {
            int select;
            System.out.println("1.Update profile and password ");
            System.out.println("2.Start the exam ");
            System.out.println("3.Logout ");
            select = input.nextInt();
            switch (select) {
                case 1:
                    data = update();
                    option_menu();
                    break;
                case 2:
                    exam_que();
                    option_menu();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Option");
            }
        }

        public HashMap<String, Integer> update() { // update profile
            String user_id;
            int user_pwd;
            System.out.println("Update profile");
            System.out.println("Enter new user name: ");
            user_id = input.next();
            if (data.containsKey(user_id)) {
                System.out.println("Enter new password: ");
                user_pwd = input.nextInt();
                data.replace(user_id, user_pwd);
            } else {
                System.out.println("User doesn't exist");
            }
            return data;
        }

        public void exam_que() {
            long examTime = System.currentTimeMillis();
            long endTime = examTime + 30;
            int ansCount = 0;
            int ans, score;
            System.out.println("Start the exam");
            while (System.currentTimeMillis() < endTime) {
                System.out.println("You have 30 seconds to answer 5 questions");
                System.out.println("Each question carries 10 marks and -5 for wrong answer");
                System.out.println("\n\nQ1. Number of primitive data types in Java are?");
                System.out.println("\n1)6" + "\t" + "2)5" + "\t" + "3)8" + "\t" + "4)9");
                System.out.println("Enter the answer");
                ans = input.nextInt();
                System.out.println("Answer Locked...");
                if (ans == 3) {
                    ansCount++;
                }
                System.out.println("\n\nWhat is the size of float and double in java?");
                System.out.println("1)32" + "\t" + "2)64 and 64" + "\t" + "3)32 and 64" + "\t" + "4)32 and 32");
                System.out.println("Enter correct option");
                ans = input.nextInt();
                System.out.println("Answer Locked...");
                if (ans == 3) {
                    ansCount++;
                }
                System.out.println("\n\nWho invented Java Programming?");
                System.out.println("1)Bjarne Stroustrup" + "\t" + "2)James Gosling" + "\t" + "3)Guido van Rossum" + "\t"
                        + "4)Dennis Ritchie");
                System.out.println("Enter correct option");
                ans = input.nextInt();
                System.out.println("Answer Locked...");
                if (ans == 2) {
                    ansCount++;
                }
                System.out.println("\n\nWhich one of the following is not a Java feature?");
                System.out.println("1) Dynamic and Extensible" + "\t" + "2) Portable" + "\t" + "3) Object-oriented" + "\t"
                        + "4) Use of pointers");
                System.out.println("Enter correct option");
                ans = input.nextInt();
                System.out.println("Answer Locked...");
                if (ans == 4) {
                    ansCount++;
                }
                System.out.println("\n\nWhich of the following is not an OOPS concept in Java?");
                System.out.println(
                        "1) Compilation" + "\t" + "2) Encapsulation" + "\t" + "3) Inheritance" + "\t" + "4) Polymorphism");
                System.out.println("Enter correct option");
                ans = input.nextInt();
                System.out.println("Answer Locked...");
                if (ans == 1) {
                    ansCount++;
                }
                break;
            }
            System.out.println("You have finished the exam");
            score = ansCount * 10 - ((5 - ansCount) * 5); // Score Counting
            System.out.println("Your score is " + score + " / 50");
        }

        public static void main(String[] args) {
            ExamSystem log = new ExamSystem();
            log.login();
        }
}

