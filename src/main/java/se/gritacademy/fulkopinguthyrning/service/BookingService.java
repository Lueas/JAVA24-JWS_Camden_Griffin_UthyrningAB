package se.gritacademy.fulkopinguthyrning.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.gritacademy.fulkopinguthyrning.dto.BookingRequest;
import se.gritacademy.fulkopinguthyrning.exception.NotFoundException;
import se.gritacademy.fulkopinguthyrning.model.Booking;
import se.gritacademy.fulkopinguthyrning.model.Item;
import se.gritacademy.fulkopinguthyrning.model.Person;
import se.gritacademy.fulkopinguthyrning.repository.BookingRepo;
import se.gritacademy.fulkopinguthyrning.repository.ItemRepo;
import se.gritacademy.fulkopinguthyrning.repository.PersonRepo;
import java.util.List;

@Service
public class BookingService {
    @Autowired
    private BookingRepo bookingRepo;
    @Autowired
    private ItemRepo itemRepo;
    @Autowired
    private PersonRepo personRepo;

    public List<Booking> getAllBookings() {
        return bookingRepo.findAll();
    }

    @Transactional
    public Booking createBooking(BookingRequest bookingRequest) {
        if (bookingRequest.getRentalStartDate().isAfter(bookingRequest.getRentalEndDate())) {
            throw new IllegalArgumentException("Rental start date cannot be after end date.");
        }

        Item item = itemRepo.findById(bookingRequest.getItemId())
                .orElseThrow(() -> new NotFoundException("Item not found with id: " + bookingRequest.getItemId()));

        Person person = personRepo.findById(bookingRequest.getPersonId())
                .orElseThrow(() -> new NotFoundException("Person not found with id: " + bookingRequest.getPersonId()));

        Booking newBooking = new Booking();
        newBooking.setItem(item);
        newBooking.setPerson(person);
        newBooking.setRentalStartDate(bookingRequest.getRentalStartDate());
        newBooking.setRentalEndDate(bookingRequest.getRentalEndDate());

        return bookingRepo.save(newBooking);
    }

    public void deleteBooking(Long id) {
        Booking booking = bookingRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Booking not found with id: " + id));
        bookingRepo.delete(booking);
    }
}