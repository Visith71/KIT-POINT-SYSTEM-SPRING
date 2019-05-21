package org.baeldung.persistence.model.kotlin

import javax.persistence.*

@Entity
data class Task(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id:Long=0,
        var name:String="",
        var status:String="",
        var planning_hour:Int=0,
        var actual_hour:Float=0.00f,
        var start_date:String="",
        var end_date:String="",
        var deadline:String="",
        var created_at:String="",
        var updated_at:String="",

        @ManyToOne(fetch = FetchType.EAGER)
        var project:Project?=null,

        @ManyToOne(fetch = FetchType.EAGER)
        var student:Student?=null,

        @ManyToOne(fetch = FetchType.EAGER)
        var batch:Batch?=null
)