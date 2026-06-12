import java.util.Scanner;

public class Main 
{
     public static void showMenu()
{
    System.out.println("========================================================");

    System.out.println("  ██████╗  █████╗ ███████╗███████╗");
    System.out.println("  ██╔══██╗██╔══██╗██╔════╝██╔════╝");
    System.out.println("  ██████╔╝███████║███████╗███████╗");
    System.out.println("  ██╔═══╝ ██╔══██║╚════██║╚════██║");
    System.out.println("  ██║     ██║  ██║███████║███████║");
    System.out.println("  ╚═╝     ╚═╝  ╚═╝╚══════╝╚══════╝");

    System.out.println();
    System.out.println("              PASSWORD VAULT");

    System.out.println();
    System.out.println("========================================================");

    System.out.println("1. ADD CREDENTIAL");
    System.out.println("2. VIEW VAULT");
    System.out.println("3. SEARCH");
    System.out.println("4. REVEAL PASSWORD");
    System.out.println("5. UPDATE PASSWORD");
    System.out.println("6. DELETE PASSWORD");
    System.out.println("7. EXIT");

    System.out.println();
    System.out.print("Command > ");
}

public static void showHeader(String title)
{
    System.out.println();
    System.out.println("========================================================");
    System.out.println("                 " + title);
    System.out.println("========================================================");
    System.out.println();
}

public static void main(String[] args) 
{
    Scanner sc = new Scanner(System.in);

    PasswordVault pv = new PasswordVault();
     Credential search;

    while(true)
{
    showMenu();

    int choice = sc.nextInt();
    sc.nextLine();

    if(choice == 7)
    {
        break;
    }

    switch(choice)
    {
        case 1:
            showHeader("Add Credential");
            String website;
            String username;
            String password;

            System.out.println(" Enter The website : ");
            website = sc.nextLine();
            System.out.println(" Enter the User Name : ");
            username = sc.nextLine();
            System.out.println(" Enter The Password : ");
            password = sc.nextLine();

            Credential c = new Credential(website, username, password);
            pv.addCredential(c);

            break;

        case 2:
            showHeader("View Vault");

            pv.viewAllCredential();

            break;

        case 3:
            showHeader(" Search ");

              System.out.println(" Enter The website : ");
            website = sc.nextLine();
            System.out.println(" Enter the User Name : ");
            username = sc.nextLine();

            search = pv.searchCredential(website, username);

            if(search==null)
            {
                System.out.println("No Credential Found");
            }
            else
            {
                System.out.println(search);
            }

            break;

        case 4:
            showHeader("Reveal Password");

              System.out.println(" Enter The website : ");
            website = sc.nextLine();
            System.out.println(" Enter the User Name : ");
            username = sc.nextLine();

            String pass = pv.revealPassword(website, username);
            

            if(pass == null)
            {
                System.out.println(" No Credential Found ");

            }

            else
            {
                  System.out.println(pass);
            }
            break;
        
        case 5:
            showHeader(" Update Password ");

             System.out.println(" Enter The website : ");
            website = sc.nextLine();
            System.out.println(" Enter the User Name : ");
            username = sc.nextLine();
            System.out.println(" Enter The New Password ");
            String newPass = sc.nextLine();

            pv.UpdatePassword(website, username, newPass);

            break;

        case 6:
            showHeader("Delete Password ");

               System.out.println(" Enter The website : ");
            website = sc.nextLine();

            System.out.println(" Enter the User Name : ");
            username = sc.nextLine();

            pv.deletePassword(website, username);
            break;






}
}
           sc.close();
}

}
