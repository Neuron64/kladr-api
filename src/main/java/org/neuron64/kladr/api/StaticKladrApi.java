package org.neuron64.kladr.api;

import com.google.gson.Gson;
import org.neuron64.kladr.api.dto.ContentType;
import org.neuron64.kladr.api.dto.KladrResult;
import org.neuron64.kladr.api.filter.Filter;
import org.neuron64.kladr.api.filter.QueryFilter;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.neuron64.kladr.api.KladrEndpoint.URL_KLADR_ENDPOINT;

/**
 * Created by neuron on 21.05.17.
 */
public class StaticKladrApi {

    public static KladrResult getKladr(Filter filter) throws URISyntaxException, IOException {
        String apiUrl = URL_KLADR_ENDPOINT
                + "?" + new QueryFilter().buildFilter(filter);
        return new Gson().fromJson(HttpUtil.get(apiUrl), KladrResult.class);
    }

    public static KladrResult getRegion(String query, int limit, boolean withParent)  {
        try {
            return getKladr(new Filter()
                    .addLimit(limit)
                    .addQuery(query)
                    .addWithParent(withParent)
                    .addContentType(ContentType.REGION));
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static KladrResult getDistrict(String query, int limit, boolean withParent) {
        try {
            return getKladr(new Filter()
                .addLimit(limit)
                .addQuery(query)
                .addWithParent(withParent)
                .addContentType(ContentType.DISTRICT));
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static KladrResult getDistrict(String query, int limit, boolean withParent, String regionId) {
        try {
            return getKladr(new Filter()
                    .addLimit(limit)
                    .addQuery(query)
                    .addWithParent(withParent)
                    .addContentType(ContentType.DISTRICT)
                    .addRegionId(regionId));
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static KladrResult getCity(String query, int limit, boolean withParent) {
        try {
            return getKladr(new Filter()
                    .addLimit(limit)
                    .addQuery(query)
                    .addWithParent(withParent)
                    .addContentType(ContentType.CITY));
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static KladrResult getCity(String query, int limit, boolean withParent, String regionId) {
        try {
            return getKladr(new Filter()
                    .addLimit(limit)
                    .addQuery(query)
                    .addWithParent(withParent)
                    .addContentType(ContentType.CITY)
                    .addRegionId(regionId));
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }

//    public static KladrResult getCity(String query, int limit, boolean withParent, String regionId, String districtId) {
//        try {
//            return getKladr(new Filter()
//                    .addLimit(limit)
//                    .addQuery(query)
//                    .addWithParent(withParent)
//                    .addContentType(ContentType.CITY)
//                    .addRegionId(regionId)
//                    .addDistrictId(districtId));
//        } catch (URISyntaxException | IOException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }

    public static KladrResult getStreet(String query, int limit, boolean withParent, String cityId) {
        try {
            return getKladr(new Filter()
                    .addLimit(limit)
                    .addQuery(query)
                    .addWithParent(withParent)
                    .addContentType(ContentType.STREET)
                    .addCityId(cityId));
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static KladrResult getBuildingByCityId(String query, int limit, boolean withParent, String cityId) {
        try {
            return getKladr(new Filter()
                    .addLimit(limit)
                    .addQuery(query)
                    .addWithParent(withParent)
                    .addContentType(ContentType.BUILDING)
                    .addCityId(cityId));
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static KladrResult getBuildingByStreetId(String query, int limit, boolean withParent, String streetId) {
        try {
            return getKladr(new Filter()
                    .addLimit(limit)
                    .addQuery(query)
                    .addWithParent(withParent)
                    .addContentType(ContentType.BUILDING)
                    .addStreetId(streetId));
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    //TODO: need test!
    public static KladrResult getBuilding(String query, int limit, boolean withParent, String streetId, String cityId) {
        try {
            return getKladr(new Filter()
                    .addLimit(limit)
                    .addQuery(query)
                    .addWithParent(withParent)
                    .addContentType(ContentType.BUILDING)
                    .addStreetId(streetId)
                    .addCityId(cityId));
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
