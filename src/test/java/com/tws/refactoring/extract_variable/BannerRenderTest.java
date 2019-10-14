package com.tws.refactoring.extract_variable;

import org.junit.Test;

import static org.junit.Assert.*;

public class BannerRenderTest {
    @Test
    public void should_render_IE_on_mac(){
        BannerRender bannerRender = new BannerRender();
        String platform = "MAC";
        String browser = "IE";

        String expected = bannerRender.renderBanner(platform, browser);

        assertEquals(expected, "IE on Mac?");
    }

    @Test
    public void should_render_banner(){
        BannerRender bannerRender = new BannerRender();
        String platform = "platform";
        String browser = "chrome";

        String expected = bannerRender.renderBanner(platform, browser);

        assertEquals(expected, "banner");
    }
}