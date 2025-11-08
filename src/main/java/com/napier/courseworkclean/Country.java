package com.napier.courseworkclean;

/** Class representing a country **/
public class Country
{

    /** Property representing Country's 3-letter code **/
    public String code;

    /** Property representing Country's name **/
    public String name;

    /** Property representing Country's continent **/
    public String continent;

    /** Property representing Country's region **/
    public String region;

    /** Property representing Country's surface area **/
    public int surfaceArea;

    /** Property representing Country's independence year **/
    public int indepYear;

    /** Property representing Country's population **/
    public int population;

    /** Property representing Country's life expectancy **/
    public double lifeExpectancy;

    /** Property representing Country's GNP **/
    public float GNP;

    /** Property representing Country's OLD GNP **/
    public float GNPOld;

    /** Property representing Country's local name **/
    public String localName;

    /** Property representing Country's government form **/
    public String govForm;

    /** Property representing Country's head of state **/
    public String headOfState;

    /** Property representing Country's capital **/
    public String capital;

    /** Property representing Country's 2-letter code  **/
    public String code2;

    // toString override method
    // Fixes ArrayList display output, lists an object's properties instead of memory address
    @Override
    public String toString() {
        return "Country{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", continent='" + continent + '\'' +
                ", region='" + region + '\'' +
                ", surfaceArea=" + surfaceArea +
                ", indepYear=" + indepYear +
                ", population=" + population +
                ", lifeExpectancy=" + lifeExpectancy +
                ", GNP=" + GNP +
                ", GNPOld=" + GNPOld +
                ", localName='" + localName + '\'' +
                ", govForm='" + govForm + '\'' +
                ", headOfState='" + headOfState + '\'' +
                ", capital='" + capital + '\'' +
                ", code2='" + code2 + '\'' +
                '}';
    }
}


