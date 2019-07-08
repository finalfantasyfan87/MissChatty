package com;

import org.alicebot.ab.Bot;
import org.alicebot.ab.Chat;
import org.alicebot.ab.MagicBooleans;
import org.alicebot.ab.utils.IOUtils;

import java.io.File;
import java.util.ResourceBundle;
import java.util.Scanner;

public class MissChatty {
static String name = "com.MissChatty";
    public static void main(String[] args) {

        String resourcesPath = getResourcesPath();
        System.out.println(resourcesPath);
        MagicBooleans.trace_mode = false;
        Bot bot = new Bot("chatty", resourcesPath);
        Chat chatSession = new Chat(bot);
        bot.brain.nodeStats();
        String textLine = "";
while(true){
    System.out.println("User:");
    textLine = IOUtils.readInputTextLine();
    String response = chatSession.multisentenceRespond(textLine);
    System.out.println("Bot : " + response);
}


    }


    private static String getResourcesPath() {
        File currDir = new File(".");
        String path = currDir.getAbsolutePath();
        path = path.substring(0, path.length() - 2);
        System.out.println(path);
        String resourcesPath = path + File.separator + "src" + File.separator + "main" + File.separator + "resources";
        return resourcesPath;
    }
}
