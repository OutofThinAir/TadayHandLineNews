package com.outofthinair.tadaynews.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/3/16.
 */

public class GunggaoBean {

    /**
     * log_extra : {"rit": 1, "convert_id": 0, "req_id": "201703161311521720171450038907AE"}
     * read_count : 120
     * ban_comment : 0
     * abstract :
     * image_list : []
     * open_url : suning://m.suning.com/index?adTypeCode=1013&adId=131155551_&utm_source=mediav&utm_medium=ttpdband&backurl=snssdk143://
     * has_video : false
     * article_type : 1
     * tag : ad
     * display_info : 五羊婴儿护肤柔湿巾10片 宝宝婴幼儿专用湿纸巾
     * has_m3u8_video : 0
     * rid : 201703161311521720171450038907AE
     * label : 苏宁广告
     * show_portrait_article : false
     * user_verified : 0
     * aggr_type : 1
     * expire_seconds : 86400
     * cell_type : 0
     * article_sub_type : 0
     * bury_count : 0
     * title : 五羊婴儿护肤柔湿巾10片 宝宝婴幼儿专用湿纸巾
     * ignore_web_transform : 1
     * source_icon_style : 3
     * tip : 0
     * hot : 0
     * share_url : http://product.suning.com/0000000000/131155551.html?utm_source=mediav&utm_medium=ttpdband
     * has_mp4_video : 0
     * source : 苏宁易购
     * comment_count : 0
     * article_url : http://product.suning.com/0000000000/131155551.html?utm_source=mediav&utm_medium=ttpdband
     * filter_words : [{"id":"2:0","name":"来源:苏宁易购","is_selected":false},{"id":"4:2","name":"看过了","is_selected":false}]
     * publish_time : 1478347265
     * ad_id : 52071454435
     * action_list : [{"action":1,"extra":{},"desc":""},{"action":3,"extra":{},"desc":""},{"action":7,"extra":{},"desc":""},{"action":9,"extra":{},"desc":""}]
     * has_image : false
     * cell_layout_style : 1
     * tag_id : 52071454436
     * video_style : 0
     * verified_content :
     * natant_level : 2
     * display_url : http://product.suning.com/0000000000/131155551.html?utm_source=mediav&utm_medium=ttpdband
     * large_image_list : []
     * item_id : 6349453154374926849
     * is_subject : false
     * show_portrait : false
     * repin_count : 1
     * cell_flag : 11
     * source_open_url : sslocal://search?from=feed_source&keyword=%E8%8B%8F%E5%AE%81%E6%98%93%E8%B4%AD
     * level : 0
     * digg_count : 0
     * behot_time : 1489640725
     * article_alt_url : http://product.suning.com/0000000000/131155551.html?utm_source=mediav&utm_medium=ttpdband
     * cursor : 1489640725999
     * url : http://product.suning.com/0000000000/131155551.html?utm_source=mediav&utm_medium=ttpdband
     * preload_web : 0
     * ad_label : 苏宁广告
     * user_repin : 0
     * label_style : 3
     * item_version : 0
     * group_id : 52071454436
     * middle_image : {"url":"http://image5.suning.cn/uimg/b2c/newcatentries/0000000000-000000000131155551_1_228x150.jpg","width":228,"url_list":[{"url":"http://image5.suning.cn/uimg/b2c/newcatentries/0000000000-000000000131155551_1_228x150.jpg"}],"uri":"http://image5.suning.cn/uimg/b2c/newcatentries/0000000000-000000000131155551_1_228x150.jpg","height":150}
     */

    private String log_extra;
    private int read_count;
    private int ban_comment;

    private String abstractX;
    private String open_url;
    private boolean has_video;
    private int article_type;
    private String tag;
    private String display_info;
    private int has_m3u8_video;
    private String rid;
    private String label;
    private boolean show_portrait_article;
    private int user_verified;
    private int aggr_type;
    private int expire_seconds;
    private int cell_type;
    private int article_sub_type;
    private int bury_count;
    private String title;
    private int ignore_web_transform;
    private int source_icon_style;
    private int tip;
    private int hot;
    private String share_url;
    private int has_mp4_video;
    private String source;
    private int comment_count;
    private String article_url;
    private int publish_time;
    private long ad_id;
    private boolean has_image;
    private int cell_layout_style;
    private long tag_id;
    private int video_style;
    private String verified_content;
    private int natant_level;
    private String display_url;
    private long item_id;
    private boolean is_subject;
    private boolean show_portrait;
    private int repin_count;
    private int cell_flag;
    private String source_open_url;
    private int level;
    private int digg_count;
    private int behot_time;
    private String article_alt_url;
    private long cursor;
    private String url;
    private int preload_web;
    private String ad_label;
    private int user_repin;
    private int label_style;
    private int item_version;
    private long group_id;
    private MiddleImageBean middle_image;
    private List<ImageBean> image_list;
    private List<FilterWordsBean> filter_words;
    private List<ActionListBean> action_list;
    private List<?> large_image_list;

