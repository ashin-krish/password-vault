import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PasswordVault {
    private ArrayList<Credential> vault;

    private void loadFromFile() {
        try {
            File file = new File("password.txt");

            if (!file.exists()) {
                return;
            }

            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String line = sc.nextLine();

                String[] data = line.split(",");

                if (data.length == 3) {
                    String website = data[0];
                    String username = data[1];
                    String password = data[2];

                    Credential credential = new Credential(website,username,password);

                    vault.add(credential);
                }
            }

            sc.close();
        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
    }

    public PasswordVault() {
        vault = new ArrayList<>();
        loadFromFile();
    }

    private boolean credentialExists(String website, String username) {
        for (Credential existingCredential : vault) {
            if (existingCredential.getWebsite().equals(website) && existingCredential.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public void addCredential(Credential credential) {
        boolean isSame = credentialExists(credential.getWebsite(), credential.getUsername());

        if (isSame) {
            System.out.println("The password already Exists");

        } else {
            try {
                FileWriter fw = new FileWriter("password.txt", true);

                vault.add(credential);

                fw.write(credential.getWebsite() + "," +
                        credential.getUsername() + "," +
                        credential.getPassword());

                fw.write(System.lineSeparator());
                System.out.println(" Password succesfully Stored ....... ");
                fw.close();

            } catch (IOException e) {
                System.out.println("Erorr : " + e);
            }
        }
    }

    public void viewAllCredential() {

        if (vault.isEmpty()) {
            System.out.println("The Valut Is Empty");
        }

        for (Credential existingCredential : vault) {

            System.out.println(existingCredential);

        }
    }

    public Credential searchCredential(String website, String username) {
        for (Credential existingCredential : vault) {
            if (existingCredential.getUsername().equals(username) && existingCredential.getWebsite().equals(website)) {
                return existingCredential;
            }

        }
        return null;
    }

    public String revealPassword(String website, String username) {
        Credential foundCredential = searchCredential(website, username);

        if (foundCredential == null) {
            return null;
        }
        return foundCredential.getPassword();
    }

    private void saveToFile()
{
    try
    {
        FileWriter fw = new FileWriter("password.txt");

        for(Credential credential : vault)
        {
            fw.write(
                credential.getWebsite() + "," +
                credential.getUsername() + "," +
                credential.getPassword()
            );

            fw.write(System.lineSeparator());
        }

        fw.close();
    }
    catch(IOException e)
    {
        System.out.println("Error : " + e);
    }
}

    public void UpdatePassword(String website, String username, String password) {
        Credential foundCredential = searchCredential(website, username);

        if (foundCredential != null) 
        {
            foundCredential.setpassword(password);
            saveToFile();
            System.out.println("Password Succesfully Saved");

        } 
        else 
        {
            System.out.println("No Credential found");
        }

    }
        public void deletePassword(String website, String username)
        {
            Credential foundCredential = searchCredential(website, username);

            if(foundCredential != null)
            {
                vault.remove(foundCredential);
                saveToFile();
                System.out.println(" Password Deleted Succesfully ");
            }
            else{
                System.out.println("No Credential Found ");
            }
        }

}
