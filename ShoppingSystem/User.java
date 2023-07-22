package ShoppingSystem;

public class User {
    private int id;
    private String username;
    private String password;
    private String registrationTime;
    private String userLevel;
    private double totalExpense;
    private String phoneNumber;
    private String email;
    private boolean isAdmin;

    public User(int id, String username, String password, String registrationTime, String userLevel, double totalExpense, String phoneNumber, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.registrationTime = registrationTime;
        this.userLevel = userLevel;
        this.totalExpense = totalExpense;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.isAdmin = false;
    }

    public void setId(int ID){
        id = ID;
    }

    public  int getId(){
        return id;
    }

    public void setUsername(String name){
        username = name;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password0){
        password = password0;
    }

    public String getPassword() {
        return password;
    }

    public void setRegistrationTime(String time){
        registrationTime = time;
    }

    public String getRegistrationTime(){
        return registrationTime;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setUserLevel(String level){
        userLevel = level;
    }

    public String getUserLevel(){
        return userLevel;
    }

    public  void setTotalExpense(double total){
        totalExpense = total;
    }

    public double getTotalExpense(){
        return totalExpense;
    }

    public void setPhoneNumber(String number){
        phoneNumber = number;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void setEmail(String mail){
        email = mail;
    }

    public String getEmail(){
        return email;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

}