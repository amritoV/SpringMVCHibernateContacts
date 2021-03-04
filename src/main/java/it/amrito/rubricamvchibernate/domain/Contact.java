/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.amrito.rubricamvchibernate.domain;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PreRemove;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.hibernate.annotations.Cascade;

/**
 *
 * @author amrit
 */
@Entity
public class Contact extends AbstractEntity {
    
    public static final String MAIL_REGEX="^[A-Za-z0-9]+@[A-Za-z0-9]+.[a-z]{2,4}";
    
    public static final String PHONE_REGEX="^[0-9]{8,10}";

    @NotNull
    @NotBlank(message = "name is required")
    private String name;
    
    @NotNull
    @NotBlank(message = "surname is required")
    private String surname;
    
    @Pattern(regexp = PHONE_REGEX, message="phone number is invalid")
    private String telephone;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "contatto_gruppo",
            joinColumns = @JoinColumn(name = "id_contatto"),
            inverseJoinColumns = @JoinColumn(name = "id_gruppo")
    )
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Set<Group> groups = new HashSet<>();

    @OneToMany(mappedBy = "owner", fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<Group> ownedGroups = new HashSet<>();

    //@Column(unique=true)
    //@OneToOne
    //@Cascade(org.hibernate.annotations.CascadeType.ALL)
    //@NotNull
    //@Column( unique = true)
    @Pattern(regexp = MAIL_REGEX, message = "email is invalid")
    private String email;

    @OneToMany(mappedBy = "sender")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Set<Message> messages = new TreeSet<>();
    

    /**
     * COSTRUTTORI *
     */
    public Contact() {

    }
    
    public Contact(String email){
        this.email=email;
    }

    public Contact(String name, String surname, String telephone, String email) {
        this.name = name;
        this.surname = surname;
        this.telephone = telephone;
        this.email=email;
    }

    /**
     * GETTERS/SETTERS *
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

    public Set<Group> getOwnedGroups() {
        return ownedGroups;
    }

    public void setOwnedGroups(Set<Group> ownedGroups) {
        this.ownedGroups = ownedGroups;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Message> getMessages() {
        return messages;
    }

    public void setMessages(Set<Message> messages) {
        this.messages = messages;
    }

    /**
     * METODI DI UTILITÀ *
     */
    //public void addEmailRelationship(Email email) {
    //    email.setContact(this);
    //    setEmail(email);
    //}
    
    
    @PreRemove
    public void removeReferences(){
        for(Message m: messages){
            m.setSender(null);
        }
        messages.clear();
        /*
        for(Group g:ownedGroups){
            g.setOwner(null);
        }
        ownedGroups.clear();*/
    }

    public void addGruppoProprietarioRelationship(Group gruppo) {
        gruppo.setOwner(this);
        this.getOwnedGroups().add(gruppo);
    }

    public void addGruppoRelationship(Group gruppo) {
        gruppo.getContacts().add(this);
        this.getGroups().add(gruppo);
    }

    /**
     * TOSTRING/EQUALS/HASHCODE *
     */
    @Override
    public String toString() {
        boolean b = true;
        if (ownedGroups.isEmpty()) {
            b = false;
        }
        return "Contatto{" + "id=" + super.getId() + ", name=" + name + ", surname=" + surname + ", email=" + email + ", telephone=" + telephone + ", owner=" + b + '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || !(o instanceof Contact)) {
            return false;
        }
        Contact that = (Contact) o;
        return this.email.equals(that.email);
    }

}
