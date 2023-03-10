/*
 * This file is generated by jOOQ.
 */
package com.pl.sggw.tinder.jooq.tables


import com.pl.sggw.tinder.jooq.Public
import com.pl.sggw.tinder.jooq.keys.USER_MATCH_DECITION_PKEY
import com.pl.sggw.tinder.jooq.tables.records.UserMatchDecitionRecord

import java.time.LocalDateTime

import kotlin.collections.List

import org.jooq.Field
import org.jooq.ForeignKey
import org.jooq.Identity
import org.jooq.Name
import org.jooq.Record
import org.jooq.Row6
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
open class UserMatchDecition(
    alias: Name,
    child: Table<out Record>?,
    path: ForeignKey<out Record, UserMatchDecitionRecord>?,
    aliased: Table<UserMatchDecitionRecord>?,
    parameters: Array<Field<*>?>?
): TableImpl<UserMatchDecitionRecord>(
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
         * The reference instance of <code>public.user_match_decition</code>
         */
        val USER_MATCH_DECITION = UserMatchDecition()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<UserMatchDecitionRecord> = UserMatchDecitionRecord::class.java

    /**
     * The column <code>public.user_match_decition.id</code>.
     */
    val ID: TableField<UserMatchDecitionRecord, Long?> = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "")

    /**
     * The column <code>public.user_match_decition.selecting_user_email</code>.
     */
    val SELECTING_USER_EMAIL: TableField<UserMatchDecitionRecord, String?> = createField(DSL.name("selecting_user_email"), SQLDataType.VARCHAR(126).nullable(false), this, "")

    /**
     * The column <code>public.user_match_decition.selected_user_email</code>.
     */
    val SELECTED_USER_EMAIL: TableField<UserMatchDecitionRecord, String?> = createField(DSL.name("selected_user_email"), SQLDataType.VARCHAR(126).nullable(false), this, "")

    /**
     * The column <code>public.user_match_decition.selected_user_approved</code>.
     */
    val SELECTED_USER_APPROVED: TableField<UserMatchDecitionRecord, Boolean?> = createField(DSL.name("selected_user_approved"), SQLDataType.BOOLEAN.nullable(false), this, "")

    /**
     * The column <code>public.user_match_decition.creation_timestamp</code>.
     */
    val CREATION_TIMESTAMP: TableField<UserMatchDecitionRecord, LocalDateTime?> = createField(DSL.name("creation_timestamp"), SQLDataType.LOCALDATETIME(6).nullable(false), this, "")

    /**
     * The column <code>public.user_match_decition.modification_timestamp</code>.
     */
    val MODIFICATION_TIMESTAMP: TableField<UserMatchDecitionRecord, LocalDateTime?> = createField(DSL.name("modification_timestamp"), SQLDataType.LOCALDATETIME(6).nullable(false), this, "")

    private constructor(alias: Name, aliased: Table<UserMatchDecitionRecord>?): this(alias, null, null, aliased, null)
    private constructor(alias: Name, aliased: Table<UserMatchDecitionRecord>?, parameters: Array<Field<*>?>?): this(alias, null, null, aliased, parameters)

    /**
     * Create an aliased <code>public.user_match_decition</code> table reference
     */
    constructor(alias: String): this(DSL.name(alias))

    /**
     * Create an aliased <code>public.user_match_decition</code> table reference
     */
    constructor(alias: Name): this(alias, null)

    /**
     * Create a <code>public.user_match_decition</code> table reference
     */
    constructor(): this(DSL.name("user_match_decition"), null)

    constructor(child: Table<out Record>, key: ForeignKey<out Record, UserMatchDecitionRecord>): this(Internal.createPathAlias(child, key), child, key, USER_MATCH_DECITION, null)
    override fun getSchema(): Schema = Public.PUBLIC
    override fun getIdentity(): Identity<UserMatchDecitionRecord, Long?> = super.getIdentity() as Identity<UserMatchDecitionRecord, Long?>
    override fun getPrimaryKey(): UniqueKey<UserMatchDecitionRecord> = USER_MATCH_DECITION_PKEY
    override fun getKeys(): List<UniqueKey<UserMatchDecitionRecord>> = listOf(USER_MATCH_DECITION_PKEY)
    override fun `as`(alias: String): UserMatchDecition = UserMatchDecition(DSL.name(alias), this)
    override fun `as`(alias: Name): UserMatchDecition = UserMatchDecition(alias, this)

    /**
     * Rename this table
     */
    override fun rename(name: String): UserMatchDecition = UserMatchDecition(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): UserMatchDecition = UserMatchDecition(name, null)

    // -------------------------------------------------------------------------
    // Row6 type methods
    // -------------------------------------------------------------------------
    override fun fieldsRow(): Row6<Long?, String?, String?, Boolean?, LocalDateTime?, LocalDateTime?> = super.fieldsRow() as Row6<Long?, String?, String?, Boolean?, LocalDateTime?, LocalDateTime?>
}
