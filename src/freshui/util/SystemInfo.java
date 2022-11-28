package freshui.util;

import freshui.Constants;

public class SystemInfo {

    /**
     * Finds the operating system that the java program is currently running on using
     * the System.getProperty method.
     * @return an integer pertaining to the operating system
     */
    public static int getOperatingSystem(){
        String fetchedDetails = System.getProperty("os.name").toLowerCase();

        if(fetchedDetails.contains("win")){
            return Constants.WINDOWS;
        }

        if(fetchedDetails.contains("osx")){
            return Constants.MAC_OS;
        }

        if(fetchedDetails.contains("lin")){
            return Constants.LINUX;
        }

        return Constants.UNIDENTIFIED_OS;
    }

    public static boolean isWindows(){
        return System.getProperty("os.name").toLowerCase().contains("win");
    }

    public static boolean isMacOS(){
        return System.getProperty("os.name").toLowerCase().contains("osx") ||
                System.getProperty("os.name").toLowerCase().contains("mac");
    }

    public static boolean isLinux(){
        return System.getProperty("os.name").toLowerCase().contains("lin");
    }

    public static String getOperatingSystemDetails(){
        return System.getProperty("os.name");
    }

}
