package org.neuron64.kladr.api.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by dpuzikov on 16.05.17.
 */

public class KladrObject {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("zip")
    @Expose
    private Integer zip;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("typeShort")
    @Expose
    private String typeShort;
    @SerializedName("okato")
    @Expose
    private String okato;
    @SerializedName("contentType")
    @Expose
    private String contentType;
    @SerializedName("parents")
    @Expose
    private List<KladrObject> parents = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getZip() {
        return zip;
    }

    public void setZip(Integer zip) {
        this.zip = zip;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeShort() {
        return typeShort;
    }

    public void setTypeShort(String typeShort) {
        this.typeShort = typeShort;
    }

    public String getOkato() {
        return okato;
    }

    public void setOkato(String okato) {
        this.okato = okato;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public List<KladrObject> getParents() {
        return parents;
    }

    public void setParents(List<KladrObject> parents) {
        this.parents = parents;
    }

    @Override
    public String toString() {
        return "KladrObject{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", zip=" + zip +
                ", type='" + type + '\'' +
                ", typeShort='" + typeShort + '\'' +
                ", okato='" + okato + '\'' +
                ", contentType='" + contentType + '\'' +
                ", parents=" + parents +
                '}';
    }
}
