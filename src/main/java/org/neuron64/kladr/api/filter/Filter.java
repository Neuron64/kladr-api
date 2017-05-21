package org.neuron64.kladr.api.filter;

import org.neuron64.kladr.api.dto.ContentType;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by neuron on 21.05.17.
 */
public class Filter {

    private Map<String, String> filterFields = new HashMap<String, String>();

    public Filter addWithParent(boolean withParent){
        int mWithParent = withParent? 1 : 0;
        filterFields.put("withParent", String.valueOf(mWithParent));
        return this;
    }

    public Filter addLimit(int limit){
        filterFields.put("limit", String.valueOf(limit));
        return this;
    }

    public Filter addContentType(ContentType contentType){
        filterFields.put("contentType", contentType.toString());
        return this;
    }

    public Filter addQuery(String query){
        filterFields.put("query", URLEncoder.encode(query));
        return this;
    }

    public Filter addToken(String token){
        filterFields.put("token", token);
        return this;
    }

    public Filter addKay(String key){
        filterFields.put("token", key);
        return this;
    }

    public Filter addRegionId(String regionId){
        filterFields.put("regionId", regionId);
        return this;
    }

    public Filter addDistrictId(String districtId){
        filterFields.put("districtId", districtId);
        return this;
    }

    public Filter addCityId(String cityId){
        filterFields.put("cityId", cityId);
        return this;
    }

    public Filter addStreetId(String streetId){
        filterFields.put("streetId", streetId);
        return this;
    }

    public Filter addBuildingId(String buildingId){
        filterFields.put("buildingId", buildingId);
        return this;
    }

    public Filter addOffset(String offset){
        filterFields.put("offset", offset);
        return this;
    }

    /* TODO: Сделать доступным только для данных условий:
    zip — Почтовый индекс. Работает только при contentType = building.
    В этом случае можно не передать parentId.
    Поиск по почтовому индексу — это поиск по строениям (building),
    поэтому логично указать withParent = 1 и limit = 1,
    чтоб выбрать данные о регионе, нас. пункте и т.п.
    * */
    public Filter addZip(String zip){
        filterFields.put("zip", zip);
        return this;
    }

    /* TODO: Реализовать побитовые операции
    * typeCode — Тип объектов для выдачи:
    1 — города
    2 — поселки
    4 — деревни
    Битовые комбинации, например, 3 ( 1 | 2 ) — города и поселки*/

    public Filter addTypeCode(String typeCode){
        filterFields.put("typeCode", typeCode);
        return this;
    }

    public Map<String, String> getFilterFields() {
        return filterFields;
    }
}
