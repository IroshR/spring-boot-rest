package com.iroshnk.demo.model;

import org.eclipse.persistence.annotations.CacheCoordinationType;
import org.eclipse.persistence.annotations.CacheType;

import javax.persistence.*;

@Entity
@Table(name = "brand")
@Cacheable(value = true)
@org.eclipse.persistence.annotations.Cache(type = CacheType.FULL, size = 1000, expiry = 900000, coordinationType = CacheCoordinationType.NONE)
public class Brand extends Model {
    public static final String PK_TYPE = "SMALLINT(5) UNSIGNED";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brandId", updatable = false, nullable = false, columnDefinition = PK_TYPE + " AUTO_INCREMENT")
    private Integer brandId;
    @Column(name = "name", nullable = false, columnDefinition = "VARCHAR(45)")
    private String name;
    @Column(name = "url", columnDefinition = "VARCHAR(100)")
    private String url;
    @Column(name = "description", columnDefinition = "VARCHAR(255)")
    private String description;
    @Column(name = "image", columnDefinition = "VARCHAR(45)")
    private String image;

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
