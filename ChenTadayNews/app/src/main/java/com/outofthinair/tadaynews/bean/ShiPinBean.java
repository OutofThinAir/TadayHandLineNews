package com.outofthinair.tadaynews.bean;

/**
 * Created by Administrator on 2017/3/21.
 */

public class ShiPinBean {

    /**
     * cover : http://vimg2.ws.126.net/image/snapshot/2017/3/H/K/VCF4G6HHK.jpg
     * description :
     * length : 68
     * m3u8Hd_url : http://flv2.bn.netease.com/videolib3/1703/21/uxzVJ7405/HD/movie_index.m3u8
     * m3u8_url : http://flv2.bn.netease.com/videolib3/1703/21/uxzVJ7405/SD/movie_index.m3u8
     * mp4Hd_url : http://flv2.bn.netease.com/videolib3/1703/21/uxzVJ7405/HD/uxzVJ7405-mobile.mp4
     * mp4_url : http://flv2.bn.netease.com/videolib3/1703/21/uxzVJ7405/SD/uxzVJ7405-mobile.mp4
     * playCount : 0
     * playersize : 0
     * ptime : 2017-03-21 11:39:24
     * replyBoard : video_bbs
     * replyid : CF49S3Q5008535RB
     * sectiontitle :
     * title : 熊孩子打劫土豪美女 笑到肚子疼
     * topicDesc : 专业坑姐夫一百年,欧巴控 !专业坑姐夫一百年,欧巴控 !专业坑姐夫一百年,欧巴控 !专业坑姐夫一百年,欧巴控 !
     * topicImg : http://vimg2.ws.126.net/image/snapshot/2016/12/R/F/VC6JBL4RF.jpg
     * topicName : 姐夫别逗
     * topicSid : VC6JBL4R7
     * vid : VCF49S3Q5
     * videoTopic : {"alias":"专业坑姐夫一百年,欧巴控 !","ename":"T1480321267583","tid":"T1480321267583","tname":"姐夫别逗","topic_icons":"http://dingyue.nosdn.127.net/tlp7jMEwkwjxAz18VY81ZCGzmMGoJTfd7c1xNQoNIVrTI1480321267024.jpg"}
     * videosource : 新媒体
     */

    private String cover;
    private String description;
    private int length;
    private String m3u8Hd_url;
    private String m3u8_url;
    private String mp4Hd_url;
    private String mp4_url;
    private int playCount;
    private int playersize;
    private String ptime;
    private String replyBoard;
    private String replyid;
    private String sectiontitle;
    private String title;
    private String topicDesc;
    private String topicImg;
    private String topicName;
    private String topicSid;
    private String vid;
    private VideoTopicBean videoTopic;
    private String videosource;

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getM3u8Hd_url() {
        return m3u8Hd_url;
    }

    public void setM3u8Hd_url(String m3u8Hd_url) {
        this.m3u8Hd_url = m3u8Hd_url;
    }

    public String getM3u8_url() {
        return m3u8_url;
    }

    public void setM3u8_url(String m3u8_url) {
        this.m3u8_url = m3u8_url;
    }

    public String getMp4Hd_url() {
        return mp4Hd_url;
    }

    public void setMp4Hd_url(String mp4Hd_url) {
        this.mp4Hd_url = mp4Hd_url;
    }

    public String getMp4_url() {
        return mp4_url;
    }

    public void setMp4_url(String mp4_url) {
        this.mp4_url = mp4_url;
    }

    public int getPlayCount() {
        return playCount;
    }

    public void setPlayCount(int playCount) {
        this.playCount = playCount;
    }

    public int getPlayersize() {
        return playersize;
    }

    public void setPlayersize(int playersize) {
        this.playersize = playersize;
    }

    public String getPtime() {
        return ptime;
    }

    public void setPtime(String ptime) {
        this.ptime = ptime;
    }

    public String getReplyBoard() {
        return replyBoard;
    }

    public void setReplyBoard(String replyBoard) {
        this.replyBoard = replyBoard;
    }

    public String getReplyid() {
        return replyid;
    }

    public void setReplyid(String replyid) {
        this.replyid = replyid;
    }

    public String getSectiontitle() {
        return sectiontitle;
    }

    public void setSectiontitle(String sectiontitle) {
        this.sectiontitle = sectiontitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTopicDesc() {
        return topicDesc;
    }

    public void setTopicDesc(String topicDesc) {
        this.topicDesc = topicDesc;
    }

    public String getTopicImg() {
        return topicImg;
    }

    public void setTopicImg(String topicImg) {
        this.topicImg = topicImg;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getTopicSid() {
        return topicSid;
    }

    public void setTopicSid(String topicSid) {
        this.topicSid = topicSid;
    }

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public VideoTopicBean getVideoTopic() {
        return videoTopic;
    }

    public void setVideoTopic(VideoTopicBean videoTopic) {
        this.videoTopic = videoTopic;
    }

    public String getVideosource() {
        return videosource;
    }

    public void setVideosource(String videosource) {
        this.videosource = videosource;
    }

    public static class VideoTopicBean {
        /**
         * alias : 专业坑姐夫一百年,欧巴控 !
         * ename : T1480321267583
         * tid : T1480321267583
         * tname : 姐夫别逗
         * topic_icons : http://dingyue.nosdn.127.net/tlp7jMEwkwjxAz18VY81ZCGzmMGoJTfd7c1xNQoNIVrTI1480321267024.jpg
         */

        private String alias;
        private String ename;
        private String tid;
        private String tname;
        private String topic_icons;

        public String getAlias() {
            return alias;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public String getEname() {
            return ename;
        }

        public void setEname(String ename) {
            this.ename = ename;
        }

        public String getTid() {
            return tid;
        }

        public void setTid(String tid) {
            this.tid = tid;
        }

        public String getTname() {
            return tname;
        }

        public void setTname(String tname) {
            this.tname = tname;
        }

        public String getTopic_icons() {
            return topic_icons;
        }

        public void setTopic_icons(String topic_icons) {
            this.topic_icons = topic_icons;
        }
    }
}
