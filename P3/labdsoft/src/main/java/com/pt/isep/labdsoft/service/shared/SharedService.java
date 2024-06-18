package com.pt.isep.labdsoft.service.shared;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Service
public class SharedService {

    public Pageable buildPageable(Class c, String orderBy, String sortOrder, int pageNumber, int pageSize){
        boolean propertyFound = orderBy != null ? Arrays.stream(c.getDeclaredFields()).anyMatch(field -> field.getName().equals(orderBy)) : false;
        Pageable pageable;
        if(propertyFound){
            Sort sort;
            if(sortOrder != null){
                Sort.Direction direction = Sort.Direction.DESC.toString().equalsIgnoreCase(sortOrder) ? Sort.Direction.DESC : Sort.Direction.ASC;
                sort = Sort.by(direction, orderBy);
            } else {
                sort = Sort.by(orderBy);
            }
            pageable = PageRequest.of(pageNumber, pageSize, sort);
        } else {
            pageable = PageRequest.of(pageNumber, pageSize);
        }
        return pageable;
    }

    public static String getDate(LocalDate date){ return date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));}
}
