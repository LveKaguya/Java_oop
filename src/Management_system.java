import java.util.Scanner;

public class Management_system {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        SelectionMenu menu = new SelectionMenu();
        Creation create = new Creation();
        GetInfo info = new GetInfo();
        CalcGPA gpa = new CalcGPA();
        Update_student update = new Update_student();
        Delete_student delete = new Delete_student();


        System.out.println("Hello");
        while(true){
            menu.selectionMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch(choice){ //Choices of actions for database menu.
                case 1:
                System.out.println("Enter students: Full Name, SSCI, IROS, Year of enrolling, Course, Financing");
                   create.createStudent(scanner.nextLine(), Double.parseDouble(scanner.nextLine()), Double.parseDouble(scanner.nextLine()), Integer.parseInt(scanner.nextLine()), Integer.parseInt(scanner.nextLine()), scanner.nextLine()); 
                   break; //Create a new student
                case 2:
                    info.getInfo(); //Print the whole table
                    break;
                case 3:
                    System.out.println("Enter student's ID:");
                    gpa.calcGPA(Integer.parseInt(scanner.nextLine()));
                    break; //Choice for caclulating GPA and inputing it into table
                case 4:
                    System.out.println("Enter Student's ID, new SSCI, new iROS, new Course, new Financing:");
                    update.updateStudent(Integer.parseInt(scanner.nextLine()), Double.parseDouble(scanner.nextLine()), Double.parseDouble(scanner.nextLine()), Integer.parseInt(scanner.nextLine()), scanner.nextLine());
                    break; //Choice for Updating student's information
                case 5:
                    System.out.println("Enter student's ID:");
                    delete.deleteStudent(Integer.parseInt(scanner.nextLine()));
                    break; //Delete student from the table by ID.
                case 0:
                    System.exit(0);
                    break; // Choice to exit the menu.

                default:
                    System.out.println("Avalible choices are only in range from 0 - 5.");




            }

        }
    }
}
