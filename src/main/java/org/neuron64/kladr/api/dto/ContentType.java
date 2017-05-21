package org.neuron64.kladr.api.dto;

/**
 * Created by dpuzikov on 16.05.17.
 */

public enum ContentType {

    REGION {
        @Override
        public String toString() {
            return "region";
        }
    },
    DISTRICT {
        @Override
        public String toString() {
            return "district";
        }
    },
    CITY{
        @Override
        public String toString() {
            return "city";
        }
    },
    STREET{
        @Override
        public String toString() {
            return "street";
        }
    },
    BUILDING{
        @Override
        public String toString() {
            return "building";
        }
    };


    public abstract String toString();
}
