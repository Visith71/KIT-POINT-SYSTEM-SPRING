package org.baeldung.persistence.model.kotlin

import javax.persistence.*

@Entity
@Table(name ="year")
data class Year(
        @Id @GeneratedValue var id:Long?=null,
        var name:String="",
        var avg_intern_hour:Int=0,
        var created_at:String="",
        var updated_at:String="",

        @OneToMany(mappedBy = "year", cascade = arrayOf(CascadeType.ALL), fetch = FetchType.LAZY)
        var semesters: MutableSet<Semester>?=null
) {

    override fun toString(): String {
        return "Year(id=$id, name='$name', avg_intern_hour=$avg_intern_hour, " +
                "created_at='$created_at', updated_at='$updated_at', semesters=$semesters)"
    }


}