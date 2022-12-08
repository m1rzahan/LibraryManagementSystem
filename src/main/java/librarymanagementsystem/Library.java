package librarymanagementsystem;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Adrian Adewunmi
 * @date 19/01/2022
 * This class is used to create a library object
 */
@Data
@Builder
@NoArgsConstructor
public class Library {
    private  String LibraryName;
    private  String LibraryAddress;

    public Library(String LibraryName, String LibraryAddress){
        this.LibraryName = LibraryName;
        this.LibraryAddress = LibraryAddress;
    }

    public String getLibraryName(){
        return LibraryName;
    }

    public String getLibraryAddress(){
        return LibraryAddress;
    }

    @Override
    public String toString() {
        return "Library Name: " + LibraryName + "\n" +
                "Library Address: " + LibraryAddress + "\n";
    }
}
