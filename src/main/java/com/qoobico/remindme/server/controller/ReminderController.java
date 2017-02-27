package com.qoobico.remindme.server.controller;

import com.qoobico.remindme.server.entity.Remind;
import com.qoobico.remindme.server.service.ReminderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class ReminderController {

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public String getMessage(ModelMap model){
        return "dvdvd";
    }

    @Autowired
    private ReminderService service;

    @RequestMapping(value = "/reminders", method = RequestMethod.GET)
    @ResponseBody
    public List<Remind> getAllReminders() {
        return service.getAll();
    }

    @RequestMapping(value = "/reminders/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Remind getReminder(@PathVariable("id") long remindID) {
        return service.getByID(remindID);
    }

    @RequestMapping(value = "/reminders", method = RequestMethod.POST)
    @ResponseBody
    public Remind saveRemider(@RequestBody Remind remind) {
        return service.save(remind);
    }

    @RequestMapping(value = "/reminders/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable long id) {
        service.remove(id);
    }

}
