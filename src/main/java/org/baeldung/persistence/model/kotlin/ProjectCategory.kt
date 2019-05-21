package org.baeldung.persistence.model.kotlin

import javax.persistence.*

@Entity
@Table(name = "project_category")
data class ProjectCategory(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id:Long =0,
        var name:String="",
        var created_at:String="",
        var updated_at:String="",

        @OneToMany(mappedBy = "projectCategory", cascade = arrayOf(CascadeType.ALL), fetch = FetchType.LAZY)
        var projects:MutableSet<Project>?=null
)