package com.napier.courseworkclean;

/** Class representing a language
 *  Properties are to be pulled from SQL database and assigned to object 'Language'
 *  Will implement ArrayList<Language> Languages
 * */
public class Language {

    /** Property representing Country's 3-letter code **/
    public String countryCode;

    /** Property representing Country's language **/
    public String language;

    /** Property representing Country's official language (String 'T' or 'F' representing true or false) **/
    public String isOfficial;

    /** Property representing the percentage of native language speakers **/
    public double percentage ;

    /** toString override method
     Fixes ArrayList display output, lists an object's properties instead of memory address
     *      */
    @Override
    public String toString() {
        return "Language {" +
                "Code='" + countryCode + '\'' +
                ", Language='" + language + '\'' +
                ", IsOfficial='" + isOfficial + '\'' +
                ", Percentage=" + percentage +
                '}';
    }
}







