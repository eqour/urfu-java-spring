package ru.eqour.spring.lab2.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.eqour.spring.lab2.model.Request;
import ru.eqour.spring.lab2.util.DateTimeUtil;

import java.util.Date;

@Service
@Qualifier("modifySystemTimeRequestService")
public class ModifySystemTimeRequestService implements ModifyRequestService {

    @Override
    public void modify(Request request) {
        request.setSystemTime(DateTimeUtil.getCustomFormat().format(new Date()));
    }
}
