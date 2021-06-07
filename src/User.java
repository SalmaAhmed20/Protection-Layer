import java.util.ArrayList;

public class User {
    private String username;
    private String  password;
    private String role ="user";
    private ArrayList <Triplet<String, Integer, Integer>> Cabilities= new ArrayList<>();
    public String getUsername () {
        return username;
    }

    public void setUsername (String username) {
        this.username = username;
    }

    public String getPassword () {
        return password;
    }

    public void setPassword (String password) {
        this.password = password;
    }

    public String getRole () {
        return role;
    }

    public void setRole (String role) {
        this.role = role;
    }

    public ArrayList <Triplet <String, Integer, Integer>> getCabilities () {
        return Cabilities;
    }

    public void setCabilities (ArrayList <Triplet <String, Integer, Integer>> cabilities) {
        Cabilities = cabilities;
    }





}
