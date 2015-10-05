package com.testgrailsproject

import javax.validation.constraints.Min
import javax.validation.constraints.NotNull

class Person {
    @NotNull
    String name

    @Min(1l)
    Integer age

    String surname

    String birthDate


}
