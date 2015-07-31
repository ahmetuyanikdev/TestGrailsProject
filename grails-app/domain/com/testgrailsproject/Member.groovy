package com.testgrailsproject

class Member {
    Integer id
    String fullName
    String password

    static constraints = {
        id blank:true,nullable: true
        fullName blank: false,nullable: false
        password blank: false,nullable: false
    }

}
