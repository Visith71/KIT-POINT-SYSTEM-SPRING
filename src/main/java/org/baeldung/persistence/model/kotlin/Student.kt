package org.baeldung.persistence.model.kotlin

import org.baeldung.persistence.model.User
import javax.persistence.*

@Entity
@Table(name = "student")
class Student (
        @Id @GeneratedValue var id:Long ?=null,
        var name:String,
        var roll_number:String,
        var is_alumni:Boolean,
        @ManyToOne var user: User
)