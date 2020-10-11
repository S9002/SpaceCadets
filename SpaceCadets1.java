import java.util.Scanner;
import java.net.*;
import java.io.*;

public class SpaceCadets1 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in); //get user input
        String stringUrl = "https://www.ecs.soton.ac.uk/people/" + in.nextLine(); //add it to end of URL

        System.out.println(getNameFromHttp(getHttpB(stringUrl)));
        //Grab the HTML from the Southampton University Website, then find and print the name
    }

    static String getNameFromHttp(String html) { //find the name and return it
        int location = html.indexOf("property=\"name\">") + 16; //find where the name is located
        //look beyond the first 16 characters as they do not have the name
        int locationEnd = location + html.substring(location, html.length()).indexOf("<"); //find where the name ends
        String out = html.substring(location, locationEnd); //shorten the input to just the name
        return out;
    }

    public static String getHttpB(String urlString) throws Exception { //grab the html from the website
        URL url = new URL(urlString); //make an url object with the url set to the input
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
        //create a new buffered reader and start reading from the website

        String line;
        String out = "";
        while ((line = in.readLine()) != null) //put every line of the page into out
            out = out + line;

        return out;
    }
}
