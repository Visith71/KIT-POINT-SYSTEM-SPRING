package org.baeldung.persistence.model.kotlin

import org.baeldung.persistence.model.User
import javax.persistence.*

@Entity
@Table(name = "faculty")
class Faculty {
    @Id @GeneratedValue var id: Long ? = null
    var name:String = ""
    var email:String = ""
    var contact:String = ""
    var address:String = ""
    var position:String = ""
    @ManyToOne var user: User? = null
}