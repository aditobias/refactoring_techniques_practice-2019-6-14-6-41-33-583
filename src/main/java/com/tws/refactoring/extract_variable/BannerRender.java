package com.tws.refactoring.extract_variable;

public class BannerRender {

    private static final String MAC = "MAC";
    String renderBanner(String platform, String browser) {
        if (isIEonMAC(platform, browser)) {
            return "IE on Mac?";
        }
        return "banner";
    }

    private boolean isIEonMAC(String platform, String browser) {
        return checkIfContainingSpecificString(platform, MAC);
    }

    private boolean checkIfContainingSpecificString(String originalString, String containingString){
        return originalString.toUpperCase().contains(containingString);
    }
}
