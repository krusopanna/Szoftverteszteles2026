package hu.example;

public class User {
    private String userName;
    private String password;
    private int id;
    private int loginCount;
    private boolean loggedIn;

    public User() {
        this.userName = null;
        this.password = null;
        this.id = 0;
        this.loginCount = 0;
        this.loggedIn = false;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void login() {
        this.loggedIn = true;
        this.loginCount++;
    }

    public void logout() {
        this.loggedIn = false;
    }

    public boolean updatePwd(String newPwd, boolean isLoggedIn) {
        throw new UnsupportedOperationException("A jelszófrissítés még nincs implementálva!");
    }

    public String getUserName() { return userName; }
    public String getPassword() { return password; }
    public int getId() { return id; }
    public int getLoginCount() { return loginCount; }
}