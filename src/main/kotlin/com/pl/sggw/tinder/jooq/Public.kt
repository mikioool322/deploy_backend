/*
 * This file is generated by jOOQ.
 */
package com.pl.sggw.tinder.jooq


import com.pl.sggw.tinder.jooq.tables.TinderUser
import com.pl.sggw.tinder.jooq.tables.UserMatchDecition
import com.pl.sggw.tinder.jooq.tables.UserPreferences

import kotlin.collections.List

import org.jooq.Catalog
import org.jooq.Table
import org.jooq.impl.SchemaImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class Public : SchemaImpl("public", DefaultCatalog.DEFAULT_CATALOG) {
    companion object {

        /**
         * The reference instance of <code>public</code>
         */
        val PUBLIC = Public()
    }

    /**
     * The table <code>public.tinder_user</code>.
     */
    val TINDER_USER get() = TinderUser.TINDER_USER

    /**
     * The table <code>public.user_match_decition</code>.
     */
    val USER_MATCH_DECITION get() = UserMatchDecition.USER_MATCH_DECITION

    /**
     * The table <code>public.user_preferences</code>.
     */
    val USER_PREFERENCES get() = UserPreferences.USER_PREFERENCES

    override fun getCatalog(): Catalog = DefaultCatalog.DEFAULT_CATALOG

    override fun getTables(): List<Table<*>> = listOf(
        TinderUser.TINDER_USER,
        UserMatchDecition.USER_MATCH_DECITION,
        UserPreferences.USER_PREFERENCES
    )
}