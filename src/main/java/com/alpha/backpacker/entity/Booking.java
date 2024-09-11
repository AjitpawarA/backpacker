package com.alpha.backpacker.entity;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Temporal(TemporalType.DATE)
    private Date checkinDate;

    @Temporal(TemporalType.DATE)
    private Date checkoutDate;

    @ManyToOne
    private Userr user;

    @OneToMany
    private List<Room> rooms;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCheckinDate() {
		return checkinDate;
	}

	public void setCheckinDate(Date checkinDate) {
		this.checkinDate = checkinDate;
	}

	public Date getCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(Date checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	public Userr getUser() {
		return user;
	}

	public void setUser(Userr user) {
		this.user = user;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

    // Getters and Setters
    
    
    
}
