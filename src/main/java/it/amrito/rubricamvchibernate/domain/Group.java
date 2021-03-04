/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.amrito.rubricamvchibernate.domain;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.PreRemove;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;

/**
 *
 * @author amrit
 */
@Entity
@Table(name =" TB_Group")
public class Group extends AbstractEntity {
    
    
    
    
    private String groupName;
    
    private String description;
    
    @ManyToMany(mappedBy="groups"/*, fetch=FetchType.EAGER*/)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Set<Contact> contacts=new HashSet<>();
    
    @ManyToOne
    private Contact owner;
    
    @OneToMany(mappedBy ="receiver")
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    @OrderBy("date ASC")
    private SortedSet<Message> messages=new TreeSet<>();
    
    /** Costruttori **/
    
    public Group(){
        
    }
    
    public Group(Contact owner){
        this.owner=owner;
        owner.getGroups().add(this);
    }
    
    public Group(String nomeGruppo, String descrizione, Contact owner){
        this.groupName=nomeGruppo;
        this.description=descrizione;
        this.owner=owner;
        owner.getGroups().add(this);
    }
    
    /**SETTERS/GETTERS**/

    

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(Set<Contact> contacts) {
        this.contacts = contacts;
    }

    public Contact getOwner() {
        return owner;
    }

    public void setOwner(Contact owner) {
        this.owner = owner;
    }

    public Set<Message> getMessages() {
        return messages;
    }

    public void setMessages(SortedSet<Message> messages) {
        this.messages = messages;
    }
    
    
    /**
     * Metodo triggerato ogni volta che si elimina un gruppo.
     * Toglie i riferimenti del proprietario dei partecipanti a tale gruppo(eliminato).
     */
    @PreRemove
    public void removeReferences(){
        if(owner != null) this.getOwner().getOwnedGroups().remove(this);
        for(Contact c: this.getContacts())       //SEMBRA FUNZIOOOOOOOOOOOOOOOOOOOOOOOONNNNNNNNNNAAAAAAAAAARRE
                c.getGroups().remove(this);
        for(Message m: messages)
            m.setReceiver(null);
    }
    
    
    /**METODI DI UTILITY (ONE WAY SETTERS FOR RELATIONSHIPS)**/
   // public void addOwnerRelationship(Contact owner){
     //   owner.getOwnedGroups().add(this);
       // this.setOwner(owner);
    //}
    
    
    
    /** TOSTRING/EQUALS/HASHCODE**/
    
    @Override
    public String toString() {
        return "Gruppo{" + "ID=" + super.getId() + ", nomeGruppo=" + groupName + ", owner="+ owner +", messages: "+ messages+" } ";
    }
    
    
    @Override
    public int hashCode(){
        return Objects.hash(groupName,description);
    }
    
    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        
        if(o == null || !(o instanceof Group)) return false;
        Group that=(Group)o;
        if(!this.groupName.equals(that.groupName)) return false;
        if(!this.description.equals(that.description)) return false;
        return true;
    }
    
    
    
    
    
}
