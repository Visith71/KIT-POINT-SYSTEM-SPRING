package org.baeldung.persistence.model.kotlin

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "point_value")
data class PointValue(
        @Id @GeneratedValue var id:Long?=null,
        var value:Int = 0,
        var created_at:String="",
        var updated_at:String=""
) {


    override fun toString(): String {
        return "PointValue(id=$id, value=$value, " +
                "created_at='$created_at', updated_at='$updated_at')"
    }


}