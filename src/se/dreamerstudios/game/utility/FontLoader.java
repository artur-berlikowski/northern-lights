package se.dreamerstudios.game.utility;

import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;
import org.newdawn.slick.util.ResourceLoader;

import java.awt.*;

public class FontLoader {
    public static UnicodeFont loadUnicodeFont(String ref, int weight, float size) {
        try{
            Font font = Font.createFont(java.awt.Font.TRUETYPE_FONT, ResourceLoader.getResourceAsStream(ref));
            font = font.deriveFont(weight, size);

            UnicodeFont unicodeFont = new UnicodeFont(font);
            unicodeFont.addAsciiGlyphs();
            unicodeFont.getEffects().add(new ColorEffect());
            unicodeFont.addAsciiGlyphs();
            unicodeFont.loadGlyphs();

            return unicodeFont;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static TrueTypeFont loadTrueTypeFont(String ref, int weight, float size) {
        try {
            Font font = Font.createFont(java.awt.Font.TRUETYPE_FONT, ResourceLoader.getResourceAsStream(ref));
            font = font.deriveFont(weight, size);

            TrueTypeFont ttf = new TrueTypeFont(font, true);

            return ttf;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
