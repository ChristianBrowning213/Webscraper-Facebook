package testing;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.htmlunit.BrowserVersion;
import org.htmlunit.WebClient;
import org.htmlunit.WebResponse;
import org.htmlunit.WebWindow;
import org.htmlunit.html.DomElement;
import org.htmlunit.html.HtmlButton;
import org.htmlunit.html.HtmlForm;
import org.htmlunit.html.HtmlInput;
import org.htmlunit.html.HtmlPage;
import org.htmlunit.html.HtmlSubmitInput;
import org.htmlunit.html.HtmlTextInput;

public class GettingHTML {

  public  HtmlPage page;
  public  String content;

  public void ScrollDown() 
  {
      //ScriptResult res=page.executeJavaScript("window.scrollBy (0,2000);");
     // page.executeJavaScript("window.scrollBy (0,100000);");
     //page.executeJavaScript("window.scrollTo(0, document.body.scrollHeight);");
       page.executeJavaScript("window.scrollBy (0,1000000);");

     System.out.println("Yeet testing testung ");
                try {
                  Thread.sleep(10000);
                } catch (InterruptedException e) {
                  // TODO Auto-generated catch block
                  e.printStackTrace();
                }
      WebResponse response = page.getWebResponse();
      String responseContent = response.getContentAsString();

      //  page.executeJavaScript("window.scrollTo(0, document.body.scrollHeight);");
      if(content.equals(page.asXml()))
      {
                        System.out.println("Nothing happened lmaoo ");
      }
      else
      {
         System.out.println("Something happened lmaoo ");
     
      }
      content = page.asXml();
      writeToFiile("SeeIfWorked", responseContent);

      writeToFiile("nextpath", page.asXml());

  }

  GettingHTML(String Item)
  {
    String baseUrl = Item;
    WebClient client = new WebClient(BrowserVersion.CHROME);
    client.getOptions().setCssEnabled(true);
    client.getOptions().setJavaScriptEnabled(true);
    try
    {
      page = client.getPage(baseUrl);
      WebResponse response = page.getWebResponse();
      String responseContent = response.getContentAsString();
      content = page.asXml();
      System.out.println(page.toString());
            writeToFiile("XML", content);

      writeToFiile("response", responseContent);
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }


  }

  public void Login() throws IOException
  {
   HtmlForm form =  page.getForms().get(0);


   
   HtmlTextInput userField = form.getInputByName("email");
   HtmlInput pwField = form.getInputByName("pass");
          System.out.println("yeet");

   userField.setValueAttribute("alphadogdogforce@gmail.com");
   pwField.setValueAttribute("Twickenham213!");
          System.out.println("yeet");
          System.out.println(form.asXml());

   HtmlButton submitButton = form.getButtonByName("login");
          System.out.println("yeet");

   page = submitButton.click();

    System.out.println(page.asNormalizedText());

  }

  public void writeToFiile(String name, String stuffToSave)
    {        
      try {
          FileWriter myWriter = new FileWriter("TestFile "+name+".txt");
          myWriter.write(stuffToSave);
          System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }
    }
    
}
