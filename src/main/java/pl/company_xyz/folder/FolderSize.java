package pl.company_xyz.folder;

public enum FolderSize {

    SMALL("SMALL"),
    MEDIUM("MEDIUM"),
    LARGE("LARGE");

    private String name;

    FolderSize(String name){

        this.name = name;
    }

    @Override
    public String toString(){

        return name;
    }
}
