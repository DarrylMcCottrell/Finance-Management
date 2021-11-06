import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.List;

public class Report {


    //Creates HTML file in project folder
    void GenerateFile() {
        try {
            File file = new File("Report.html");
            if(file.createNewFile()){
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists");
            }
        }catch (IOException e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }
    }

    //Writes to HTML file based off Account information given
    void WriteToFile(List<Account> a){
        try{
            FileWriter w = new FileWriter("Report.html");
            w.write("<html> \n \t <body> \n \t \t <h1> Report </h1> \n \t \t \t");
            for(Account ac : a){
                w.write(ac.GenerateHTML() + "\n \n");
            }
            w.write("\n \t </body> \n </html>");
            w.close();
            System.out.println("Sucessfully wrote to the file.");
        } catch (IOException e){
            System.out.println("An error has occurred");
            e.printStackTrace();
        }
    }
};