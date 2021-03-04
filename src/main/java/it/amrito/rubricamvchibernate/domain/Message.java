/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.amrito.rubricamvchibernate.domain;

import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.Cascade;

/**
 *
 * @author amrit
 */

@Entity
public class Message extends AbstractEntity implements Comparable<Message> {
    
    
    
    private String message;
    
    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Contact sender;
    
    @ManyToOne
    //@Column(name = "gruppo_receiver") //OTTENGO ERRORE ?
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Group receiver;
    
    @Column(columnDefinition = "TIMESTAMP") //Cosa fa ?
    private LocalDateTime date;
    
    
    /**COSTRUTTORI**/
     public Message(){
    }
     
    public Message(String message, Contact sender, Group receiver){
        this.message=message;
        this.sender=sender;
        this.receiver=receiver;
        date = LocalDateTime.now();
        
    }
    
    
    /**GETTERS/SETTERS**/

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Contact getSender() {
        return sender;
    }

    public void setSender(Contact sender) {
        this.sender = sender;
    }

    public Group getReceiver() {
        return receiver;
    }

    public void setReceiver(Group receiver) {
        this.receiver = receiver;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
    
    
    /**TOSTRING/EQUALS/HASHCODE **/
    
    /*
    @Override
    public String toString() {
        return "Messaggio{" + "id=" + super.getId() + ", message=" + message + ", sender=" + sender.getName() + ", gruppo="+receiver.getGroupName() + '}';
    }
    */
    
    @Override
    public String toString() {
        return "Messaggio{" + "id=" + super.getId() + ", message=" + message + ", date="+date+'}';
    }
    
    
    /*
    @Override
    public int hashCode(){
        return Objects.hash(message,sender,receiver,date);
    }
    */
    @Override
    public int hashCode(){
        return Objects.hash(date,message);
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if( o == null || !(o instanceof Message)) return false;
        Message that= (Message)o;
        if(this.getId() != null && that.getId() != null) return this.getId().equals(that.getId());
        if(!this.date.equals(that.date)) return false;
        if(!this.message.equals(that.message)) return false;
        return true;
    }
    
    
    
    @Override
    public int compareTo(Message m) {
        
        /*if(this.getId() != null && m.getId() != null)
            return this.getId().compareTo(m.getId());*/
        return this.date.compareTo(m.date);
    }
    
    
}
