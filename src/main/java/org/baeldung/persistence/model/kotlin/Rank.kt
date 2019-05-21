package org.baeldung.persistence.model.kotlin

import javax.persistence.*

@Entity
@Table(name = "rank")
data class Rank(
        @Id @GeneratedValue var id:Long?=null,
        var code:String = "",
        var name:String = "",
        var description:String = "",
        @OneToMany(mappedBy = "rank", cascade = arrayOf(CascadeType.ALL), fetch = FetchType.LAZY)
        var students: MutableSet<Student>?=null,
        @OneToMany(mappedBy = "rank", cascade = arrayOf(CascadeType.ALL), fetch = FetchType.LAZY)
        var chargedTable: MutableSet<ChargedTable>?= null
){

    override fun toString(): String {
        return "Rank(id=$id, code='$code', name='$name', description='$description'," +
                "students=$students), chargedTable='$chargedTable'"
    }


}