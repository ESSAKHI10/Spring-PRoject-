package com.example.demo.springsecuritynewfeatures.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;
 
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true)
    private String username;
    private String password;
    private boolean enabled=true;
    private boolean credentialsexpired =false;
    private boolean locked=false;
    private boolean expired=false;
    
    @ManyToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinTable(
               name ="AccountRole",
             
                joinColumns =  @JoinColumn(name="accountId",referencedColumnName="id")    ,
               inverseJoinColumns = @JoinColumn(name="roleId",referencedColumnName="id")    
    )
    private Set<Role> roles ;

}
