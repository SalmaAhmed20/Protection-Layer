public class Directory { private String directoryPath;
    private String name;
    private File[] files ;
    private Directory[] subDirectories = new  Directory[5];
    private boolean deleted = false;

    public Directory ( ) {
        directoryPath=" VFSD:/";
        name="VFSD";

    }
    public String getName ( ) {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getDirectoryPath ( ) {
        return directoryPath;
    }

    public void setDirectoryPath (String directoryPath) {
        this.directoryPath = directoryPath;
    }

    public File[] getFiles ( ) {
        return files;
    }

    public void setFiles (File[] files) {
        this.files = files;
    }

    public Directory[] getSubDirectories ( ) {
        return subDirectories;
    }

    public void setSubDirectories (Directory[] subDirectories) {
        this.subDirectories = subDirectories;
    }

    public boolean isDeleted ( ) {
        return deleted;
    }

    public void setDeleted (boolean deleted) {
        this.deleted = deleted;
    }
}
