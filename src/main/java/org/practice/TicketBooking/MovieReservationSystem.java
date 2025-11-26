package org.practice.TicketBooking;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MovieReservationSystem {

    int availableSeats;

    Lock reservationLock;

    MovieReservationSystem(int availableSeats){
        this.availableSeats=availableSeats;
        reservationLock = new ReentrantLock();
    }

    public boolean reserveSeats(int numSeats){
        try{
            reservationLock.lock();
            if(availableSeats>numSeats){
                availableSeats-=numSeats;
                return true;
            }
        }
        finally {
            reservationLock.unlock();
        }
        return false;
    }

    public int getAvailableSeats(){
        return availableSeats;
    }
}
