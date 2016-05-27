import org.slf4j.LoggerFactory;
import sx.blah.discord.api.EventDispatcher;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.Image;

import java.io.*;
import java.util.logging.Logger;

/**
 * Created by Vaerys on 19/05/2016.
 */
public class Main {


    public static void main(String[] args) {

        String token;
        // you need to set a token in Token/Token.txt for the bot to run
        try {
            File configDir = new File("Token");
            if (!configDir.exists()) {
                configDir.mkdirs();
            }
            File file = new File("Token/Token.txt");
            if(!file.exists()){
                file.createNewFile();
            }
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            token = bufferedReader.readLine();
            IDiscordClient client = Client.getClient(token, true);
            client.isBot();
            EventDispatcher dispatcher = client.getDispatcher();
            dispatcher.registerListener(new InterfaceListener());
            dispatcher.registerListener(new AnnotationListener());
        } catch (DiscordException ex) {
            System.out.println(ex);
        } catch (FileNotFoundException e) {

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
