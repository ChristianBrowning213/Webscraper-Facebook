package testing;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.plaf.synth.SynthMenuItemUI;

/*
 * "listing"
"formatted_amount":"\u00a3___"
"marketplace_listing_title":"___"
"id":"___"
https://www.facebook.com/marketplace/item/967121807732872/

Ok so store onto a file by regex the string using listing to break up each listing by listing.

Look at each title and regex it by looking for a specific item 

Extract formatted amount -> Compare it to the amount wanted.

Place ID into a facebook marketplace link to be searched through 

 */
public class ProcessHTML {
    
     String fullHTML;

   ProcessHTML(String content)
   {
    fullHTML = content;
   }

    public   List<Listing>  ProcessHTMLnow()
    {
        Matcher matcher = CreateRegex("\"listing\"(.*?)\"listing\"", fullHTML);
        //"listing(.*?)listing");


        //"listing(.*?)(?:listing|$)"
        String[] listOfListings = fullHTML.split("\"listing\"");
        

        System.out.println(listOfListings.length);
        
        return CreateListingList(listOfListings);


    }

    private static Listing createListing(String htmlString)
    {
        /* "listing"
        "formatted_amount":"\u00a3___"
        marketplace_listing_title":"___"
        "id":"___"
        */

        //System.out.println(htmlString);

         Pattern pattern = Pattern.compile("\"formatted_amount\":\"(.*?),", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(htmlString);
       
        matcher.find();
         System.out.println(matcher.group());
        String amount = matcher.group();

        pattern = Pattern.compile("\"marketplace_listing_title\":\"(.*?),", Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(htmlString);

        matcher.find();
        System.out.println(matcher.group());

        String description = matcher.group();

        pattern = Pattern.compile("\"id\":\"(.*?),", Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(htmlString);

        matcher.find();
                 System.out.println(matcher.group());
        String id = matcher.group();

        Listing listing = new Listing(amount, description, id);

        return listing;
    }

    private static List<Listing> CreateListingList(String[] listOfListings)
    {
       List<Listing> objlistinglist = new ArrayList<>();
       boolean skipfirst = true;
        for (String string : listOfListings) 
        {
            if(skipfirst == true)
            {
                skipfirst = false;
            }
            else
            {
              System.out.println("yeet");

            Listing listing = createListing(string);
                 System.out.println("yeet2");

            objlistinglist.add(listing);
            }
      
        }

       return objlistinglist;
    }

    private static Matcher CreateRegex(String regpattern, String content)
    {
        Pattern pattern = Pattern.compile(regpattern, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(content);
       
        return matcher;

    }

}
