import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        ArrayList<User>users=new ArrayList <> ();
        User admin = new User ();
        admin.setUsername ("admin");
        admin.setPassword ("admin");
        admin.setRole ("admin");

    }
    private void TellUser(User us)
    {
        System.out.println ("Current User:- " + us.getUsername ());
        System.out.println ("your role:- "+us.getRole ());
    }
    private void CUser(ArrayList<User>users)
    {
        Scanner sc= new Scanner(System.in);
        System.out.print ("Enter Username: ");
        String un = sc.nextLine ();
        for (var us:users){
            if(us.getUsername ().equals (un))
            {
                System.out.println ("\nUser is already exist");
                return;
            }
        }
        System.out.print ("\n Enter Password :- ");
        String pass = sc.nextLine ();
        User us = new User ();
        us.setUsername (un);
        us.setPassword (pass);
        users.add (us);
    }
    void login()
    {

    }
}
