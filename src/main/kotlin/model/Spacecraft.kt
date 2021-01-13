package model

class Spacecraft(
    var name: String? = null,
    var manufacturer: String? = null,
    var engineName: String? = null,
    var seats: Int? = null,
    var payloadCapacity: String? = null
) {
    constructor() : this(null, null, null, null, null)
}

class Airplane (
    var name: String? = null,
    var manufacturer: String? = null,
    var engineName: String? = null,
    var seats: Int? = null,
    var payloadCapacity: String? = null
) {
    constructor(): this(null, null, null, null, null)
}