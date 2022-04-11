package ngoapplication;
import java.util.*;
public class NGOMain
{
    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);
        int category;
        System.out.println("\t\t HEARTY WELCOME TO OUR WEBSITE ");
        System.out.println("\t\t MAY I KNOW HOW MAY WE HELP YOU ");
        System.out.println("**************** CATEGORIES **************");
        System.out.println("\t (1) VOLUNTEER \n\t (2) DONOR \n\t (3) NEEDY PEOPLE");
        System.out.println("****************************************");
        System.out.println("Enter the category you want to enter : ");
        category=s.nextInt();
        switch(category)
        {
            case 1:
                Volunteer v=new Volunteer();
                System.out.println("(1) You Now Register \t (2) Already Register only view");
                int choice = s.nextInt();
                switch (choice)
                {
                    case 1:
                    v.getPersonalDetails();
                    v.idGeneration();
                    v.display();
                    NGODetails.end();
                    break;
                    case 2:
                        v.view();
                        break;
                }
                break;
            case 2:
                Donor d = new Donor();
                d.getPersonalDetails();
                d.idGeneration();
                d.requirement();
                d.display();
                NGODetails.end();
                break;
            case 3:
                Needy np = new Needy();
                np.getPersonalDetails();
                np.idGeneration();
                np.requirement();
                np.display();
                NGODetails.end();
                break;
            default:
                System.out.println("Please enter a valid category");
                break;
        }
    }
}