    public String getLog_extra() {
        return log_extra;
    }

    public void setLog_extra(String log_extra) {
        this.log_extra = log_extra;
    }

    public int getRead_count() {
        return read_count;
    }

    public void setRead_count(int read_count) {
        this.read_count = read_count;
    }

    public int getBan_comment() {
        return ban_comment;
    }

    public void setBan_comment(int ban_comment) {
        this.ban_comment = ban_comment;
    }

    public String getAbstractX() {
        return abstractX;
    }

    public void setAbstractX(String abstractX) {
        this.abstractX = abstractX;
    }

    public String getOpen_url() {
        return open_url;
    }

    public void setOpen_url(String open_url) {
        this.open_url = open_url;
    }

    public boolean isHas_video() {
        return has_video;
    }

    public void setHas_video(boolean has_video) {
        this.has_video = has_video;
    }

    public int getArticle_type() {
        return article_type;
    }

    public void setArticle_type(int article_type) {
        this.article_type = article_type;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getDisplay_info() {
        return display_info;
    }

    public void setDisplay_info(String display_info) {
        this.display_info = display_info;
    }

    public int getHas_m3u8_video() {
        return has_m3u8_video;
    }

    public void setHas_m3u8_video(int has_m3u8_video) {
        this.has_m3u8_video = has_m3u8_video;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean isShow_portrait_article() {
        return show_portrait_article;
    }

    public void setShow_portrait_article(boolean show_portrait_article) {
        this.show_portrait_article = show_portrait_article;
    }

    public int getUser_verified() {
        return user_verified;
    }

    public void setUser_verified(int user_verified) {
        this.user_verified = user_verified;
    }

    public int getAggr_type() {
        return aggr_type;
    }

    public void setAggr_type(int aggr_type) {
        this.aggr_type = aggr_type;
    }

    public int getExpire_seconds() {
        return expire_seconds;
    }

    public void setExpire_seconds(int expire_seconds) {
        this.expire_seconds = expire_seconds;
    }

    public int getCell_type() {
        return cell_type;
    }

    public void setCell_type(int cell_type) {
        this.cell_type = cell_type;
    }

    public int getArticle_sub_type() {
        return article_sub_type;
    }

    public void setArticle_sub_type(int article_sub_type) {
        this.article_sub_type = article_sub_type;
    }

    public int getBury_count() {
        return bury_count;
    }

    public void setBury_count(int bury_count) {
        this.bury_count = bury_count;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIgnore_web_transform() {
        return ignore_web_transform;
    }

    public void setIgnore_web_transform(int ignore_web_transform) {
        this.ignore_web_transform = ignore_web_transform;
    }

    public int getSource_icon_style() {
        return source_icon_style;
    }

    public void setSource_icon_style(int source_icon_style) {
        this.source_icon_style = source_icon_style;
    }

    public int getTip() {
        return tip;
    }

    public void setTip(int tip) {
        this.tip = tip;
    }

    public int getHot() {
        return hot;
    }

    public void setHot(int hot) {
        this.hot = hot;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public int getHas_mp4_video() {
        return has_mp4_video;
    }

    public void setHas_mp4_video(int has_mp4_video) {
        this.has_mp4_video = has_mp4_video;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public int getComment_count() {
        return comment_count;
    }

    public void setComment_count(int comment_count) {
        this.comment_count = comment_count;
    }

    public String getArticle_url() {
        return article_url;
    }

    public void setArticle_url(String article_url) {
        this.article_url = article_url;
    }

    public int getPublish_time() {
        return publish_time;
    }

    public void setPublish_time(int publish_time) {
        this.publish_time = publish_time;
    }

    public long getAd_id() {
        return ad_id;
    }

    public void setAd_id(long ad_id) {
        this.ad_id = ad_id;
    }

    public boolean isHas_image() {
        return has_image;
    }

    public void setHas_image(boolean has_image) {
        this.has_image = has_image;
    }

    public int getCell_layout_style() {
        return cell_layout_style;
    }

    public void setCell_layout_style(int cell_layout_style) {
        this.cell_layout_style = cell_layout_style;
    }

    public long getTag_id() {
        return tag_id;
    }

    public void setTag_id(long tag_id) {
        this.tag_id = tag_id;
    }

    public int getVideo_style() {
        return video_style;
    }

    public void setVideo_style(int video_style) {
        this.video_style = video_style;
    }

    public String getVerified_content() {
        return verified_content;
    }

    public void setVerified_content(String verified_content) {
        this.verified_content = verified_content;
    }

    public int getNatant_level() {
        return natant_level;
    }

    public void setNatant_level(int natant_level) {
        this.natant_level = natant_level;
    }

    public String getDisplay_url() {
        return display_url;
    }

    public void setDisplay_url(String display_url) {
        this.display_url = display_url;
    }

    public long getItem_id() {
        return item_id;
    }

    public void setItem_id(long item_id) {
        this.item_id = item_id;
    }

    public boolean isIs_subject() {
        return is_subject;
    }

    public void setIs_subject(boolean is_subject) {
        this.is_subject = is_subject;
    }

    public boolean isShow_portrait() {
        return show_portrait;
    }

    public void setShow_portrait(boolean show_portrait) {
        this.show_portrait = show_portrait;
    }

    public int getRepin_count() {
        return repin_count;
    }

    public void setRepin_count(int repin_count) {
        this.repin_count = repin_count;
    }

    public int getCell_flag() {
        return cell_flag;
    }

    public void setCell_flag(int cell_flag) {
        this.cell_flag = cell_flag;
    }

    public String getSource_open_url() {
        return source_open_url;
    }

    public void setSource_open_url(String source_open_url) {
        this.source_open_url = source_open_url;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getDigg_count() {
        return digg_count;
    }

    public void setDigg_count(int digg_count) {
        this.digg_count = digg_count;
    }

    public int getBehot_time() {
        return behot_time;
    }

    public void setBehot_time(int behot_time) {
        this.behot_time = behot_time;
    }

    public String getArticle_alt_url() {
        return article_alt_url;
    }

    public void setArticle_alt_url(String article_alt_url) {
        this.article_alt_url = article_alt_url;
    }

    public long getCursor() {
        return cursor;
    }

    public void setCursor(long cursor) {
        this.cursor = cursor;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getPreload_web() {
        return preload_web;
    }

    public void setPreload_web(int preload_web) {
        this.preload_web = preload_web;
    }

    public String getAd_label() {
        return ad_label;
    }

    public void setAd_label(String ad_label) {
        this.ad_label = ad_label;
    }

    public int getUser_repin() {
        return user_repin;
    }

    public void setUser_repin(int user_repin) {
        this.user_repin = user_repin;
    }

    public int getLabel_style() {
        return label_style;
    }

    public void setLabel_style(int label_style) {
        this.label_style = label_style;
    }

    public int getItem_version() {
        return item_version;
    }

    public void setItem_version(int item_version) {
        this.item_version = item_version;
    }

    public long getGroup_id() {
        return group_id;
    }

    public void setGroup_id(long group_id) {
        this.group_id = group_id;
    }

    public MiddleImageBean getMiddle_image() {
        return middle_image;
    }

    public void setMiddle_image(MiddleImageBean middle_image) {
        this.middle_image = middle_image;
    }

    public List<ImageBean> getImage_list() {
        return image_list;
    }

    public void setImage_list(List<ImageBean> image_list) {
        this.image_list = image_list;
    }

    public List<FilterWordsBean> getFilter_words() {
        return filter_words;
    }

    public void setFilter_words(List<FilterWordsBean> filter_words) {
        this.filter_words = filter_words;
    }

    public List<ActionListBean> getAction_list() {
        return action_list;
    }

    public void setAction_list(List<ActionListBean> action_list) {
        this.action_list = action_list;
    }

    public List<?> getLarge_image_list() {
        return large_image_list;
    }

    public void setLarge_image_list(List<?> large_image_list) {
        this.large_image_list = large_image_list;
    }

    public static class MiddleImageBean {
        /**
         * url : http://image5.suning.cn/uimg/b2c/newcatentries/0000000000-000000000131155551_1_228x150.jpg
         * width : 228
         * url_list : [{"url":"http://image5.suning.cn/uimg/b2c/newcatentries/0000000000-000000000131155551_1_228x150.jpg"}]
         * uri : http://image5.suning.cn/uimg/b2c/newcatentries/0000000000-000000000131155551_1_228x150.jpg
         * height : 150
         */

        private String url;
        private int width;
        private String uri;
        private int height;
        private List<UrlListBean> url_list;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public List<UrlListBean> getUrl_list() {
            return url_list;
        }

        public void setUrl_list(List<UrlListBean> url_list) {
            this.url_list = url_list;
        }

        public static class UrlListBean {
            /**
             * url : http://image5.suning.cn/uimg/b2c/newcatentries/0000000000-000000000131155551_1_228x150.jpg
             */

            private String url;

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }

    public static class FilterWordsBean {
        /**
         * id : 2:0
         * name : 来源:苏宁易购
         * is_selected : false
         */

        private String id;
        private String name;
        private boolean is_selected;

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

        public boolean isIs_selected() {
            return is_selected;
        }

        public void setIs_selected(boolean is_selected) {
            this.is_selected = is_selected;
        }
    }

    public static class ActionListBean {
        /**
         * action : 1
         * extra : {}
         * desc :
         */

        private int action;
        private ExtraBean extra;
        private String desc;

        public int getAction() {
            return action;
        }

        public void setAction(int action) {
            this.action = action;
        }

        public ExtraBean getExtra() {
            return extra;
        }

        public void setExtra(ExtraBean extra) {
            this.extra = extra;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public static class ExtraBean {
        }
    }
}
