/*
 * This file is generated by jOOQ.
 */
package com.pl.sggw.tinder.jooq.tables


import com.pl.sggw.tinder.jooq.Public
import com.pl.sggw.tinder.jooq.keys.TINDER_USER_PKEY
import com.pl.sggw.tinder.jooq.keys.TINDER_USER_USER_EMAIL_KEY
import com.pl.sggw.tinder.jooq.tables.records.TinderUserRecord

import java.time.LocalDateTime

import kotlin.collections.List

import org.jooq.Field
import org.jooq.ForeignKey
import org.jooq.Identity
import org.jooq.Name
import org.jooq.Record
import org.jooq.Row12
import org.jooq.Schema
import org.jooq.Table
import org.jooq.TableField
import org.jooq.TableOptions
import org.jooq.UniqueKey
import org.jooq.impl.DSL
import org.jooq.impl.Internal
import org.jooq.impl.SQLDataType
import org.jooq.impl.TableImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class TinderUser(
    alias: Name,
    child: Table<out Record>?,
    path: ForeignKey<out Record, TinderUserRecord>?,
    aliased: Table<TinderUserRecord>?,
    parameters: Array<Field<*>?>?
): TableImpl<TinderUserRecord>(
    alias,
    Public.PUBLIC,
    child,
    path,
    aliased,
    parameters,
    DSL.comment(""),
    TableOptions.table()
) {
    companion object {

        /**
         * The reference instance of <code>public.tinder_user</code>
         */
        val TINDER_USER = TinderUser()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<TinderUserRecord> = TinderUserRecord::class.java

    /**
     * The column <code>public.tinder_user.id</code>.
     */
    val ID: TableField<TinderUserRecord, Long?> = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "")

    /**
     * The column <code>public.tinder_user.user_email</code>.
     */
    val USER_EMAIL: TableField<TinderUserRecord, String?> = createField(DSL.name("user_email"), SQLDataType.VARCHAR(126), this, "")

    /**
     * The column <code>public.tinder_user.password</code>.
     */
    val PASSWORD: TableField<TinderUserRecord, String?> = createField(DSL.name("password"), SQLDataType.VARCHAR(100).nullable(false), this, "")

    /**
     * The column <code>public.tinder_user.name</code>.
     */
    val NAME: TableField<TinderUserRecord, String?> = createField(DSL.name("name"), SQLDataType.VARCHAR(126).nullable(false), this, "")

    /**
     * The column <code>public.tinder_user.description</code>.
     */
    val DESCRIPTION: TableField<TinderUserRecord, String?> = createField(DSL.name("description"), SQLDataType.CLOB, this, "")

    /**
     * The column <code>public.tinder_user.phone_number</code>.
     */
    val PHONE_NUMBER: TableField<TinderUserRecord, String?> = createField(DSL.name("phone_number"), SQLDataType.VARCHAR(9), this, "")

    /**
     * The column <code>public.tinder_user.photo</code>.
     */
    val PHOTO: TableField<TinderUserRecord, String?> = createField(DSL.name("photo"), SQLDataType.CLOB, this, "")

    /**
     * The column <code>public.tinder_user.gender</code>.
     */
    val GENDER: TableField<TinderUserRecord, String?> = createField(DSL.name("gender"), SQLDataType.VARCHAR(6), this, "")

    /**
     * The column <code>public.tinder_user.age</code>.
     */
    val AGE: TableField<TinderUserRecord, Short?> = createField(DSL.name("age"), SQLDataType.SMALLINT, this, "")

    /**
     * The column <code>public.tinder_user.degree</code>.
     */
    val DEGREE: TableField<TinderUserRecord, String?> = createField(DSL.name("degree"), SQLDataType.CLOB, this, "")

    /**
     * The column <code>public.tinder_user.creation_timestamp</code>.
     */
    val CREATION_TIMESTAMP: TableField<TinderUserRecord, LocalDateTime?> = createField(DSL.name("creation_timestamp"), SQLDataType.LOCALDATETIME(6).nullable(false), this, "")

    /**
     * The column <code>public.tinder_user.modification_timestamp</code>.
     */
    val MODIFICATION_TIMESTAMP: TableField<TinderUserRecord, LocalDateTime?> = createField(DSL.name("modification_timestamp"), SQLDataType.LOCALDATETIME(6).nullable(false), this, "")

    private constructor(alias: Name, aliased: Table<TinderUserRecord>?): this(alias, null, null, aliased, null)
    private constructor(alias: Name, aliased: Table<TinderUserRecord>?, parameters: Array<Field<*>?>?): this(alias, null, null, aliased, parameters)

    /**
     * Create an aliased <code>public.tinder_user</code> table reference
     */
    constructor(alias: String): this(DSL.name(alias))

    /**
     * Create an aliased <code>public.tinder_user</code> table reference
     */
    constructor(alias: Name): this(alias, null)

    /**
     * Create a <code>public.tinder_user</code> table reference
     */
    constructor(): this(DSL.name("tinder_user"), null)

    constructor(child: Table<out Record>, key: ForeignKey<out Record, TinderUserRecord>): this(Internal.createPathAlias(child, key), child, key, TINDER_USER, null)
    override fun getSchema(): Schema = Public.PUBLIC
    override fun getIdentity(): Identity<TinderUserRecord, Long?> = super.getIdentity() as Identity<TinderUserRecord, Long?>
    override fun getPrimaryKey(): UniqueKey<TinderUserRecord> = TINDER_USER_PKEY
    override fun getKeys(): List<UniqueKey<TinderUserRecord>> = listOf(TINDER_USER_PKEY, TINDER_USER_USER_EMAIL_KEY)
    override fun `as`(alias: String): TinderUser = TinderUser(DSL.name(alias), this)
    override fun `as`(alias: Name): TinderUser = TinderUser(alias, this)

    /**
     * Rename this table
     */
    override fun rename(name: String): TinderUser = TinderUser(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): TinderUser = TinderUser(name, null)

    // -------------------------------------------------------------------------
    // Row12 type methods
    // -------------------------------------------------------------------------
    override fun fieldsRow(): Row12<Long?, String?, String?, String?, String?, String?, String?, String?, Short?, String?, LocalDateTime?, LocalDateTime?> = super.fieldsRow() as Row12<Long?, String?, String?, String?, String?, String?, String?, String?, Short?, String?, LocalDateTime?, LocalDateTime?>
}
