package org.baeldung.persistence.model.kotlin

import javax.persistence.*

@Entity
@Table(name = "charged_table")
data class ChargedTable(
        @Id @GeneratedValue var id:Long?=null,

        var created_at:String="",
        var updated_at:String="",

        var value:Float = 0.0f,

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "batch_id")
        var batch:Batch?=null,

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "semester_id")
        var semester:Semester?=null,

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "rank_id")
        var rank:Rank?=null
) {

    override fun toString(): String {
        return "ChargedTable(id=$id, value=$value, batch=$batch, " +
                "semester=$semester, rank=$rank," +
                "created_at=$created_at, updated_at=$updated_at)"
    }


}