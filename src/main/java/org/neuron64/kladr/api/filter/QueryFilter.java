package org.neuron64.kladr.api.filter;

import java.util.Map;

/**
 * Created by neuron on 21.05.17.
 */
public class QueryFilter{

        public String buildFilter(Filter filter){
            String query = "";
            for(Map.Entry<String, String> ll : filter.getFilterFields().entrySet()){
                query += "&"
                        + ll.getKey()
                        + "="
                        + ll.getValue();
            }
            return query;
        }
}
