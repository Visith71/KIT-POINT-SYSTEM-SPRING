package org.baeldung.persistence.model.kotlin

import org.baeldung.persistence.model.User
import javax.persistence.*

@Entity
data class Faculty(
        @Id @GeneratedValue var id: Long ? = null,
        var name:String = "",
        var email:String = "",
        var contact:String = "",
        var address:String = "",
        var position:String = "",
        @ManyToOne(fetch = FetchType.EAGER)
        var user: User? = null,

        @OneToMany(mappedBy = "faculty", cascade = arrayOf(CascadeType.ALL), fetch = FetchType.LAZY)
        var projects: MutableSet<Project>?= null,

        @OneToMany(mappedBy = "chairman", cascade = arrayOf(CascadeType.ALL), fetch = FetchType.LAZY)
        var companies:MutableSet<Company>?=null
)