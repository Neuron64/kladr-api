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
 * Created by neuron on 21.05.17. */
public class AsyncKladrApi {

    public static void getKladr(final Action<KladrResult> action, Filter filter) throws URISyntaxException, IOException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String apiUrl = URL_KLADR_ENDPOINT
                            + "?" + new QueryFilter().buildFilter(filter);
                    action.perform(new Gson().fromJson(HttpUtil.get(apiUrl), KladrResult.class));
                }
                catch(IOException e) {
                    action.handle(e);
                }
            }
        }).start();
    }

    public static void getRegion(final Action<KladrResult> action, String query, int limit, boolean withParent) throws URISyntaxException, IOException {
        getKladr(action, new Filter()
                .addLimit(limit)
                .addQuery(query)
                .addWithParent(withParent)
                .addContentType(ContentType.REGION));
    }

    public static void getDistrict(final Action<KladrResult> action, String query, int limit, boolean withParent) throws URISyntaxException, IOException {
        getKladr(action, new Filter()
                .addLimit(limit)
                .addQuery(query)
                .addWithParent(withParent)
                .addContentType(ContentType.DISTRICT));
    }

    public static void getDistrict(final Action<KladrResult> action, String query, int limit, boolean withParent, String regionId) throws URISyntaxException, IOException {
        getKladr(action, new Filter()
                .addLimit(limit)
                .addQuery(query)
                .addWithParent(withParent)
                .addContentType(ContentType.DISTRICT)
                .addRegionId(regionId));
    }

    public static void getCity(final Action<KladrResult> action, String query, int limit, boolean withParent) throws URISyntaxException, IOException {
        getKladr(action, new Filter()
                .addLimit(limit)
                .addQuery(query)
                .addWithParent(withParent)
                .addContentType(ContentType.CITY));

    }

    public static void getCity(final Action<KladrResult> action, String query, int limit, boolean withParent, String regionId) throws URISyntaxException, IOException {
        getKladr(action, new Filter()
                .addLimit(limit)
                .addQuery(query)
                .addWithParent(withParent)
                .addContentType(ContentType.CITY)
                .addRegionId(regionId));
    }

//    public static void getCity(final Action<KladrResult> action, String query, int limit, boolean withParent, String regionId, String districtId) throws URISyntaxException, IOException {
//        getKladr(action, new Filter()
//                .addLimit(limit)
//                .addQuery(query)
//                .addWithParent(withParent)
//                .addContentType(ContentType.CITY)
//                .addRegionId(regionId)
//                .addDistrictId(districtId));
//    }

    public static void getStreet(final Action<KladrResult> action, String query, int limit, boolean withParent, String cityId) throws URISyntaxException, IOException {
        getKladr(action, new Filter()
                .addLimit(limit)
                .addQuery(query)
                .addWithParent(withParent)
                .addContentType(ContentType.STREET)
                .addCityId(cityId));
    }

    public static void getBuildingByCityId(final Action<KladrResult> action, String query, int limit, boolean withParent, String cityId) throws URISyntaxException, IOException {
        getKladr(action, new Filter()
                .addLimit(limit)
                .addQuery(query)
                .addWithParent(withParent)
                .addContentType(ContentType.BUILDING)
                .addCityId(cityId));
    }

    public static void getBuildingByStreetId(final Action<KladrResult> action, String query, int limit, boolean withParent, String streetId) throws URISyntaxException, IOException {
        getKladr(action, new Filter()
                .addLimit(limit)
                .addQuery(query)
                .addWithParent(withParent)
                .addContentType(ContentType.BUILDING)
                .addStreetId(streetId));
    }

    //TODO: need test!
    public static void getBuilding(final Action<KladrResult> action, String query, int limit, boolean withParent, String streetId, String cityId) throws URISyntaxException, IOException {
        getKladr(action, new Filter()
                .addLimit(limit)
                .addQuery(query)
                .addWithParent(withParent)
                .addContentType(ContentType.BUILDING)
                .addStreetId(streetId)
                .addCityId(cityId));
    }

}
