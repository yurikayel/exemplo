package retrofit

import kotlin.reflect.KClass

open class Repository<T : Service>(url: String, service: KClass<T>) {
    val service = RetroInit(url).create(service)
}