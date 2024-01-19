//package com.iiitb.imageEffectApplication.controller;
//
//import com.iiitb.imageEffectApplication.model.LogModel;
//import com.iiitb.imageEffectApplication.service.LoggingService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/logs")
//public class LogController {
//
//    @Autowired
//    private LoggingService loggingService;
//
//    @GetMapping("")
//    public List<LogModel> getAllLogs() {
//        return loggingService.getAllLogs();
//    }
//
//
//    @GetMapping("/{effectName}")
//    public List<LogModel> getLogsByEffect(@PathVariable String effectName) {
//        return loggingService.getLogsByEffect(effectName);
//    }
//
//    @DeleteMapping("")
//    public ResponseEntity<String> clearLogs() {
//        loggingService.clearLogs();
//        return ResponseEntity.ok("Logs cleared successfully");
//    }
//}
package com.iiitb.imageEffectApplication.controller;

import com.iiitb.imageEffectApplication.model.LogModel;
import com.iiitb.imageEffectApplication.service.LoggingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/logs")
public class LogController {

    @Autowired
    private LoggingService loggingService;

    @GetMapping("")
    public List<LogModel> getAllLogs() {
        return loggingService.getAllLogs();
    }


    @GetMapping("/{effectName}")
    public List<LogModel> getLogsByEffect(@PathVariable String effectName) {
        return loggingService.getLogsByEffect(effectName);
    }

    @DeleteMapping("")
    public ResponseEntity<String> clearLogs() {
        loggingService.clearLogs();
        return ResponseEntity.ok("Logs cleared successfully");
    }

    @GetMapping("/between-timestamps")
    public List<LogModel> getLogsBetweenTimestamps(@RequestParam String startTime, @RequestParam String endTime)
    {
        // Parse the timestamps to LocalDateTime, you may need to adjust the date-time format
        LocalDateTime startTimestamp = LocalDateTime.parse(startTime, DateTimeFormatter.ISO_DATE_TIME);
        LocalDateTime endTimestamp = LocalDateTime.parse(endTime, DateTimeFormatter.ISO_DATE_TIME);

        return loggingService.getLogsBetweenTimestamps(startTimestamp, endTimestamp);
    }
}