package com.tuyenvo.xeduyen.utils.enums

enum class GenderEnum(var value: String) {
    FEMALE("Female"),
    MALE("Male");

    companion object{
        fun get(gender: String?): GenderEnum {
            for (gen in values()) {
                if (gen.value == gender) {
                    return gen
                }
            }
            return FEMALE
        }
    }
}