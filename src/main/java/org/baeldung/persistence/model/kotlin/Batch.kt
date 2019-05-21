package org.baeldung.persistence.model.kotlin

import javax.persistence.*
@Entity
@Table(name = "batch")
data class Batch (
        @Id @GeneratedValue var id:Long?=null,
        var name:String="",
        var start_date:String="",
        var end_date:String="",
        var created_at:String="",
        var updated_at:String="",
        @OneToMany(mappedBy = "batch", cascade = arrayOf(CascadeType.ALL), fetch = FetchType.LAZY)
        var students: MutableSet<Student>?= null,

        @OneToMany(mappedBy = "batch", cascade = arrayOf(CascadeType.ALL), fetch = FetchType.LAZY)
        var semesters: MutableSet<Semester>?= null,

        @OneToMany(mappedBy = "batch", cascade = arrayOf(CascadeType.ALL), fetch = FetchType.LAZY)
        var chargedTables: MutableSet<ChargedTable>?= null,

        @OneToMany(mappedBy = "batch", cascade = arrayOf(CascadeType.ALL), fetch = FetchType.LAZY)
        var tasks:MutableSet<Task>?=null

)