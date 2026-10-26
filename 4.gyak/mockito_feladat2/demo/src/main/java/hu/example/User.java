package hu.example;

public class User {
    private String userName;
    private String password;
    private int id;
    private int loginCount;
    private boolean loggedIn;
    private final UserDatabase userDatabase;

    public User() {
        this(new UserDatabase());
    }

    public User(UserDatabase userDatabase) {
        this.userName = null;
        this.password = null;
        this.id = 0;
        this.loginCount = 0;
        this.loggedIn = false;
        this.userDatabase = userDatabase;
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

    public String getUserName() { return userName; }
    public String getPassword() { return password; }
    public int getId() { return id; }
    public int getLoginCount() { return loginCount; }

    public boolean updatePwd(String newPwd, boolean isLoggedIn) {
        if (!isLoggedIn) {
            return false;
        }
        userDatabase.setPassword(id, newPwd);
        this.password = newPwd;
        return true;
    }
}