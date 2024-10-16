package ru.eqour.spring.lab2.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.eqour.spring.lab2.model.Request;

@Service
@Qualifier("modifyCompositeRequestService")
public class ModifyCompositeRequestService implements ModifyRequestService {

    private final ModifyRequestService systemNameService;
    private final ModifyRequestService sourceService;
    private final ModifyRequestService systemTimeService;

    public ModifyCompositeRequestService(
            @Qualifier("modifySystemNameRequestService") ModifyRequestService systemNameService,
            @Qualifier("modifySourceRequestService") ModifyRequestService sourceService,
            @Qualifier("modifySystemTimeRequestService") ModifyRequestService systemTimeService
    ) {
        this.systemNameService = systemNameService;
        this.sourceService = sourceService;
        this.systemTimeService = systemTimeService;
    }

    @Override
    public void modify(Request request) {
        sourceService.modify(request);
        systemTimeService.modify(request);
        systemNameService.modify(request);
    }
}
