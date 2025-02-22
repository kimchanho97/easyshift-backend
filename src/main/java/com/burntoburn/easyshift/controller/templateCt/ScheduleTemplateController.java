package com.burntoburn.easyshift.controller.templateCt;

import com.burntoburn.easyshift.dto.schedule.req.ScheduleTemplateRequest;
import com.burntoburn.easyshift.entity.schedule.ScheduleTemplate;
import com.burntoburn.easyshift.service.schedule.ScheduleTemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/schedule-templates")
public class ScheduleTemplateController {
    private final ScheduleTemplateService scheduleTemplateService;

    /**
     * 스케줄 템플릿 생성 API
     */
    @PostMapping("/{storeId}")
    public ResponseEntity<ScheduleTemplate> createScheduleTemplate(
            @PathVariable Long storeId,
            @RequestBody ScheduleTemplateRequest request) {
        ScheduleTemplate createdTemplate = scheduleTemplateService.createScheduleTemplate(storeId, request);
        return ResponseEntity.ok(createdTemplate);
    }
}
