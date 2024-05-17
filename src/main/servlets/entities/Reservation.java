package entities;

import java.time.LocalDate;

public class Reservation {

 // New attribute
    private int reservationId;
    private int movieId;

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    private int userId;
    private int numberOfSeats;
    private LocalDate reservationDate;

    // Constructor


    public Reservation(int movieId, int userId, int numberOfSeats, LocalDate reservationDate) {
        this.movieId = movieId;
        this.userId = userId;
        this.numberOfSeats = numberOfSeats;
        this.reservationDate = reservationDate;
    }

    public Reservation() {
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public LocalDate getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDate reservationDate) {
        this.reservationDate = reservationDate;
    }
}
