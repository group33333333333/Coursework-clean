package com.napier.courseworkclean;

/** Class representing a country's language **/
public class Language {

    /** Property representing Country's 3-letter code **/
    public String countryCode;

    /** Property representing Country's language **/
    public String language;

    /** Property representing Country's official language (String 'T' or 'F' representing true or false) **/
    public String isOfficial;

    /** Property representing the percentage of native language speakers **/
    public double percentage ;

    // toString override method
    // Fixes ArrayList display output
    @Override
    public String toString() {
        return "Language{" +
                "countryCode='" + countryCode + '\'' +
                ", language='" + language + '\'' +
                ", isOfficial='" + isOfficial + '\'' +
                ", percentage=" + percentage +
                '}';
    }
}