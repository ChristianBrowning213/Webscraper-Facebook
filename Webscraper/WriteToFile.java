package testing;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteToFile {
    List<Listing> listinglist;
    String fileName;
    WriteToFile(List<Listing> pListing, String Filename) throws IOException
    {
        listinglist = pListing;
        fileName = Filename;
        writeToFile();
    }

    public void writeToFile() throws IOException
    {
        FileWriter myWriter = new FileWriter("TestFile "+ fileName+".txt");

        for (Listing listing : listinglist) 
        {
            myWriter.write(listing.WritetoFile());
        }
    }
    
}
