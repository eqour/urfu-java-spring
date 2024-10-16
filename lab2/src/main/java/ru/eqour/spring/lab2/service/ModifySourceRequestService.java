package ru.eqour.spring.lab2.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.eqour.spring.lab2.model.Request;

@Service
@Qualifier("modifySourceRequestService")
public class ModifySourceRequestService implements ModifyRequestService {

    @Override
    public void modify(Request request) {
        request.setSource("service-1-source");
    }
}
