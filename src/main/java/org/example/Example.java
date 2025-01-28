package org.example;

import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;
import org.example.Commands._CommandsManager;
import org.example.Commands.test;

import javax.security.auth.login.LoginException;
import java.util.EnumSet;

public class Example {

    public Example() throws LoginException {
        Dotenv dotenv = Dotenv.load();
        String token = dotenv.get("TOKEN");
        DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault(token);
        builder.setActivity(Activity.customStatus("JDA_APP_TEMPLATE"));
        builder.enableIntents(EnumSet.allOf(GatewayIntent.class));
        ShardManager shardManager = builder.build();
        shardManager.addEventListener(
                new _CommandsManager(),
                new test());
    }

    public static void main(String[] args) {

        try {
            new Example();
        }catch (Exception e) {
            System.out.println("Invalid token!");
        }

    }
}
