package com.iroshnk.demo.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user")
@Cacheable(value = true)
@NamedQueries({
        @NamedQuery(name = "User.findByUsername", query = "SELECT o FROM User o WHERE o.username = :username AND o.status <> 4"),
        @NamedQuery(name = "User.findBySessionId", query = "SELECT o FROM User o WHERE o.sessionId = :sessionId AND o.status = 2")
})
public class User extends Model {
    public static final String PK_TYPE = "SMALLINT(5) UNSIGNED";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId", updatable = false, nullable = false, columnDefinition = PK_TYPE + " AUTO_INCREMENT")
    private Integer userId;
    @Column(name = "username", unique = true, columnDefinition = "VARCHAR(20)")
    private String username;
    @Column(name = "password", unique = true, columnDefinition = "VARCHAR(200)")
    private String password;

    @Column(name = "firstName", nullable = false, columnDefinition = "VARCHAR(100)")
    private String firstName;
    @Column(name = "middleName", columnDefinition = "VARCHAR(40)")
    private String middleName;
    @Column(name = "lastName", columnDefinition = "VARCHAR(40)")
    private String lastName;
    @Column(name = "gender", columnDefinition = "VARCHAR(6)")
    private String gender;

    @Column(name = "address1", columnDefinition = "VARCHAR(100)")
    private String address1;
    @Column(name = "address2", columnDefinition = "VARCHAR(100)")
    private String address2;
    @Column(name = "city", columnDefinition = "VARCHAR(60)")
    private String city;
    @Column(name = "postalCode", columnDefinition = "VARCHAR(16)")
    private String postalCode;

    @Column(name = "email", columnDefinition = "VARCHAR(50)")
    private String email;
    @Column(name = "mobile", columnDefinition = "VARCHAR(20)")
    private String mobile;
    @Column(name = "telephone", columnDefinition = "VARCHAR(20)")
    private String telephone;

    @Column(name = "dateOfBirth")
    @Temporal(value = TemporalType.DATE)
    private Date dateOfBirth;

    @Column(name = "udid", columnDefinition = "VARCHAR(200)")
    private String udid;//unique device id
    @Column(name = "sessionId", columnDefinition = "VARCHAR(40)")
    private String sessionId;
    @Column(name = "token", columnDefinition = "VARCHAR(40)")
    private String token;
    @Column(name = "noOfLogins", nullable = false, columnDefinition = "SMALLINT(5) UNSIGNED default '0'")
    private int noOfLogins;
    @Column(name = "lastLoginDate", nullable = true)
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date lastLoginDate;

    @Column(name = "superUser", nullable = false, columnDefinition = "TINYINT(1) UNSIGNED default '0'")
    private boolean superUser;
    @Column(name = "xAdmin", nullable = false, columnDefinition = "TINYINT(1) UNSIGNED default '0'")
    private boolean xAdmin;

    @Column(name = "expiryDate")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date expiryDate;

    @Column(name = "ipList", columnDefinition = "VARCHAR(100)")
    private String ipList;

    @Column(name = "locale", columnDefinition = "CHAR(2)")
    private String locale;

    @Transient
    private transient String pwd;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getUdid() {
        return udid;
    }

    public void setUdid(String udid) {
        this.udid = udid;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getNoOfLogins() {
        return noOfLogins;
    }

    public void setNoOfLogins(int noOfLogins) {
        this.noOfLogins = noOfLogins;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public boolean isSuperUser() {
        return superUser;
    }

    public void setSuperUser(boolean superUser) {
        this.superUser = superUser;
    }

    public boolean isxAdmin() {
        return xAdmin;
    }

    public void setxAdmin(boolean xAdmin) {
        this.xAdmin = xAdmin;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getIpList() {
        return ipList;
    }

    public void setIpList(String ipList) {
        this.ipList = ipList;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}

