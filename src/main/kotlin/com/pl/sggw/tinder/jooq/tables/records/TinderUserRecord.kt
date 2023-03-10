/*
 * This file is generated by jOOQ.
 */
package com.pl.sggw.tinder.jooq.tables.records


import com.pl.sggw.tinder.jooq.tables.TinderUser

import java.time.LocalDateTime

import org.jooq.Field
import org.jooq.Record1
import org.jooq.Record12
import org.jooq.Row12
import org.jooq.impl.UpdatableRecordImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class TinderUserRecord() : UpdatableRecordImpl<TinderUserRecord>(TinderUser.TINDER_USER), Record12<Long?, String?, String?, String?, String?, String?, String?, String?, Short?, String?, LocalDateTime?, LocalDateTime?> {

    var id: Long?
        set(value) = set(0, value)
        get() = get(0) as Long?

    var userEmail: String?
        set(value) = set(1, value)
        get() = get(1) as String?

    var password: String?
        set(value) = set(2, value)
        get() = get(2) as String?

    var name: String?
        set(value) = set(3, value)
        get() = get(3) as String?

    var description: String?
        set(value) = set(4, value)
        get() = get(4) as String?

    var phoneNumber: String?
        set(value) = set(5, value)
        get() = get(5) as String?

    var photo: String?
        set(value) = set(6, value)
        get() = get(6) as String?

    var gender: String?
        set(value) = set(7, value)
        get() = get(7) as String?

    var age: Short?
        set(value) = set(8, value)
        get() = get(8) as Short?

    var degree: String?
        set(value) = set(9, value)
        get() = get(9) as String?

    var creationTimestamp: LocalDateTime?
        set(value) = set(10, value)
        get() = get(10) as LocalDateTime?

    var modificationTimestamp: LocalDateTime?
        set(value) = set(11, value)
        get() = get(11) as LocalDateTime?

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    override fun key(): Record1<Long?> = super.key() as Record1<Long?>

    // -------------------------------------------------------------------------
    // Record12 type implementation
    // -------------------------------------------------------------------------

    override fun fieldsRow(): Row12<Long?, String?, String?, String?, String?, String?, String?, String?, Short?, String?, LocalDateTime?, LocalDateTime?> = super.fieldsRow() as Row12<Long?, String?, String?, String?, String?, String?, String?, String?, Short?, String?, LocalDateTime?, LocalDateTime?>
    override fun valuesRow(): Row12<Long?, String?, String?, String?, String?, String?, String?, String?, Short?, String?, LocalDateTime?, LocalDateTime?> = super.valuesRow() as Row12<Long?, String?, String?, String?, String?, String?, String?, String?, Short?, String?, LocalDateTime?, LocalDateTime?>
    override fun field1(): Field<Long?> = TinderUser.TINDER_USER.ID
    override fun field2(): Field<String?> = TinderUser.TINDER_USER.USER_EMAIL
    override fun field3(): Field<String?> = TinderUser.TINDER_USER.PASSWORD
    override fun field4(): Field<String?> = TinderUser.TINDER_USER.NAME
    override fun field5(): Field<String?> = TinderUser.TINDER_USER.DESCRIPTION
    override fun field6(): Field<String?> = TinderUser.TINDER_USER.PHONE_NUMBER
    override fun field7(): Field<String?> = TinderUser.TINDER_USER.PHOTO
    override fun field8(): Field<String?> = TinderUser.TINDER_USER.GENDER
    override fun field9(): Field<Short?> = TinderUser.TINDER_USER.AGE
    override fun field10(): Field<String?> = TinderUser.TINDER_USER.DEGREE
    override fun field11(): Field<LocalDateTime?> = TinderUser.TINDER_USER.CREATION_TIMESTAMP
    override fun field12(): Field<LocalDateTime?> = TinderUser.TINDER_USER.MODIFICATION_TIMESTAMP
    override fun component1(): Long? = id
    override fun component2(): String? = userEmail
    override fun component3(): String? = password
    override fun component4(): String? = name
    override fun component5(): String? = description
    override fun component6(): String? = phoneNumber
    override fun component7(): String? = photo
    override fun component8(): String? = gender
    override fun component9(): Short? = age
    override fun component10(): String? = degree
    override fun component11(): LocalDateTime? = creationTimestamp
    override fun component12(): LocalDateTime? = modificationTimestamp
    override fun value1(): Long? = id
    override fun value2(): String? = userEmail
    override fun value3(): String? = password
    override fun value4(): String? = name
    override fun value5(): String? = description
    override fun value6(): String? = phoneNumber
    override fun value7(): String? = photo
    override fun value8(): String? = gender
    override fun value9(): Short? = age
    override fun value10(): String? = degree
    override fun value11(): LocalDateTime? = creationTimestamp
    override fun value12(): LocalDateTime? = modificationTimestamp

    override fun value1(value: Long?): TinderUserRecord {
        this.id = value
        return this
    }

    override fun value2(value: String?): TinderUserRecord {
        this.userEmail = value
        return this
    }

    override fun value3(value: String?): TinderUserRecord {
        this.password = value
        return this
    }

    override fun value4(value: String?): TinderUserRecord {
        this.name = value
        return this
    }

    override fun value5(value: String?): TinderUserRecord {
        this.description = value
        return this
    }

    override fun value6(value: String?): TinderUserRecord {
        this.phoneNumber = value
        return this
    }

    override fun value7(value: String?): TinderUserRecord {
        this.photo = value
        return this
    }

    override fun value8(value: String?): TinderUserRecord {
        this.gender = value
        return this
    }

    override fun value9(value: Short?): TinderUserRecord {
        this.age = value
        return this
    }

    override fun value10(value: String?): TinderUserRecord {
        this.degree = value
        return this
    }

    override fun value11(value: LocalDateTime?): TinderUserRecord {
        this.creationTimestamp = value
        return this
    }

    override fun value12(value: LocalDateTime?): TinderUserRecord {
        this.modificationTimestamp = value
        return this
    }

    override fun values(value1: Long?, value2: String?, value3: String?, value4: String?, value5: String?, value6: String?, value7: String?, value8: String?, value9: Short?, value10: String?, value11: LocalDateTime?, value12: LocalDateTime?): TinderUserRecord {
        this.value1(value1)
        this.value2(value2)
        this.value3(value3)
        this.value4(value4)
        this.value5(value5)
        this.value6(value6)
        this.value7(value7)
        this.value8(value8)
        this.value9(value9)
        this.value10(value10)
        this.value11(value11)
        this.value12(value12)
        return this
    }

    /**
     * Create a detached, initialised TinderUserRecord
     */
    constructor(id: Long? = null, userEmail: String? = null, password: String? = null, name: String? = null, description: String? = null, phoneNumber: String? = null, photo: String? = null, gender: String? = null, age: Short? = null, degree: String? = null, creationTimestamp: LocalDateTime? = null, modificationTimestamp: LocalDateTime? = null): this() {
        this.id = id
        this.userEmail = userEmail
        this.password = password
        this.name = name
        this.description = description
        this.phoneNumber = phoneNumber
        this.photo = photo
        this.gender = gender
        this.age = age
        this.degree = degree
        this.creationTimestamp = creationTimestamp
        this.modificationTimestamp = modificationTimestamp
    }
}
