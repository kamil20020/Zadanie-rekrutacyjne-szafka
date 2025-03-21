package pl.company_xyz.cabinet;

import pl.company_xyz.folder.Folder;
import pl.company_xyz.folder.multi_folder.MultiFolder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileCabinet implements Cabinet {

    private List<Folder> folders = new ArrayList<>();

    public FileCabinet(List<Folder> folders){

        this.folders = folders;
    }

    public FileCabinet(){


    }

    @Override
    public Optional<Folder> findFolderByName(String name) {

        return getFoldersFlatMapStream()
            .filter(folder -> folder.getName().equals(name))
            .findFirst();
    }

    @Override
    public List<Folder> findFoldersBySize(String size) {

        return getFoldersFlatMapStream()
            .filter(folder -> folder.getSize().equals(size))
            .collect(Collectors.toList());
    }

    @Override
    public int count() {

        return (int) getFoldersFlatMapStream()
            .count();
    }

    public void clear(){
        folders.clear();
    }

    private Stream<Folder> getFoldersFlatMapStream(){

        return folders.stream()
            .flatMap(this::getFolderFlatMapStream);
    }

    private Stream<Folder> getFolderFlatMapStream(Folder folder){

        Stream<Folder> folderStream = Stream.of(folder);

        if(folder instanceof MultiFolder multiFolder){

            return Stream.concat(folderStream, multiFolder.getFolders().stream().flatMap(this::getFolderFlatMapStream));
        }

        return folderStream;
    }
}
