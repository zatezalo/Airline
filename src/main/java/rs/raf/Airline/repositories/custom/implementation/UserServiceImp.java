package rs.raf.Airline.repositories.custom.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import rs.raf.Airline.model.Booking;
import rs.raf.Airline.model.MyUser;
import rs.raf.Airline.model.dto.authDto.RegisterDto;
import rs.raf.Airline.repositories.BookingRepository;
import rs.raf.Airline.repositories.UserRepository;
import rs.raf.Airline.repositories.custom.services.UserService;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public String register(RegisterDto registerDto) {
        MyUser user = userRepository.findByUsername(registerDto.getUsername());

        if (user != null) {
            return "That user with the username " + user.getUsername() + " already exists!!!";
        } else {
            MyUser u = new MyUser();
            u.setPassword(bCryptPasswordEncoder.encode(registerDto.getPassword()));
            u.setUsername(registerDto.getUsername());
            u.setUserType(registerDto.getUserType());

            userRepository.save(u);

            return "User Created!!";
        }
    }

    @Override
    public String deleteBooking(Long id) {
        bookingRepository.deleteById(id);
        return "Deleted Booking";
    }

    @Override
    public String reserveBooking(Long id) {
        Booking booking = bookingRepository.findById(id).get();
        booking.getTicket().setAvailableCount(booking.getTicket().getAvailableCount() - booking.getNumberOfBookings());
        booking.setAvailable(true);
        bookingRepository.save(booking);
        return "Booked !!!";
    }
}
