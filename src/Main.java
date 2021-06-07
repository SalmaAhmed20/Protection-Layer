import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Contiguous ctgs = new Contiguous ();

    public static void main (String[] args) {
        ArrayList<User> users = new ArrayList<> ();
        User admin = new User ();
        ArrayList<Triplet<String, Integer, Integer>> t = new ArrayList<> ();
        t.add (new Triplet<> (ctgs.getRoot ().getDirectoryPath (),1,1));
        ctgs.CreateFolder ("VFSD:/Folder1");
        t.add (new Triplet<> ("VFSD:/Folder1",1,1));
        ctgs.DisplayDiskStructure (ctgs.getRoot ());
        admin.setUsername ("admin");
        admin.setPassword ("admin");
        admin.setRole ("admin");
        admin.setCabilities (t);
        users.add (admin);
        User us = new User ();
        us.setUsername ("ahmed");
        us.setPassword ("pass123");
        us.setCabilities (new ArrayList<> (t));
        users.add (us);
        for (var uu:users){
            TellUser(uu);
            for (var p: uu.getCabilities ()){
                System.out.println (p.getFirst () + " " + p.getSecond () + " " + p.getThird ());
            }
        }
        for (var p: us.getCabilities ()){
            System.out.println (p.getFirst () + " " + p.getSecond () + " " + p.getThird ());
        }
        Grant (users);
        for (var uu:users){
            TellUser(uu);
            for (var p: uu.getCabilities ()){
                System.out.println (p.getFirst () + " " + p.getSecond () + " " + p.getThird ());
            }
        }
        Storeuserfile(users);
        StoreCapabilities (users);


    }

    public static void TellUser (User us) {
        System.out.println ("Current User:- " + us.getUsername ());
        System.out.println ("your role:- " + us.getRole ());
    }

    private void CUser (ArrayList<User> users) {
        Scanner sc = new Scanner (System.in);
        System.out.print ("Enter Username: ");
        String un = sc.nextLine ();
        for (var us: users){
            if(us.getUsername ().equals (un)) {
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

    void login () {

    }

    static boolean Grant (ArrayList<User> users) {
        Scanner sc = new Scanner (System.in);
        String un = sc.nextLine ();
        String[] parse = un.split (" ");
        int j =0;
        for (var us: users){
            if(us.getUsername ().equals (parse[0])) {
                String[] Folder = parse[1].split ("/");
                Directory dir = ctgs.DirExist2 (ctgs.getRoot (),Folder,0,Folder.length - 2);
                //System.out.println (dir.getName ());
                if(dir != null) {
                    System.out.println ("Create \t Delete \t Comment");
                    System.out.println ("00) 0 \t   0 \t No Create,No Delete");
                    System.out.println ("01) 0 \t   1 \t No Create, Delete");
                    System.out.println ("10) 1 \t   0 \t Create   , No Delete");
                    System.out.println ("11) 1 \t   1 \t Create   , Delete");
                    //System.out.println (parse[2]);
                    if(parse[2].equals ("00")) {
                        ArrayList<Triplet<String, Integer, Integer>> t = us.getCabilities ();
                        int i = 0;
                        for (var p: t){
                            //System.out.println (p.getFirst ());
                            if(p.getFirst ().equals (parse[1])) {
                                System.out.println (p.getFirst ());
                                t.remove (i);
                                t.add (i,new Triplet<> (parse[1],0,0));
                                us.setCabilities (t);
                                users.remove (j);
                                users.add (j,us);
                                return true;
                            }
                            i++;
                        }
                    }
                    if(parse[2].equals ("01")) {
                        ArrayList<Triplet<String, Integer, Integer>> t = us.getCabilities ();
                        int i = 0;
                        for (var p: t){
                            if(p.getFirst ().equals (parse[1])) {
                                t.remove (i);
                                t.add (i,new Triplet<> (parse[1],0,1));
                                us.setCabilities (t);
                                users.remove (j);
                                users.add (j,us);
                                return true;
                            }
                            i++;
                        }
                    }
                    if(parse[2].equals ("10")) {
                        ArrayList<Triplet<String, Integer, Integer>> t = us.getCabilities ();
                        int i = 0;
                        for (var p: t){
                            if(p.getFirst ().equals (parse[1])) {
                                t.remove (i);
                                t.add (i,new Triplet<> (parse[1],1,0));
                                us.setCabilities (t);
                                users.remove (j);
                                users.add (j,us);
                                return true;
                            }
                            i++;
                        }
                    }
                    if(parse[2].equals ("11")) {
                        ArrayList<Triplet<String, Integer, Integer>> t = us.getCabilities ();
                        int i = 0;
                        for (var p: t){
                            if(p.getFirst ().equals (parse[1])) {
                                t.remove (i);
                                t.add (i,new Triplet<> (parse[1],1,1));
                                us.setCabilities (t);
                                users.remove (j);
                                users.add (j,us);
                                return true;
                            }
                            i++;
                        }
                    }else System.out.println ("Capability not exist ");
                }else {
                    System.out.println ("Folder not exist");
                    return false;
                }
            }
            j++;
        }
        System.out.println ("User not exist");
        return false;
    }
    static void Storeuserfile (ArrayList<User> users)
    {
        try{
            FileWriter fWriter = new FileWriter ("user.txt");
            for (var uu:users){
                fWriter.write (uu.getUsername ()+","+uu.getPassword ()+"\n");
            }
            fWriter.close ();
        }catch (IOException e){
            e.printStackTrace ();
        }
    }
    static void StoreCapabilities (ArrayList<User> users)
    {
        try{
            FileWriter fWriter = new FileWriter ("capabilities.txt");
            User s=users.get (0);
            ArrayList<String>paths=new ArrayList<> ();
            for (int i = 1 ; i < s.getCabilities ().size ()  ; i++){
                paths.add (s.getCabilities ().get (i).getFirst ());

            }
            for (int i = 0 ; i < paths.size () ; i++){
                fWriter.append (paths.get (i)+",");
                for (int k = 1 ; k <users.size ()  ; k++){
                    User cab = users.get (k);
                    for (int j = 0 ; j < cab.getCabilities ().size () ; j++){
                        if(cab.getCabilities ().get (j).getFirst ().equals (paths.get (i)))
                        {
                            if(k != users.size ()-1) {
                                fWriter.append (cab.getUsername () + "," + cab.getCabilities ().get (j).getSecond () +
                                        cab.getCabilities ().get (j).getThird () + ",");
                            }
                            else
                            {
                                fWriter.append (cab.getUsername () + "," + cab.getCabilities ().get (j).getSecond () +
                                        cab.getCabilities ().get (j).getThird () );
                            }
                        }

                    }
                }
            }
            fWriter.close ();
        }catch (IOException e){
            e.printStackTrace ();
        }


    }
}
