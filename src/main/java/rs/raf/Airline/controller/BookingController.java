package rs.raf.Airline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rs.raf.Airline.repositories.BookingRepository;
import rs.raf.Airline.repositories.custom.services.UserService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/booking")
public class BookingController {

    @Autowired
    private UserService userService;

    @DeleteMapping("/{id}")
    public String deleteBooking(@PathVariable("id") Long id) {
        System.out.println(id);
        userService.deleteBooking(id);
        return "Booking deleted!!!";
    }

    @PutMapping("/reserveBooking/{id}")
    public String reserveBooking(@PathVariable("id") Long id) {
        System.out.println("USO");
        System.out.println(id);
        //System.out.println(bookingDto.getId());
        userService.reserveBooking(id);
        return "Booking Reserved";
    }
}
