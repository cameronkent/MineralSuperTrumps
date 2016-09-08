package com.SuperTrumps;

import com.dd.plist.NSString;

public class TrumpCard extends Card {
    NSString title, subtitle;

    public TrumpCard(NSString title, NSString subtitle) {
        this.title = title;
        this.subtitle = subtitle;
    }

    @Override
    public String toString() {
        return ("**************************************************" +
                "\n SUPERTRUMP \n" + this.title +
                "\n\n ABILITY: \n" + this.subtitle +
                "\n**************************************************");
    }
}
