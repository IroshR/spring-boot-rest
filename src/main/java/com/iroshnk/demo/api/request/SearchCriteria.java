package com.iroshnk.demo.api.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel
public class SearchCriteria extends Request {
    @JsonIgnore
    public int PK;
    @JsonIgnore
    public String KEY;
    public List<Integer> PKs;
    public int offset;
    public int limit = 1000;
    public List<String> searchKeys;
    public List<Object> values;
    @ApiModelProperty(value = "EQ - equal, GT - greater than, GTE - greater than or equal, LT - less than, LTE - less than or equal, LIKE - like")
    public List<String> operators;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "Format yyyy-MM-dd")
    public Date fromDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "Format yyyy-MM-dd")
    public Date toDate;
    @ApiModelProperty(value = "Key for order by operation.")
    public String orderByKey;
    @ApiModelProperty(value = "ASC - ascending, DESC descending")
    public String orderByValue;
    public List<Integer> statuses;
    @ApiModelProperty(value = "DATE - day wise,MONTH - month wise, YEAR - year wise")
    public String groupBy;
}
