package com.napier.courseworkclean;

/** Class representing a country's language properties **/
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
    // Fixes ArrayList display output, lists an object's properties instead of memory address
    @Override
    public String toString() {
        return "Language{" +
                "code='" + countryCode + '\'' +
                ", language='" + language + '\'' +
                ", isOfficial='" + isOfficial + '\'' +
                ", percentage=" + percentage +
                '}';
    }
}







