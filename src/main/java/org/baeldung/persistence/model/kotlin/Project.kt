package org.baeldung.persistence.model.kotlin
import javax.persistence.*

@Entity
@Table(name = "project")
data class Project(
        @Id
        @GeneratedValue
        var id: Long ? = null,
        var name:String = "",
        var code:String = "",
        var status:String = "",
        var planning_hour:Int = 0,
        var budget:Int=0,
        var actual_hour:Float=0.00f,
        var hour_base:Float=0.00f,
        var value_base:Float=0.00f,
        var estimate_point:Float=0.00f,
        var proposing_point:Float=0.00f,
        var start_date:String = "",
        var end_date:String = "",
        var deadline:String = "",
        var is_old:Boolean=false,
        var is_generated:Boolean=false,
        var contingency:Int=0,
        @Column(name="chairman_remark", length = 500)
        var chairman_remark:String="",
        @Column(name="president_remark", length = 500)
        var president_remark:String="",
        var created_at:String="",
        var updated_at:String="",

        @ManyToOne(fetch = FetchType.EAGER)
        var projectCategory:ProjectCategory?=null,

        @ManyToOne(fetch = FetchType.EAGER)
        var company:Company?=null,


        @ManyToOne(fetch = FetchType.EAGER)
        var faculty:Faculty? = null,

        @ManyToOne(fetch = FetchType.EAGER)
        var student:Student? = null,

        @OneToMany(mappedBy = "project", cascade = arrayOf(CascadeType.ALL), fetch = FetchType.LAZY)
        var tasks:MutableSet<Task>?=null,

        @ManyToMany(cascade = arrayOf(CascadeType.ALL),fetch = FetchType.EAGER)
        @JoinTable(name = "project_member",
                joinColumns = arrayOf(JoinColumn(name = "project_id", referencedColumnName = "id")),
                inverseJoinColumns = arrayOf(JoinColumn(name = "student_id", referencedColumnName = "id")))
        var students: MutableSet<Student> ?= null
)