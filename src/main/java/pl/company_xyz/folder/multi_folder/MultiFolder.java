package pl.company_xyz.folder.multi_folder;

import pl.company_xyz.folder.Folder;

import java.util.List;

public interface MultiFolder extends Folder {

    List<Folder> getFolders();
}
