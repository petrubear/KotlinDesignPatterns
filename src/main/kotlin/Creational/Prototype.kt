data class User(
    val name: String,
    val role: Role,
    var permissions: Set<String>,
) {
    fun hasPermission(permission: String) = permission in permissions
}
enum class Role { ADMIN, SUPER_ADMIN, REGULAR_USER }

val allUsers = mutableListOf<User>()
fun createUser(_name: String, role: Role) {
    for (u in allUsers) {
        if (u.role == role) {
            // use copy to change specific fields
            allUsers += u.copy(name = _name)
            return 
        }
    }   
}