package org.baeldung.persistence.model.kotlin

import javax.persistence.*

@Entity
data class Company(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id:Long =0,
        var name:String="",
        @Column(name="description", length = 255)
        var description:String="",
        var founded_date:String="",
        var created_at:String="",
        var updated_at:String="",

        @ManyToOne(fetch = FetchType.EAGER)
        var chairman:Faculty?=null,

        @ManyToOne(fetch = FetchType.EAGER)
        var president:Student?=null,

        @ManyToOne(fetch = FetchType.EAGER)
        var vice_pre_1:Student?=null,

        @ManyToOne(fetch = FetchType.EAGER)
        var vice_pre_2:Student?=null,

        @ManyToMany(cascade = arrayOf(CascadeType.ALL),fetch = FetchType.EAGER)
        @JoinTable(name = "company_member",
                joinColumns = arrayOf(JoinColumn(name = "company_id", referencedColumnName = "id")),
                inverseJoinColumns = arrayOf(JoinColumn(name = "student_id", referencedColumnName = "id")))
        var students: MutableSet<Student> ?= null
)