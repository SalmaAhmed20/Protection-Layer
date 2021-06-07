import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Contiguous  ctgs =new Contiguous ();


    public static void main (String[] args) {
        ArrayList<User>users=new ArrayList <> ();
        User admin = new User ();
        ArrayList<Triplet<String, Integer, Integer>> t = new ArrayList <> ();
        t.add (new Triplet <> (ctgs.getRoot ().getDirectoryPath (),1,1));
        ctgs.CreateFolder ("VFSD:/Folder1");
        admin.setUsername ("admin");
        admin.setPassword ("admin");
        admin.setRole ("admin");
        admin.setCabilities (t);
        users.add (admin);
        User us = new User ();
        us.setUsername ("ahmed");
        us.setPassword ("pass123");
        us.setCabilities (t);


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
    boolean Grant(ArrayList<User>users)
    {
        Scanner sc= new Scanner(System.in);
        String un =sc.nextLine ();
        String[] parse=un.split (" ");
        for (var us:users){
            if(us.getUsername ().equals (parse[0]))
            {
                String[] Folder = parse[1].split ("/");
                File F = new File ();
                F.setName (Folder[Folder.length - 1]);
                F.setFilePath (parse[1]);
                Directory dir = ctgs.DirExist (ctgs.getRoot (),Folder,1,Folder.length-2);
                if(dir !=null)
                {
                    System.out.println ("Create \t Delete \t Comment");
                    System.out.println ("00) 0 \t   0 \t No Create,No Delete");
                    System.out.println ("01) 0 \t   1 \t No Create, Delete");
                    System.out.println ("10) 1 \t   0 \t Create   , No Delete");
                    System.out.println ("11) 1 \t   1 \t Create   , Delete");
                    switch (parse[2]) {
                        case "00" -> {
                            ArrayList <Triplet <String, Integer, Integer>> t = us.getCabilities ();
                            int i = 0;
                            for (var p : t){
                                if(p.getFirst ().equals (parse[1])) {
                                    t.remove (i);
                                    t.add (i,new Triplet <> (parse[1],0,0));
                                    us.setCabilities (t);
                                    return true;
                                }
                                i++;
                            }
                        }
                        case "01" -> {
                            ArrayList <Triplet <String, Integer, Integer>> t = us.getCabilities ();
                            int i = 0;
                            for (var p : t){
                                if(p.getFirst ().equals (parse[1])) {
                                    t.remove (i);
                                    t.add (i,new Triplet <> (parse[1],0,1));
                                    us.setCabilities (t);
                                    return true;
                                }
                                i++;
                            }
                        }
                        case "10" -> {
                            ArrayList <Triplet <String, Integer, Integer>> t = us.getCabilities ();
                            int i = 0;
                            for (var p : t){
                                if(p.getFirst ().equals (parse[1])) {
                                    t.remove (i);
                                    t.add (i,new Triplet <> (parse[1],1,0));
                                    us.setCabilities (t);
                                    return true;
                                }
                                i++;
                            }
                        }
                        case "11" -> {
                            ArrayList <Triplet <String, Integer, Integer>> t = us.getCabilities ();
                            int i = 0;
                            for (var p : t){
                                if(p.getFirst ().equals (parse[1])) {
                                    t.remove (i);
                                    t.add (i,new Triplet <> (parse[1],1,1));
                                    us.setCabilities (t);
                                    return true;
                                }
                                i++;
                            }
                        }
                        default -> System.out.println ("Capability not exist ");
                    }
                }else
                    System.out.println ("File not exist");
            }else
                System.out.println ("User not exist");
        }
        return  false;
    }
}
