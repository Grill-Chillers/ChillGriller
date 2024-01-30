package org.grill.chill;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.grill.chill.Chat.ChatListener;

import javax.security.auth.login.LoginException;
import java.io.File;

public class Main {
    public static void main(String[] args) {

        try {
            Configurations configs = new Configurations();
            Configuration config  = configs.properties(new File("config.properties"));

            JDABuilder builder = JDABuilder.createDefault(config.getString("botToken"));

            builder.setActivity(Activity.playing("with your mom"));
            builder.addEventListeners(new ChatListener());

            builder.build();
        } catch (LoginException e) {
            throw new RuntimeException(e);
        } catch (ConfigurationException e) {
            throw new RuntimeException(e);
        }
    }
}