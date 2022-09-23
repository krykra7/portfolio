package com.krystiankrawczyk.portfolio.provider.mapper;

import com.krystiankrawczyk.portfolio.api.response.ServiceGroupResponse;
import com.krystiankrawczyk.portfolio.api.response.ServiceResponse;
import com.krystiankrawczyk.portfolio.db.ServiceGroupDb;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ServiceGroupsMapper {

    public List<ServiceGroupResponse> map(List<ServiceGroupDb> serviceGroups) {
        return serviceGroups
                .stream()
                .map(group -> new ServiceGroupResponse(group.getTitle(), mapService(group)))
                .collect(Collectors.toList());
    }

    private List<ServiceResponse> mapService(ServiceGroupDb serviceGroupDb) {
        return serviceGroupDb
                .getServices()
                .stream()
                .map(serviceDb -> new ServiceResponse(serviceDb.getName()))
                .collect(Collectors.toList());
    }
}
