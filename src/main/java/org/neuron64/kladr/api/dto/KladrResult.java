package org.neuron64.kladr.api.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by dpuzikov on 16.05.17.
 */

public class KladrResult {

    @SerializedName("result")
    @Expose
    private List<KladrObject> result = null;

    public List<KladrObject> getResult() {
        return result;
    }

    public void setResult(List<KladrObject> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "KladrResult{" +
                "result=" + result +
                '}';
    }
}
