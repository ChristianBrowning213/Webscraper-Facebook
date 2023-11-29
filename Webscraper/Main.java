package testing;

import java.io.IOException;

import org.htmlunit.WebClient;
import org.htmlunit.WebResponse;
import org.htmlunit.html.*;
import java.io.File;  // Import the File class
import java.io.FileWriter;
import java.io.IOException;  // Import the IOException class to handle errors
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {

    public static void actuallyProcess(String htmlCode) throws IOException
    {
      ProcessHTML prosessor = new ProcessHTML(htmlCode);

      List<Listing> listofListing = prosessor.ProcessHTMLnow();

      WriteToFile writeToFile = new WriteToFile(listofListing, "generalTest");
    }
   
     public static void main(String[] args) throws IOException {
      //https://www.facebook.com/marketplace/liverpool/cymbals/?locale=en_GB
      //https://www.facebook.com/marketplace/category/cymbals/?locale=en_GB
      GettingHTML getHTML = new GettingHTML("https://www.facebook.com/marketplace/liverpool/cymbals/?locale=en_GB");
      String preHTMLCode = getHTML.content;


      //getHTML.Login();
     // getHTML.writeToFiile();
      actuallyProcess(preHTMLCode);
      
      getHTML.ScrollDown();


    }
  
}

