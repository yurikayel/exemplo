package custom

fun <K : Any, V : Any> crossMapOf(keys: List<K> = listOf(), values: List<V> = listOf()) =
    CrossMap<K, V>().apply { keys.forEachIndexed { index, key -> put(key, values[index]) } }

class CrossMap<Key : Any, Value : Any> : Iterable<Key> {

    private val invertedMap = mutableMapOf<Value, Key>()
    private val map = mutableMapOf<Key, Value>()
    val values get() = map.values
    val keys get() = map.keys

    val size get() = invertedMap.size

    fun put(key: Key, value: Value) {
        invertedMap[value] = key
        map[key] = value
    }

    fun get(key: Key): Value? = map[key]

    fun getValue(key: Key): Value? = map[key]

    fun getKey(value: Value): Key? = invertedMap[value]

    fun remove(key: Key) {
        invertedMap.remove(map[key])
        map.remove(key)
    }

    fun removeKey(key: Key) {
        invertedMap.remove(map[key])
        map.remove(key)
    }

    fun removeValue(value: Value) {
        map.remove(invertedMap[value])
        invertedMap.remove(value)
    }

    override fun iterator(): Iterator<Key> {
        return keys.iterator()
    }
}