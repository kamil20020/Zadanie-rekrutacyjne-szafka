package pl.company_xyz.folder.multi_folder;

import pl.company_xyz.folder.ConcreteFolder;
import pl.company_xyz.folder.Folder;
import pl.company_xyz.folder.FolderSize;

import java.util.List;

public class ConcreteMultiFolder extends ConcreteFolder implements MultiFolder {

    private List<Folder> folders;

    public ConcreteMultiFolder(String name, FolderSize size, List<Folder> folders) {

        super(name, size);

        this.folders = folders;
    }

    @Override
    public List<Folder> getFolders() {
        return folders;
    }
}
