package ngoapplication;
import com.location.Location;
import java.sql.*;
import java.util.*;
public class Needy implements NGODetails
{
        Scanner input=new Scanner(System.in);
        String DB_URL = "jdbc:mysql://localhost/NGO";
        final String USER = "root";
        final String PASS = "root";
        String first_name,last_name,city,needy_ID,amount;
        String item,office,mobile_number,occupation,bank_Name,acc_name,ifsc,branch,upi_id,acc_no;
        int quantity,age;
        public void getPersonalDetails()
        {
            System.out.println("Enter your First Name : ");
            first_name=input.nextLine();
            System.out.println("Enter your Last Name : ");
            last_name=input.nextLine();
            System.out.println("Enter your Age : ");
            age=input.nextInt();
            input.nextLine();
            System.out.println("Enter your Occupation : ");
            occupation=input.nextLine();
            System.out.println("Enter Phone Number : ");
            mobile_number=input.nextLine();
            if(mobile_number.length()!=10)
            {
                System.out.println("Invalid phone number......... Enter valid phone number.");
                System.exit(0);
            }
            System.out.println("Enter current City : ");
            city=input.nextLine();
            System.out.println("Marital Status : ");
            String status=input.nextLine();
            office = Location.findNearestHub(city);
        }
        public void idGeneration()
        {
            Random r=new Random();
            int rn=r.nextInt(1000000);
            needy_ID=Integer.toString(rn);
            needy_ID="NGO-N"+needy_ID;
            System.out.println("------------YOU HAVE REGISTERED SUCCESSFULLY----------");
            System.out.println("Name: "+first_name+" "+last_name);
            System.out.println("Registration No: "+needy_ID);
            System.out.println("------------------------------------------------------");
        }
        public void requirement()
        {
            int option;
            System.out.println("-----------OPTIONS-----------");
            System.out.println("\t (1) GOODS \n\t (2) MONEY \n\t (3) GOODS AND MONEY");
            System.out.println("-----------------------------");
            System.out.println("Enter your choice : ");
            option = input.nextInt();
            input.nextLine();
            switch (option)
            {
                case 1:

                        System.out.println("Enter the Item : ");
                        item = input.nextLine();
                        System.out.println("Enter the Quantity : ");
                        quantity = input.nextInt();
                    System.out.println("We request you to collect the goods from our nearest hub "+office);
                    break;
                case 2:
                    amountNeeded();
                    modeOfTransaction();
                    break;
                case 3:
                        System.out.println("Enter the Item : ");
                        item = input.nextLine();
                        System.out.println("Enter the Quantity : ");
                        quantity = input.nextInt();
                    System.out.println("We request you to collect the goods from our nearest hub "+office);
                    input.nextLine();
                    amountNeeded();
                    modeOfTransaction();
                    break;
                default:
                    System.out.println("Invalid Option >>>>>>> Please Enter valid option");
                    System.exit(0);
            }
        }
        public void modeOfTransaction()
        {
            System.out.println("----------------- OPTIONS -------------------");
            System.out.println("\n1)Bank \n2)UPI \n3)Cash");
            System.out.println("----------------------------------------------");
            System.out.println("Enter your Option : ");
            String option1=input.nextLine();
            switch (option1)
            {
                case "1" :
                    System.out.println("******* Your Bank Details *********");
                    System.out.println("Bank Name : ");
                    bank_Name = input.nextLine();
                    System.out.println("Account Number : ");
                    acc_no = input.nextLine();
                    System.out.println("Account Holder Name : ");
                    acc_name = input.nextLine();
                    System.out.println("IFSC Code : ");
                    ifsc = input.nextLine();
                    System.out.println("Branch: ");
                    branch = input.nextLine();
                    System.out.println("City : ");
                    String bank_city = input.nextLine();
                    break;
                case "2" :
                    System.out.println("****** UPI ID *******");
                    System.out.println("Enter your upi_id no : ");
                    upi_id = input.nextLine();
                    break;
                case "3":
                    System.out.println("We request you to collect the cash from our nearest hub " + office);
                    break;
                default:
                    System.out.println("Invalid Option >>>>>> Please Enter valid option");
                    System.exit(0);
            }
        }
        public void amountNeeded()
        {
            System.out.println("----------------- REASONS --------------------");
            System.out.println("* Education\n* Medical\n* Women Empowerment\n* Unemployed");
            System.out.println("--------------------------------------------");
            System.out.println("Enter the Reason : ");
            String reason=input.nextLine();
            String convert_reason=reason.toLowerCase();
            switch (convert_reason)
            {
                case "education" :
                    amount = "25000";
                    break;
                case "medical" :
                    amount = "30000";
                    break;
                case "women empowerment" :
                    amount = "20000";
                    break;
                case "unemployed":
                    amount = "10000";
                    break;
                default :
                    System.out.println("Sorry.  We Need a Valid Reason to help you. Retry with a Valid Reason.");
                    System.exit(0);
            }
        }
        public void display()
        {
            try
            {
                Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement statement = conn.createStatement();
                String sql = "INSERT INTO Needy_People VALUES('"+needy_ID+"','"+first_name+"','"+last_name+"',"+age+",'"+occupation+"','"+mobile_number+"','"+city+"')";
                String sql1 = "INSERT INTO Needy_Receive (Needy_Id,Item ,Amount ,Account_Holder_Name,Account_Number,IFSC_Code,Branch_Name,Bank_Name,UPI_ID,Receive_Location) VALUES('"+needy_ID+"','"+item+"','"+amount+"','"+acc_name+"','"+acc_no+"','"+ifsc+"','"+branch+"','"+bank_Name+"','"+upi_id+"','"+office+"')";
                statement.executeUpdate(sql);
                statement.executeUpdate(sql1);
                System.out.println("Thank You...!");
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }

    public void view()
    {
        String value;
        System.out.println("Enter your Needy_ID : ");
        value = input.nextLine();
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement statement = conn.createStatement();
            System.out.println("Your Details Here..");
            String sql2 ="select * from NGO.needy_people where Needy_Id = '"+value+"'";
            ResultSet resultSet1 = statement.executeQuery(sql2);
            while(resultSet1.next())
            {
                System.out.println("-------------------------------------------------------------");
                System.out.println("Your Needy ID is : "+resultSet1.getString("Needy_Id"));
                System.out.println("Name   : " +resultSet1.getString("First_name")+""+resultSet1.getString("Last_name"));
                System.out.println("City   : "+resultSet1.getString("City"));
            }
            String sql1 ="select * from NGO.needy_receive where Needy_Id = '"+value+"'";
            ResultSet resultSet = statement.executeQuery(sql1);
            while (resultSet.next())
            {
                System.out.println("Your Received Location is :"+resultSet.getString("Receive_Location"));
                System.out.println("--------------------------------------------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

