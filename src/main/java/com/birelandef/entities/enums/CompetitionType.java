package com.birelandef.entities.enums;

/**
 * Created by sophie on 15/05/17.
 */
public enum CompetitionType {

    INTERNATIONAL("International"),
    ALLRUSSIAN("AllRussian"),
    INTERREGIONAL("Interregional"),
    LOCAL("local"),
    REGION("region");

    private String type;

    CompetitionType(String type) {
        this.type = type;
    }
}
