package pl.company_xyz.folder;

public class ConcreteFolder implements Folder {

    private String name;
    private FolderSize size;

    public ConcreteFolder(String name, FolderSize size) {

        this.name = name;
        this.size = size;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSize() {
        return size.toString();
    }
}
