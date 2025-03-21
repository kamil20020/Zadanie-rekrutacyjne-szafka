package pl.company_xyz;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pl.company_xyz.cabinet.FileCabinet;
import pl.company_xyz.folder.ConcreteFolder;
import pl.company_xyz.folder.Folder;
import pl.company_xyz.folder.FolderSize;
import pl.company_xyz.folder.multi_folder.ConcreteMultiFolder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FileCabinetTest {

    private FileCabinet fileCabinet;

    @BeforeEach
    public void setUp(){

        Folder folder1Level0 = new ConcreteFolder("Folder 0_1", FolderSize.LARGE);

        ConcreteMultiFolder multiFolder2Level0 = new ConcreteMultiFolder("Multi folder 0_2", FolderSize.MEDIUM);

            Folder folder1Level1 = new ConcreteFolder("Folder 1_1", FolderSize.LARGE);
            ConcreteMultiFolder multiFolder2Level1 = new ConcreteMultiFolder("Multi folder 1_2", FolderSize.LARGE);

                Folder folder1Level2 = new ConcreteFolder("Folder 2_1", FolderSize.SMALL);

            multiFolder2Level1.addFolder(folder1Level2);

        multiFolder2Level0.addFolder(folder1Level1);
        multiFolder2Level0.addFolder(multiFolder2Level1);

        ConcreteMultiFolder multiFolder3Level0 = new ConcreteMultiFolder("Multi folder 0_3", FolderSize.SMALL);

            Folder folder3Level1 = new ConcreteFolder("Folder 1_3", FolderSize.MEDIUM);
            Folder folder4Level1 = new ConcreteFolder("Folder 1_4", FolderSize.SMALL);

        multiFolder3Level0.addFolder(folder3Level1);
        multiFolder3Level0.addFolder(folder4Level1);

        Folder folder4Level0 = new ConcreteFolder("Folder 0_4", FolderSize.SMALL);

        fileCabinet = new FileCabinet(
            new ArrayList<>(
                List.of(folder1Level0, multiFolder2Level0, multiFolder3Level0, folder4Level0)
            )
        );
    }

    @ParameterizedTest
    @CsvSource(value = {
        "Folder 0_4",
        "Multi folder 0_2",
        "Folder 1_1",
        "Multi folder 1_2",
        "Folder 2_1",
        "Folder 1_3"
    })
    public void shouldFindFolderByNameWhenNameExists(String name) {

        //given

        //when
        Optional<Folder> foundFolderOpt = fileCabinet.findFolderByName(name);

        //then
        assertTrue(foundFolderOpt.isPresent());

        Folder foundFolder = foundFolderOpt.get();

        assertEquals(name, foundFolder.getName());
    }

    @Test
    public void shouldNotFindFolderByNameWhenNameDoesNotExist(){

        //given
        String name = "Folder 3_1";

        //when
        Optional<Folder> gotFolderOpt = fileCabinet.findFolderByName(name);

        //then
        assertTrue(gotFolderOpt.isEmpty());
    }

    @ParameterizedTest
    @CsvSource(value = {
        "SMALL, 4",
        "MEDIUM, 2",
        "LARGE, 3",
        "HUGE, 0"
    })
    public void shouldFindFoldersBySize(String size, int expectedFoldersCount){

        //given

        //when
        List<Folder> gotFolders = fileCabinet.findFoldersBySize(size);

        //then
        assertEquals(expectedFoldersCount, gotFolders.size());
    }

    @Test
    public void shouldCountManyFolders(){

        //given
        int expectedNumberOFFolders = 9;

        //when
        int gotNumberOfFolders = fileCabinet.count();

        //then
        assertEquals(expectedNumberOFFolders, gotNumberOfFolders);
    }

    @Test
    public void shouldCountNoFolders(){

        //given
        fileCabinet.clear();

        //when
        int gotNumberOfFolders = fileCabinet.count();

        //then
        assertEquals(0, gotNumberOfFolders);
    }
}
