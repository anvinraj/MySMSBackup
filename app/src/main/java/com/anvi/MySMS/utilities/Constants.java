package com.anvi.nearme.utilities;

/**
 * Created by Anvin on 8/25/2017.
 */

public class Constants {
    public static String registration="registeration";
    public static String user_details="user_details";
    public static String courierboys_location="courierboys_location";
    public static String delivery_task="delivery_task";
    public static String completed_deliveries="completed_deliveries";
    public static String delivery_status="delivery_status";
    public static String packager_addresses="packager_addresses";




    public static String dlvry_boy_status="";
    public interface ACTION {
        public static String MAIN_ACTION = "com.marothiatechs.customnotification.action.main";
        public static String INIT_ACTION = "com.marothiatechs.customnotification.action.init";
        public static String PREV_ACTION = "com.marothiatechs.customnotification.action.prev";
        public static String PAUSE_ACTION = "com.marothiatechs.customnotification.action.play";
        public static String PLAY_ACTION = "com.meridian.voiceofislam.audioplayer.action.pause";
        public static String NEXT_ACTION = "com.marothiatechs.customnotification.action.next";
        public static String STARTFOREGROUND_ACTION = "com.marothiatechs.customnotification.action.startforeground";
        public static String STOPFOREGROUND_ACTION = "com.marothiatechs.customnotification.action.stopforeground";
    }
    public interface NOTIFICATION_ID {
        public static int FOREGROUND_SERVICE = 101;
    }
}
