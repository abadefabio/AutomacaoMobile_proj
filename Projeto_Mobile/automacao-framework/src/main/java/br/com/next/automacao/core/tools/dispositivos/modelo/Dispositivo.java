package br.com.next.automacao.core.tools.dispositivos.modelo;


public class Dispositivo {
    private String platformName;
    private String platformVersion;
    private String deviceName;
    private String udid;
    private String deviceType;
    private String deviceHostingType;
    private String nickName;
    private Boolean connected;
    private String currentReservationStatus;
    private String connectorName;


    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String plataformName) {
        this.platformName = plataformName;
    }

    public String getPlatformVersion() {
        return platformVersion;
    }

    public void setPlatformVersion(String platformVersion) {
        this.platformVersion = platformVersion;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getUdid() {
        return udid;
    }

    public void setUdid(String udid) {
        this.udid = udid;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceHostingType() {
        return deviceHostingType;
    }

    public void setDeviceHostingType(String deviceHostingType) {
        this.deviceHostingType = deviceHostingType;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Boolean getConnected() {
        return connected;
    }

    private void setConnected(Boolean connected) {
        this.connected = connected;
    }

    public String getCurrentReservationStatus() {
        return currentReservationStatus;
    }

    private void setCurrentReservationStatus(String currentReservationStatus) {
        this.currentReservationStatus = currentReservationStatus;
    }

    public String getConnectorName() {
        return connectorName;
    }

    public void setConnectorName(String connectorName) {
        this.connectorName = connectorName;
    }
}