package com.pt.isep.labdsoft.dto;

import java.util.List;

public class    PageDTO<T> {
    private List<T> content;
    private long number;
    private long size;
    private long totalElements;
    private long totalPages;

    public PageDTO(List<T> content, long number, long size, long totalElements, long totalPages){
        this.content = content;
        this.number = number;
        this.size = size;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
    }

    public List<T> getContent(){ return content;}

    public void setContent(List<T> content) {
        this.content = content;
    }

    public long getNumber(){ return number;}

    public long getSize() {
        return size;
    }

    public long getTotalElements(){
        return totalElements;
    }

    public long getTotalPages(){
        return totalPages;
    }
}

