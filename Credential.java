public class Credential {

    private String website;
    private String username;
    private String password;

    Credential(String website, String username, String password) {
        setUserName(username);
        setWebsite(website);
        setpassword(password);
    }

    public void setWebsite(String website) {
        if (website == null) {
            throw new IllegalArgumentException("Website cannot be Null");
        } else if (website.trim().isEmpty()) {
            throw new IllegalArgumentException("Website should not be empty ");
        }
        this.website = website.trim().toLowerCase();
    }

    public void setUserName(String username) {
        if (username == null) {
            throw new IllegalArgumentException("User Name cannot be Null");
        } else if (username.trim().isEmpty()) {
            throw new IllegalArgumentException("User Name should not be empty ");
        }
        this.username = username.trim().toLowerCase();
    }

    public void setpassword(String password) {
        if (password == null) {
            throw new IllegalArgumentException("PassWord cannot be Null");
        } else if (password.trim().isEmpty()) {
            throw new IllegalArgumentException("PassWord should not be empty ");
        }
        this.password = password.trim();
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getWebsite() {
        return website;
    }

  @Override
public String toString()
{
    return "Website  : " + website + "\n" +
           "Username : " + username + "\n" +
           "Password : ********";
}
}
