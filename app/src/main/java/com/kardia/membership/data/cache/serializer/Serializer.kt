/**
 * Copyright (C) 2015 Fernando Cejas Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.kardia.membership.data.cache.serializer

import com.google.gson.Gson
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Json Serializer/Deserializer.
 */
@Singleton
class Serializer @Inject internal constructor() {
    private val gson = Gson()

    /**
     * Serialize an object to Json.
     *
     * @param object to serialize.
     */
    fun serialize(`object`: Any?, clazz: Class<*>?): String {
        return gson.toJson(`object`, clazz)
    }

    /**
     * Deserialize a json representation of an object.
     *
     * @param string A json string to deserialize.
     */
    fun <T> deserialize(string: String?, clazz: Class<T>?): T? {
        return try {
            gson.fromJson(string, clazz)
        } catch (e: Exception) {
            null
        }
    }
}