import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Contiguous  ctgs =new Contiguous ();
    private ArrayList<User>users=new ArrayList <> ();
    private User admin = new User ();
    public void main (String[] args) {
        this.admin.setUsername ("admin");
        this.admin.setPassword ("admin");
        this.admin.setRole ("admin");


    }
    private void TellUser(User us)
    {
        System.out.println ("Current User:- " + us.getUsername ());
        System.out.println ("your role:- "+us.getRole ());
    }
    private void CUser()
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
    boolean Grant()
    {
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter user name :- ");
        String un =sc.nextLine ();
        String path;
        for (var us:users){
            if(us.getUsername ().equals (un))
            {
                System.out.print("\nPath+ Name Folder:- ");
                path=sc.nextLine ();
                String[] Folder = path.split ("/");
                File F = new File ();
                F.setName (Folder[Folder.length - 1]);
                F.setFilePath (path);
                Directory dir = ctgs.DirExist (ctgs.getRoot (),Folder,1,Folder.length-2);
                if(dir !=null)
                {

                }

            }
        }

    }
}
