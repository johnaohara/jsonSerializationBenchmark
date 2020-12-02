package io.quarkus.perf;

import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

import java.util.HashMap;
import java.util.Map;

@State(Scope.Benchmark)
public class CapitalState {

    private static final Map<String, Capital> capitalMap;

    static {
        capitalMap = new HashMap<>();
        capitalMap.put("Alabama", new Capital("Montgomery", 1846,159.8f,198525));
        capitalMap.put("Alaska", new Capital("Juneau", 1906,2716.7f,32113));
        capitalMap.put("Arizona", new Capital("Phoenix", 1912,517.6f,1680992));
        capitalMap.put("Arkansas", new Capital("Little Rock", 1821,116.2f,197312));
        capitalMap.put("California", new Capital("Sacramento", 1854,97.9f,513624));
        capitalMap.put("Colorado", new Capital("Denver", 1867,153.3f,727211));
        capitalMap.put("Connecticut", new Capital("Hartford", 1875,17.3f,122105));
        capitalMap.put("Delaware", new Capital("Dover", 1777,22.4f,38079));
        capitalMap.put("Florida", new Capital("Tallahassee", 1824,95.7f,194500));
        capitalMap.put("Georgia", new Capital("Atlanta", 1868,133.5f,506811));
        capitalMap.put("Hawaii", new Capital("Honolulu", 1845,68.4f,345064));
        capitalMap.put("Idaho", new Capital("Boise", 1865,63.8f,228959));
        capitalMap.put("Illinois", new Capital("Springfield", 1837,54f,114230));
        capitalMap.put("Indiana", new Capital("Indianapolis", 1825,361.5f,876384));
        capitalMap.put("Iowa", new Capital("Des Moines", 1857,75.8f,214237));
        capitalMap.put("Kansas", new Capital("Topeka", 1856,56f,125310));
        capitalMap.put("Kentucky", new Capital("Frankfort", 1792,14.7f,27679));
        capitalMap.put("Louisiana", new Capital("Baton Rouge", 1880,76.8f,220236));
        capitalMap.put("Maine", new Capital("Augusta", 1832,55.4f,18681));
        capitalMap.put("Maryland", new Capital("Annapolis", 1694,6.73f,39174));
        capitalMap.put("Massachusetts", new Capital("Boston", 1630,89.6f,692600));
        capitalMap.put("Michigan", new Capital("Lansing", 1847,35f,118210));
        capitalMap.put("Minnesota", new Capital("Saint Paul", 1849,52.8f,308096));
        capitalMap.put("Mississippi", new Capital("Jackson", 1821,104.9f,160628));
        capitalMap.put("Missouri", new Capital("Jefferson City", 1826,27.3f,42838));
        capitalMap.put("Montana", new Capital("Helena", 1875,14f,32315));
        capitalMap.put("Nebraska", new Capital("Lincoln", 1867,74.6f,289102));
        capitalMap.put("Nevada", new Capital("Carson City", 1861,143.4f,55916));
        capitalMap.put("New Hampshire", new Capital("Concord", 1808,64.3f,43627));
        capitalMap.put("New Jersey", new Capital("Trenton", 1784,7.66f,83203));
        capitalMap.put("New Mexico", new Capital("Santa Fe", 1610,37.3f,84683));
        capitalMap.put("New York", new Capital("Albany", 1797,21.4f,96460));
        capitalMap.put("North Carolina", new Capital("Raleigh", 1792,114.6f,474069));
        capitalMap.put("North Dakota", new Capital("Bismarck", 1883,26.9f,73529));
        capitalMap.put("Ohio", new Capital("Columbus", 1816,210.3f,898553));
        capitalMap.put("Oklahoma", new Capital("Oklahoma City", 1910,620.3f,655057));
        capitalMap.put("Oregon", new Capital("Salem", 1855,45.7f,174365));
        capitalMap.put("Pennsylvania", new Capital("Harrisburg", 1812,8.11f,49528));
        capitalMap.put("Rhode Island", new Capital("Providence", 1900,18.5f,179883));
        capitalMap.put("South Carolina", new Capital("Columbia", 1786,125.2f,131674));
        capitalMap.put("South Dakota", new Capital("Pierre", 1889,13f,13646));
        capitalMap.put("Tennessee", new Capital("Nashville", 1826,525.9f,670820));
        capitalMap.put("Texas", new Capital("Austin", 1839,305.1f,978908));
        capitalMap.put("Utah", new Capital("Salt Lake City", 1858,109.1f,200567));
        capitalMap.put("Vermont", new Capital("Montpelier", 1805,10.2f,7855));
        capitalMap.put("Virginia", new Capital("Richmond", 1780,60.1f,230436));
        capitalMap.put("Washington", new Capital("Olympia", 1853,16.7f,46478));
        capitalMap.put("West Virginia", new Capital("Charleston", 1885,31.6f,46536));
        capitalMap.put("Wisconsin", new Capital("Madison", 1838,68.7f,259680));
        capitalMap.put("Wyoming", new Capital("Cheyenne", 1869,21.1f,64235));


    }

    public Map<String, Capital> getCapitolMap(){
        return CapitalState.capitalMap;
    }


    public static class Capital {

        public String name;
        public Integer since;
        public Float area;
        public Integer population;

        public Capital(String name, Integer since, Float area, Integer population) {
            this.name = name;
            this.since = since;
            this.area = area;
            this.population = population;
        }
    }
}
