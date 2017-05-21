package org.neuron64.kladr.api;

import org.neuron64.kladr.api.dto.KladrResult;

/**
 * Created by neuron on 21.05.17.
 */
public class Example {

    public static void main(String[] args) {
        KladrResult region = StaticKladrApi.getRegion("Саратовская", 1, false);
        KladrResult district = StaticKladrApi.getDistrict("Саратов", 1, false);
        KladrResult city = StaticKladrApi.getCity("Саратов", 1, false, region.getResult().get(0).getId());
        KladrResult street = StaticKladrApi.getStreet("Московская", 1, false, city.getResult().get(0).getId());
        KladrResult building = StaticKladrApi.getBuildingByStreetId("90", 1, false, street.getResult().get(0).getId());

        System.out.println("REGION : " + region.toString());
        System.out.println("\n");
        System.out.println("DISTRICT : " + district.toString());
        System.out.println("\n");
        System.out.println("CITY : " + city.toString());
        System.out.println("\n");
        System.out.println("BUILDING : " + building.toString());
    }
}
