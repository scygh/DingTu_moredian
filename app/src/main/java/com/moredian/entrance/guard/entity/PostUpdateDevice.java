package com.moredian.entrance.guard.entity;

/**
 * description ：
 * author : scy
 * email : 1797484636@qq.com
 * date : 2020/7/16 08:50
 */
public class PostUpdateDevice {

    /**
     * Id : 0
     * AutoAmount : string
     * Pattern : string
     * LinkIpAddress : string
     * LinkPort : string
     * FirmwareVersion : string
     */

    private int Id;
    private String AutoAmount;
    private String Pattern;
    private String LinkIpAddress;
    private String LinkPort;
    private String FirmwareVersion;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getAutoAmount() {
        return AutoAmount;
    }

    public void setAutoAmount(String AutoAmount) {
        this.AutoAmount = AutoAmount;
    }

    public String getPattern() {
        return Pattern;
    }

    public void setPattern(String Pattern) {
        this.Pattern = Pattern;
    }

    public String getLinkIpAddress() {
        return LinkIpAddress;
    }

    public void setLinkIpAddress(String LinkIpAddress) {
        this.LinkIpAddress = LinkIpAddress;
    }

    public String getLinkPort() {
        return LinkPort;
    }

    public void setLinkPort(String LinkPort) {
        this.LinkPort = LinkPort;
    }

    public String getFirmwareVersion() {
        return FirmwareVersion;
    }

    public void setFirmwareVersion(String FirmwareVersion) {
        this.FirmwareVersion = FirmwareVersion;
    }
}
