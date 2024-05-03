// 
// Decompiled by Procyon v0.5.36
// 

package io.javabrains.springsecurityjwt.model;

import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;

@Entity
@Table(name = "igl_web_mobile_users")
public class Users
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_user;
    @Column(name = "user_emailid")
    private String userName;
    @Column(name = "password")
    private String password;
    @Column(name = "first_name")
    private String first_name;
    @Column(name = "last_name")
    private String last_name;
    @Column(name = "status")
    private int status;
    @Column(name = "type_user")
    private String type_user;
    @Column(name = "imei_number")
    private String imei_number;
    @Column(name = "zone_id")
    private String zoneId;
    @Column(name = "latitude")
    private String latitude;
    @Column(name = "longitude")
    private String longitude;
    @Column(name = "user_mobno")
    private String mobileNo;
    
    public String getLatitude() {
        return this.latitude;
    }
    
    public void setLatitude(final String latitude) {
        this.latitude = latitude;
    }
    
    public String getLongitude() {
        return this.longitude;
    }
    
    public void setLongitude(final String longitude) {
        this.longitude = longitude;
    }
    
    public String getMobileNo() {
        return this.mobileNo;
    }
    
    public void setMobileNo(final String mobileNo) {
        this.mobileNo = mobileNo;
    }
    
    public String getZoneId() {
        return this.zoneId;
    }
    
    public void setZoneId(final String zoneId) {
        this.zoneId = zoneId;
    }
    
    public int getId_user() {
        return this.id_user;
    }
    
    public void setId_user(final int id_user) {
        this.id_user = id_user;
    }
    
    public String getUserName() {
        return this.userName;
    }
    
    public void setUserName(final String userName) {
        this.userName = userName;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(final String password) {
        this.password = password;
    }
    
    public String getFirst_name() {
        return this.first_name;
    }
    
    public String getLast_name() {
        return this.last_name;
    }
    
    public int getStatus() {
        return this.status;
    }
    
    public String getType_user() {
        return this.type_user;
    }
    
    public String getImei_number() {
        return this.imei_number;
    }
    
    public void setFirst_name(final String first_name) {
        this.first_name = first_name;
    }
    
    public void setLast_name(final String last_name) {
        this.last_name = last_name;
    }
    
    public void setStatus(final int status) {
        this.status = status;
    }
    
    public void setType_user(final String type_user) {
        this.type_user = type_user;
    }
    
    public void setImei_number(final String imei_number) {
        this.imei_number = imei_number;
    }
}
