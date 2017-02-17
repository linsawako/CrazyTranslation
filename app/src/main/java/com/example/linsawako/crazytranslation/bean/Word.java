package com.example.linsawako.crazytranslation.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by linsawako on 2017/2/16.
 */

public class Word implements Serializable {

    /**
     * translation : ["坏"]
     * basic : {"us-phonetic":"bæd","phonetic":"bæd","uk-phonetic":"bæd","explains":["n. 坏事；坏人","adj. 坏的；严重的；劣质的","adv. 很，非常；坏地；邪恶地","n. (Bad)人名；(罗)巴德"]}
     * query : bad
     * errorCode : 0
     * web : [{"value":["坏的","真棒","Bad世界巡回演唱会"],"key":"bad"},{"value":["坏帐","呆帐","坏账"],"key":"bad debt"},{"value":["巴特迪克海姆县","巴德迪尔克海姆","迪克海姆"],"key":"Bad Dürkheim"}]
     */

    private BasicBean basic;
    private String query;
    private int errorCode;
    private List<String> translation;
    private List<WebBean> web;

    public BasicBean getBasic() {
        return basic;
    }

    public void setBasic(BasicBean basic) {
        this.basic = basic;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public List<String> getTranslation() {
        return translation;
    }

    public void setTranslation(List<String> translation) {
        this.translation = translation;
    }

    public List<WebBean> getWeb() {
        return web;
    }

    public void setWeb(List<WebBean> web) {
        this.web = web;
    }

    public static class BasicBean implements Serializable {
        /**
         * us-phonetic : bæd
         * phonetic : bæd
         * uk-phonetic : bæd
         * explains : ["n. 坏事；坏人","adj. 坏的；严重的；劣质的","adv. 很，非常；坏地；邪恶地","n. (Bad)人名；(罗)巴德"]
         */

        @SerializedName("us-phonetic")
        private String usphonetic;
        private String phonetic;
        @SerializedName("uk-phonetic")
        private String ukphonetic;
        private List<String> explains;

        public String getUsphonetic() {
            return usphonetic;
        }

        public void setUsphonetic(String usphonetic) {
            this.usphonetic = usphonetic;
        }

        public String getPhonetic() {
            return phonetic;
        }

        public void setPhonetic(String phonetic) {
            this.phonetic = phonetic;
        }

        public String getUkphonetic() {
            return ukphonetic;
        }

        public void setUkphonetic(String ukphonetic) {
            this.ukphonetic = ukphonetic;
        }

        public List<String> getExplains() {
            return explains;
        }

        public void setExplains(List<String> explains) {
            this.explains = explains;
        }
    }

    public static class WebBean implements Serializable {
        /**
         * value : ["坏的","真棒","Bad世界巡回演唱会"]
         * key : bad
         */

        private String key;
        private List<String> value;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public List<String> getValue() {
            return value;
        }

        public void setValue(List<String> value) {
            this.value = value;
        }
    }
}
