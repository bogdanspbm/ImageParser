package utils;

import java.util.ArrayList;
import java.util.List;

public class Settings {

    public static List<String> banned;

    private static void initBannedList() {
        banned = new ArrayList<>();
        banned.add("livejournal");
    }

    public static List<String> getBanned() {
        if (banned == null || banned.size() == 0) {
            initBannedList();
        }

        return banned;
    }
}
