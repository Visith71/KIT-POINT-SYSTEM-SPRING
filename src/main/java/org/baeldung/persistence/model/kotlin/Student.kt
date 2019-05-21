package org.baeldung.persistence.model.kotlin
import org.baeldung.persistence.model.User
import javax.persistence.*

@Entity
@Table(name = "student")
data class Student(
        @Id @GeneratedValue var id:Long ?=null,
        var name:String="",
        var roll_number:String="",
        var is_alumni:Boolean = false,
        var gender:String="",
        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "batch_id")
        var batch: Batch? = null,
        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "rank_id")
        var rank: Rank?=null,
        @ManyToOne(fetch = FetchType.EAGER)
        var user: User?=null,

        @OneToMany(mappedBy = "student", cascade = arrayOf(CascadeType.ALL),fetch = FetchType.LAZY)
        var project: MutableSet<Project>?= null,

        @ManyToMany(mappedBy = "students",cascade = arrayOf(CascadeType.ALL),fetch = FetchType.EAGER)
        var projects:MutableSet<Project> ?= null,

        @ManyToMany(mappedBy = "students",cascade = arrayOf(CascadeType.ALL),fetch = FetchType.EAGER)
        var companies:MutableSet<Company> ?= null,

        @OneToMany(mappedBy = "student",cascade = arrayOf(CascadeType.ALL), fetch = FetchType.LAZY)
        var tasks:MutableSet<Task>?=null
) {


    override fun toString(): String {
        return "Student(id=$id, name='$name', roll_number='$roll_number', is_alumni=$is_alumni, gender='$gender')"
    }


}