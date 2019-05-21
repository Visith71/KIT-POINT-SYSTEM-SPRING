package org.baeldung.persistence.model.kotlin

import javax.persistence.*

@Entity
@Table(name="semester")
data class Semester(
        @Id @GeneratedValue var id:Long?=null,
        var name:String="",
        var code:String = "",
        var start_date:String="",
        var end_date:String="",
        var created_at:String="",
        var updated_at:String="",

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "batch_id")
        var batch:Batch?=null,

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "year_id")
        var year:Year?=null,

        @OneToMany(mappedBy = "semester", cascade = arrayOf(CascadeType.ALL), fetch = FetchType.LAZY)
        var chargedTable: MutableSet<ChargedTable>?= null
) {

    override fun toString(): String {
        return "Semester(id=$id, name='$name', code='$code', " +
                "start_date='$start_date', end_date='$end_date'," +
                " created_at='$created_at', updated_at='$updated_at', " +
                "batch=$batch, year=$year), chargedTable='$chargedTable'"
    }


}