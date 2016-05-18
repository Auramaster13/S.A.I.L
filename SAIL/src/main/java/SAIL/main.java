package SAIL;

import com.google.common.util.concurrent.FutureCallback;

import de.btobastian.javacord.DiscordAPI;
import de.btobastian.javacord.Javacord;
import de.btobastian.javacord.entities.message.Message;
import de.btobastian.javacord.listener.message.MessageCreateListener;

public class main {

	public static void main (String args[]) {
		
		String token = "MTgyNTAyOTY0NDA0MDI3Mzky.Ch4QoQ.Q0l_Ys2EhsCQwf3575Q0u3Isffs";
		boolean bot = true;
		
		DiscordAPI api = Javacord.getApi(token, bot);
		//connect
		api.connect(new FutureCallback<DiscordAPI>() {
			
			public void onSuccess(DiscordAPI api) {
				api.registerListener(new MessageCreateListener() {
					
					public void onMessageCreate(DiscordAPI api, Message message) {
						if (message.getContent().equalsIgnoreCase("ping")){
							message.reply("pong");
						}
						
					}
				});
			}

			public void onFailure(Throwable t) {
				t.printStackTrace();	
			}
		});
	}

}