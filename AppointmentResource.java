package com.hendisantika.onlinebanking.resource;

import com.hendisantika.onlinebanking.entity.Appointment;
import com.hendisantika.onlinebanking.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : online-banking
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 09/08/18
 * Time: 04.31
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping("/api/appointment")
@PreAuthorize("hasRole('ADMIN')")
@RequiredArgsConstructor
public class AppointmentResource {

    private final AppointmentService appointmentService;

    @RequestMapping("/all")
    public List<Appointment> findAppointmentList() {
        return appointmentService.findAll();
    }

    @RequestMapping("/{id}/confirm")
    public void confirmAppointment(@PathVariable("id") Long id) {
        appointmentService.confirmAppointment(id);
    }
}
