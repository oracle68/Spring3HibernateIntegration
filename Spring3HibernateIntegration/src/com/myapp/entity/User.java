package com.myapp.entity;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.type.EnumType;


@Entity (name = "Usuarios")
@Table(name="USUARIOS")
public class User {

    @Id
    @Column(name="USER_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_id")
    @SequenceGenerator(name="seq_id", sequenceName = "seqid")
     private Integer id;
    @NotNull //(message="Camp firstname obligatori")
    @Column(name="FIRST_NAME")
    private String firstname;
    
    //@NotNull(message="Camp lastname obligatori")
    @NotNull
    @Column(name="LAST_NAME")
    private String lastname;

    @NotNull
    @Column(name="GENDER")
    private String gender;
  
    
	@OneToOne(cascade = CascadeType.PERSIST) //, orphanRemoval = false) //fetch = FetchType.EAGER, 
	@JoinColumn(name="IDCITY")
    private City city;
     
    public Integer getId() {
        return id;
    }
     
    public String getFirstName() {
        return firstname;
    }
    public String getLastName() {
        return lastname;
    }

    public City getCity() {
        return city;
    }

    public void setFirstName(String firstname) {
        this.firstname = firstname;
    }
    public void setLastName(String lastname) {
        this.lastname = lastname;
    }
    public void setCity (City city) {
        this.city = city;
    }
    public void setId(Integer id) {
        this.id = id;
    }

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", gender=" + gender
				+ ", city=" + city + "]";
	}
    
    
}
