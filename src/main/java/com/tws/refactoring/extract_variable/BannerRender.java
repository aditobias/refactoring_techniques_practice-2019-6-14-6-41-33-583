package com.tws.refactoring.extract_variable;

public class BannerRender {

    private static final String MAC = "MAC";
    private static final String IE = "IE";

    public String renderBanner(String platform, String browser) {
        if (isIEonMAC(platform, browser)) {
            return "IE on Mac?";
        }
        return "banner";
    }

    public boolean isIEonMAC(String platform, String browser) {
        return checkIfContainingSpecificString(platform, MAC) && checkIfContainingSpecificString(browser, IE);
    }

    public boolean checkIfContainingSpecificString(String originalString, String containingString){
        return originalString.toUpperCase().contains(containingString);
    }
}
