package com.green.greengram.common.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class Paging {
    private Integer page;
    private Integer size;

    public Paging(Integer page, Integer size){
        this.page = page;
        this.size = size == null || size == 0 ? 10 : size;
        this.startIdx = ( this.page - 1 ) < 0 ? 0 : ( this.page - 1 ) * this.size ;
    }
    @JsonIgnore
    private Integer startIdx;
}
